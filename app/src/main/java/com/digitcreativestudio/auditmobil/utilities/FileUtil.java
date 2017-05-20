package com.digitcreativestudio.auditmobil.utilities;

import android.annotation.TargetApi;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import android.util.Base64;
import android.webkit.MimeTypeMap;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;
import java.util.Arrays;

/**
 * Created by faqih on 20/05/17.
 */

public class FileUtil {
    public static final String[] mimeTypes = new String[]{
            "image/jpeg", "image/png", "image/jpg"
    };

    @TargetApi(Build.VERSION_CODES.KITKAT)
    public static String getPath(final Context context, final Uri uri) {
        final boolean isKitKat = Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT;
        // DocumentProvider
        if (isKitKat && DocumentsContract.isDocumentUri(context, uri)) {
            // ExternalStorageProvider
            if (isExternalStorageDocument(uri)) {
                final String docId = DocumentsContract.getDocumentId(uri);
                final String[] split = docId.split(":");
                final String type = split[0];
                if ("primary".equalsIgnoreCase(type)) {
                    return Environment.getExternalStorageDirectory() + "/" + split[1];
                }
            }
            // DownloadsProvider
            else if (isDownloadsDocument(uri)) {
                final String id = DocumentsContract.getDocumentId(uri);
                final Uri contentUri = ContentUris.withAppendedId(Uri.parse("content://downloads/public_downloads"), Long.valueOf(id));
                return getDataColumn(context, contentUri, null, null);
            }
            // MediaProvider
            else if (isMediaDocument(uri)) {
                final String docId = DocumentsContract.getDocumentId(uri);
                final String[] split = docId.split(":");
                final String type = split[0];
                Uri contentUri = null;
                if ("image".equals(type)) {
                    contentUri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
                } else if ("video".equals(type)) {
                    contentUri = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
                } else if ("audio".equals(type)) {
                    contentUri = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
                }
                final String selection = "_id=?";
                final String[] selectionArgs = new String[]{split[1]};
                return getDataColumn(context, contentUri, selection, selectionArgs);
            }
        }
        // MediaStore (and general)
        else if ("content".equalsIgnoreCase(uri.getScheme())) {
            // Return the remote address
            if (isGooglePhotosUri(uri))
                return uri.getLastPathSegment();
            return getDataColumn(context, uri, null, null);
        }
        // File
        else if ("file".equalsIgnoreCase(uri.getScheme())) {
            return uri.getPath();
        }
        return null;
    }

    public static String getDataColumn(Context context, Uri uri, String selection, String[] selectionArgs) {
        Cursor cursor = null;
        final String column = "_data";
        final String[] projection = {column};
        try {
            cursor = context.getContentResolver().query(uri, projection, selection, selectionArgs, null);
            if (cursor != null && cursor.moveToFirst()) {
                final int index = cursor.getColumnIndexOrThrow(column);
                return cursor.getString(index);
            }
        } finally {
            if (cursor != null)
                cursor.close();
        }
        return null;
    }

    public static boolean isExternalStorageDocument(Uri uri) {
        return "com.android.externalstorage.documents".equals(uri.getAuthority());
    }

    public static boolean isDownloadsDocument(Uri uri) {
        return "com.android.providers.downloads.documents".equals(uri.getAuthority());
    }

    public static boolean isMediaDocument(Uri uri) {
        return "com.android.providers.media.documents".equals(uri.getAuthority());
    }

    public static boolean isGooglePhotosUri(Uri uri) {
        return "com.google.android.apps.photos.content".equals(uri.getAuthority());
    }

    public static String convertFileToByteArray(File f) {
        byte[] byteArray = null;
        String result = "";
        try {
            InputStream inputStream = new FileInputStream(f);
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            byte[] b = new byte[1024 * 11];
            int bytesRead = 0;

            while ((bytesRead = inputStream.read(b)) != -1) {
                bos.write(b, 0, bytesRead);
            }

            byteArray = bos.toByteArray();

            result = Base64.encodeToString(byteArray, Base64.NO_WRAP);
            result = URLEncoder.encode(result, "utf-8");

        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }

    public static String getType(Context context, Uri uri){
        String mimeType = null;
        if (uri.getScheme().equals(ContentResolver.SCHEME_CONTENT)) {
            ContentResolver cr = context.getContentResolver();
            mimeType = cr.getType(uri);
        } else {
            String fileExtension = MimeTypeMap.getFileExtensionFromUrl(uri
                    .toString());
            mimeType = MimeTypeMap.getSingleton().getMimeTypeFromExtension(
                    fileExtension.toLowerCase());
        }
        return mimeType;
    }

    public static byte[] toByteArray(File file) {
        ByteArrayOutputStream ous = null;
        InputStream ios = null;
        try {
            byte[] buffer = new byte[4096];
            ous = new ByteArrayOutputStream();
            ios = new FileInputStream(file);
            int read = 0;
            while ((read = ios.read(buffer)) != -1) {
                ous.write(buffer, 0, read);
            }
        }catch(IOException ie){
            ie.printStackTrace();
        }finally {
            try {
                if (ous != null)
                    ous.close();
            } catch (IOException e) {
            }

            try {
                if (ios != null)
                    ios.close();
            } catch (IOException e) {
            }
        }
        return ous.toByteArray();
    }
    public static int compare(File file1, File file2) {

        // one or both null
        if (file1 == file2) {
            return 0;
        } else if (file1 == null && file2 != null) {
            return -1;
        } else if (file1 != null && file2 == null) {
            return 1;
        }

        if (file1.isDirectory() || file2.isDirectory()) {
            throw new IllegalArgumentException("Unable to compare directory content");
        }

        // not same size
        if (file1.length() < file2.length()) {
            return -1;
        } else if (file1.length() > file2.length()) {
            return 1;
        }

        try {
            return compareContent(file1, file2);
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage(), e);
        }

    }

    public static int bufferSize(long fileLength) {
        int multiple = (int) (fileLength / 1024);
        if (multiple <= 1) {
            return 1024;
        } else if (multiple <= 8) {
            return 1024 * 2;
        } else if (multiple <= 16) {
            return 1024 * 4;
        } else if (multiple <= 32) {
            return 1024 * 8;
        } else if (multiple <= 64) {
            return 1024 * 16;
        } else {
            return 1024 * 64;
        }
    }

    public static int compareContent(File file1, File file2) throws IOException {

        final int BUFFER_SIZE = bufferSize(file1.length());

        // check content
        BufferedInputStream is1 = new BufferedInputStream(new FileInputStream(file1), BUFFER_SIZE);
        BufferedInputStream is2 = new BufferedInputStream(new FileInputStream(file2), BUFFER_SIZE);

        byte[] b1 = new byte[BUFFER_SIZE];
        byte[] b2 = new byte[BUFFER_SIZE];

        int read1 = -1;
        int read2 = -1;
        int read = -1;

        do {
            read1 = is1.read(b1);
            read2 = is2.read(b2);

            if (read1 < read2) {
                return -1;
            } else if (read1 > read2) {
                return 1;
            } else {
                // read1 is equals to read2
                read = read1;
            }

            if (read >= 0) {
                if (read != BUFFER_SIZE) {
                    // clear the buffer not filled from the read
                    Arrays.fill(b1, read, BUFFER_SIZE, (byte) 0);
                    Arrays.fill(b2, read, BUFFER_SIZE, (byte) 0);
                }
                // compare the content of the two buffers
                if (!Arrays.equals(b1, b2)) {
                    return new String(b1).compareTo(new String(b2));
                }
            }
        } while (read >= 0);

        // no difference found
        return 0;
    }

}

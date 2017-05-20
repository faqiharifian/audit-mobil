package com.digitcreativestudio.auditmobil.utilities;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;

/**
 * Created by faqih on 20/05/17.
 */

public class FileUtil {

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

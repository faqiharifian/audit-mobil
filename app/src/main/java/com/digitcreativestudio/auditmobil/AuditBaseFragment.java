package com.digitcreativestudio.auditmobil;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.Toast;

import com.digitcreativestudio.auditmobil.entities.Audit;
import com.digitcreativestudio.auditmobil.utilities.FileUtil;
import com.digitcreativestudio.auditmobil.view.ProgressDialog;

import java.io.File;
import java.util.Arrays;
import java.util.concurrent.Callable;

/**
 * Created by faqih on 19/05/17.
 */

public abstract class AuditBaseFragment extends Fragment implements View.OnClickListener {
    public static final int PICTURE_CHOOSER_1_REQUEST = 101;
    public static final int PICTURE_CHOOSER_2_REQUEST = 102;
    public static final int PICTURE_CHOOSER_3_REQUEST = 103;
    public static final String[] mimeTypes = new String[]{
            "image/jpeg", "image/png", "image/jpg"
    };

    Audit audit;
    File[] files;

    public AuditBaseFragment(){
        audit = new Audit();
        files = new File[3];
    }

    public void openPictureChooser(int requestCode){
        Intent intent = new Intent(Intent.ACTION_GET_CONTENT);

        intent.setType("image/*");
        intent.putExtra(Intent.EXTRA_MIME_TYPES, mimeTypes);
        intent.addCategory(Intent.CATEGORY_OPENABLE);

        try {
            startActivityForResult(Intent.createChooser(intent, "Choose"),
                    requestCode);
        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(getActivity(), "Please install a File Manager.",
                    Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode){
            case PICTURE_CHOOSER_1_REQUEST:
            case PICTURE_CHOOSER_2_REQUEST:
            case PICTURE_CHOOSER_3_REQUEST:
                if (resultCode == Activity.RESULT_OK) {
                    Uri imageUri = data.getData();
                    String imagePath = FileUtil.getPath(getContext(), imageUri);
                    final File imageFile = new File(imagePath);
                    if(!Arrays.asList(mimeTypes).contains(FileUtil.getType(getContext(), imageUri))){
                        Toast.makeText(getActivity(), "Please select .jpg, .jpeg, .png file", Toast.LENGTH_LONG).show();
                    }else{
                        switch (requestCode){
                            case PICTURE_CHOOSER_1_REQUEST:
                                files[0] = imageFile;
                                break;
                            case PICTURE_CHOOSER_2_REQUEST:
                                files[1] = imageFile;
                                break;
                            case PICTURE_CHOOSER_3_REQUEST:
                                files[2] = imageFile;
                                break;
                        }
                    }
                }
                break;
            default:
                super.onActivityResult(requestCode, resultCode, data);
                break;
        }
    }

    public File[] getFiles(){
        return files.clone();
    }

    public Audit getAudit(){
        return audit;
    }

    public abstract void updateData(Audit audit, File[] files);

    public abstract boolean isValid();

    public abstract boolean isChanged(Audit audit, File[] files);

    public void post(final ProgressDialog progressDialog, final Callable<Void> next) throws Exception{
        progressDialog.show();
        (new Handler()).postDelayed(new Runnable() {
            public void run() {
                try {
                    progressDialog.hide();

                    next.call();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }, 1000);
    }
}

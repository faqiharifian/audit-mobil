package com.digitcreativestudio.auditmobil;

import android.os.Handler;
import android.support.v4.app.Fragment;

import com.digitcreativestudio.auditmobil.entities.Audit;
import com.digitcreativestudio.auditmobil.view.ProgressDialog;

import java.io.File;
import java.util.concurrent.Callable;

/**
 * Created by faqih on 19/05/17.
 */

public abstract class AuditBaseFragment extends Fragment {
    Audit audit;
    File[] files;

    public AuditBaseFragment(){
        audit = new Audit();
        files = new File[3];
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

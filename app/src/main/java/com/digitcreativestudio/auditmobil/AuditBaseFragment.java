package com.digitcreativestudio.auditmobil;

import android.support.v4.app.Fragment;

import com.digitcreativestudio.auditmobil.entities.Audit;

import java.io.File;

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
        return files;
    }

    public Audit getAudit(){
        return audit;
    }

    public abstract void updateData(Audit audit, File[] files);

    public abstract boolean isValid();

    public abstract boolean isChanged(Audit audit, File[] files);
}

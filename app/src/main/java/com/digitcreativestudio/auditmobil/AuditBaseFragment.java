package com.digitcreativestudio.auditmobil;

import android.support.v4.app.Fragment;

import com.digitcreativestudio.auditmobil.entities.Audit;

import java.io.File;
import java.util.ArrayList;

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

    public abstract boolean isValid();

    public abstract ArrayList<File> getFiles();

    public abstract void updateData(Audit audit, File[] files);

    public abstract Audit getAudit();

    public abstract boolean isChanged(Audit audit, File[] files);
}

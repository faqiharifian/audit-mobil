package com.digitcreativestudio.auditmobil;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.digitcreativestudio.auditmobil.entities.Audit;

import java.io.File;
import java.util.ArrayList;

/**
 * Created by ADIK on 15/05/2017.
 */

public class PengecekanRemFragment extends AuditBaseFragment {
    CheckBox workingCheckBox;
    EditText workingInformationEditText;
    ImageView workingImageView;
    ImageView workingAddImageView;
    TextView workingChangeTextView;

    public PengecekanRemFragment() {
        super();
    }

    public static PengecekanRemFragment newInstance() {
        PengecekanRemFragment fragment = new PengecekanRemFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_pengecekan_rem, container, false);

        workingCheckBox = (CheckBox) rootView.findViewById(R.id.check_working);
        workingInformationEditText = (EditText) rootView.findViewById(R.id.edit_working_information);
        workingImageView = (ImageView) rootView.findViewById(R.id.image_working);
        workingAddImageView = (ImageView) rootView.findViewById(R.id.image_working_add);
        workingChangeTextView = (TextView) rootView.findViewById(R.id.text_working_change_image);

        return rootView;
    }

    @Override
    public boolean isValid() {
        return true;
    }

    @Override
    public ArrayList<File> getFiles() {
        return null;
    }

    @Override
    public void updateData(Audit audit, File[] files) {

    }

    @Override
    public Audit getAudit() {
        return null;
    }

    @Override
    public boolean isChanged(Audit audit, File[] files) {
        return false;
    }
}

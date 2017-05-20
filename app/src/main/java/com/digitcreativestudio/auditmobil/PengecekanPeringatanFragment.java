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

public class PengecekanPeringatanFragment extends AuditBaseFragment {
    CheckBox overallCheckBox;
    EditText overallInformationEditText;
    ImageView overallImageView;
    ImageView overallAddImageView;
    TextView overallChangeTextView;

    public PengecekanPeringatanFragment() {
        super();
    }

    public static PengecekanPeringatanFragment newInstance() {
        PengecekanPeringatanFragment fragment = new PengecekanPeringatanFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_pengecekan_peringatan, container, false);

        overallCheckBox = (CheckBox) rootView.findViewById(R.id.check_overall);
        overallInformationEditText = (EditText) rootView.findViewById(R.id.edit_overall_information);
        overallImageView = (ImageView) rootView.findViewById(R.id.image_overall);
        overallAddImageView = (ImageView) rootView.findViewById(R.id.image_overall_add);
        overallChangeTextView = (TextView) rootView.findViewById(R.id.text_overall_change_image);

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

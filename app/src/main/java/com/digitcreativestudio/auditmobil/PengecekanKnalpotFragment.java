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

public class PengecekanKnalpotFragment extends AuditBaseFragment {
    CheckBox bentCheckBox;
    EditText bentInformationEditText;
    ImageView bentImageView,
            bentAddImageView;
    TextView bentChangeTextView;

    CheckBox standardCheckBox;
    EditText standardEmmisionEditText,
            standardInformationEditText;
    ImageView standardImageView,
            standardAddImageView;
    TextView standardChangeTextView;

    public PengecekanKnalpotFragment() {
        super();
    }

    public static PengecekanKnalpotFragment newInstance() {
        PengecekanKnalpotFragment fragment = new PengecekanKnalpotFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_pengecekan_knalpot, container, false);

        bentCheckBox = (CheckBox) rootView.findViewById(R.id.check_bent);
        bentInformationEditText = (EditText) rootView.findViewById(R.id.edit_bent_information);
        bentImageView = (ImageView) rootView.findViewById(R.id.image_bent);
        bentAddImageView = (ImageView) rootView.findViewById(R.id.image_bent_add);
        bentChangeTextView = (TextView) rootView.findViewById(R.id.text_bent_change_image);

        standardCheckBox = (CheckBox) rootView.findViewById(R.id.check_standard);
        standardEmmisionEditText = (EditText) rootView.findViewById(R.id.edit_standard_emission);
        standardInformationEditText = (EditText) rootView.findViewById(R.id.edit_standard_information);
        standardImageView = (ImageView) rootView.findViewById(R.id.image_standard);
        standardAddImageView = (ImageView) rootView.findViewById(R.id.image_standard_add);
        standardChangeTextView = (TextView) rootView.findViewById(R.id.text_standard_change_image);

        return rootView;
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
    public boolean isValid() {
        return true;
    }

    @Override
    public boolean isChanged(Audit audit, File[] files) {
        return false;
    }
}

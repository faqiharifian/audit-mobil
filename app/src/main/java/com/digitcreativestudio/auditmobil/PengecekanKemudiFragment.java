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

public class PengecekanKemudiFragment extends AuditBaseFragment {
    CheckBox steerMaxCheckBox;
    EditText steerMaxInformationEditText;
    ImageView steerMaxImageView;
    ImageView steerMaxAddImageView;
    TextView steerMaxChangeTextView;

    CheckBox easySteerCheckBox;
    EditText easySteerInformationEditText;
    ImageView easySteerImageView;
    ImageView easySteerAddImageView;
    TextView easySteerChangeTextView;

    public PengecekanKemudiFragment() {
        super();
    }

    public static PengecekanKemudiFragment newInstance() {
        PengecekanKemudiFragment fragment = new PengecekanKemudiFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_pengecekan_kemudi, container, false);

        steerMaxCheckBox = (CheckBox) rootView.findViewById(R.id.check_steer_max);
        steerMaxInformationEditText = (EditText) rootView.findViewById(R.id.edit_steer_max_information);
        steerMaxImageView = (ImageView) rootView.findViewById(R.id.image_steer_max);
        steerMaxAddImageView = (ImageView) rootView.findViewById(R.id.image_steer_max_add);
        steerMaxChangeTextView = (TextView) rootView.findViewById(R.id.text_steer_max_change_image);

        easySteerCheckBox = (CheckBox) rootView.findViewById(R.id.check_easy_steer);
        easySteerInformationEditText = (EditText) rootView.findViewById(R.id.edit_easy_steer_information);
        easySteerImageView = (ImageView) rootView.findViewById(R.id.image_easy_steer);
        easySteerAddImageView = (ImageView) rootView.findViewById(R.id.image_easy_steer_add);
        easySteerChangeTextView = (TextView) rootView.findViewById(R.id.text_easy_steer_change_image);

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

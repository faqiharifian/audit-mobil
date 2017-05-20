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

/**
 * Created by ADIK on 15/05/2017.
 */

public class PengecekanLampuFragment extends AuditBaseFragment {
    CheckBox lightOnClosedCheckBox;
    EditText lightOnClosedInformationEditText;
    ImageView lightOnClosedImageView;
    ImageView lightOnClosedAddImageView;
    TextView lightOnClosedChangeTextView;

    CheckBox lightOverallCheckBox;
    EditText lightOverallInformationEditText;
    ImageView lightOverallImageView;
    ImageView lightOverallAddImageView;
    TextView lightOverallChangeTextView;

    public PengecekanLampuFragment() {
        super();
    }

    public static PengecekanLampuFragment newInstance() {
        PengecekanLampuFragment fragment = new PengecekanLampuFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_pengecekan_lampu, container, false);

        lightOnClosedCheckBox = (CheckBox) rootView.findViewById(R.id.check_light_on_closed);
        lightOnClosedInformationEditText = (EditText) rootView.findViewById(R.id.edit_light_on_closed_information);
        lightOnClosedImageView = (ImageView) rootView.findViewById(R.id.image_light_on_closed);
        lightOnClosedAddImageView = (ImageView) rootView.findViewById(R.id.image_light_on_closed_add);
        lightOnClosedChangeTextView = (TextView) rootView.findViewById(R.id.text_light_on_closed_change_image);

        lightOverallCheckBox = (CheckBox) rootView.findViewById(R.id.check_light_overall);
        lightOverallInformationEditText = (EditText) rootView.findViewById(R.id.edit_light_overall_information);
        lightOverallImageView = (ImageView) rootView.findViewById(R.id.image_light_overall);
        lightOverallAddImageView = (ImageView) rootView.findViewById(R.id.image_light_overall_add);
        lightOverallChangeTextView = (TextView) rootView.findViewById(R.id.text_light_overall_change_image);

        return rootView;
    }

    @Override
    public void updateData(Audit audit, File[] files) {
        if(audit.isInstantiated5()){
            lightOnClosedCheckBox.setChecked(audit.isLight_on_closed_check());
            lightOnClosedInformationEditText.setText(audit.getLight_on_closed_information());

            lightOverallCheckBox.setChecked(audit.isLight_overall_check());
            lightOverallInformationEditText.setText(audit.getLight_overall_information());
        }
    }

    @Override
    public boolean isValid() {
        audit.setInstantiated5(true);

        audit.setLight_on_closed_check(lightOnClosedCheckBox.isChecked());
        audit.setLight_on_closed_information(lightOnClosedInformationEditText.getText().toString().trim());

        audit.setLight_overall_check(lightOverallCheckBox.isChecked());
        audit.setLight_overall_information(lightOverallInformationEditText.getText().toString().trim());
        return true;
    }

    @Override
    public boolean isChanged(Audit audit, File[] files) {
        return false;
    }
}

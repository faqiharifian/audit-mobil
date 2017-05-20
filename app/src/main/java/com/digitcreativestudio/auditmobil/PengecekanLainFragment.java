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

public class PengecekanLainFragment extends AuditBaseFragment {
    CheckBox emergencyCheckBox;
    EditText emergencyInformationEditText;
    ImageView emergencyImageView;
    ImageView emergencyAddImageView;
    TextView emergencyChangeTextView;

    CheckBox doorCheckBox;
    EditText doorInformationEditText;
    ImageView doorImageView;
    ImageView doorAddImageView;
    TextView doorChangeTextView;

    CheckBox spatborCheckBox;
    EditText spatborInformationEditText;
    ImageView spatborImageView;
    ImageView spatborAddImageView;
    TextView spatborChangeTextView;

    public PengecekanLainFragment() {
        super();
    }

    public static PengecekanLainFragment newInstance() {
        PengecekanLainFragment fragment = new PengecekanLainFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_pengecekan_lain, container, false);

        emergencyCheckBox = (CheckBox) rootView.findViewById(R.id.check_emergency);
        emergencyInformationEditText = (EditText) rootView.findViewById(R.id.edit_emergency_information);
        emergencyImageView = (ImageView) rootView.findViewById(R.id.image_emergency);
        emergencyAddImageView = (ImageView) rootView.findViewById(R.id.image_emergency_add);
        emergencyChangeTextView = (TextView) rootView.findViewById(R.id.text_emergency_change_image);

        doorCheckBox = (CheckBox) rootView.findViewById(R.id.check_door);
        doorInformationEditText = (EditText) rootView.findViewById(R.id.edit_door_information);
        doorImageView = (ImageView) rootView.findViewById(R.id.image_door);
        doorAddImageView = (ImageView) rootView.findViewById(R.id.image_door_add);
        doorChangeTextView = (TextView) rootView.findViewById(R.id.text_door_change_image);

        spatborCheckBox = (CheckBox) rootView.findViewById(R.id.check_spatbor);
        spatborInformationEditText = (EditText) rootView.findViewById(R.id.edit_spatbor_information);
        spatborImageView = (ImageView) rootView.findViewById(R.id.image_spatbor);
        spatborAddImageView = (ImageView) rootView.findViewById(R.id.image_spatbor_add);
        spatborChangeTextView = (TextView) rootView.findViewById(R.id.text_spatbor_change_image);

        return rootView;
    }

    @Override
    public void updateData(Audit audit, File[] files) {
        if(audit.isInstantiated12()){
            emergencyCheckBox.setChecked(audit.isEmergency_check());
            emergencyInformationEditText.setText(audit.getEmergency_information());

            doorCheckBox.setChecked(audit.isDoor_check());
            doorInformationEditText.setText(audit.getDoor_information());

            spatborCheckBox.setChecked(audit.isSpatbor_check());
            spatborInformationEditText.setText(audit.getSpatbor_information());
        }
    }

    @Override
    public boolean isValid() {
        audit.setInstantiated12(true);

        audit.setEmergency_check(emergencyCheckBox.isChecked());
        audit.setEmergency_information(emergencyInformationEditText.getText().toString().trim());

        audit.setDoor_check(doorCheckBox.isChecked());
        audit.setDoor_information(doorInformationEditText.getText().toString().trim());

        audit.setSpatbor_check(spatborCheckBox.isChecked());
        audit.setSpatbor_information(spatborInformationEditText.getText().toString().trim());
        return true;
    }

    @Override
    public boolean isChanged(Audit audit, File[] files) {
        return false;
    }
}

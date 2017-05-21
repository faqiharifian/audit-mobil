package com.digitcreativestudio.auditmobil;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.digitcreativestudio.auditmobil.entities.Audit;
import com.digitcreativestudio.auditmobil.utilities.FileUtil;

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
        emergencyImageView.setOnClickListener(this);
        emergencyAddImageView = (ImageView) rootView.findViewById(R.id.image_emergency_add);
        emergencyChangeTextView = (TextView) rootView.findViewById(R.id.text_emergency_change_image);

        doorCheckBox = (CheckBox) rootView.findViewById(R.id.check_door);
        doorInformationEditText = (EditText) rootView.findViewById(R.id.edit_door_information);
        doorImageView = (ImageView) rootView.findViewById(R.id.image_door);
        doorImageView.setOnClickListener(this);
        doorAddImageView = (ImageView) rootView.findViewById(R.id.image_door_add);
        doorChangeTextView = (TextView) rootView.findViewById(R.id.text_door_change_image);

        spatborCheckBox = (CheckBox) rootView.findViewById(R.id.check_spatbor);
        spatborInformationEditText = (EditText) rootView.findViewById(R.id.edit_spatbor_information);
        spatborImageView = (ImageView) rootView.findViewById(R.id.image_spatbor);
        spatborImageView.setOnClickListener(this);
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

            if(files[0] != null){
                Glide.with(getContext()).load(files[0]).into(emergencyImageView);
                emergencyAddImageView.setVisibility(View.GONE);
                emergencyChangeTextView.setVisibility(View.VISIBLE);
            }
            if(files[1] != null){
                Glide.with(getContext()).load(files[1]).into(doorImageView);
                doorAddImageView.setVisibility(View.GONE);
                doorChangeTextView.setVisibility(View.VISIBLE);
            }
            if(files[2] != null){
                Glide.with(getContext()).load(files[2]).into(spatborImageView);
                spatborAddImageView.setVisibility(View.GONE);
                spatborChangeTextView.setVisibility(View.VISIBLE);
            }
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
        boolean isChanged = false;
        if(audit.isInstantiated12()){
            if(
                    audit.isEmergency_check() != this.audit.isEmergency_check() ||
                    !audit.getEmergency_information().equals(this.audit.getEmergency_information()) ||

                    audit.isDoor_check() != this.audit.isDoor_check() ||
                    !audit.getDoor_information().equals(this.audit.getDoor_information()) ||

                    audit.isSpatbor_check() != this.audit.isSpatbor_check() ||
                    !audit.getSpatbor_information().equals(this.audit.getSpatbor_information()) ||

                    FileUtil.compare(files[0], this.files[0]) != 0 ||
                    FileUtil.compare(files[1], this.files[1]) != 0 ||
                    FileUtil.compare(files[2], this.files[2]) != 0
                ){
                isChanged = true;
            }
        }else{
            isChanged = true;
        }
        return isChanged;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.image_emergency:
                openPictureChooser(0);
                break;
            case R.id.image_door:
                openPictureChooser(1);
                break;
            case R.id.image_spatbor:
                openPictureChooser(2);
                break;
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == Activity.RESULT_OK) {
            switch (requestCode) {
                case PICTURE_CHOOSER_1_REQUEST:
                    Glide.with(getContext()).load(files[0]).into(emergencyImageView);
                    emergencyAddImageView.setVisibility(View.GONE);
                    emergencyChangeTextView.setVisibility(View.VISIBLE);
                    break;
                case PICTURE_CHOOSER_2_REQUEST:
                    Glide.with(getContext()).load(files[1]).into(doorImageView);
                    doorAddImageView.setVisibility(View.GONE);
                    doorChangeTextView.setVisibility(View.VISIBLE);
                    break;
                case PICTURE_CHOOSER_3_REQUEST:
                    Glide.with(getContext()).load(files[2]).into(spatborImageView);
                    spatborAddImageView.setVisibility(View.GONE);
                    spatborChangeTextView.setVisibility(View.VISIBLE);
                    break;
            }
        }
    }
}

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
        lightOnClosedImageView.setOnClickListener(this);
        lightOnClosedAddImageView = (ImageView) rootView.findViewById(R.id.image_light_on_closed_add);
        lightOnClosedChangeTextView = (TextView) rootView.findViewById(R.id.text_light_on_closed_change_image);

        lightOverallCheckBox = (CheckBox) rootView.findViewById(R.id.check_light_overall);
        lightOverallInformationEditText = (EditText) rootView.findViewById(R.id.edit_light_overall_information);
        lightOverallImageView = (ImageView) rootView.findViewById(R.id.image_light_overall);
        lightOverallImageView.setOnClickListener(this);
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

            if(files[0] != null){
                Glide.with(getContext()).load(files[0]).into(lightOnClosedImageView);
                lightOnClosedAddImageView.setVisibility(View.GONE);
                lightOnClosedChangeTextView.setVisibility(View.VISIBLE);
            }
            if(files[1] != null){
                Glide.with(getContext()).load(files[1]).into(lightOverallImageView);
                lightOverallAddImageView.setVisibility(View.GONE);
                lightOverallChangeTextView.setVisibility(View.VISIBLE);
            }
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
        boolean isChanged = false;
        if(audit.isInstantiated5()){
            if(
                    audit.isLight_on_closed_check() != this.audit.isLight_on_closed_check() ||
                    !audit.getLight_on_closed_information().equals(this.audit.getLight_on_closed_information()) ||

                    audit.isLight_overall_check() != this.audit.isLight_overall_check() ||
                    !audit.getLight_overall_information().equals(this.audit.getLight_overall_information()) ||

                    FileUtil.compare(files[0], this.files[0]) != 0 ||
                    FileUtil.compare(files[1], this.files[1]) != 0
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
            case R.id.image_light_on_closed:
                openPictureChooser(0);
                break;
            case R.id.image_light_overall:
                openPictureChooser(1);
                break;
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == Activity.RESULT_OK) {
            switch (requestCode) {
                case PICTURE_CHOOSER_1_REQUEST:
                    Glide.with(getContext()).load(files[0]).into(lightOnClosedImageView);
                    lightOnClosedAddImageView.setVisibility(View.GONE);
                    lightOnClosedChangeTextView.setVisibility(View.VISIBLE);
                    break;
                case PICTURE_CHOOSER_2_REQUEST:
                    Glide.with(getContext()).load(files[1]).into(lightOverallImageView);
                    lightOverallAddImageView.setVisibility(View.GONE);
                    lightOverallChangeTextView.setVisibility(View.VISIBLE);
                    break;
            }
        }
    }
}

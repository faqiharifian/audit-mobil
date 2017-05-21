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

public class PengecekanMotorFragment extends AuditBaseFragment {
    CheckBox safetySwitch1CheckBox;
    EditText safetySwitch1InformationEditText;
    ImageView safetySwitch1ImageView,
            safetySwitch1AddImageView;
    TextView safetySwitch1ChangeTextView;

    CheckBox safetySwitch2CheckBox;
    EditText safetySwitch2InformationEditText;
    ImageView safetySwitch2ImageView,
            safetySwitch2AddImageView;
    TextView safetySwitch2ChangeTextView;

    CheckBox starterCheckBox;
    EditText starterInformationEditText;
    ImageView starterImageView,
            starterAddImageView;
    TextView starterChangeTextView;

    public PengecekanMotorFragment() {
        super();
    }

    public static PengecekanMotorFragment newInstance() {
        PengecekanMotorFragment fragment = new PengecekanMotorFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_pengecekan_motor, container, false);

        safetySwitch1CheckBox = (CheckBox ) rootView.findViewById(R.id.check_safety_switch_1);
        safetySwitch1InformationEditText = (EditText) rootView.findViewById(R.id.edit_safety_switch_1_information);
        safetySwitch1ImageView = (ImageView) rootView.findViewById(R.id.image_safety_switch_1);
        safetySwitch1AddImageView = (ImageView) rootView.findViewById(R.id.image_safety_switch_1_add);
        safetySwitch1ChangeTextView = (TextView) rootView.findViewById(R.id.text_safety_switch_1_change_image);
        safetySwitch1ImageView.setOnClickListener(this);

        safetySwitch2CheckBox = (CheckBox ) rootView.findViewById(R.id.check_safety_switch_2);
        safetySwitch2InformationEditText = (EditText) rootView.findViewById(R.id.edit_safety_switch_2_information);
        safetySwitch2ImageView = (ImageView) rootView.findViewById(R.id.image_safety_switch_2);
        safetySwitch2AddImageView = (ImageView) rootView.findViewById(R.id.image_safety_switch_2_add);
        safetySwitch2ChangeTextView = (TextView) rootView.findViewById(R.id.text_safety_switch_2_change_image);
        safetySwitch2ImageView.setOnClickListener(this);

        starterCheckBox = (CheckBox ) rootView.findViewById(R.id.check_starter);
        starterInformationEditText = (EditText) rootView.findViewById(R.id.edit_starter_information);
        starterImageView = (ImageView) rootView.findViewById(R.id.image_starter);
        starterAddImageView = (ImageView) rootView.findViewById(R.id.image_starter_add);
        starterChangeTextView = (TextView) rootView.findViewById(R.id.text_starter_change_image);
        starterImageView.setOnClickListener(this);

        return rootView;
    }

    @Override
    public void updateData(Audit audit, File[] files) {
        if(audit.isInstantiated1()){
            safetySwitch1CheckBox.setChecked(audit.isSafety_switch_1_check());
            safetySwitch1InformationEditText.setText(audit.getSafety_switch_1_information());

            safetySwitch2CheckBox.setChecked(audit.isSafety_switch_2_check());
            safetySwitch2InformationEditText.setText(audit.getSafety_switch_2_information());

            starterCheckBox.setChecked(audit.isStarter_check());
            starterInformationEditText.setText(audit.getStarter_information());

            if(files[0] != null){
                Glide.with(getContext()).load(files[0]).into(safetySwitch1ImageView);
                safetySwitch1AddImageView.setVisibility(View.GONE);
                safetySwitch1ChangeTextView.setVisibility(View.VISIBLE);
            }
            if(files[1] != null){
                Glide.with(getContext()).load(files[1]).into(safetySwitch2ImageView);
                safetySwitch2AddImageView.setVisibility(View.GONE);
                safetySwitch2ChangeTextView.setVisibility(View.VISIBLE);
            }
            if(files[2] != null){
                Glide.with(getContext()).load(files[2]).into(starterImageView);
                starterAddImageView.setVisibility(View.GONE);
                starterChangeTextView.setVisibility(View.VISIBLE);
            }
        }
    }

    @Override
    public boolean isValid() {
        audit.setInstantiated1(true);

        audit.setSafety_switch_1_check(safetySwitch1CheckBox.isChecked());
        audit.setSafety_switch_1_information(safetySwitch1InformationEditText.getText().toString().trim());

        audit.setSafety_switch_2_check(safetySwitch2CheckBox.isChecked());
        audit.setSafety_switch_2_information(safetySwitch2InformationEditText.getText().toString().trim());

        audit.setStarter_check(starterCheckBox.isChecked());
        audit.setStarter_information(starterInformationEditText.getText().toString().trim());
        return true;
    }

    @Override
    public boolean isChanged(Audit audit, File[] files) {
        boolean isChanged = false;
        if(audit.isInstantiated1()){
            if(
                    audit.isSafety_switch_1_check() != this.audit.isSafety_switch_1_check() ||
                    !audit.getSafety_switch_1_information().equals(this.audit.getSafety_switch_1_information()) ||

                    audit.isSafety_switch_2_check() != this.audit.isSafety_switch_2_check() ||
                    !audit.getSafety_switch_2_information().equals(this.audit.getSafety_switch_2_information()) ||

                    audit.isStarter_check() != this.audit.isStarter_check() ||
                    !audit.getStarter_information().equals(this.audit.getStarter_information()) ||

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
            case R.id.image_safety_switch_1:
                openPictureChooser(0);
                break;
            case R.id.image_safety_switch_2:
                openPictureChooser(1);
                break;
            case R.id.image_starter:
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
                    Glide.with(getContext()).load(files[0]).into(safetySwitch1ImageView);
                    safetySwitch1AddImageView.setVisibility(View.GONE);
                    safetySwitch1ChangeTextView.setVisibility(View.VISIBLE);
                    break;
                case PICTURE_CHOOSER_2_REQUEST:
                    Glide.with(getContext()).load(files[1]).into(safetySwitch2ImageView);
                    safetySwitch2AddImageView.setVisibility(View.GONE);
                    safetySwitch2ChangeTextView.setVisibility(View.VISIBLE);
                    break;
                case PICTURE_CHOOSER_3_REQUEST:
                    Glide.with(getContext()).load(files[2]).into(starterImageView);
                    starterAddImageView.setVisibility(View.GONE);
                    starterChangeTextView.setVisibility(View.VISIBLE);
                    break;
            }
        }
    }
}

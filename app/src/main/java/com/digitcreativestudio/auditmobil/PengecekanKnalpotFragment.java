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
        bentImageView.setOnClickListener(this);

        standardCheckBox = (CheckBox) rootView.findViewById(R.id.check_standard);
        standardEmmisionEditText = (EditText) rootView.findViewById(R.id.edit_standard_emission);
        standardInformationEditText = (EditText) rootView.findViewById(R.id.edit_standard_information);
        standardImageView = (ImageView) rootView.findViewById(R.id.image_standard);
        standardAddImageView = (ImageView) rootView.findViewById(R.id.image_standard_add);
        standardChangeTextView = (TextView) rootView.findViewById(R.id.text_standard_change_image);
        standardImageView.setOnClickListener(this);

        return rootView;
    }

    @Override
    public void updateData(Audit audit, File[] files) {
        if(audit.isInstantiated2()){
            bentCheckBox.setChecked(audit.isBent_check());
            bentInformationEditText.setText(audit.getBent_information());

            standardCheckBox.setChecked(audit.isStandard_check());
            standardEmmisionEditText.setText(audit.getStandard_emission());
            standardInformationEditText.setText(audit.getStandard_information());

            if(files[0] != null){
                Glide.with(getContext()).load(files[0]).into(bentImageView);
                bentAddImageView.setVisibility(View.GONE);
                bentChangeTextView.setVisibility(View.VISIBLE);
            }
            if(files[1] != null){
                Glide.with(getContext()).load(files[1]).into(standardImageView);
                standardAddImageView.setVisibility(View.GONE);
                standardChangeTextView.setVisibility(View.VISIBLE);
            }
        }
    }

    @Override
    public boolean isValid() {
        audit.setInstantiated2(true);

        audit.setBent_check(bentCheckBox.isChecked());
        audit.setBent_information(bentInformationEditText.getText().toString().trim());

        audit.setStandard_check(standardCheckBox.isChecked());
        audit.setStandard_emission(standardEmmisionEditText.getText().toString().trim());
        audit.setStandard_information(standardInformationEditText.getText().toString().trim());
        return true;
    }

    @Override
    public boolean isChanged(Audit audit, File[] files) {
        boolean isChanged = false;
        if(audit.isInstantiated2()){
            if(
                    audit.isBent_check() != this.audit.isBent_check() ||
                    !audit.getBent_information().equals(this.audit.getBent_information()) ||

                    audit.isStandard_check() != this.audit.isStandard_check() ||
                    !audit.getStandard_emission().equals(audit.getStandard_emission()) ||
                    !audit.getStandard_information().equals(this.audit.getStandard_information()) ||

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
            case R.id.image_bent:
                openPictureChooser(0);
                break;
            case R.id.image_standard:
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
                    Glide.with(getContext()).load(files[0]).into(bentImageView);
                    bentAddImageView.setVisibility(View.GONE);
                    bentChangeTextView.setVisibility(View.VISIBLE);
                    break;
                case PICTURE_CHOOSER_2_REQUEST:
                    Glide.with(getContext()).load(files[1]).into(standardImageView);
                    standardAddImageView.setVisibility(View.GONE);
                    standardChangeTextView.setVisibility(View.VISIBLE);
                    break;
            }
        }
    }
}

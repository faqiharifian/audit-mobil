package com.digitcreativestudio.auditmobil;

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

public class PengecekanPemadamFragment extends AuditBaseFragment {
    CheckBox dcpCo2CheckBox;
    EditText dcpCo2InformationEditText;
    ImageView dcpCo2ImageView;
    ImageView dcpCo2AddImageView;
    TextView dcpCo2ChangeTextView;

    CheckBox goodConditionCheckBox;
    EditText goodConditionInformationEditText;
    ImageView goodConditionImageView;
    ImageView goodConditionAddImageView;
    TextView goodConditionChangeTextView;

    public PengecekanPemadamFragment() {
        super();
    }

    public static PengecekanPemadamFragment newInstance() {
        PengecekanPemadamFragment fragment = new PengecekanPemadamFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_pengecekan_pemadam, container, false);

        dcpCo2CheckBox = (CheckBox) rootView.findViewById(R.id.check_dcp_co2);
        dcpCo2InformationEditText = (EditText) rootView.findViewById(R.id.edit_dcp_co2_information);
        dcpCo2ImageView = (ImageView) rootView.findViewById(R.id.image_dcp_co2);
        dcpCo2AddImageView = (ImageView) rootView.findViewById(R.id.image_dcp_co2_add);
        dcpCo2ChangeTextView = (TextView) rootView.findViewById(R.id.text_dcp_co2_change_image);

        goodConditionCheckBox = (CheckBox) rootView.findViewById(R.id.check_good_condition);
        goodConditionInformationEditText = (EditText) rootView.findViewById(R.id.edit_good_condition_information);
        goodConditionImageView = (ImageView) rootView.findViewById(R.id.image_good_condition);
        goodConditionAddImageView = (ImageView) rootView.findViewById(R.id.image_good_condition_add);
        goodConditionChangeTextView = (TextView) rootView.findViewById(R.id.text_good_condition_change_image);

        return rootView;
    }

    @Override
    public void updateData(Audit audit, File[] files) {
        if(audit.isInstantiated7()){
            dcpCo2CheckBox.setChecked(audit.isDcp_co2_check());
            dcpCo2InformationEditText.setText(audit.getDcp_co2_information());

            goodConditionCheckBox.setChecked(audit.isGood_condition_check());
            goodConditionInformationEditText.setText(audit.getGood_condition_information());

            if(files[0] != null){
                Glide.with(getContext()).load(files[0]).into(dcpCo2ImageView);
                dcpCo2AddImageView.setVisibility(View.GONE);
                dcpCo2ChangeTextView.setVisibility(View.VISIBLE);
            }
            if(files[1] != null){
                Glide.with(getContext()).load(files[1]).into(goodConditionImageView);
                goodConditionAddImageView.setVisibility(View.GONE);
                goodConditionChangeTextView.setVisibility(View.VISIBLE);
            }
        }
    }

    @Override
    public boolean isValid() {
        audit.setInstantiated7(true);

        audit.setDcp_co2_check(dcpCo2CheckBox.isChecked());
        audit.setDcp_co2_information(dcpCo2InformationEditText.getText().toString().trim());

        audit.setGood_condition_check(goodConditionCheckBox.isChecked());
        audit.setGood_condition_information(dcpCo2InformationEditText.getText().toString().trim());
        return true;
    }

    @Override
    public boolean isChanged(Audit audit, File[] files) {
        boolean isChanged = false;
        if(audit.isInstantiated7()){
            if(
                    audit.isDcp_co2_check() != this.audit.isDcp_co2_check() ||
                    !audit.getDcp_co2_information().equals(this.audit.getDcp_co2_information()) ||

                    audit.isGood_condition_check() != this.audit.isGood_condition_check() ||
                    !audit.getGood_condition_information().equals(this.audit.getGood_condition_information()) ||

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
}

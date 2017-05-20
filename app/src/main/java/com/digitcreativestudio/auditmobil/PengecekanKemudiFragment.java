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
import com.digitcreativestudio.auditmobil.utilities.FileUtil;

import java.io.File;

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
    public void updateData(Audit audit, File[] files) {
        if(audit.isInstantiated10()){
            steerMaxCheckBox.setChecked(audit.isSteer_max_check());
            steerMaxInformationEditText.setText(audit.getSteer_max_information());

            easySteerCheckBox.setChecked(audit.isEasy_steer_check());
            easySteerInformationEditText.setText(audit.getEasy_steer_information());
        }
    }

    @Override
    public boolean isValid() {
        audit.setInstantiated10(true);

        audit.setSteer_max_check(steerMaxCheckBox.isChecked());
        audit.setSteer_max_information(steerMaxInformationEditText.getText().toString().trim());

        audit.setEasy_steer_check(easySteerCheckBox.isChecked());
        audit.setEasy_steer_information(easySteerInformationEditText.getText().toString().trim());
        return true;
    }

    @Override
    public boolean isChanged(Audit audit, File[] files) {
        boolean isChanged = false;
        if(audit.isInstantiated10()){
            if(
                    audit.isSteer_max_check() != this.audit.isSteer_max_check() ||
                    !audit.getSteer_max_information().equals(this.audit.getSteer_max_information()) ||

                    audit.isEasy_steer_check() != this.audit.isEasy_steer_check() ||
                    !audit.getEasy_steer_information().equals(this.audit.getEasy_steer_information()) ||

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

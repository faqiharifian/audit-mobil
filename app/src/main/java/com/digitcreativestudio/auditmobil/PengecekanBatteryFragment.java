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

public class PengecekanBatteryFragment extends AuditBaseFragment {
    CheckBox wellMaintainedCheckBox;
    EditText wellMaintainedInformationEditText;
    ImageView wellMaintainedImageView;
    ImageView wellMaintainedAddImageView;
    TextView wellMaintainedChangeTextView;

    CheckBox wellInstalledCheckBox;
    EditText wellInstalledInformationEditText;
    ImageView wellInstalledImageView;
    ImageView wellInstalledAddImageView;
    TextView wellInstalledChangeTextView;

    public PengecekanBatteryFragment() {
        super();
    }

    public static PengecekanBatteryFragment newInstance() {
        PengecekanBatteryFragment fragment = new PengecekanBatteryFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_pengecekan_battery, container, false);

        wellMaintainedCheckBox = (CheckBox) rootView.findViewById(R.id.check_well_maintained);
        wellMaintainedInformationEditText = (EditText) rootView.findViewById(R.id.edit_well_maintained_information);
        wellMaintainedImageView = (ImageView) rootView.findViewById(R.id.image_well_maintained);
        wellMaintainedAddImageView = (ImageView) rootView.findViewById(R.id.image_well_maintained_add);
        wellMaintainedChangeTextView = (TextView) rootView.findViewById(R.id.text_well_maintained_change_image);

        wellInstalledCheckBox = (CheckBox) rootView.findViewById(R.id.check_well_installed);
        wellInstalledInformationEditText = (EditText) rootView.findViewById(R.id.edit_well_installed_information);
        wellInstalledImageView = (ImageView) rootView.findViewById(R.id.image_well_installed);
        wellInstalledAddImageView = (ImageView) rootView.findViewById(R.id.image_well_installed_add);
        wellInstalledChangeTextView = (TextView) rootView.findViewById(R.id.text_well_installed_change_image);

        return rootView;
    }

    @Override
    public void updateData(Audit audit, File[] files) {
        if(audit.isInstantiated4()){
            wellMaintainedCheckBox.setChecked(audit.isWell_maintained_check());
            wellMaintainedInformationEditText.setText(audit.getWell_maintained_information());

            wellInstalledCheckBox.setChecked(audit.isWell_installed_check());
            wellInstalledInformationEditText.setText(audit.getWell_installed_information());


            if(files[0] != null){
                Glide.with(getContext()).load(files[0]).into(wellMaintainedImageView);
                wellMaintainedAddImageView.setVisibility(View.GONE);
                wellMaintainedChangeTextView.setVisibility(View.VISIBLE);
            }
            if(files[1] != null){
                Glide.with(getContext()).load(files[1]).into(wellInstalledImageView);
                wellInstalledAddImageView.setVisibility(View.GONE);
                wellInstalledChangeTextView.setVisibility(View.VISIBLE);
            }
        }
    }

    @Override
    public boolean isValid() {
        audit.setInstantiated4(true);

        audit.setWell_maintained_check(wellMaintainedCheckBox.isChecked());
        audit.setWell_maintained_information(wellMaintainedInformationEditText.getText().toString().trim());

        audit.setWell_installed_check(wellInstalledCheckBox.isChecked());
        audit.setWell_installed_information(wellInstalledCheckBox.getText().toString().trim());
        return true;
    }

    @Override
    public boolean isChanged(Audit audit, File[] files) {
        boolean isChanged = false;
        if(audit.isInstantiated4()){
            if(
                    audit.isWell_maintained_check() != this.audit.isWell_maintained_check() ||
                    !audit.getWell_maintained_information().equals(this.audit.getWell_maintained_information()) ||

                    audit.isWell_installed_check() != this.audit.isWell_installed_check() ||
                    !audit.getWell_installed_information().equals(this.audit.getWell_installed_information()) ||

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

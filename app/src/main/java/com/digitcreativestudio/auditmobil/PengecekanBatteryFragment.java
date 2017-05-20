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

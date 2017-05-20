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

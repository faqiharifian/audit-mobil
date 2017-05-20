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

        safetySwitch2CheckBox = (CheckBox ) rootView.findViewById(R.id.check_safety_switch_2);
        safetySwitch2InformationEditText = (EditText) rootView.findViewById(R.id.edit_safety_switch_2_information);
        safetySwitch2ImageView = (ImageView) rootView.findViewById(R.id.image_safety_switch_2);
        safetySwitch2AddImageView = (ImageView) rootView.findViewById(R.id.image_safety_switch_2_add);
        safetySwitch2ChangeTextView = (TextView) rootView.findViewById(R.id.text_safety_switch_2_change_image);

        starterCheckBox = (CheckBox ) rootView.findViewById(R.id.check_starter);
        starterInformationEditText = (EditText) rootView.findViewById(R.id.edit_starter_information);
        starterImageView = (ImageView) rootView.findViewById(R.id.image_starter);
        starterAddImageView = (ImageView) rootView.findViewById(R.id.image_starter_add);
        starterChangeTextView = (TextView) rootView.findViewById(R.id.text_starter_change_image);

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

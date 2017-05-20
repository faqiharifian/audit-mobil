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

public class PengecekanRodaFragment extends AuditBaseFragment {
    CheckBox frontTireCheckBox;
    EditText frontTireInformationEditText;
    ImageView frontTireImageView;
    ImageView frontTireAddImageView;
    TextView frontTireChangeTextView;

    CheckBox rearTireCheckBox;
    EditText rearTireInformationEditText;
    ImageView rearTireImageView;
    ImageView rearTireAddImageView;
    TextView rearTireChangeTextView;

    public PengecekanRodaFragment() {
        super();
    }

    public static PengecekanRodaFragment newInstance() {
        PengecekanRodaFragment fragment = new PengecekanRodaFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_pengecekan_roda, container, false);

        frontTireCheckBox = (CheckBox) rootView.findViewById(R.id.check_front_tire);
        frontTireInformationEditText = (EditText) rootView.findViewById(R.id.edit_front_tire_information);
        frontTireImageView = (ImageView) rootView.findViewById(R.id.image_front_tire);
        frontTireAddImageView = (ImageView) rootView.findViewById(R.id.image_front_tire_add);
        frontTireChangeTextView = (TextView) rootView.findViewById(R.id.text_front_tire_change_image);

        rearTireCheckBox = (CheckBox) rootView.findViewById(R.id.check_rear_tire);
        rearTireInformationEditText = (EditText) rootView.findViewById(R.id.edit_rear_tire_information);
        rearTireImageView = (ImageView) rootView.findViewById(R.id.image_rear_tire);
        rearTireAddImageView = (ImageView) rootView.findViewById(R.id.image_rear_tire_add);
        rearTireChangeTextView = (TextView) rootView.findViewById(R.id.text_rear_tire_change_image);

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

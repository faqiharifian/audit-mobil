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
    public void updateData(Audit audit, File[] files) {
        if(audit.isInstantiated9()){
            frontTireCheckBox.setChecked(audit.isFront_tire_check());
            frontTireInformationEditText.setText(audit.getFront_tire_information());

            rearTireCheckBox.setChecked(audit.isRear_tire_check());
            rearTireInformationEditText.setText(audit.getRear_tire_information());
        }
    }

    @Override
    public boolean isValid() {
        audit.setInstantiated9(true);

        audit.setFront_tire_check(frontTireCheckBox.isChecked());
        audit.setFront_tire_information(frontTireInformationEditText.getText().toString().trim());

        audit.setRear_tire_check(rearTireCheckBox.isChecked());
        audit.setRear_tire_information(rearTireInformationEditText.getText().toString().trim());
        return true;
    }

    @Override
    public boolean isChanged(Audit audit, File[] files) {
        boolean isChanged = false;
        if(audit.isInstantiated9()){
            if(
                    audit.isFront_tire_check() != this.audit.isFront_tire_check() ||
                    !audit.getFront_tire_information().equals(this.audit.getFront_tire_information()) ||

                    audit.isRear_tire_check() != this.audit.isRear_tire_check() ||
                    !audit.getRear_tire_information().equals(this.audit.getRear_tire_information()) ||

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

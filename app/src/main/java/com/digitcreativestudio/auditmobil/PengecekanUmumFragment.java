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

public class PengecekanUmumFragment extends AuditBaseFragment {
    CheckBox stnkCheckBox;
    EditText stnkValidDateEditText,
            stnkInformationEditText;
    ImageView stnkImageView,
            stnkAddImageView;
    TextView stnkChangeTextView;

    CheckBox llajrCheckBox;
    EditText llajrValidDateEditText,
            llajrInformationEditText;
    ImageView llajrImageView,
            llajrAddImageView;
    TextView llajrChangeTextView;

    public PengecekanUmumFragment() {
        super();
    }

    public static PengecekanUmumFragment newInstance() {
        PengecekanUmumFragment fragment = new PengecekanUmumFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_pengecekan_umum, container, false);

        stnkCheckBox = (CheckBox) rootView.findViewById(R.id.check_stnk);
        llajrCheckBox = (CheckBox) rootView.findViewById(R.id.check_llajr);

        stnkValidDateEditText = (EditText) rootView.findViewById(R.id.edit_stnk_valid_date);
        stnkInformationEditText = (EditText) rootView.findViewById(R.id.edit_stnk_information);
        llajrValidDateEditText = (EditText) rootView.findViewById(R.id.edit_llajr_valid_date);
        llajrInformationEditText = (EditText) rootView.findViewById(R.id.edit_llajr_information);

        stnkImageView = (ImageView) rootView.findViewById(R.id.image_stnk);
        stnkAddImageView = (ImageView) rootView.findViewById(R.id.image_add_stnk);

        llajrImageView = (ImageView) rootView.findViewById(R.id.image_llajr);
        llajrAddImageView = (ImageView) rootView.findViewById(R.id.image_llajr_add);

        stnkChangeTextView = (TextView) rootView.findViewById(R.id.text_stnk_change_image);
        llajrChangeTextView = (TextView) rootView.findViewById(R.id.text_llajr_change_image);
        return rootView;
    }

    @Override
    public ArrayList<File> getFiles() {
        return null;
    }

    @Override
    public void updateData(Audit audit, File[] files) {
        if(audit.isInstantiated0()){
            stnkCheckBox.setChecked(audit.isStnk_check());
            llajrCheckBox.setChecked(audit.isLlajr_check());

            stnkValidDateEditText.setText(audit.getStnk_valid_date());
            stnkInformationEditText.setText(audit.getStnk_information());
            llajrValidDateEditText.setText(audit.getLlajr_valid_date());
            llajrInformationEditText.setText(audit.getLlajr_information());
        }
    }

    @Override
    public Audit getAudit() {
        return audit;
    }

    @Override
    public boolean isValid() {
        boolean isValid = true;

        audit.setInstantiated0(true);
        audit.setStnk_check(stnkCheckBox.isChecked());
        audit.setLlajr_check(llajrCheckBox.isChecked());

        audit.setStnk_valid_date(stnkValidDateEditText.getText().toString().trim());
        audit.setStnk_information(stnkInformationEditText.getText().toString().trim());
        audit.setLlajr_valid_date(llajrValidDateEditText.getText().toString().trim());
        audit.setLlajr_information(llajrInformationEditText.getText().toString().trim());

        return isValid;
    }

    @Override
    public boolean isChanged(Audit audt, File[] fils) {
        boolean isChanged = false;
        if(audt.isInstantiated0()){
            if(
                    audt.isStnk_check() != audit.isStnk_check() ||
                    audt.isLlajr_check() != audit.isLlajr_check() ||

                    !audt.getStnk_valid_date().equals(audit.getStnk_valid_date()) ||
                    !audt.getStnk_information().equals(audit.getStnk_information()) ||
                    !audt.getLlajr_valid_date().equals(audit.getLlajr_valid_date()) ||
                    !audt.getLlajr_information().equals(audit.getLlajr_information()) ||

                    (fils[0] != files[0]) || (fils[1] != files[1])
                ){
                isChanged = true;
            }
        }else{
            isChanged = true;
        }
        return isChanged;
    }
}

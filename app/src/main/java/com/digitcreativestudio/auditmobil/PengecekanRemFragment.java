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

public class PengecekanRemFragment extends AuditBaseFragment {
    CheckBox workingCheckBox;
    EditText workingInformationEditText;
    ImageView workingImageView;
    ImageView workingAddImageView;
    TextView workingChangeTextView;

    public PengecekanRemFragment() {
        super();
    }

    public static PengecekanRemFragment newInstance() {
        PengecekanRemFragment fragment = new PengecekanRemFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_pengecekan_rem, container, false);

        workingCheckBox = (CheckBox) rootView.findViewById(R.id.check_working);
        workingInformationEditText = (EditText) rootView.findViewById(R.id.edit_working_information);
        workingImageView = (ImageView) rootView.findViewById(R.id.image_working);
        workingImageView.setOnClickListener(this);
        workingAddImageView = (ImageView) rootView.findViewById(R.id.image_working_add);
        workingChangeTextView = (TextView) rootView.findViewById(R.id.text_working_change_image);

        return rootView;
    }

    @Override
    public void updateData(Audit audit, File[] files) {
        if(audit.isInstantiated8()){
            workingCheckBox.setChecked(audit.isWorking_check());
            workingInformationEditText.setText(audit.getWorking_information());

            if(files[0] != null){
                Glide.with(getContext()).load(files[0]).into(workingImageView);
                workingAddImageView.setVisibility(View.GONE);
                workingChangeTextView.setVisibility(View.VISIBLE);
            }
        }
    }

    @Override
    public boolean isValid() {
        audit.setInstantiated8(true);

        audit.setWorking_check(workingCheckBox.isChecked());
        audit.setWorking_information(workingInformationEditText.getText().toString().trim());
        return true;
    }

    @Override
    public boolean isChanged(Audit audit, File[] files) {
        boolean isChanged = false;
        if(audit.isInstantiated8()){
            if(
                    audit.isWorking_check() != this.audit.isWorking_check() ||
                    !audit.getWorking_information().equals(this.audit.getWorking_information()) ||

                    FileUtil.compare(files[0], this.files[0]) != 0
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
            case R.id.image_working:
                openPictureChooser(PICTURE_CHOOSER_1_REQUEST);
                break;
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == Activity.RESULT_OK) {
            switch (requestCode) {
                case PICTURE_CHOOSER_1_REQUEST:
                    Glide.with(getContext()).load(files[0]).into(workingImageView);
                    workingAddImageView.setVisibility(View.GONE);
                    workingChangeTextView.setVisibility(View.VISIBLE);
                    break;
            }
        }
    }
}

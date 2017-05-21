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

public class PengecekanKabelFragment extends AuditBaseFragment {
    CheckBox isolatedCheckBox;
    EditText isolatedInformationEditText;
    ImageView isolatedImageView;
    ImageView isolatedAddImageView;
    TextView isolatedChangeTextView;

    CheckBox fuseOriginalCheckBox;
    EditText fuseOriginalInformationEditText;
    ImageView fuseOriginalImageView;
    ImageView fuseOriginalAddImageView;
    TextView fuseOriginalChangeTextView;

    public PengecekanKabelFragment() {
        super();
    }

    public static PengecekanKabelFragment newInstance() {
        PengecekanKabelFragment fragment = new PengecekanKabelFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_pengecekan_kabel, container, false);

        isolatedCheckBox = (CheckBox) rootView.findViewById(R.id.check_isolated);
        isolatedInformationEditText = (EditText) rootView.findViewById(R.id.edit_isolated_information);
        isolatedImageView = (ImageView) rootView.findViewById(R.id.image_isolated);
        isolatedImageView.setOnClickListener(this);
        isolatedAddImageView = (ImageView) rootView.findViewById(R.id.image_isolated_add);
        isolatedChangeTextView = (TextView) rootView.findViewById(R.id.text_isolated_change_image);

        fuseOriginalCheckBox = (CheckBox) rootView.findViewById(R.id.check_fuse_original);
        fuseOriginalInformationEditText = (EditText) rootView.findViewById(R.id.edit_fuse_original_information);
        fuseOriginalImageView = (ImageView) rootView.findViewById(R.id.image_fuse_original);
        fuseOriginalImageView.setOnClickListener(this);
        fuseOriginalAddImageView = (ImageView) rootView.findViewById(R.id.image_fuse_original_add);
        fuseOriginalChangeTextView = (TextView) rootView.findViewById(R.id.text_fuse_original_change_image);

        return rootView;
    }

    @Override
    public void updateData(Audit audit, File[] files) {
        if(audit.isInstantiated3()){
            isolatedCheckBox.setChecked(audit.isolated_check());
            isolatedInformationEditText.setText(audit.getIsolated_information());

            fuseOriginalCheckBox.setChecked(audit.isFuse_original_check());
            fuseOriginalInformationEditText.setText(audit.getFuse_original_information());

            if(files[0] != null){
                Glide.with(getContext()).load(files[0]).into(isolatedImageView);
                isolatedAddImageView.setVisibility(View.GONE);
                isolatedChangeTextView.setVisibility(View.VISIBLE);
            }
            if(files[1] != null){
                Glide.with(getContext()).load(files[1]).into(fuseOriginalImageView);
                fuseOriginalAddImageView.setVisibility(View.GONE);
                fuseOriginalChangeTextView.setVisibility(View.VISIBLE);
            }
        }
    }

    @Override
    public boolean isValid() {
        audit.setInstantiated3(true);

        audit.setIsolated_check(isolatedCheckBox.isChecked());
        audit.setIsolated_information(isolatedInformationEditText.getText().toString().trim());

        audit.setFuse_original_check(fuseOriginalCheckBox.isChecked());
        audit.setFuse_original_information(fuseOriginalInformationEditText.getText().toString().trim());
        return true;
    }

    @Override
    public boolean isChanged(Audit audit, File[] files) {
        boolean isChanged = false;
        if(audit.isInstantiated3()){
            if(
                    audit.isolated_check() != this.audit.isolated_check() ||
                    !audit.getIsolated_information().equals(this.audit.getIsolated_information()) ||

                    audit.isFuse_original_check() != this.audit.isFuse_original_check() ||
                    !audit.getFuse_original_information().equals(this.audit.getFuse_original_information()) ||

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

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.image_isolated:
                openPictureChooser(PICTURE_CHOOSER_1_REQUEST);
                break;
            case R.id.image_fuse_original:
                openPictureChooser(PICTURE_CHOOSER_2_REQUEST);
                break;
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == Activity.RESULT_OK) {
            switch (requestCode) {
                case PICTURE_CHOOSER_1_REQUEST:
                    Glide.with(getContext()).load(files[0]).into(isolatedImageView);
                    isolatedAddImageView.setVisibility(View.GONE);
                    isolatedChangeTextView.setVisibility(View.VISIBLE);
                    break;
                case PICTURE_CHOOSER_2_REQUEST:
                    Glide.with(getContext()).load(files[1]).into(fuseOriginalImageView);
                    fuseOriginalAddImageView.setVisibility(View.GONE);
                    fuseOriginalChangeTextView.setVisibility(View.VISIBLE);
                    break;
                case PICTURE_CHOOSER_3_REQUEST:
                    break;
            }
        }
    }
}

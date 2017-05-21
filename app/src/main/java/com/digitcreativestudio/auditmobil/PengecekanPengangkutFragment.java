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

public class PengecekanPengangkutFragment extends AuditBaseFragment {
    CheckBox nonporousHasLogoCheckBox;
    EditText nonporousHasLogoInformationEditText;
    ImageView nonporousHasLogoImageView;
    ImageView nonporousHasLogoAddImageView;
    TextView nonporousHasLogoChangeTextView;

    CheckBox clearWritingCheckBox;
    EditText clearWritingInformationEditText;
    ImageView clearWritingImageView;
    ImageView clearWritingAddImageView;
    TextView clearWritingChangeTextView;

    CheckBox woodCoatedCheckBox;
    EditText woodCoatedInformationEditText;
    ImageView woodCoatedImageView;
    ImageView woodCoatedAddImageView;
    TextView woodCoatedChangeTextView;

    public PengecekanPengangkutFragment() {
        super();
    }

    public static PengecekanPengangkutFragment newInstance() {
        PengecekanPengangkutFragment fragment = new PengecekanPengangkutFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_pengecekan_pengangkut, container, false);

        nonporousHasLogoCheckBox = (CheckBox) rootView.findViewById(R.id.check_nonporous_has_logo);
        nonporousHasLogoInformationEditText = (EditText) rootView.findViewById(R.id.edit_nonporous_has_logo_information);
        nonporousHasLogoImageView = (ImageView) rootView.findViewById(R.id.image_nonporous_has_logo);
        nonporousHasLogoImageView.setOnClickListener(this);
        nonporousHasLogoAddImageView = (ImageView) rootView.findViewById(R.id.image_nonporous_has_logo_add);
        nonporousHasLogoChangeTextView = (TextView) rootView.findViewById(R.id.text_nonporous_has_logo_change_image);

        clearWritingCheckBox = (CheckBox) rootView.findViewById(R.id.check_clear_writing);
        clearWritingInformationEditText = (EditText) rootView.findViewById(R.id.edit_clear_writing_information);
        clearWritingImageView = (ImageView) rootView.findViewById(R.id.image_clear_writing);
        clearWritingImageView.setOnClickListener(this);
        clearWritingAddImageView = (ImageView) rootView.findViewById(R.id.image_clear_writing_add);
        clearWritingChangeTextView = (TextView) rootView.findViewById(R.id.text_clear_writing_change_image);

        woodCoatedCheckBox = (CheckBox) rootView.findViewById(R.id.check_wood_coated);
        woodCoatedInformationEditText = (EditText) rootView.findViewById(R.id.edit_wood_coated_information);
        woodCoatedImageView = (ImageView) rootView.findViewById(R.id.image_wood_coated);
        woodCoatedImageView.setOnClickListener(this);
        woodCoatedAddImageView = (ImageView) rootView.findViewById(R.id.image_wood_coated_add);
        woodCoatedChangeTextView = (TextView) rootView.findViewById(R.id.text_wood_coated_change_image);

        return rootView;
    }

    @Override
    public void updateData(Audit audit, File[] files) {
        if(audit.isInstantiated6()){
            nonporousHasLogoCheckBox.setChecked(audit.isNonporous_has_logo_check());
            nonporousHasLogoInformationEditText.setText(audit.getNonporous_has_logo_information());

            clearWritingCheckBox.setChecked(audit.isClear_writing_check());
            clearWritingInformationEditText.setText(audit.getClear_writing_information());

            woodCoatedCheckBox.setChecked(audit.isWood_coated_check());
            woodCoatedInformationEditText.setText(audit.getWood_coated_information());

            if(files[0] != null){
                Glide.with(getContext()).load(files[0]).into(nonporousHasLogoImageView);
                nonporousHasLogoAddImageView.setVisibility(View.GONE);
                nonporousHasLogoChangeTextView.setVisibility(View.VISIBLE);
            }
            if(files[1] != null){
                Glide.with(getContext()).load(files[1]).into(clearWritingImageView);
                clearWritingAddImageView.setVisibility(View.GONE);
                clearWritingChangeTextView.setVisibility(View.VISIBLE);
            }
            if(files[2] != null){
                Glide.with(getContext()).load(files[2]).into(woodCoatedImageView);
                woodCoatedAddImageView.setVisibility(View.GONE);
                woodCoatedChangeTextView.setVisibility(View.VISIBLE);
            }
        }
    }

    @Override
    public boolean isValid() {
        audit.setInstantiated6(true);

        audit.setNonporous_has_logo_check(nonporousHasLogoCheckBox.isChecked());
        audit.setNonporous_has_logo_information(nonporousHasLogoInformationEditText.getText().toString().trim());

        audit.setClear_writing_check(clearWritingCheckBox.isChecked());
        audit.setClear_writing_information(clearWritingInformationEditText.getText().toString().trim());

        audit.setWood_coated_check(woodCoatedCheckBox.isChecked());
        audit.setWood_coated_information(woodCoatedInformationEditText.getText().toString().trim());
        return true;
    }

    @Override
    public boolean isChanged(Audit audit, File[] files) {
        boolean isChanged = false;
        if(audit.isInstantiated6()){
            if(
                    audit.isNonporous_has_logo_check() != this.audit.isNonporous_has_logo_check() ||
                    !audit.getNonporous_has_logo_information().equals(this.audit.getNonporous_has_logo_information()) ||

                    audit.isClear_writing_check() != this.audit.isClear_writing_check() ||
                    !audit.getClear_writing_information().equals(this.audit.getClear_writing_information()) ||

                    audit.isWood_coated_check() != this.audit.isWood_coated_check() ||
                    !audit.getWood_coated_information().equals(this.audit.getWood_coated_information()) ||

                    FileUtil.compare(files[0], this.files[0]) != 0 ||
                    FileUtil.compare(files[1], this.files[1]) != 0 ||
                    FileUtil.compare(files[2], this.files[2]) != 0
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
            case R.id.image_nonporous_has_logo:
                openPictureChooser(0);
                break;
            case R.id.image_clear_writing:
                openPictureChooser(1);
                break;
            case R.id.image_wood_coated:
                openPictureChooser(2);
                break;
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == Activity.RESULT_OK) {
            switch (requestCode) {
                case PICTURE_CHOOSER_1_REQUEST:
                    Glide.with(getContext()).load(files[0]).into(nonporousHasLogoImageView);
                    nonporousHasLogoAddImageView.setVisibility(View.GONE);
                    nonporousHasLogoChangeTextView.setVisibility(View.VISIBLE);
                    break;
                case PICTURE_CHOOSER_2_REQUEST:
                    Glide.with(getContext()).load(files[1]).into(clearWritingImageView);
                    clearWritingAddImageView.setVisibility(View.GONE);
                    clearWritingChangeTextView.setVisibility(View.VISIBLE);
                    break;
                case PICTURE_CHOOSER_3_REQUEST:
                    Glide.with(getContext()).load(files[2]).into(woodCoatedImageView);
                    woodCoatedAddImageView.setVisibility(View.GONE);
                    woodCoatedChangeTextView.setVisibility(View.VISIBLE);
                    break;
            }
        }
    }
}

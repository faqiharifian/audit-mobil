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
        nonporousHasLogoAddImageView = (ImageView) rootView.findViewById(R.id.image_nonporous_has_logo_add);
        nonporousHasLogoChangeTextView = (TextView) rootView.findViewById(R.id.text_nonporous_has_logo_change_image);

        clearWritingCheckBox = (CheckBox) rootView.findViewById(R.id.check_clear_writing);
        clearWritingInformationEditText = (EditText) rootView.findViewById(R.id.edit_clear_writing_information);
        clearWritingImageView = (ImageView) rootView.findViewById(R.id.image_clear_writing);
        clearWritingAddImageView = (ImageView) rootView.findViewById(R.id.image_clear_writing_add);
        clearWritingChangeTextView = (TextView) rootView.findViewById(R.id.text_clear_writing_change_image);

        woodCoatedCheckBox = (CheckBox) rootView.findViewById(R.id.check_wood_coated);
        woodCoatedInformationEditText = (EditText) rootView.findViewById(R.id.edit_wood_coated_information);
        woodCoatedImageView = (ImageView) rootView.findViewById(R.id.image_wood_coated);
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
        return false;
    }
}

package com.digitcreativestudio.auditmobil;

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

public class PengecekanPeringatanFragment extends AuditBaseFragment {
    CheckBox overallCheckBox;
    EditText overallInformationEditText;
    ImageView overallImageView;
    ImageView overallAddImageView;
    TextView overallChangeTextView;

    public PengecekanPeringatanFragment() {
        super();
    }

    public static PengecekanPeringatanFragment newInstance() {
        PengecekanPeringatanFragment fragment = new PengecekanPeringatanFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_pengecekan_peringatan, container, false);

        overallCheckBox = (CheckBox) rootView.findViewById(R.id.check_overall);
        overallInformationEditText = (EditText) rootView.findViewById(R.id.edit_overall_information);
        overallImageView = (ImageView) rootView.findViewById(R.id.image_overall);
        overallAddImageView = (ImageView) rootView.findViewById(R.id.image_overall_add);
        overallChangeTextView = (TextView) rootView.findViewById(R.id.text_overall_change_image);

        return rootView;
    }

    @Override
    public void updateData(Audit audit, File[] files) {
        if(audit.isInstantiated11()){
            overallCheckBox.setChecked(audit.isOverall_check());
            overallInformationEditText.setText(audit.getOverall_information());

            if(files[0] != null){
                Glide.with(getContext()).load(files[0]).into(overallImageView);
                overallAddImageView.setVisibility(View.GONE);
                overallChangeTextView.setVisibility(View.VISIBLE);
            }
        }
    }

    @Override
    public boolean isValid() {
        audit.setInstantiated11(true);

        audit.setOverall_check(overallCheckBox.isChecked());
        audit.setOverall_information(overallInformationEditText.getText().toString().trim());
        return true;
    }

    @Override
    public boolean isChanged(Audit audit, File[] files) {
        boolean isChanged = false;
        if(audit.isInstantiated11()){
            if(
                    audit.isOverall_check() != this.audit.isOverall_check() ||
                    !audit.getOverall_information().equals(this.audit.getOverall_information()) ||

                    FileUtil.compare(files[0], this.files[0]) != 0
                ){
                isChanged = true;
            }
        }else{
            isChanged = true;
        }
        return isChanged;
    }
}

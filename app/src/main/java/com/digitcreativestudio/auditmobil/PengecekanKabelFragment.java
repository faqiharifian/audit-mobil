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
        isolatedAddImageView = (ImageView) rootView.findViewById(R.id.image_isolated_add);
        isolatedChangeTextView = (TextView) rootView.findViewById(R.id.text_isolated_change_image);

        fuseOriginalCheckBox = (CheckBox) rootView.findViewById(R.id.check_fuse_original);
        fuseOriginalInformationEditText = (EditText) rootView.findViewById(R.id.edit_fuse_original_information);
        fuseOriginalImageView = (ImageView) rootView.findViewById(R.id.image_fuse_original);
        fuseOriginalAddImageView = (ImageView) rootView.findViewById(R.id.image_fuse_original_add);
        fuseOriginalChangeTextView = (TextView) rootView.findViewById(R.id.text_fuse_original_change_image);

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

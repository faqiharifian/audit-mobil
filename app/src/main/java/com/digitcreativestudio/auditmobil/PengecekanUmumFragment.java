package com.digitcreativestudio.auditmobil;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.digitcreativestudio.auditmobil.entities.Audit;
import com.digitcreativestudio.auditmobil.utilities.FileUtil;

import java.io.File;
import java.util.Arrays;

import static com.digitcreativestudio.auditmobil.utilities.FileUtil.mimeTypes;

/**
 * Created by ADIK on 15/05/2017.
 */

public class PengecekanUmumFragment extends AuditBaseFragment implements View.OnClickListener {
    public static final int PICTURE_CHOOSER_1_REQUEST = 101;
    public static final int PICTURE_CHOOSER_2_REQUEST = 102;
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
        stnkImageView.setOnClickListener(this);
        stnkAddImageView = (ImageView) rootView.findViewById(R.id.image_add_stnk);

        llajrImageView = (ImageView) rootView.findViewById(R.id.image_llajr);
        llajrImageView.setOnClickListener(this);
        llajrAddImageView = (ImageView) rootView.findViewById(R.id.image_llajr_add);

        stnkChangeTextView = (TextView) rootView.findViewById(R.id.text_stnk_change_image);
        llajrChangeTextView = (TextView) rootView.findViewById(R.id.text_llajr_change_image);
        return rootView;
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

            if(files[0] != null){
                Glide.with(getActivity()).load(files[0]).into(stnkImageView);
                stnkAddImageView.setVisibility(View.GONE);
                stnkChangeTextView.setVisibility(View.VISIBLE);
            }
            if(files[1] != null){
                Glide.with(getActivity()).load(files[1]).into(llajrImageView);
                llajrAddImageView.setVisibility(View.GONE);
                llajrChangeTextView.setVisibility(View.VISIBLE);
            }
        }
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

                    FileUtil.compare(fils[0], files[0]) != 0 || FileUtil.compare(fils[1], files[1]) != 0
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
        Intent intent = new Intent(Intent.ACTION_GET_CONTENT);

        intent.setType("image/*");
        intent.putExtra(Intent.EXTRA_MIME_TYPES, mimeTypes);
        intent.addCategory(Intent.CATEGORY_OPENABLE);

        try {
            switch (v.getId()){
                case R.id.image_stnk:
                    startActivityForResult(
                            Intent.createChooser(intent, "Choose"),
                            PICTURE_CHOOSER_1_REQUEST);
                    break;
                case R.id.image_llajr:
                    startActivityForResult(
                            Intent.createChooser(intent, "Choose"),
                            PICTURE_CHOOSER_2_REQUEST);
                    break;
            }
        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(getActivity(), "Please install a File Manager.",
                    Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode){
            case PICTURE_CHOOSER_1_REQUEST:
            case PICTURE_CHOOSER_2_REQUEST:
                if (resultCode == Activity.RESULT_OK) {
                    Uri imageUri = data.getData();
                    String imagePath = FileUtil.getPath(getContext(), imageUri);
                    final File imageFile = new File(imagePath);
                    if(!Arrays.asList(mimeTypes).contains(FileUtil.getType(getContext(), imageUri))){
                        Toast.makeText(getActivity(), "Please select .jpg, .jpeg, .png file", Toast.LENGTH_LONG).show();
                    }else{
                        switch (requestCode){
                            case PICTURE_CHOOSER_1_REQUEST:
                                files[0] = imageFile;
                                Glide.with(getContext()).load(imageFile).into(stnkImageView);
                                stnkAddImageView.setVisibility(View.GONE);
                                stnkChangeTextView.setVisibility(View.VISIBLE);
                                break;
                            case PICTURE_CHOOSER_2_REQUEST:
                                files[1] = imageFile;
                                Glide.with(getContext()).load(imageFile).into(llajrImageView);
                                llajrAddImageView.setVisibility(View.GONE);
                                llajrChangeTextView.setVisibility(View.VISIBLE);
                                break;
                        }
                    }
                }
                break;
            default:
                super.onActivityResult(requestCode, resultCode, data);
                break;
        }
    }
}

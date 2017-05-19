package com.digitcreativestudio.auditmobil;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by ADIK on 15/05/2017.
 */

public class PengecekanUmumFragment extends Fragment {

    private static final String ARG_SECTION_NUMBER = "section_number";

    public PengecekanUmumFragment() {
    }

    public static PengecekanUmumFragment newInstance(int sectionNumber) {
        PengecekanUmumFragment fragment = new PengecekanUmumFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_pengecekan_umum, container, false);

        return rootView;
    }
}

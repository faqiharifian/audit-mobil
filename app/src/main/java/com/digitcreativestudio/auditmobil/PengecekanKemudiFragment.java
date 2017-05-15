package com.digitcreativestudio.auditmobil;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by ADIK on 15/05/2017.
 */

public class PengecekanKemudiFragment extends Fragment {

    private static final String ARG_SECTION_NUMBER = "section_number";

    public PengecekanKemudiFragment() {
    }

    public static PengecekanKemudiFragment newInstance(int sectionNumber) {
        PengecekanKemudiFragment fragment = new PengecekanKemudiFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_pengecekan_kemudi, container, false);
        rootView.findViewById(R.id.lanjut_image_view).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction trans = getFragmentManager().beginTransaction();
                trans.replace(R.id.root_frame, new PengecekanPeringatanFragment());
                trans.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
                trans.addToBackStack(null);
                trans.commit();
            }
        });
        return rootView;
    }
}
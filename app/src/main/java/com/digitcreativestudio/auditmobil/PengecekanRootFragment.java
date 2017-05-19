package com.digitcreativestudio.auditmobil;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.digitcreativestudio.auditmobil.view.ViewPager;

import me.relex.circleindicator.CircleIndicator;

/**
 * Created by ADIK on 15/05/2017.
 */

public class PengecekanRootFragment extends Fragment {

    private static final String ARG_SECTION_NUMBER = "section_number";

    ViewPager pager;
    CheckFragmentStatePagerAdapter adapter;

    ImageView nextImageView, backImageView;

    public PengecekanRootFragment() {
    }

    public static PengecekanRootFragment newInstance(int sectionNumber) {
        PengecekanRootFragment fragment = new PengecekanRootFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_pengecekan_root, container, false);

        pager = (ViewPager) rootView.findViewById(R.id.pager_container);
        adapter = new CheckFragmentStatePagerAdapter(getFragmentManager());
        pager.setAdapter(adapter);
        pager.setPagingEnabled(false);

        CircleIndicator indicator = (CircleIndicator) rootView.findViewById(R.id.indicator);
        indicator.setViewPager(pager);
        adapter.registerDataSetObserver(indicator.getDataSetObserver());

        nextImageView = (ImageView) rootView.findViewById(R.id.lanjut_image_view);
        backImageView = (ImageView) rootView.findViewById(R.id.back_image_view);
        backImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = pager.getCurrentItem();
                if(position > 0){
                    pager.setCurrentItem(position-1);
                    if(position == 1) backImageView.setVisibility(View.GONE);
                }
            }
        });
        nextImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = pager.getCurrentItem();
                if(position < adapter.getCount()){
                    pager.setCurrentItem(position+1);
                    backImageView.setVisibility(View.VISIBLE);
                }else{
                    final AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                    builder.setTitle("SELESAI")
                            .setMessage("Apakah Anda yakin data yang yang dimasukan sudah benar ?")
                            .setPositiveButton("Ya", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int id) {
                                    startActivity(new Intent(getActivity(),HomeActivity.class));
                                }
                            })
                            .setNegativeButton("Tidak", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int id) {
                                }
                            });
                    builder.create();
                    builder.show();
                }
            }
        });
        return rootView;
    }

    public class CheckFragmentStatePagerAdapter extends FragmentStatePagerAdapter {
        public CheckFragmentStatePagerAdapter(FragmentManager fm) {
            super(fm);
        }

        // Initiate fragment and pass province to it
        @Override
        public Fragment getItem(int position) {
            switch (position){
                case 0:
                    return PengecekanUmumFragment.newInstance(position);
                case 1:
                    return PengecekanMotorFragment.newInstance(position);
                case 2:
                    return PengecekanKnalpotFragment.newInstance(position);
                case 3:
                    return PengecekanKabelFragment.newInstance(position);
                case 4:
                    return PengecekanBatteryFragment.newInstance(position);
                case 5:
                    return PengecekanLampuFragment.newInstance(position);
                case 6:
                    return PengecekanPengangkutFragment.newInstance(position);
                case 7:
                    return PengecekanPemadamFragment.newInstance(position);
                case 8:
                    return PengecekanRemFragment.newInstance(position);
                case 9:
                    return PengecekanRodaFragment.newInstance(position);
                case 10:
                    return PengecekanKemudiFragment.newInstance(position);
                case 11:
                    return PengecekanPeringatanFragment.newInstance(position);
                case 12:
                    return PengecekanLainFragment.newInstance(position);
            }
            return null;
        }

        @Override
        public int getCount() {
            return 13;
        }

    }
}

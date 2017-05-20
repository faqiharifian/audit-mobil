package com.digitcreativestudio.auditmobil;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.digitcreativestudio.auditmobil.entities.Audit;
import com.digitcreativestudio.auditmobil.view.ProgressDialog;
import com.digitcreativestudio.auditmobil.view.ViewPager;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

import me.relex.circleindicator.CircleIndicator;

/**
 * Created by ADIK on 15/05/2017.
 */

public class PengecekanRootFragment extends Fragment {

    private static final String ARG_SECTION_NUMBER = "section_number";

    ViewPager pager;
    AuditFragmentStatePagerAdapter adapter;

    ImageView nextImageView, backImageView;

    ProgressDialog progressDialog;

    public PengecekanRootFragment() {
    }

    public static PengecekanRootFragment newInstance() {
        PengecekanRootFragment fragment = new PengecekanRootFragment();
        return fragment;
    }

    @Override
    public void onResume() {
        if(adapter != null){
            if(adapter.audit != null) {
                if (!adapter.audit.isInstantiated0()) {
                    if(pager != null){
                        pager.setCurrentItem(0);
                    }
                }
            }
        }
        super.onResume();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_pengecekan_root, container, false);

        progressDialog = new ProgressDialog(getContext());

        pager = (ViewPager) rootView.findViewById(R.id.pager_container);
        adapter = new AuditFragmentStatePagerAdapter(getFragmentManager(), pager);
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
                    if(position == 1) backImageView.setVisibility(View.INVISIBLE);
                }
            }
        });
        nextImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = pager.getCurrentItem();
                if(adapter.isValid(position)){
                    if(adapter.isChanged(position)){
                        adapter.post(position, progressDialog, new Callable<Void>(){
                            @Override
                            public Void call() throws Exception {
                                progressDialog.hide();
                                nextPager();
                                return null;
                            }
                        });
                    }else{
                        Log.e("unchanged", "unchanged");
                        nextPager();
                    }
                }

            }
        });
        return rootView;
    }

    private void nextPager(){
        int position = pager.getCurrentItem();
        if(position < adapter.getCount()-1){
            pager.setCurrentItem(position+1);
            backImageView.setVisibility(View.VISIBLE);
        }else{
            final AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
            builder.setTitle("SELESAI")
                    .setMessage("Apakah Anda yakin data yang yang dimasukan sudah benar ?")
                    .setPositiveButton("Ya", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int id) {
                            startActivity(new Intent(getActivity(), HomeActivity.class));
                        }
                    })
                    .setNegativeButton("Tidak", null);
            builder.create();
            builder.show();
        }
    }

    public class AuditFragmentStatePagerAdapter extends FragmentStatePagerAdapter {
        Audit audit;
        List<AuditBaseFragment> fragments;
        File[][] files = new File[13][3];
        ViewPager pager;
        public AuditFragmentStatePagerAdapter(FragmentManager fm, ViewPager pager) {
            super(fm);
            audit = new Audit();
            this.pager = pager;
            fragments = new ArrayList<>();
            fragments.add(PengecekanUmumFragment.newInstance());
            fragments.add(PengecekanMotorFragment.newInstance());
            fragments.add(PengecekanKnalpotFragment.newInstance());
            fragments.add(PengecekanKabelFragment.newInstance());
            fragments.add(PengecekanBatteryFragment.newInstance());
            fragments.add(PengecekanLampuFragment.newInstance());
            fragments.add(PengecekanPengangkutFragment.newInstance());
            fragments.add(PengecekanPemadamFragment.newInstance());
            fragments.add(PengecekanRemFragment.newInstance());
            fragments.add(PengecekanRodaFragment.newInstance());
            fragments.add(PengecekanKemudiFragment.newInstance());
            fragments.add(PengecekanPeringatanFragment.newInstance());
            fragments.add(PengecekanLainFragment.newInstance());
        }

        @Override
        public void finishUpdate(ViewGroup container) {
            super.finishUpdate(container);

            fragments.get(pager.getCurrentItem()).updateData(audit, files[pager.getCurrentItem()]);
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            Object obj = super.instantiateItem(container, position);
            return obj;
        }

        // Initiate fragment and pass province to it
        @Override
        public Fragment getItem(int position) {
            return fragments.get(position);
        }

        @Override
        public int getCount() {
            return fragments.size();
        }

        public boolean isChanged(int position){
            boolean isChanged = fragments.get(position).isChanged(audit, files[position]);
            if(isChanged){
                Audit audit = fragments.get(position).getAudit();
                files[position] = fragments.get(position).getFiles();
                switch (position){
                    case 0:
                        this.audit.update0(audit);
                        break;
                    case 1:
                        this.audit.update1(audit);
                        break;
                    case 2:
                        this.audit.update2(audit);
                        break;
                    case 3:
                        this.audit.update3(audit);
                        break;
                    case 4:
                        this.audit.update4(audit);
                        break;
                    case 5:
                        this.audit.update5(audit);
                        break;
                    case 6:
                        this.audit.update6(audit);
                        break;
                    case 7:
                        this.audit.update7(audit);
                        break;
                    case 8:
                        this.audit.update8(audit);
                        break;
                    case 9:
                        this.audit.update9(audit);
                        break;
                    case 10:
                        this.audit.update10(audit);
                        break;
                    case 11:
                        this.audit.update11(audit);
                        break;
                    case 12:
                        this.audit.update12(audit);
                        break;
                }
            }
            return isChanged;
        }

        public boolean isValid(int position){
            return fragments.get(position).isValid();
        }

        public void post(int position, ProgressDialog progressDialog, Callable<Void> callable) {
            try {
                fragments.get(position).post(progressDialog, callable);
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }
}

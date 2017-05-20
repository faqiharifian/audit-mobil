package com.digitcreativestudio.auditmobil;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;

import com.digitcreativestudio.auditmobil.utilities.SessionPreference;
import com.digitcreativestudio.auditmobil.view.ProgressDialog;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity {

    private SectionsPagerAdapter mSectionsPagerAdapter;
    private ViewPager mViewPager;
    private SessionPreference sessionPreference;
    public TabLayout tabLayout;

    @Override
    protected void onDestroy() {
        super.onDestroy();
        sessionPreference.removeCarId();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        sessionPreference = new SessionPreference(this);
        if(!sessionPreference.isLoggedIn()){
            startActivity(new Intent(this, LoginActivity.class));
            finish();
        }

        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);

        mViewPager.addOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener(){
            @Override
            public void onPageSelected(int position) {
                if(sessionPreference.getCarId() == -1){
                    mViewPager.setCurrentItem(0);
                    Toast.makeText(HomeActivity.this, "Mohon isi data mobil terlebih dahulu", Toast.LENGTH_LONG).show();
                }else{
                    if(getCurrentFocus() != null) {
                        InputMethodManager inputManager = (InputMethodManager)
                                getSystemService(Context.INPUT_METHOD_SERVICE);
                        inputManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(),
                                InputMethodManager.HIDE_NOT_ALWAYS);
                    }
                }
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_logout) {
            sessionPreference.logoutUser();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void postCar(View view){
        BaseFragment baseFragment = (BaseFragment) mSectionsPagerAdapter.getItem(mViewPager.getCurrentItem());
        if(baseFragment.isValid()){
            final ProgressDialog progressDialog = new ProgressDialog(HomeActivity.this);

//            progressDialog.show();
//
//            AuditService auditService = AuditClient.getClient().create(AuditService.class);
//
//            Call<CarParser> call = auditService.postCarData(baseFragment.getCar());
//            call.enqueue(new Callback<CarParser>() {
//                @Override
//                public void onResponse(Call<CarParser> call, Response<CarParser> response) {
//                    progressDialog.hide();
//
//                    CarParser carParser = response.body();
//                    if(carParser.isSuccess()){
//                        Car car = carParser.getCar();
//                        (new SessionPreference(HomeActivity.this)).setCarId(car.getId());
//                    }else{
//                        AlertDialog.Builder builder = new AlertDialog.Builder(HomeActivity.this);
//                        builder.setTitle("Gagal");
//                        builder.setMessage(carParser.getMessage());
//                        builder.setPositiveButton("OK", null);
//                        builder.show();
//                    }
//                }
//
//                @Override
//                public void onFailure(Call<CarParser> call, Throwable t) {
//                    progressDialog.hide();
//
//                    AlertDialog.Builder builder = new AlertDialog.Builder(HomeActivity.this);
//                    builder.setTitle("Gagal");
//                    builder.setMessage(t.getMessage());
//                    builder.setPositiveButton("OK", null);
//                    builder.show();
//                }
//            });

            progressDialog.show();
            (new Handler()).postDelayed(new Runnable() {
                public void run() {
                    progressDialog.hide();

                    (new SessionPreference(HomeActivity.this)).setCarId(1);
                    mViewPager.setCurrentItem(1);
                }
            }, 2000);
        }
    }


    public class SectionsPagerAdapter extends FragmentPagerAdapter {
        List<Fragment> fragments;

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
            fragments = new ArrayList<>();
            fragments.add(DataMobilFragment.newInstance());
            fragments.add(PengecekanRootFragment.newInstance());
        }

        @Override
        public Fragment getItem(int position) {
            return fragments.get(position);
        }

        @Override
        public int getCount() {
            return fragments.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "Data Mobil";
                case 1:
                    return "Pengecekan Umum";
            }
            return null;
        }
    }

    @Override
    public void onBackPressed() {
        Intent a = new Intent(Intent.ACTION_MAIN);
        a.addCategory(Intent.CATEGORY_HOME);
        a.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(a);
        super.onBackPressed();

    }
}

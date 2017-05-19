package com.digitcreativestudio.auditmobil;

import android.support.v4.app.Fragment;

import com.digitcreativestudio.auditmobil.entities.Car;

/**
 * Created by faqih on 19/05/17.
 */

public abstract class BaseFragment extends Fragment {
    public abstract boolean isValid();

    public abstract Car getCar();
}

package com.digitcreativestudio.auditmobil.view;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.annotation.Nullable;
import android.view.KeyboardShortcutGroup;
import android.view.Menu;

import com.digitcreativestudio.auditmobil.R;

import java.util.List;

/**
 * Created by faqih on 11/05/17.
 */

public class ProgressDialog extends android.app.ProgressDialog {
    public ProgressDialog(Context context) {
        super(context);
    }

    public ProgressDialog(Context context, int theme) {
        super(context, theme);
    }

    @Override
    public void onProvideKeyboardShortcuts(List<KeyboardShortcutGroup> data, @Nullable Menu menu, int deviceId) {

    }

    @Override
    public void show() {
        super.setCancelable(false);
        super.show();
        getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        setContentView(R.layout.progress_dialog);
    }
}

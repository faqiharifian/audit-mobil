package com.digitcreativestudio.auditmobil.utilities;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.v4.content.ContextCompat;

/**
 * Created by faqiharifian on 30/03/17.
 */

public class PermissionUtil {
    @TargetApi(23)
    public static void askPermissions(Activity context) {
        String[] permissions = retrievePermissions(context);
        if(PermissionUtil.shouldAskPermissions(context, permissions)){
            int requestCode = 200;
            context.requestPermissions(permissions, requestCode);
        }
    }

    public static String[] retrievePermissions(Context context) {
        try {
            return context
                    .getPackageManager()
                    .getPackageInfo(context.getPackageName(), PackageManager.GET_PERMISSIONS)
                    .requestedPermissions;
        } catch (PackageManager.NameNotFoundException e) {
            throw new RuntimeException("This should have never happened.", e);
        }
    }

    public static boolean isPermissionGranted(Context context, String[] permissions){
        boolean result = true;
        for(String permission : permissions){
            result = ContextCompat.checkSelfPermission(context, permission) == PackageManager.PERMISSION_GRANTED;
            if(!result) break;
        }
        return result;
    }

    public static boolean shouldAskPermissions(Context context, String[] permissions) {
        return !(isPermissionGranted(context, permissions)) &&
                (Build.VERSION.SDK_INT > Build.VERSION_CODES.LOLLIPOP_MR1);
    }
}

package com.google.android.gms.internal;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Environment;

@ey
public class bl {
    private final Context mContext;

    public bl(Context context) {
        jx.m5219b((Object) context, (Object) "Context can not be null");
        this.mContext = context;
    }

    public static boolean bs() {
        return "mounted".equals(Environment.getExternalStorageState());
    }

    public boolean m4257a(Intent intent) {
        jx.m5219b((Object) intent, (Object) "Intent can not be null");
        return !this.mContext.getPackageManager().queryIntentActivities(intent, 0).isEmpty();
    }

    public boolean bo() {
        Intent intent = new Intent("android.intent.action.DIAL");
        intent.setData(Uri.parse("tel:"));
        return m4257a(intent);
    }

    public boolean bp() {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse("sms:"));
        return m4257a(intent);
    }

    public boolean bq() {
        return bs() && this.mContext.checkCallingOrSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") == 0;
    }

    public boolean br() {
        return false;
    }

    public boolean bt() {
        return VERSION.SDK_INT >= 14 && m4257a(new Intent("android.intent.action.INSERT").setType("vnd.android.cursor.dir/event"));
    }
}

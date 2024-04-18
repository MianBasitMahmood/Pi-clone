package com.google.android.gms.internal;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;

@ey
public final class dm {
    public static boolean m4440a(Context context, C1089do c1089do, dv dvVar) {
        if (c1089do == null) {
            gr.m4773W("No intent data for launcher overlay.");
            return false;
        }
        Intent intent = new Intent();
        if (TextUtils.isEmpty(c1089do.rH)) {
            gr.m4773W("Open GMSG did not contain a URL.");
            return false;
        }
        if (TextUtils.isEmpty(c1089do.mimeType)) {
            intent.setData(Uri.parse(c1089do.rH));
        } else {
            intent.setDataAndType(Uri.parse(c1089do.rH), c1089do.mimeType);
        }
        intent.setAction("android.intent.action.VIEW");
        if (!TextUtils.isEmpty(c1089do.packageName)) {
            intent.setPackage(c1089do.packageName);
        }
        if (!TextUtils.isEmpty(c1089do.rI)) {
            String[] split = c1089do.rI.split("/", 2);
            if (split.length < 2) {
                gr.m4773W("Could not parse component name from open GMSG: " + c1089do.rI);
                return false;
            }
            intent.setClassName(split[0], split[1]);
        }
        try {
            gr.m4772V("Launching an intent: " + intent);
            context.startActivity(intent);
            dvVar.af();
            return true;
        } catch (ActivityNotFoundException e) {
            gr.m4773W(e.getMessage());
            return false;
        }
    }
}

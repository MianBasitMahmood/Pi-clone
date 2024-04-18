package com.google.android.gms.tagmanager;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

public class PreviewActivity extends Activity {

    /* renamed from: com.google.android.gms.tagmanager.PreviewActivity.1 */
    class C17471 implements OnClickListener {
        final /* synthetic */ PreviewActivity asl;

        C17471(PreviewActivity previewActivity) {
            this.asl = previewActivity;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    private void m6388d(String str, String str2, String str3) {
        AlertDialog create = new Builder(this).create();
        create.setTitle(str);
        create.setMessage(str2);
        create.setButton(-1, str3, new C17471(this));
        create.show();
    }

    public void onCreate(Bundle bundle) {
        try {
            super.onCreate(bundle);
            bh.m6459U("Preview activity");
            Uri data = getIntent().getData();
            if (!TagManager.getInstance(this).m6395i(data)) {
                String str = "Cannot preview the app with the uri: " + data + ". Launching current version instead.";
                bh.m6461W(str);
                m6388d("Preview failure", str, "Continue");
            }
            Intent launchIntentForPackage = getPackageManager().getLaunchIntentForPackage(getPackageName());
            if (launchIntentForPackage != null) {
                bh.m6459U("Invoke the launch activity for package name: " + getPackageName());
                startActivity(launchIntentForPackage);
                return;
            }
            bh.m6459U("No launch activity found for package name: " + getPackageName());
        } catch (Exception e) {
            bh.m6458T("Calling preview threw an exception: " + e.getMessage());
        }
    }
}

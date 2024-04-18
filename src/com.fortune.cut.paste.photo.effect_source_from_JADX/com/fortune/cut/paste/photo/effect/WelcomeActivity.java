package com.fortune.cut.paste.photo.effect;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.view.View;
import android.view.View.OnClickListener;
import com.chartboost.sdk.CBLocation;
import com.chartboost.sdk.Chartboost;
import com.chartboost.sdk.Libraries.CBLogging.Level;
import com.google.android.gms.wearable.DataEvent;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class WelcomeActivity extends Activity implements OnClickListener {
    static File f1060a;
    Intent f1061b;
    private GoogleAd f1062c;
    private GoogleBannerAd f1063d;

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_welcome);
        String file = Environment.getExternalStorageDirectory().toString();
        new File(new StringBuilder(String.valueOf(file)).append("/").append(getString(R.string.app_name)).append("/temp").toString()).mkdirs();
        if ("mounted".equals(Environment.getExternalStorageState())) {
            f1060a = new File(new StringBuilder(String.valueOf(file)).append("/").append(getString(R.string.app_name)).append("/temp/").toString(), "img_cutpaste.jpg");
        } else {
            f1060a = new File(getFilesDir(), "img_cutpaste.jpg");
        }
        this.f1062c = new GoogleAd(this);
        this.f1063d = new GoogleBannerAd(this);
        Chartboost.startWithAppId(this, getResources().getString(R.string.CHARTBOOST_APP_ID), getResources().getString(R.string.CHARTBOOST_APP_SIGNATURE));
        Chartboost.setLoggingLevel(Level.ALL);
        Chartboost.onCreate(this);
        findViewById(R.id.btn_camera).setOnClickListener(this);
        findViewById(R.id.btn_gallery).setOnClickListener(this);
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_camera:
                Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
                try {
                    intent.putExtra("output", "mounted".equals(Environment.getExternalStorageState()) ? Uri.fromFile(f1060a) : InternalStorageContentProvider.f1034a);
                    intent.putExtra("return-data", true);
                    startActivityForResult(intent, 2);
                } catch (ActivityNotFoundException e) {
                }
            case R.id.btn_gallery:
                this.f1061b = new Intent();
                this.f1061b.setType("image/*");
                this.f1061b.setAction("android.intent.action.GET_CONTENT");
                startActivityForResult(this.f1061b, 1);
            default:
        }
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        if (i2 == -1) {
            Intent intent2;
            switch (i) {
                case DataEvent.TYPE_CHANGED /*1*/:
                    try {
                        InputStream openInputStream = getContentResolver().openInputStream(intent.getData());
                        OutputStream fileOutputStream = new FileOutputStream(f1060a);
                        m1428a(openInputStream, fileOutputStream);
                        fileOutputStream.close();
                        openInputStream.close();
                        intent2 = new Intent(this, MainActivity.class);
                        intent2.putExtra("mImageUri", f1060a.getPath());
                        startActivity(intent2);
                        break;
                    } catch (Exception e) {
                        e.printStackTrace();
                        break;
                    }
                case DataEvent.TYPE_DELETED /*2*/:
                    intent2 = new Intent(this, MainActivity.class);
                    intent2.putExtra("mImageUri", f1060a.getPath());
                    startActivity(intent2);
                    break;
            }
            super.onActivityResult(i, i2, intent);
        }
    }

    private static void m1428a(InputStream inputStream, OutputStream outputStream) throws IOException {
        byte[] bArr = new byte[AccessibilityNodeInfoCompat.ACTION_NEXT_HTML_ELEMENT];
        while (true) {
            int read = inputStream.read(bArr);
            if (read != -1) {
                outputStream.write(bArr, 0, read);
            } else {
                return;
            }
        }
    }

    public void onBackPressed() {
        if (!Chartboost.onBackPressed()) {
            super.onBackPressed();
        }
    }

    protected void onResume() {
        super.onResume();
        Chartboost.onResume(this);
        if (this.f1063d.f1066a != null) {
            this.f1063d.f1066a.resume();
        }
    }

    protected void onPause() {
        Chartboost.onPause(this);
        if (this.f1063d.f1066a != null) {
            this.f1063d.f1066a.pause();
        }
        super.onPause();
    }

    protected void onDestroy() {
        Chartboost.onDestroy(this);
        if (f1060a.exists()) {
            f1060a.delete();
        }
        if (this.f1063d.f1066a != null) {
            this.f1063d.f1066a.destroy();
        }
        super.onDestroy();
    }

    protected void onStart() {
        super.onStart();
        Chartboost.onStart(this);
        Chartboost.showInterstitial(CBLocation.LOCATION_DEFAULT);
    }

    protected void onStop() {
        super.onStop();
        Chartboost.onStop(this);
    }
}

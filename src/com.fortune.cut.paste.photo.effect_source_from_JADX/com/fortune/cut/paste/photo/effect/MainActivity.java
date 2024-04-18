package com.fortune.cut.paste.photo.effect;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Point;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.widget.RelativeLayout;
import com.chartboost.sdk.CBLocation;
import com.chartboost.sdk.Chartboost;
import com.chartboost.sdk.Libraries.CBLogging.Level;

@SuppressLint({"NewApi"})
public class MainActivity extends Activity implements OnClickListener {
    static MainActivity f1041d;
    RelativeLayout f1042a;
    Bitmap f1043b;
    CropView f1044c;
    private Display f1045e;
    private Point f1046f;
    private int f1047g;
    private int f1048h;
    private GoogleBannerAd f1049i;

    /* renamed from: com.fortune.cut.paste.photo.effect.MainActivity.1 */
    class C03611 implements OnClickListener {
        final /* synthetic */ MainActivity f1039a;
        private final /* synthetic */ Dialog f1040b;

        C03611(MainActivity mainActivity, Dialog dialog) {
            this.f1039a = mainActivity;
            this.f1040b = dialog;
        }

        public final void onClick(View view) {
            this.f1040b.cancel();
        }
    }

    public MainActivity() {
        this.f1043b = null;
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_main);
        this.f1049i = new GoogleBannerAd(this);
        f1041d = this;
        this.f1042a = (RelativeLayout) findViewById(R.id.cropLyt);
        findViewById(R.id.retryBtn).setOnClickListener(this);
        findViewById(R.id.InnercropBtn).setOnClickListener(this);
        findViewById(R.id.outerCropBtn).setOnClickListener(this);
        this.f1045e = ((WindowManager) getBaseContext().getSystemService("window")).getDefaultDisplay();
        if (VERSION.SDK_INT >= 13) {
            this.f1046f = new Point();
            this.f1045e.getSize(this.f1046f);
            this.f1047g = this.f1046f.x;
            this.f1048h = this.f1046f.y;
        } else {
            this.f1047g = this.f1045e.getWidth();
            this.f1048h = this.f1045e.getHeight();
        }
        String stringExtra = getIntent().getStringExtra("mImageUri");
        new Options().inJustDecodeBounds = true;
        Bitmap decodeFile = BitmapFactory.decodeFile(stringExtra);
        int width = decodeFile.getWidth();
        int height = decodeFile.getHeight();
        int i = this.f1047g - 170;
        int i2 = this.f1048h - 350;
        if (width > height) {
            i2 = (int) (((float) height) / (((float) width) / ((float) i)));
        } else if (height > width) {
            i = (int) (((float) width) / (((float) height) / ((float) i2)));
        }
        this.f1043b = Bitmap.createScaledBitmap(decodeFile, i, i2, true);
        LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.f1043b.getWidth(), this.f1043b.getHeight());
        layoutParams.addRule(13, -1);
        this.f1042a.setLayoutParams(layoutParams);
        this.f1044c = new CropView((Context) this, this.f1043b);
        this.f1042a.addView(this.f1044c);
        Dialog dialog = new Dialog(this, R.style.TemplateDialog);
        dialog.setContentView(R.layout.hint1dialog);
        dialog.findViewById(R.id.btn_close).setOnClickListener(new C03611(this, dialog));
        dialog.show();
        Chartboost.startWithAppId(this, getResources().getString(R.string.CHARTBOOST_APP_ID), getResources().getString(R.string.CHARTBOOST_APP_SIGNATURE));
        Chartboost.setLoggingLevel(Level.ALL);
        Chartboost.onCreate(this);
    }

    public static MainActivity m1427a() {
        return f1041d;
    }

    public void onClick(View view) {
        Intent intent;
        switch (view.getId()) {
            case R.id.retryBtn:
                this.f1044c.m1426a();
                findViewById(R.id.optionLyt).setVisibility(8);
            case R.id.InnercropBtn:
                intent = new Intent(this, CropActivity.class);
                intent.putExtra("crop", true);
                startActivity(intent);
                f1041d.finish();
            case R.id.outerCropBtn:
                intent = new Intent(this, CropActivity.class);
                intent.putExtra("crop", false);
                startActivity(intent);
                this.f1044c.f1028e = false;
                f1041d.finish();
            default:
        }
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

    public void onBackPressed() {
        if (!Chartboost.onBackPressed()) {
            super.onBackPressed();
        }
    }

    protected void onResume() {
        if (this.f1049i.f1066a != null) {
            this.f1049i.f1066a.resume();
        }
        Chartboost.onResume(this);
        super.onResume();
    }

    protected void onPause() {
        if (this.f1049i.f1066a != null) {
            this.f1049i.f1066a.pause();
        }
        Chartboost.onPause(this);
        super.onPause();
    }

    protected void onDestroy() {
        Chartboost.onDestroy(this);
        if (this.f1049i.f1066a != null) {
            this.f1049i.f1066a.destroy();
        }
        super.onDestroy();
    }
}

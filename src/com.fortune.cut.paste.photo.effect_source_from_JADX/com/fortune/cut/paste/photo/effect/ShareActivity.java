package com.fortune.cut.paste.photo.effect;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Point;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class ShareActivity extends Activity implements OnClickListener {
    RelativeLayout f1050a;
    ImageView f1051b;
    Intent f1052c;
    Intent f1053d;
    Bitmap f1054e;
    private Uri f1055f;
    private Display f1056g;
    private Point f1057h;
    private int f1058i;
    private int f1059j;

    public ShareActivity() {
        this.f1054e = null;
    }

    @SuppressLint({"NewApi"})
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        setContentView(R.layout.share_activity);
        this.f1055f = Uri.parse(getIntent().getStringExtra("mImageUri"));
        this.f1050a = (RelativeLayout) findViewById(R.id.imgShareLyt);
        this.f1051b = (ImageView) findViewById(R.id.imgShare);
        this.f1056g = ((WindowManager) getSystemService("window")).getDefaultDisplay();
        if (VERSION.SDK_INT >= 13) {
            this.f1057h = new Point();
            this.f1056g.getSize(this.f1057h);
            this.f1058i = this.f1057h.x;
            this.f1059j = this.f1057h.y;
        } else {
            this.f1058i = this.f1056g.getWidth();
            this.f1059j = this.f1056g.getHeight();
        }
        findViewById(R.id.share_facebook).setOnClickListener(this);
        findViewById(R.id.share_whatup).setOnClickListener(this);
        findViewById(R.id.share_twitter).setOnClickListener(this);
        findViewById(R.id.share_instagram).setOnClickListener(this);
        findViewById(R.id.share_flickr).setOnClickListener(this);
        findViewById(R.id.share_other).setOnClickListener(this);
        findViewById(R.id.photoCollage).setOnClickListener(this);
        findViewById(R.id.coolPix).setOnClickListener(this);
        findViewById(R.id.InstaMirrorEffect).setOnClickListener(this);
        findViewById(R.id.ColorSplashEffect).setOnClickListener(this);
        findViewById(R.id.AppManager).setOnClickListener(this);
        findViewById(R.id.magazineCollage).setOnClickListener(this);
        Bitmap decodeFile = BitmapFactory.decodeFile(this.f1055f.getPath());
        if (decodeFile != null) {
            int height = decodeFile.getHeight();
            if (height > this.f1059j - 200) {
                height = this.f1059j - 200;
            }
            int width = (decodeFile.getWidth() * height) / decodeFile.getHeight();
            if (width > this.f1058i - 100) {
                height = this.f1058i - 100;
                width = (decodeFile.getHeight() * height) / decodeFile.getWidth();
            } else {
                int i = width;
                width = height;
                height = i;
            }
            this.f1054e = Bitmap.createScaledBitmap(decodeFile, height, width, true);
        }
        this.f1051b.setImageBitmap(this.f1054e);
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.share_facebook:
                try {
                    this.f1052c = new Intent("android.intent.action.SEND");
                    this.f1052c.setType("image/*");
                    this.f1052c.putExtra("android.intent.extra.STREAM", this.f1055f);
                    this.f1052c.setPackage("com.facebook.katana");
                    startActivity(Intent.createChooser(this.f1052c, "Your Awesome Text and Pic..."));
                } catch (Exception e) {
                    Toast.makeText(this, "facebook is not installed in your device !", 0).show();
                }
            case R.id.share_whatup:
                try {
                    this.f1052c = new Intent("android.intent.action.SEND");
                    this.f1052c.setType("image/*");
                    this.f1052c.putExtra("android.intent.extra.TEXT", "Your text here");
                    this.f1052c.putExtra("android.intent.extra.STREAM", this.f1055f);
                    this.f1052c.setPackage("com.whatsapp");
                    startActivity(Intent.createChooser(this.f1052c, "Your Awesome Text and Pic..."));
                } catch (Exception e2) {
                    Toast.makeText(this, "whatsapp is not installed in your device !", 0).show();
                }
            case R.id.share_instagram:
                try {
                    this.f1052c = new Intent("android.intent.action.SEND");
                    this.f1052c.setType("image/*");
                    this.f1052c.putExtra("android.intent.extra.STREAM", this.f1055f);
                    this.f1052c.setPackage("com.instagram.android");
                    startActivity(Intent.createChooser(this.f1052c, "Your Awesome Text and Pic..."));
                } catch (Exception e3) {
                    Toast.makeText(this, "instagram is not installed in your device !", 0).show();
                }
            case R.id.share_twitter:
                try {
                    this.f1052c = new Intent("android.intent.action.SEND");
                    this.f1052c.setType("image/*");
                    this.f1052c.putExtra("android.intent.extra.STREAM", this.f1055f);
                    this.f1052c.setPackage("com.twitter.android");
                    startActivity(Intent.createChooser(this.f1052c, "Your Awesome Text and Pic..."));
                } catch (Exception e4) {
                    Toast.makeText(this, "instagram is not installed in your device !", 0).show();
                }
            case R.id.share_flickr:
                try {
                    this.f1052c = new Intent("android.intent.action.SEND");
                    this.f1052c.setType("image/*");
                    this.f1052c.putExtra("android.intent.extra.STREAM", this.f1055f);
                    this.f1052c.setPackage("com.tumblr");
                    startActivity(Intent.createChooser(this.f1052c, "Your Awesome Text and Pic..."));
                } catch (Exception e5) {
                    Toast.makeText(this, "instagram is not installed in your device !", 0).show();
                }
            case R.id.share_other:
                this.f1052c = new Intent("android.intent.action.SEND");
                this.f1052c.setType("image/*");
                this.f1052c.putExtra("android.intent.extra.STREAM", this.f1055f);
                startActivity(Intent.createChooser(this.f1052c, "Share image using"));
            case R.id.photoCollage:
                this.f1053d = new Intent("android.intent.action.VIEW", Uri.parse("https://play.google.com/store/apps/details?id=com.fortunetechlab.photo.grid.shape.collage"));
                startActivity(this.f1053d);
            case R.id.coolPix:
                this.f1053d = new Intent("android.intent.action.VIEW", Uri.parse("https://play.google.com/store/apps/details?id=com.fortunetechlab.photo.collage.frame.effects.coolpix"));
                startActivity(this.f1053d);
            case R.id.magazineCollage:
                this.f1053d = new Intent("android.intent.action.VIEW", Uri.parse("https://play.google.com/store/apps/details?id=com.fortune.magazine.collage.maker"));
                startActivity(this.f1053d);
            case R.id.InstaMirrorEffect:
                this.f1053d = new Intent("android.intent.action.VIEW", Uri.parse("https://play.google.com/store/apps/details?id=com.fortune.insta.mirror.reflection.photoeffect"));
                startActivity(this.f1053d);
            case R.id.ColorSplashEffect:
                this.f1053d = new Intent("android.intent.action.VIEW", Uri.parse("https://play.google.com/store/apps/details?id=com.fortune.photo.color.splash.effect"));
                startActivity(this.f1053d);
            case R.id.AppManager:
                this.f1053d = new Intent("android.intent.action.VIEW", Uri.parse("https://play.google.com/store/apps/details?id=com.fortunetechlab.app.manager.cleaner"));
                startActivity(this.f1053d);
            default:
        }
    }
}

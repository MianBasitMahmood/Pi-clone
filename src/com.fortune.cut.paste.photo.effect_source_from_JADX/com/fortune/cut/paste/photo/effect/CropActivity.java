package com.fortune.cut.paste.photo.effect;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.BlurMaskFilter;
import android.graphics.BlurMaskFilter.Blur;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.media.MediaScannerConnection;
import android.media.MediaScannerConnection.OnScanCompletedListener;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Environment;
import android.preference.PreferenceManager;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.Toast;
import com.fortune.cut.paste.photo.effect.CropView.C0359a;
import com.google.android.gms.cast.TextTrackStyle;
import com.google.android.gms.wallet.NotifyTransactionStatusRequest.Status.Error;
import com.google.android.gms.wallet.fragment.Dimension;
import com.google.android.gms.wallet.fragment.WalletFragmentState;
import com.google.android.gms.wearable.DataEvent;
import com.p000a.p001a.p002a.ContrastFilter;
import com.p000a.p001a.p002a.p003a.AndroidUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

@SuppressLint({"NewApi"})
public class CropActivity extends Activity implements OnClickListener {
    private static String f993g;
    private GoogleBannerAd f994A;
    private GoogleAd f995B;
    Bitmap f996a;
    OnSeekBarChangeListener f997b;
    OnSeekBarChangeListener f998c;
    OnSeekBarChangeListener f999d;
    private int f1000e;
    private RectF f1001f;
    private RelativeLayout f1002h;
    private File f1003i;
    private File f1004j;
    private boolean f1005k;
    private Uri f1006l;
    private Display f1007m;
    private Point f1008n;
    private int f1009o;
    private int f1010p;
    private Matrix f1011q;
    private Matrix f1012r;
    private ImageView f1013s;
    private ImageView f1014t;
    private boolean f1015u;
    private Dialog f1016v;
    private SharedPreferences f1017w;
    private SeekBar f1018x;
    private SeekBar f1019y;
    private SeekBar f1020z;

    /* renamed from: com.fortune.cut.paste.photo.effect.CropActivity.1 */
    class C03511 implements OnSeekBarChangeListener {
        float f972a;
        final /* synthetic */ CropActivity f973b;

        C03511(CropActivity cropActivity) {
            this.f973b = cropActivity;
            this.f972a = TextTrackStyle.DEFAULT_FONT_SCALE;
        }

        public final void onStopTrackingTouch(SeekBar seekBar) {
        }

        public final void onStartTrackingTouch(SeekBar seekBar) {
        }

        public final void onProgressChanged(SeekBar seekBar, int i, boolean z) {
            this.f972a = ((float) this.f973b.f1020z.getProgress()) / 1000.0f;
            try {
                this.f973b.f1013s.setAlpha(this.f972a);
            } catch (Exception e) {
            }
        }
    }

    /* renamed from: com.fortune.cut.paste.photo.effect.CropActivity.2 */
    class C03522 implements OnSeekBarChangeListener {
        int f974a;
        final /* synthetic */ CropActivity f975b;

        C03522(CropActivity cropActivity) {
            this.f975b = cropActivity;
        }

        public final void onStopTrackingTouch(SeekBar seekBar) {
            ImageView b = this.f975b.f1013s;
            Bitmap bitmap = this.f975b.f996a;
            float f = (float) this.f974a;
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            ContrastFilter contrastFilter = new ContrastFilter();
            contrastFilter.m19c(f * 0.025f);
            b.setImageBitmap(Bitmap.createBitmap(contrastFilter.m16a(AndroidUtils.m10a(bitmap), width, height), width, height, Config.ARGB_8888));
        }

        public final void onStartTrackingTouch(SeekBar seekBar) {
        }

        public final void onProgressChanged(SeekBar seekBar, int i, boolean z) {
            this.f974a = i + 10;
        }
    }

    /* renamed from: com.fortune.cut.paste.photo.effect.CropActivity.3 */
    class C03533 implements OnSeekBarChangeListener {
        int f976a;
        final /* synthetic */ CropActivity f977b;

        C03533(CropActivity cropActivity) {
            this.f977b = cropActivity;
        }

        public final void onStopTrackingTouch(SeekBar seekBar) {
            ImageView b = this.f977b.f1013s;
            Bitmap bitmap = this.f977b.f996a;
            float f = (float) this.f976a;
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            ContrastFilter contrastFilter = new ContrastFilter();
            contrastFilter.m18b(f * 0.025f);
            b.setImageBitmap(Bitmap.createBitmap(contrastFilter.m16a(AndroidUtils.m10a(bitmap), width, height), width, height, Config.ARGB_8888));
        }

        public final void onStartTrackingTouch(SeekBar seekBar) {
        }

        public final void onProgressChanged(SeekBar seekBar, int i, boolean z) {
            this.f976a = i + 10;
        }
    }

    /* renamed from: com.fortune.cut.paste.photo.effect.CropActivity.4 */
    class C03544 implements OnTouchListener {
        final /* synthetic */ CropActivity f978a;
        private final /* synthetic */ Dialog f979b;

        C03544(CropActivity cropActivity, Dialog dialog) {
            this.f978a = cropActivity;
            this.f979b = dialog;
        }

        public final boolean onTouch(View view, MotionEvent motionEvent) {
            this.f979b.cancel();
            return false;
        }
    }

    /* renamed from: com.fortune.cut.paste.photo.effect.CropActivity.5 */
    class C03555 implements DialogInterface.OnClickListener {
        final /* synthetic */ CropActivity f980a;

        C03555(CropActivity cropActivity) {
            this.f980a = cropActivity;
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            this.f980a.f1005k = true;
            this.f980a.m1424a();
            this.f980a.f995B.m1429a();
        }
    }

    /* renamed from: com.fortune.cut.paste.photo.effect.CropActivity.6 */
    class C03566 implements DialogInterface.OnClickListener {
        final /* synthetic */ CropActivity f981a;

        C03566(CropActivity cropActivity) {
            this.f981a = cropActivity;
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.dismiss();
        }
    }

    /* renamed from: com.fortune.cut.paste.photo.effect.CropActivity.7 */
    class C03577 implements OnScanCompletedListener {
        final /* synthetic */ CropActivity f982a;

        C03577(CropActivity cropActivity) {
            this.f982a = cropActivity;
        }

        public final void onScanCompleted(String str, Uri uri) {
        }
    }

    /* renamed from: com.fortune.cut.paste.photo.effect.CropActivity.a */
    private class C0358a implements OnTouchListener {
        int f983a;
        PointF f984b;
        PointF f985c;
        float f986d;
        float f987e;
        float f988f;
        float f989g;
        float f990h;
        final /* synthetic */ CropActivity f991i;
        private float f992j;

        private C0358a(CropActivity cropActivity) {
            this.f991i = cropActivity;
            this.f983a = 0;
            this.f984b = new PointF();
            this.f985c = new PointF();
            this.f986d = TextTrackStyle.DEFAULT_FONT_SCALE;
        }

        public final boolean onTouch(View view, MotionEvent motionEvent) {
            switch (motionEvent.getAction() & MotionEventCompat.ACTION_MASK) {
                case WalletFragmentState.UNKNOWN /*0*/:
                    this.f991i.f1011q.set(this.f991i.f1012r);
                    this.f984b.set(motionEvent.getX(), motionEvent.getY());
                    this.f987e = motionEvent.getX();
                    this.f988f = motionEvent.getY();
                    this.f983a = 1;
                    break;
                case DataEvent.TYPE_CHANGED /*1*/:
                case Error.OTHER /*6*/:
                    this.f983a = 0;
                    break;
                case DataEvent.TYPE_DELETED /*2*/:
                    this.f989g = motionEvent.getX();
                    this.f990h = motionEvent.getY();
                    if (Math.abs(Math.abs(this.f987e) - Math.abs(this.f989g)) <= 10.0f) {
                        Math.abs(Math.abs(this.f988f) - Math.abs(this.f990h));
                    }
                    if (this.f983a != 1) {
                        if (this.f983a == 2) {
                            float a = (float) C0358a.m1412a(motionEvent);
                            this.f991i.f1012r.set(this.f991i.f1011q);
                            if (a > 10.0f) {
                                a /= this.f986d;
                                this.f991i.f1012r.postScale(a, a, this.f985c.x, this.f985c.y);
                            }
                            this.f991i.f1012r.postRotate(C0358a.m1413b(motionEvent) - this.f992j, (float) (view.getMeasuredWidth() / 2), (float) (view.getMeasuredHeight() / 2));
                            break;
                        }
                    }
                    this.f991i.f1012r.set(this.f991i.f1011q);
                    this.f991i.f1012r.postTranslate(motionEvent.getX() - this.f984b.x, motionEvent.getY() - this.f984b.y);
                    break;
                    break;
                case Dimension.UNIT_MM /*5*/:
                    this.f992j = C0358a.m1413b(motionEvent);
                    this.f986d = (float) C0358a.m1412a(motionEvent);
                    this.f991i.f1011q.set(this.f991i.f1012r);
                    this.f985c.set((motionEvent.getX(0) + motionEvent.getX(1)) / 2.0f, (motionEvent.getY(0) + motionEvent.getY(1)) / 2.0f);
                    this.f983a = 2;
                    break;
            }
            ((ImageView) view).setImageMatrix(this.f991i.f1012r);
            return true;
        }

        private static double m1412a(MotionEvent motionEvent) {
            double x = (double) (motionEvent.getX(0) - motionEvent.getX(1));
            double y = (double) (motionEvent.getY(0) - motionEvent.getY(1));
            return Math.sqrt((x * x) + (y * y));
        }

        private static float m1413b(MotionEvent motionEvent) {
            return (float) Math.toDegrees(Math.atan2((double) (motionEvent.getY(0) - motionEvent.getY(1)), (double) (motionEvent.getX(0) - motionEvent.getX(1))));
        }
    }

    public CropActivity() {
        this.f1000e = 100;
        this.f1001f = new RectF();
        this.f1005k = false;
        this.f1006l = null;
        this.f1011q = new Matrix();
        this.f1012r = new Matrix();
        this.f997b = new C03511(this);
        this.f998c = new C03522(this);
        this.f999d = new C03533(this);
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.cropview);
        this.f994A = new GoogleBannerAd(this);
        this.f995B = new GoogleAd(this);
        this.f1020z = (SeekBar) findViewById(R.id.opacity);
        this.f1018x = (SeekBar) findViewById(R.id.brightness);
        this.f1019y = (SeekBar) findViewById(R.id.contrast);
        this.f1019y.setOnSeekBarChangeListener(this.f998c);
        this.f1018x.setOnSeekBarChangeListener(this.f999d);
        this.f1020z.setOnSeekBarChangeListener(this.f997b);
        this.f1002h = (RelativeLayout) findViewById(R.id.mlayout);
        findViewById(R.id.resetBtn).setOnClickListener(this);
        findViewById(R.id.selectImage).setOnClickListener(this);
        findViewById(R.id.ImageAdjustTool).setOnClickListener(this);
        findViewById(R.id.adjustOpacity).setOnClickListener(this);
        findViewById(R.id.saveBtn).setOnClickListener(this);
        findViewById(R.id.shareBtn).setOnClickListener(this);
        this.f1013s = (ImageView) findViewById(R.id.our_imageview);
        this.f1014t = (ImageView) findViewById(R.id.bakgroundImage);
        String file = Environment.getExternalStorageDirectory().toString();
        new File(new StringBuilder(String.valueOf(file)).append("/").append(getString(R.string.app_name)).append("/temp").toString()).mkdirs();
        if ("mounted".equals(Environment.getExternalStorageState())) {
            this.f1004j = new File(new StringBuilder(String.valueOf(file)).append("/").append(getString(R.string.app_name)).append("/temp/").toString(), "img_cutpaste.jpg");
        } else {
            this.f1004j = new File(getFilesDir(), "img_cutpaste.jpg");
        }
        LayoutParams layoutParams = new RelativeLayout.LayoutParams(MainActivity.m1427a().f1043b.getWidth(), MainActivity.m1427a().f1043b.getHeight());
        layoutParams.addRule(13, -1);
        this.f1002h.setLayoutParams(layoutParams);
        this.f1007m = ((WindowManager) getBaseContext().getSystemService("window")).getDefaultDisplay();
        if (VERSION.SDK_INT >= 13) {
            this.f1008n = new Point();
            this.f1007m.getSize(this.f1008n);
            this.f1009o = this.f1008n.x;
            this.f1010p = this.f1008n.y;
        } else {
            this.f1009o = this.f1007m.getWidth();
            this.f1010p = this.f1007m.getHeight();
        }
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            this.f1015u = extras.getBoolean("crop");
        }
        DisplayMetrics displayMetrics = new DisplayMetrics();
        try {
            getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        } catch (Exception e) {
        }
        int i = displayMetrics.widthPixels;
        int i2 = displayMetrics.heightPixels;
        Bitmap bitmap = MainActivity.m1427a().f1043b;
        this.f996a = Bitmap.createBitmap(i, i2, bitmap.getConfig());
        Canvas canvas = new Canvas(this.f996a);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setDither(true);
        paint.setColor(-13421773);
        paint.setMaskFilter(new BlurMaskFilter(50.0f, Blur.NORMAL));
        this.f1001f.top = (float) this.f1000e;
        this.f1001f.bottom = this.f1001f.top + ((float) (this.f1000e / 2));
        this.f1001f.left = 0.0f;
        this.f1001f.right = (float) ((int) paint.measureText("hello"));
        Path path = new Path();
        for (i = 0; i < CropView.f1024a.size(); i++) {
            path.lineTo(((C0359a) CropView.f1024a.get(i)).f1021a, ((C0359a) CropView.f1024a.get(i)).f1022b);
        }
        canvas.drawPath(path, paint);
        if (this.f1015u) {
            paint.setXfermode(new PorterDuffXfermode(Mode.SRC_IN));
        } else {
            paint.setXfermode(new PorterDuffXfermode(Mode.SRC_OUT));
        }
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, paint);
        this.f1013s.setImageBitmap(this.f996a);
        this.f1013s.setOnTouchListener(new C0358a());
        this.f1017w = PreferenceManager.getDefaultSharedPreferences(this);
        if (this.f1017w.getBoolean("help2", true)) {
            Dialog dialog = new Dialog(this, R.style.TemplateDialog);
            dialog.setContentView(R.layout.hint2dialog);
            dialog.findViewById(R.id.hint2).setOnTouchListener(new C03544(this, dialog));
            dialog.show();
            Editor edit = this.f1017w.edit();
            edit.putBoolean("help2", false);
            edit.commit();
        }
    }

    public void onClick(View view) {
        Intent intent;
        switch (view.getId()) {
            case R.id.cameraBtn:
                intent = new Intent("android.media.action.IMAGE_CAPTURE");
                try {
                    this.f1006l = null;
                    if ("mounted".equals(Environment.getExternalStorageState())) {
                        this.f1006l = Uri.fromFile(this.f1004j);
                    } else {
                        this.f1006l = InternalStorageContentProvider.f1034a;
                    }
                    intent.putExtra("output", this.f1006l);
                    intent.putExtra("return-data", true);
                    startActivityForResult(intent, 2);
                } catch (ActivityNotFoundException e) {
                }
                this.f1016v.cancel();
            case R.id.galleryBtn:
                intent = new Intent();
                intent.setType("image/*");
                intent.setAction("android.intent.action.GET_CONTENT");
                startActivityForResult(intent, 1);
                this.f1016v.cancel();
            case R.id.resetBtn:
                this.f1013s.setImageBitmap(this.f996a);
            case R.id.selectImage:
                this.f1016v = new Dialog(this, R.style.TemplateDialog);
                this.f1016v.requestWindowFeature(1);
                this.f1016v.setContentView(R.layout.camera_gallery_dialog);
                this.f1016v.findViewById(R.id.cameraBtn).setOnClickListener(this);
                this.f1016v.findViewById(R.id.galleryBtn).setOnClickListener(this);
                this.f1016v.show();
                this.f1020z.setVisibility(8);
                findViewById(R.id.seekBarLyt).setVisibility(8);
            case R.id.ImageAdjustTool:
                this.f1020z.setVisibility(8);
                findViewById(R.id.seekBar2Lyt).setVisibility(8);
                findViewById(R.id.seekBarLyt).setVisibility(0);
            case R.id.adjustOpacity:
                this.f1020z.setVisibility(0);
                findViewById(R.id.seekBar2Lyt).setVisibility(0);
                findViewById(R.id.seekBarLyt).setVisibility(8);
            case R.id.saveBtn:
                m1419b();
            case R.id.shareBtn:
                if (this.f1005k) {
                    intent = new Intent(this, ShareActivity.class);
                    intent.putExtra("mImageUri", this.f1003i.getAbsolutePath());
                    startActivity(intent);
                    return;
                }
                m1419b();
            default:
        }
    }

    private static void m1416a(InputStream inputStream, OutputStream outputStream) throws IOException {
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

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            switch (i) {
                case DataEvent.TYPE_CHANGED /*1*/:
                    try {
                        InputStream openInputStream = getContentResolver().openInputStream(intent.getData());
                        OutputStream fileOutputStream = new FileOutputStream(this.f1004j);
                        m1416a(openInputStream, fileOutputStream);
                        fileOutputStream.close();
                        openInputStream.close();
                        m1417a(this.f1004j.getPath());
                    } catch (Exception e) {
                    }
                case DataEvent.TYPE_DELETED /*2*/:
                    m1417a(this.f1004j.getPath());
                default:
            }
        }
    }

    private void m1417a(String str) {
        Options options = new Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(str, options);
        Bitmap decodeFile = BitmapFactory.decodeFile(str);
        int width = decodeFile.getWidth();
        int height = decodeFile.getHeight();
        int i = this.f1009o - 150;
        int i2 = this.f1010p - 300;
        if (width > height) {
            i2 = (int) (((float) height) / (((float) width) / ((float) i)));
        } else if (height > width) {
            i = (int) (((float) width) / (((float) height) / ((float) i2)));
        }
        Bitmap createScaledBitmap = Bitmap.createScaledBitmap(decodeFile, i, i2, true);
        this.f1002h.setBackgroundDrawable(new BitmapDrawable(createScaledBitmap));
        LayoutParams layoutParams = new RelativeLayout.LayoutParams(createScaledBitmap.getWidth(), createScaledBitmap.getHeight());
        layoutParams.addRule(13, -1);
        this.f1002h.setLayoutParams(layoutParams);
    }

    private void m1419b() {
        Builder builder = new Builder(this);
        builder.setTitle("Save");
        builder.setMessage("Your Work is not saved!! Would you like to save your work?").setCancelable(true).setPositiveButton("Yes", new C03555(this)).setNegativeButton("No", new C03566(this));
        builder.create().show();
    }

    protected final void m1424a() {
        f993g = "img_cutpaste";
        this.f1002h.setDrawingCacheEnabled(true);
        this.f1002h.layout(0, 0, this.f1002h.getMeasuredWidth(), this.f1002h.getMeasuredHeight());
        Bitmap drawingCache = this.f1002h.getDrawingCache(true);
        try {
            drawingCache.compress(CompressFormat.JPEG, 90, new FileOutputStream(this.f1004j));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        int i = defaultSharedPreferences.getInt("count", 0);
        Editor edit = defaultSharedPreferences.edit();
        i++;
        edit.putInt("count", i);
        edit.commit();
        String file = Environment.getExternalStorageDirectory().toString();
        new File(new StringBuilder(String.valueOf(file)).append("/").append(getString(R.string.app_name)).append("/DCIM").toString()).mkdirs();
        if ("mounted".equals(Environment.getExternalStorageState())) {
            this.f1003i = new File(new StringBuilder(String.valueOf(file)).append("/").append(getString(R.string.app_name)).append("/DCIM/").append(f993g).append(i).append(".JPEG").toString());
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(this.f1003i);
            } catch (FileNotFoundException e2) {
                e2.printStackTrace();
            }
        } else {
            this.f1003i = new File(getFilesDir(), f993g);
        }
        try {
            m1415a(this.f1004j, this.f1003i);
        } catch (IOException e3) {
            e3.printStackTrace();
        }
        LayoutParams layoutParams = new RelativeLayout.LayoutParams(drawingCache.getWidth(), drawingCache.getHeight());
        layoutParams.addRule(13, -1);
        this.f1002h.setLayoutParams(layoutParams);
        this.f1002h.setDrawingCacheEnabled(false);
        Toast.makeText(this, "Save to : " + file, 0).show();
        try {
            MediaScannerConnection.scanFile(getApplicationContext(), new String[]{this.f1003i.getAbsolutePath()}, null, new C03577(this));
            sendBroadcast(new Intent("android.intent.action.MEDIA_MOUNTED", Uri.parse("file://" + Environment.getExternalStorageDirectory())));
        } catch (Exception e4) {
        }
    }

    private static void m1415a(File file, File file2) throws IOException {
        InputStream fileInputStream = new FileInputStream(file);
        OutputStream fileOutputStream = new FileOutputStream(file2);
        byte[] bArr = new byte[AccessibilityNodeInfoCompat.ACTION_NEXT_HTML_ELEMENT];
        while (true) {
            int read = fileInputStream.read(bArr);
            if (read <= 0) {
                fileInputStream.close();
                fileOutputStream.close();
                return;
            }
            fileOutputStream.write(bArr, 0, read);
        }
    }

    protected void onStart() {
        super.onStart();
    }

    protected void onStop() {
        super.onStop();
    }

    public void onBackPressed() {
        super.onBackPressed();
    }

    protected void onResume() {
        if (this.f994A.f1066a != null) {
            this.f994A.f1066a.resume();
        }
        super.onResume();
    }

    protected void onPause() {
        if (this.f994A.f1066a != null) {
            this.f994A.f1066a.pause();
        }
        super.onPause();
    }

    protected void onDestroy() {
        if (this.f994A.f1066a != null) {
            this.f994A.f1066a.destroy();
        }
        super.onDestroy();
    }
}

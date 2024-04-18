package com.google.android.gms.plus;

import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.wallet.fragment.WalletFragmentState;
import com.google.android.gms.wearable.DataEvent;

public class PlusOneDummyView extends FrameLayout {
    public static final String TAG = "PlusOneDummyView";

    /* renamed from: com.google.android.gms.plus.PlusOneDummyView.d */
    private interface C1709d {
        Drawable getDrawable(int i);

        boolean isValid();
    }

    /* renamed from: com.google.android.gms.plus.PlusOneDummyView.a */
    private static class C1710a implements C1709d {
        private Context mContext;

        private C1710a(Context context) {
            this.mContext = context;
        }

        public Drawable getDrawable(int i) {
            return this.mContext.getResources().getDrawable(17301508);
        }

        public boolean isValid() {
            return true;
        }
    }

    /* renamed from: com.google.android.gms.plus.PlusOneDummyView.b */
    private static class C1711b implements C1709d {
        private Context mContext;

        private C1711b(Context context) {
            this.mContext = context;
        }

        public Drawable getDrawable(int i) {
            try {
                String str;
                Resources resources = this.mContext.createPackageContext(GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_PACKAGE, 4).getResources();
                String str2 = GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_PACKAGE;
                switch (i) {
                    case WalletFragmentState.UNKNOWN /*0*/:
                        str = "ic_plusone_small";
                        break;
                    case DataEvent.TYPE_CHANGED /*1*/:
                        str = "ic_plusone_medium";
                        break;
                    case DataEvent.TYPE_DELETED /*2*/:
                        str = "ic_plusone_tall";
                        break;
                    default:
                        str = "ic_plusone_standard";
                        break;
                }
                return resources.getDrawable(resources.getIdentifier(str, "drawable", str2));
            } catch (NameNotFoundException e) {
                return null;
            }
        }

        public boolean isValid() {
            try {
                this.mContext.createPackageContext(GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_PACKAGE, 4).getResources();
                return true;
            } catch (NameNotFoundException e) {
                return false;
            }
        }
    }

    /* renamed from: com.google.android.gms.plus.PlusOneDummyView.c */
    private static class C1712c implements C1709d {
        private Context mContext;

        private C1712c(Context context) {
            this.mContext = context;
        }

        public Drawable getDrawable(int i) {
            String str;
            switch (i) {
                case WalletFragmentState.UNKNOWN /*0*/:
                    str = "ic_plusone_small_off_client";
                    break;
                case DataEvent.TYPE_CHANGED /*1*/:
                    str = "ic_plusone_medium_off_client";
                    break;
                case DataEvent.TYPE_DELETED /*2*/:
                    str = "ic_plusone_tall_off_client";
                    break;
                default:
                    str = "ic_plusone_standard_off_client";
                    break;
            }
            return this.mContext.getResources().getDrawable(this.mContext.getResources().getIdentifier(str, "drawable", this.mContext.getPackageName()));
        }

        public boolean isValid() {
            return (this.mContext.getResources().getIdentifier("ic_plusone_small_off_client", "drawable", this.mContext.getPackageName()) == 0 || this.mContext.getResources().getIdentifier("ic_plusone_medium_off_client", "drawable", this.mContext.getPackageName()) == 0 || this.mContext.getResources().getIdentifier("ic_plusone_tall_off_client", "drawable", this.mContext.getPackageName()) == 0 || this.mContext.getResources().getIdentifier("ic_plusone_standard_off_client", "drawable", this.mContext.getPackageName()) == 0) ? false : true;
        }
    }

    public PlusOneDummyView(Context context, int i) {
        super(context);
        View button = new Button(context);
        button.setEnabled(false);
        button.setBackgroundDrawable(ot().getDrawable(i));
        Point fs = fs(i);
        addView(button, new LayoutParams(fs.x, fs.y, 17));
    }

    private Point fs(int i) {
        int i2 = 24;
        int i3 = 20;
        Point point = new Point();
        switch (i) {
            case WalletFragmentState.UNKNOWN /*0*/:
                i3 = 14;
                break;
            case DataEvent.TYPE_CHANGED /*1*/:
                i2 = 32;
                break;
            case DataEvent.TYPE_DELETED /*2*/:
                i2 = 50;
                break;
            default:
                i2 = 38;
                i3 = 24;
                break;
        }
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        float applyDimension = TypedValue.applyDimension(1, (float) i2, displayMetrics);
        float applyDimension2 = TypedValue.applyDimension(1, (float) i3, displayMetrics);
        point.x = (int) (((double) applyDimension) + 0.5d);
        point.y = (int) (((double) applyDimension2) + 0.5d);
        return point;
    }

    private C1709d ot() {
        C1709d c1711b = new C1711b(null);
        if (!c1711b.isValid()) {
            c1711b = new C1712c(null);
        }
        return !c1711b.isValid() ? new C1710a(null) : c1711b;
    }
}

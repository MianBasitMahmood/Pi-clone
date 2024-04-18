package com.google.android.gms.games.appcontent;

import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.jv;

public final class AppContentAnnotationEntity implements SafeParcelable, AppContentAnnotation {
    public static final AppContentAnnotationEntityCreator CREATOR;
    private final int CK;
    private final String OH;
    private final String UO;
    private final Uri XN;
    private final String vc;

    static {
        CREATOR = new AppContentAnnotationEntityCreator();
    }

    AppContentAnnotationEntity(int i, String str, Uri uri, String str2, String str3) {
        this.CK = i;
        this.UO = str;
        this.XN = uri;
        this.OH = str2;
        this.vc = str3;
    }

    public AppContentAnnotationEntity(AppContentAnnotation appContentAnnotation) {
        this.CK = 1;
        this.UO = appContentAnnotation.getDescription();
        this.XN = appContentAnnotation.kL();
        this.OH = appContentAnnotation.getTitle();
        this.vc = appContentAnnotation.getType();
    }

    static int m2844a(AppContentAnnotation appContentAnnotation) {
        return jv.hashCode(appContentAnnotation.getDescription(), appContentAnnotation.kL(), appContentAnnotation.getTitle(), appContentAnnotation.getType());
    }

    static boolean m2845a(AppContentAnnotation appContentAnnotation, Object obj) {
        if (!(obj instanceof AppContentAnnotation)) {
            return false;
        }
        if (appContentAnnotation == obj) {
            return true;
        }
        AppContentAnnotation appContentAnnotation2 = (AppContentAnnotation) obj;
        return jv.equal(appContentAnnotation2.getDescription(), appContentAnnotation.getDescription()) && jv.equal(appContentAnnotation2.kL(), appContentAnnotation.kL()) && jv.equal(appContentAnnotation2.getTitle(), appContentAnnotation.getTitle()) && jv.equal(appContentAnnotation2.getType(), appContentAnnotation.getType());
    }

    static String m2846b(AppContentAnnotation appContentAnnotation) {
        return jv.m5212h(appContentAnnotation).m5211a("Description", appContentAnnotation.getDescription()).m5211a("ImageUri", appContentAnnotation.kL()).m5211a("Title", appContentAnnotation.getTitle()).m5211a("Type", appContentAnnotation.getType()).toString();
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        return m2845a(this, obj);
    }

    public final /* synthetic */ Object freeze() {
        return kM();
    }

    public final String getDescription() {
        return this.UO;
    }

    public final String getTitle() {
        return this.OH;
    }

    public final String getType() {
        return this.vc;
    }

    public final int getVersionCode() {
        return this.CK;
    }

    public final int hashCode() {
        return m2844a(this);
    }

    public final boolean isDataValid() {
        return true;
    }

    public final Uri kL() {
        return this.XN;
    }

    public final AppContentAnnotation kM() {
        return this;
    }

    public final String toString() {
        return m2846b(this);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        AppContentAnnotationEntityCreator.m2847a(this, parcel, i);
    }
}

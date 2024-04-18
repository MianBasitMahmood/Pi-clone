package com.google.android.gms.cast;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.images.WebImage;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.in;
import com.google.android.gms.internal.jv;
import java.util.ArrayList;
import java.util.List;

public final class ApplicationMetadata implements SafeParcelable {
    public static final Creator<ApplicationMetadata> CREATOR;
    private final int CK;
    String Fo;
    List<WebImage> Fp;
    List<String> Fq;
    String Fr;
    Uri Fs;
    String mName;

    static {
        CREATOR = new C0484a();
    }

    private ApplicationMetadata() {
        this.CK = 1;
        this.Fp = new ArrayList();
        this.Fq = new ArrayList();
    }

    ApplicationMetadata(int i, String str, String str2, List<WebImage> list, List<String> list2, String str3, Uri uri) {
        this.CK = i;
        this.Fo = str;
        this.mName = str2;
        this.Fp = list;
        this.Fq = list2;
        this.Fr = str3;
        this.Fs = uri;
    }

    public final boolean areNamespacesSupported(List<String> list) {
        return this.Fq != null && this.Fq.containsAll(list);
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ApplicationMetadata)) {
            return false;
        }
        ApplicationMetadata applicationMetadata = (ApplicationMetadata) obj;
        return in.m5027a(this.Fo, applicationMetadata.Fo) && in.m5027a(this.Fp, applicationMetadata.Fp) && in.m5027a(this.mName, applicationMetadata.mName) && in.m5027a(this.Fq, applicationMetadata.Fq) && in.m5027a(this.Fr, applicationMetadata.Fr) && in.m5027a(this.Fs, applicationMetadata.Fs);
    }

    public final Uri fP() {
        return this.Fs;
    }

    public final String getApplicationId() {
        return this.Fo;
    }

    public final List<WebImage> getImages() {
        return this.Fp;
    }

    public final String getName() {
        return this.mName;
    }

    public final String getSenderAppIdentifier() {
        return this.Fr;
    }

    final int getVersionCode() {
        return this.CK;
    }

    public final int hashCode() {
        return jv.hashCode(Integer.valueOf(this.CK), this.Fo, this.mName, this.Fp, this.Fq, this.Fr, this.Fs);
    }

    public final boolean isNamespaceSupported(String str) {
        return this.Fq != null && this.Fq.contains(str);
    }

    public final String toString() {
        return this.mName;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        C0484a.m1759a(this, parcel, i);
    }
}

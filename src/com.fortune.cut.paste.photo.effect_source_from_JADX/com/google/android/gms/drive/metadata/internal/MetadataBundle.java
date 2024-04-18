package com.google.android.gms.drive.metadata.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.data.C0522a;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.internal.C0634w;
import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.internal.jv;
import com.google.android.gms.internal.jx;
import com.google.android.gms.internal.ln;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public final class MetadataBundle implements SafeParcelable {
    public static final Creator<MetadataBundle> CREATOR;
    final int CK;
    final Bundle Ri;

    static {
        CREATOR = new C0663h();
    }

    MetadataBundle(int i, Bundle bundle) {
        this.CK = i;
        this.Ri = (Bundle) jx.m5223i(bundle);
        this.Ri.setClassLoader(getClass().getClassLoader());
        List<String> arrayList = new ArrayList();
        for (String str : this.Ri.keySet()) {
            if (C0660e.bm(str) == null) {
                arrayList.add(str);
                C0634w.m2301o("MetadataBundle", "Ignored unknown metadata field in bundle: " + str);
            }
        }
        for (String str2 : arrayList) {
            this.Ri.remove(str2);
        }
    }

    private MetadataBundle(Bundle bundle) {
        this(1, bundle);
    }

    public static <T> MetadataBundle m2341a(MetadataField<T> metadataField, T t) {
        MetadataBundle iZ = iZ();
        iZ.m2344b(metadataField, t);
        return iZ;
    }

    public static MetadataBundle m2342a(MetadataBundle metadataBundle) {
        return new MetadataBundle(new Bundle(metadataBundle.Ri));
    }

    public static MetadataBundle iZ() {
        return new MetadataBundle(new Bundle());
    }

    public final <T> T m2343a(MetadataField<T> metadataField) {
        return metadataField.m2328h(this.Ri);
    }

    public final <T> void m2344b(MetadataField<T> metadataField, T t) {
        if (C0660e.bm(metadataField.getName()) == null) {
            throw new IllegalArgumentException("Unregistered field: " + metadataField.getName());
        }
        metadataField.m2327a(t, this.Ri);
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MetadataBundle)) {
            return false;
        }
        MetadataBundle metadataBundle = (MetadataBundle) obj;
        Set<String> keySet = this.Ri.keySet();
        if (!keySet.equals(metadataBundle.Ri.keySet())) {
            return false;
        }
        for (String str : keySet) {
            if (!jv.equal(this.Ri.get(str), metadataBundle.Ri.get(str))) {
                return false;
            }
        }
        return true;
    }

    public final int hashCode() {
        int i = 1;
        for (String str : this.Ri.keySet()) {
            i *= 31;
            i = this.Ri.get(str).hashCode() + i;
        }
        return i;
    }

    public final Set<MetadataField<?>> ja() {
        Set<MetadataField<?>> hashSet = new HashSet();
        for (String bm : this.Ri.keySet()) {
            hashSet.add(C0660e.bm(bm));
        }
        return hashSet;
    }

    public final void setContext(Context context) {
        C0522a c0522a = (C0522a) m2343a(ln.RI);
        if (c0522a != null) {
            c0522a.m1873a(context.getCacheDir());
        }
    }

    public final String toString() {
        return "MetadataBundle [values=" + this.Ri + "]";
    }

    public final void writeToParcel(Parcel parcel, int i) {
        C0663h.m2372a(this, parcel, i);
    }
}

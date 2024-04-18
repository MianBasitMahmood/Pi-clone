package com.google.android.gms.drive.metadata.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.metadata.CustomPropertyKey;
import com.google.android.gms.internal.jx;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class AppVisibleCustomProperties implements SafeParcelable, Iterable<CustomProperty> {
    public static final Creator<AppVisibleCustomProperties> CREATOR;
    public static final AppVisibleCustomProperties Rd;
    final int CK;
    final List<CustomProperty> Re;

    /* renamed from: com.google.android.gms.drive.metadata.internal.AppVisibleCustomProperties.a */
    public static class C0655a {
        private final Map<CustomPropertyKey, CustomProperty> Rf;

        public C0655a() {
            this.Rf = new HashMap();
        }

        public C0655a m2340a(CustomPropertyKey customPropertyKey, String str) {
            jx.m5219b((Object) customPropertyKey, (Object) "key");
            this.Rf.put(customPropertyKey, new CustomProperty(customPropertyKey, str));
            return this;
        }

        public AppVisibleCustomProperties iW() {
            return new AppVisibleCustomProperties(null);
        }
    }

    static {
        CREATOR = new C0656a();
        Rd = new C0655a().iW();
    }

    AppVisibleCustomProperties(int i, Collection<CustomProperty> collection) {
        this.CK = i;
        jx.m5223i(collection);
        this.Re = new ArrayList(collection);
    }

    private AppVisibleCustomProperties(Collection<CustomProperty> collection) {
        this(1, (Collection) collection);
    }

    public final int describeContents() {
        return 0;
    }

    public final Map<CustomPropertyKey, String> iV() {
        Map hashMap = new HashMap(this.Re.size());
        for (CustomProperty customProperty : this.Re) {
            hashMap.put(customProperty.iX(), customProperty.getValue());
        }
        return Collections.unmodifiableMap(hashMap);
    }

    public final Iterator<CustomProperty> iterator() {
        return this.Re.iterator();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        C0656a.m2345a(this, parcel, i);
    }
}

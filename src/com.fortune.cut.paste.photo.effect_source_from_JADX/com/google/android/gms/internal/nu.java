package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public final class nu implements SafeParcelable {
    public static final nv CREATOR;
    final int CK;
    final List<oa> ahn;
    private final Set<oa> aho;
    private final String ahr;
    private final boolean ahs;
    final List<oe> aht;
    final List<String> ahu;
    private final Set<oe> ahv;
    private final Set<String> ahw;

    static {
        CREATOR = new nv();
    }

    nu(int i, List<oa> list, String str, boolean z, List<oe> list2, List<String> list3) {
        this.CK = i;
        this.ahn = list == null ? Collections.emptyList() : Collections.unmodifiableList(list);
        if (str == null) {
            str = "";
        }
        this.ahr = str;
        this.ahs = z;
        this.aht = list2 == null ? Collections.emptyList() : Collections.unmodifiableList(list2);
        this.ahu = list3 == null ? Collections.emptyList() : Collections.unmodifiableList(list3);
        this.aho = m5681g(this.ahn);
        this.ahv = m5681g(this.aht);
        this.ahw = m5681g(this.ahu);
    }

    private static <E> Set<E> m5681g(List<E> list) {
        return list.isEmpty() ? Collections.emptySet() : Collections.unmodifiableSet(new HashSet(list));
    }

    public final int describeContents() {
        nv nvVar = CREATOR;
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof nu)) {
            return false;
        }
        nu nuVar = (nu) obj;
        return this.aho.equals(nuVar.aho) && this.ahs == nuVar.ahs && this.ahv.equals(nuVar.ahv) && this.ahw.equals(nuVar.ahw);
    }

    public final int hashCode() {
        return jv.hashCode(this.aho, Boolean.valueOf(this.ahs), this.ahv, this.ahw);
    }

    @Deprecated
    public final String nu() {
        return this.ahr;
    }

    public final boolean nv() {
        return this.ahs;
    }

    public final String toString() {
        return jv.m5212h(this).m5211a("types", this.aho).m5211a("placeIds", this.ahw).m5211a("requireOpenNow", Boolean.valueOf(this.ahs)).m5211a("requestedUserDataTypes", this.ahv).toString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        nv nvVar = CREATOR;
        nv.m5682a(this, parcel, i);
    }
}

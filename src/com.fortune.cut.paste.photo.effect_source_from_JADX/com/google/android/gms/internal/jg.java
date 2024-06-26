package com.google.android.gms.internal;

import android.os.Parcel;
import android.view.View;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public final class jg {
    private final View JJ;
    private final C1244a Mw;

    /* renamed from: com.google.android.gms.internal.jg.a */
    public static final class C1244a implements SafeParcelable {
        public static final jw CREATOR;
        private final int CK;
        private final String DZ;
        private final int JI;
        private final String JK;
        private final List<String> Kh;

        static {
            CREATOR = new jw();
        }

        C1244a(int i, String str, List<String> list, int i2, String str2) {
            this.Kh = new ArrayList();
            this.CK = i;
            this.DZ = str;
            this.Kh.addAll(list);
            this.JI = i2;
            this.JK = str2;
        }

        public C1244a(String str, Collection<String> collection, int i, String str2) {
            this(3, str, new ArrayList(collection), i, str2);
        }

        public final int describeContents() {
            return 0;
        }

        public final String getAccountName() {
            return this.DZ;
        }

        public final int getVersionCode() {
            return this.CK;
        }

        public final String hm() {
            return this.DZ != null ? this.DZ : "<<default account>>";
        }

        public final int hn() {
            return this.JI;
        }

        public final List<String> ho() {
            return new ArrayList(this.Kh);
        }

        public final String hq() {
            return this.JK;
        }

        public final void writeToParcel(Parcel parcel, int i) {
            jw.m5213a(this, parcel, i);
        }
    }

    public jg(String str, Collection<String> collection, int i, View view, String str2) {
        this.Mw = new C1244a(str, collection, i, str2);
        this.JJ = view;
    }

    public final String getAccountName() {
        return this.Mw.getAccountName();
    }

    public final String hm() {
        return this.Mw.hm();
    }

    public final int hn() {
        return this.Mw.hn();
    }

    public final List<String> ho() {
        return this.Mw.ho();
    }

    public final String[] hp() {
        return (String[]) this.Mw.ho().toArray(new String[0]);
    }

    public final String hq() {
        return this.Mw.hq();
    }

    public final View hr() {
        return this.JJ;
    }
}

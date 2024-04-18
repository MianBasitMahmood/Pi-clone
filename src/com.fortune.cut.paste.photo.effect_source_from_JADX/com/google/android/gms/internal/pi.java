package com.google.android.gms.internal;

import android.os.Parcel;
import android.support.v4.util.TimeUtils;
import com.google.android.gms.C0366R;
import com.google.android.gms.common.Scopes;
import com.google.android.gms.common.api.CommonStatusCodes;
import com.google.android.gms.fitness.FitnessActivities;
import com.google.android.gms.games.GamesStatusCodes;
import com.google.android.gms.games.Notifications;
import com.google.android.gms.internal.kr.C1277a;
import com.google.android.gms.plus.PlusShare;
import com.google.android.gms.plus.model.people.Person;
import com.google.android.gms.plus.model.people.Person.AgeRange;
import com.google.android.gms.plus.model.people.Person.Cover;
import com.google.android.gms.plus.model.people.Person.Cover.CoverInfo;
import com.google.android.gms.plus.model.people.Person.Cover.CoverPhoto;
import com.google.android.gms.plus.model.people.Person.Image;
import com.google.android.gms.plus.model.people.Person.Name;
import com.google.android.gms.plus.model.people.Person.Organizations;
import com.google.android.gms.plus.model.people.Person.PlacesLived;
import com.google.android.gms.plus.model.people.Person.Urls;
import com.google.android.gms.wallet.NotifyTransactionStatusRequest.Status.Error;
import com.google.android.gms.wallet.fragment.Dimension;
import com.google.android.gms.wallet.fragment.WalletFragmentState;
import com.google.android.gms.wearable.DataEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public final class pi extends ks implements Person {
    public static final pj CREATOR;
    private static final HashMap<String, C1277a<?, ?>> aom;
    String CE;
    final int CK;
    String FR;
    String OS;
    final Set<Integer> aon;
    int apA;
    String apB;
    List<C1445h> apC;
    boolean apD;
    String apl;
    C1436a apm;
    String apn;
    String apo;
    int app;
    C1439b apq;
    String apr;
    C1440c aps;
    boolean apt;
    C1441d apu;
    String apv;
    int apw;
    List<C1443f> apx;
    List<C1444g> apy;
    int apz;
    int ow;
    String vf;

    /* renamed from: com.google.android.gms.internal.pi.a */
    public static final class C1436a extends ks implements AgeRange {
        public static final pk CREATOR;
        private static final HashMap<String, C1277a<?, ?>> aom;
        final int CK;
        final Set<Integer> aon;
        int apE;
        int apF;

        static {
            CREATOR = new pk();
            HashMap hashMap = new HashMap();
            aom = hashMap;
            hashMap.put("max", C1277a.m5273i("max", 2));
            aom.put("min", C1277a.m5273i("min", 3));
        }

        public C1436a() {
            this.CK = 1;
            this.aon = new HashSet();
        }

        C1436a(Set<Integer> set, int i, int i2, int i3) {
            this.aon = set;
            this.CK = i;
            this.apE = i2;
            this.apF = i3;
        }

        protected final boolean m5778a(C1277a c1277a) {
            return this.aon.contains(Integer.valueOf(c1277a.hR()));
        }

        protected final Object m5779b(C1277a c1277a) {
            switch (c1277a.hR()) {
                case DataEvent.TYPE_DELETED /*2*/:
                    return Integer.valueOf(this.apE);
                case WalletFragmentState.PROCESSING /*3*/:
                    return Integer.valueOf(this.apF);
                default:
                    throw new IllegalStateException("Unknown safe parcelable id=" + c1277a.hR());
            }
        }

        public final int describeContents() {
            pk pkVar = CREATOR;
            return 0;
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof C1436a)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            C1436a c1436a = (C1436a) obj;
            for (C1277a c1277a : aom.values()) {
                if (m5778a(c1277a)) {
                    if (!c1436a.m5778a(c1277a)) {
                        return false;
                    }
                    if (!m5779b(c1277a).equals(c1436a.m5779b(c1277a))) {
                        return false;
                    }
                } else if (c1436a.m5778a(c1277a)) {
                    return false;
                }
            }
            return true;
        }

        public final /* synthetic */ Object freeze() {
            return oM();
        }

        public final int getMax() {
            return this.apE;
        }

        public final int getMin() {
            return this.apF;
        }

        public final HashMap<String, C1277a<?, ?>> hK() {
            return aom;
        }

        public final boolean hasMax() {
            return this.aon.contains(Integer.valueOf(2));
        }

        public final boolean hasMin() {
            return this.aon.contains(Integer.valueOf(3));
        }

        public final int hashCode() {
            int i = 0;
            for (C1277a c1277a : aom.values()) {
                int hashCode;
                if (m5778a(c1277a)) {
                    hashCode = m5779b(c1277a).hashCode() + (i + c1277a.hR());
                } else {
                    hashCode = i;
                }
                i = hashCode;
            }
            return i;
        }

        public final boolean isDataValid() {
            return true;
        }

        public final C1436a oM() {
            return this;
        }

        public final void writeToParcel(Parcel parcel, int i) {
            pk pkVar = CREATOR;
            pk.m5800a(this, parcel, i);
        }
    }

    /* renamed from: com.google.android.gms.internal.pi.b */
    public static final class C1439b extends ks implements Cover {
        public static final pl CREATOR;
        private static final HashMap<String, C1277a<?, ?>> aom;
        final int CK;
        final Set<Integer> aon;
        C1437a apG;
        C1438b apH;
        int apI;

        /* renamed from: com.google.android.gms.internal.pi.b.a */
        public static final class C1437a extends ks implements CoverInfo {
            public static final pm CREATOR;
            private static final HashMap<String, C1277a<?, ?>> aom;
            final int CK;
            final Set<Integer> aon;
            int apJ;
            int apK;

            static {
                CREATOR = new pm();
                HashMap hashMap = new HashMap();
                aom = hashMap;
                hashMap.put("leftImageOffset", C1277a.m5273i("leftImageOffset", 2));
                aom.put("topImageOffset", C1277a.m5273i("topImageOffset", 3));
            }

            public C1437a() {
                this.CK = 1;
                this.aon = new HashSet();
            }

            C1437a(Set<Integer> set, int i, int i2, int i3) {
                this.aon = set;
                this.CK = i;
                this.apJ = i2;
                this.apK = i3;
            }

            protected final boolean m5780a(C1277a c1277a) {
                return this.aon.contains(Integer.valueOf(c1277a.hR()));
            }

            protected final Object m5781b(C1277a c1277a) {
                switch (c1277a.hR()) {
                    case DataEvent.TYPE_DELETED /*2*/:
                        return Integer.valueOf(this.apJ);
                    case WalletFragmentState.PROCESSING /*3*/:
                        return Integer.valueOf(this.apK);
                    default:
                        throw new IllegalStateException("Unknown safe parcelable id=" + c1277a.hR());
                }
            }

            public final int describeContents() {
                pm pmVar = CREATOR;
                return 0;
            }

            public final boolean equals(Object obj) {
                if (!(obj instanceof C1437a)) {
                    return false;
                }
                if (this == obj) {
                    return true;
                }
                C1437a c1437a = (C1437a) obj;
                for (C1277a c1277a : aom.values()) {
                    if (m5780a(c1277a)) {
                        if (!c1437a.m5780a(c1277a)) {
                            return false;
                        }
                        if (!m5781b(c1277a).equals(c1437a.m5781b(c1277a))) {
                            return false;
                        }
                    } else if (c1437a.m5780a(c1277a)) {
                        return false;
                    }
                }
                return true;
            }

            public final /* synthetic */ Object freeze() {
                return oO();
            }

            public final int getLeftImageOffset() {
                return this.apJ;
            }

            public final int getTopImageOffset() {
                return this.apK;
            }

            public final HashMap<String, C1277a<?, ?>> hK() {
                return aom;
            }

            public final boolean hasLeftImageOffset() {
                return this.aon.contains(Integer.valueOf(2));
            }

            public final boolean hasTopImageOffset() {
                return this.aon.contains(Integer.valueOf(3));
            }

            public final int hashCode() {
                int i = 0;
                for (C1277a c1277a : aom.values()) {
                    int hashCode;
                    if (m5780a(c1277a)) {
                        hashCode = m5781b(c1277a).hashCode() + (i + c1277a.hR());
                    } else {
                        hashCode = i;
                    }
                    i = hashCode;
                }
                return i;
            }

            public final boolean isDataValid() {
                return true;
            }

            public final C1437a oO() {
                return this;
            }

            public final void writeToParcel(Parcel parcel, int i) {
                pm pmVar = CREATOR;
                pm.m5802a(this, parcel, i);
            }
        }

        /* renamed from: com.google.android.gms.internal.pi.b.b */
        public static final class C1438b extends ks implements CoverPhoto {
            public static final pn CREATOR;
            private static final HashMap<String, C1277a<?, ?>> aom;
            final int CK;
            final Set<Integer> aon;
            int li;
            int lj;
            String vf;

            static {
                CREATOR = new pn();
                HashMap hashMap = new HashMap();
                aom = hashMap;
                hashMap.put("height", C1277a.m5273i("height", 2));
                aom.put(PlusShare.KEY_CALL_TO_ACTION_URL, C1277a.m5276l(PlusShare.KEY_CALL_TO_ACTION_URL, 3));
                aom.put("width", C1277a.m5273i("width", 4));
            }

            public C1438b() {
                this.CK = 1;
                this.aon = new HashSet();
            }

            C1438b(Set<Integer> set, int i, int i2, String str, int i3) {
                this.aon = set;
                this.CK = i;
                this.lj = i2;
                this.vf = str;
                this.li = i3;
            }

            protected final boolean m5782a(C1277a c1277a) {
                return this.aon.contains(Integer.valueOf(c1277a.hR()));
            }

            protected final Object m5783b(C1277a c1277a) {
                switch (c1277a.hR()) {
                    case DataEvent.TYPE_DELETED /*2*/:
                        return Integer.valueOf(this.lj);
                    case WalletFragmentState.PROCESSING /*3*/:
                        return this.vf;
                    case WalletFragmentState.WALLET_UNAVAILABLE /*4*/:
                        return Integer.valueOf(this.li);
                    default:
                        throw new IllegalStateException("Unknown safe parcelable id=" + c1277a.hR());
                }
            }

            public final int describeContents() {
                pn pnVar = CREATOR;
                return 0;
            }

            public final boolean equals(Object obj) {
                if (!(obj instanceof C1438b)) {
                    return false;
                }
                if (this == obj) {
                    return true;
                }
                C1438b c1438b = (C1438b) obj;
                for (C1277a c1277a : aom.values()) {
                    if (m5782a(c1277a)) {
                        if (!c1438b.m5782a(c1277a)) {
                            return false;
                        }
                        if (!m5783b(c1277a).equals(c1438b.m5783b(c1277a))) {
                            return false;
                        }
                    } else if (c1438b.m5782a(c1277a)) {
                        return false;
                    }
                }
                return true;
            }

            public final /* synthetic */ Object freeze() {
                return oP();
            }

            public final int getHeight() {
                return this.lj;
            }

            public final String getUrl() {
                return this.vf;
            }

            public final int getWidth() {
                return this.li;
            }

            public final HashMap<String, C1277a<?, ?>> hK() {
                return aom;
            }

            public final boolean hasHeight() {
                return this.aon.contains(Integer.valueOf(2));
            }

            public final boolean hasUrl() {
                return this.aon.contains(Integer.valueOf(3));
            }

            public final boolean hasWidth() {
                return this.aon.contains(Integer.valueOf(4));
            }

            public final int hashCode() {
                int i = 0;
                for (C1277a c1277a : aom.values()) {
                    int hashCode;
                    if (m5782a(c1277a)) {
                        hashCode = m5783b(c1277a).hashCode() + (i + c1277a.hR());
                    } else {
                        hashCode = i;
                    }
                    i = hashCode;
                }
                return i;
            }

            public final boolean isDataValid() {
                return true;
            }

            public final C1438b oP() {
                return this;
            }

            public final void writeToParcel(Parcel parcel, int i) {
                pn pnVar = CREATOR;
                pn.m5803a(this, parcel, i);
            }
        }

        static {
            CREATOR = new pl();
            HashMap hashMap = new HashMap();
            aom = hashMap;
            hashMap.put("coverInfo", C1277a.m5270a("coverInfo", 2, C1437a.class));
            aom.put("coverPhoto", C1277a.m5270a("coverPhoto", 3, C1438b.class));
            aom.put("layout", C1277a.m5269a("layout", 4, new ko().m5264h("banner", 0), false));
        }

        public C1439b() {
            this.CK = 1;
            this.aon = new HashSet();
        }

        C1439b(Set<Integer> set, int i, C1437a c1437a, C1438b c1438b, int i2) {
            this.aon = set;
            this.CK = i;
            this.apG = c1437a;
            this.apH = c1438b;
            this.apI = i2;
        }

        protected final boolean m5784a(C1277a c1277a) {
            return this.aon.contains(Integer.valueOf(c1277a.hR()));
        }

        protected final Object m5785b(C1277a c1277a) {
            switch (c1277a.hR()) {
                case DataEvent.TYPE_DELETED /*2*/:
                    return this.apG;
                case WalletFragmentState.PROCESSING /*3*/:
                    return this.apH;
                case WalletFragmentState.WALLET_UNAVAILABLE /*4*/:
                    return Integer.valueOf(this.apI);
                default:
                    throw new IllegalStateException("Unknown safe parcelable id=" + c1277a.hR());
            }
        }

        public final int describeContents() {
            pl plVar = CREATOR;
            return 0;
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof C1439b)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            C1439b c1439b = (C1439b) obj;
            for (C1277a c1277a : aom.values()) {
                if (m5784a(c1277a)) {
                    if (!c1439b.m5784a(c1277a)) {
                        return false;
                    }
                    if (!m5785b(c1277a).equals(c1439b.m5785b(c1277a))) {
                        return false;
                    }
                } else if (c1439b.m5784a(c1277a)) {
                    return false;
                }
            }
            return true;
        }

        public final /* synthetic */ Object freeze() {
            return oN();
        }

        public final CoverInfo getCoverInfo() {
            return this.apG;
        }

        public final CoverPhoto getCoverPhoto() {
            return this.apH;
        }

        public final int getLayout() {
            return this.apI;
        }

        public final HashMap<String, C1277a<?, ?>> hK() {
            return aom;
        }

        public final boolean hasCoverInfo() {
            return this.aon.contains(Integer.valueOf(2));
        }

        public final boolean hasCoverPhoto() {
            return this.aon.contains(Integer.valueOf(3));
        }

        public final boolean hasLayout() {
            return this.aon.contains(Integer.valueOf(4));
        }

        public final int hashCode() {
            int i = 0;
            for (C1277a c1277a : aom.values()) {
                int hashCode;
                if (m5784a(c1277a)) {
                    hashCode = m5785b(c1277a).hashCode() + (i + c1277a.hR());
                } else {
                    hashCode = i;
                }
                i = hashCode;
            }
            return i;
        }

        public final boolean isDataValid() {
            return true;
        }

        public final C1439b oN() {
            return this;
        }

        public final void writeToParcel(Parcel parcel, int i) {
            pl plVar = CREATOR;
            pl.m5801a(this, parcel, i);
        }
    }

    /* renamed from: com.google.android.gms.internal.pi.c */
    public static final class C1440c extends ks implements Image {
        public static final po CREATOR;
        private static final HashMap<String, C1277a<?, ?>> aom;
        final int CK;
        final Set<Integer> aon;
        String vf;

        static {
            CREATOR = new po();
            HashMap hashMap = new HashMap();
            aom = hashMap;
            hashMap.put(PlusShare.KEY_CALL_TO_ACTION_URL, C1277a.m5276l(PlusShare.KEY_CALL_TO_ACTION_URL, 2));
        }

        public C1440c() {
            this.CK = 1;
            this.aon = new HashSet();
        }

        public C1440c(String str) {
            this.aon = new HashSet();
            this.CK = 1;
            this.vf = str;
            this.aon.add(Integer.valueOf(2));
        }

        C1440c(Set<Integer> set, int i, String str) {
            this.aon = set;
            this.CK = i;
            this.vf = str;
        }

        protected final boolean m5786a(C1277a c1277a) {
            return this.aon.contains(Integer.valueOf(c1277a.hR()));
        }

        protected final Object m5787b(C1277a c1277a) {
            switch (c1277a.hR()) {
                case DataEvent.TYPE_DELETED /*2*/:
                    return this.vf;
                default:
                    throw new IllegalStateException("Unknown safe parcelable id=" + c1277a.hR());
            }
        }

        public final int describeContents() {
            po poVar = CREATOR;
            return 0;
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof C1440c)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            C1440c c1440c = (C1440c) obj;
            for (C1277a c1277a : aom.values()) {
                if (m5786a(c1277a)) {
                    if (!c1440c.m5786a(c1277a)) {
                        return false;
                    }
                    if (!m5787b(c1277a).equals(c1440c.m5787b(c1277a))) {
                        return false;
                    }
                } else if (c1440c.m5786a(c1277a)) {
                    return false;
                }
            }
            return true;
        }

        public final /* synthetic */ Object freeze() {
            return oQ();
        }

        public final String getUrl() {
            return this.vf;
        }

        public final HashMap<String, C1277a<?, ?>> hK() {
            return aom;
        }

        public final boolean hasUrl() {
            return this.aon.contains(Integer.valueOf(2));
        }

        public final int hashCode() {
            int i = 0;
            for (C1277a c1277a : aom.values()) {
                int hashCode;
                if (m5786a(c1277a)) {
                    hashCode = m5787b(c1277a).hashCode() + (i + c1277a.hR());
                } else {
                    hashCode = i;
                }
                i = hashCode;
            }
            return i;
        }

        public final boolean isDataValid() {
            return true;
        }

        public final C1440c oQ() {
            return this;
        }

        public final void writeToParcel(Parcel parcel, int i) {
            po poVar = CREATOR;
            po.m5804a(this, parcel, i);
        }
    }

    /* renamed from: com.google.android.gms.internal.pi.d */
    public static final class C1441d extends ks implements Name {
        public static final pp CREATOR;
        private static final HashMap<String, C1277a<?, ?>> aom;
        final int CK;
        String aoL;
        String aoO;
        final Set<Integer> aon;
        String apL;
        String apM;
        String apN;
        String apO;

        static {
            CREATOR = new pp();
            HashMap hashMap = new HashMap();
            aom = hashMap;
            hashMap.put("familyName", C1277a.m5276l("familyName", 2));
            aom.put("formatted", C1277a.m5276l("formatted", 3));
            aom.put("givenName", C1277a.m5276l("givenName", 4));
            aom.put("honorificPrefix", C1277a.m5276l("honorificPrefix", 5));
            aom.put("honorificSuffix", C1277a.m5276l("honorificSuffix", 6));
            aom.put("middleName", C1277a.m5276l("middleName", 7));
        }

        public C1441d() {
            this.CK = 1;
            this.aon = new HashSet();
        }

        C1441d(Set<Integer> set, int i, String str, String str2, String str3, String str4, String str5, String str6) {
            this.aon = set;
            this.CK = i;
            this.aoL = str;
            this.apL = str2;
            this.aoO = str3;
            this.apM = str4;
            this.apN = str5;
            this.apO = str6;
        }

        protected final boolean m5788a(C1277a c1277a) {
            return this.aon.contains(Integer.valueOf(c1277a.hR()));
        }

        protected final Object m5789b(C1277a c1277a) {
            switch (c1277a.hR()) {
                case DataEvent.TYPE_DELETED /*2*/:
                    return this.aoL;
                case WalletFragmentState.PROCESSING /*3*/:
                    return this.apL;
                case WalletFragmentState.WALLET_UNAVAILABLE /*4*/:
                    return this.aoO;
                case Dimension.UNIT_MM /*5*/:
                    return this.apM;
                case Error.OTHER /*6*/:
                    return this.apN;
                case Error.AVS_DECLINE /*7*/:
                    return this.apO;
                default:
                    throw new IllegalStateException("Unknown safe parcelable id=" + c1277a.hR());
            }
        }

        public final int describeContents() {
            pp ppVar = CREATOR;
            return 0;
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof C1441d)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            C1441d c1441d = (C1441d) obj;
            for (C1277a c1277a : aom.values()) {
                if (m5788a(c1277a)) {
                    if (!c1441d.m5788a(c1277a)) {
                        return false;
                    }
                    if (!m5789b(c1277a).equals(c1441d.m5789b(c1277a))) {
                        return false;
                    }
                } else if (c1441d.m5788a(c1277a)) {
                    return false;
                }
            }
            return true;
        }

        public final /* synthetic */ Object freeze() {
            return oR();
        }

        public final String getFamilyName() {
            return this.aoL;
        }

        public final String getFormatted() {
            return this.apL;
        }

        public final String getGivenName() {
            return this.aoO;
        }

        public final String getHonorificPrefix() {
            return this.apM;
        }

        public final String getHonorificSuffix() {
            return this.apN;
        }

        public final String getMiddleName() {
            return this.apO;
        }

        public final HashMap<String, C1277a<?, ?>> hK() {
            return aom;
        }

        public final boolean hasFamilyName() {
            return this.aon.contains(Integer.valueOf(2));
        }

        public final boolean hasFormatted() {
            return this.aon.contains(Integer.valueOf(3));
        }

        public final boolean hasGivenName() {
            return this.aon.contains(Integer.valueOf(4));
        }

        public final boolean hasHonorificPrefix() {
            return this.aon.contains(Integer.valueOf(5));
        }

        public final boolean hasHonorificSuffix() {
            return this.aon.contains(Integer.valueOf(6));
        }

        public final boolean hasMiddleName() {
            return this.aon.contains(Integer.valueOf(7));
        }

        public final int hashCode() {
            int i = 0;
            for (C1277a c1277a : aom.values()) {
                int hashCode;
                if (m5788a(c1277a)) {
                    hashCode = m5789b(c1277a).hashCode() + (i + c1277a.hR());
                } else {
                    hashCode = i;
                }
                i = hashCode;
            }
            return i;
        }

        public final boolean isDataValid() {
            return true;
        }

        public final C1441d oR() {
            return this;
        }

        public final void writeToParcel(Parcel parcel, int i) {
            pp ppVar = CREATOR;
            pp.m5805a(this, parcel, i);
        }
    }

    /* renamed from: com.google.android.gms.internal.pi.e */
    public static class C1442e {
        public static int ck(String str) {
            if (str.equals("person")) {
                return 0;
            }
            if (str.equals("page")) {
                return 1;
            }
            throw new IllegalArgumentException("Unknown objectType string: " + str);
        }
    }

    /* renamed from: com.google.android.gms.internal.pi.f */
    public static final class C1443f extends ks implements Organizations {
        public static final pq CREATOR;
        private static final HashMap<String, C1277a<?, ?>> aom;
        final int CK;
        int Gt;
        String OH;
        String UO;
        String aoK;
        final Set<Integer> aon;
        String apP;
        String apQ;
        boolean apR;
        String apa;
        String mName;

        static {
            CREATOR = new pq();
            HashMap hashMap = new HashMap();
            aom = hashMap;
            hashMap.put("department", C1277a.m5276l("department", 2));
            aom.put(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_DESCRIPTION, C1277a.m5276l(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_DESCRIPTION, 3));
            aom.put("endDate", C1277a.m5276l("endDate", 4));
            aom.put("location", C1277a.m5276l("location", 5));
            aom.put("name", C1277a.m5276l("name", 6));
            aom.put("primary", C1277a.m5275k("primary", 7));
            aom.put("startDate", C1277a.m5276l("startDate", 8));
            aom.put(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_TITLE, C1277a.m5276l(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_TITLE, 9));
            aom.put("type", C1277a.m5269a("type", 10, new ko().m5264h("work", 0).m5264h("school", 1), false));
        }

        public C1443f() {
            this.CK = 1;
            this.aon = new HashSet();
        }

        C1443f(Set<Integer> set, int i, String str, String str2, String str3, String str4, String str5, boolean z, String str6, String str7, int i2) {
            this.aon = set;
            this.CK = i;
            this.apP = str;
            this.UO = str2;
            this.aoK = str3;
            this.apQ = str4;
            this.mName = str5;
            this.apR = z;
            this.apa = str6;
            this.OH = str7;
            this.Gt = i2;
        }

        protected final boolean m5790a(C1277a c1277a) {
            return this.aon.contains(Integer.valueOf(c1277a.hR()));
        }

        protected final Object m5791b(C1277a c1277a) {
            switch (c1277a.hR()) {
                case DataEvent.TYPE_DELETED /*2*/:
                    return this.apP;
                case WalletFragmentState.PROCESSING /*3*/:
                    return this.UO;
                case WalletFragmentState.WALLET_UNAVAILABLE /*4*/:
                    return this.aoK;
                case Dimension.UNIT_MM /*5*/:
                    return this.apQ;
                case Error.OTHER /*6*/:
                    return this.mName;
                case Error.AVS_DECLINE /*7*/:
                    return Boolean.valueOf(this.apR);
                case Error.FRAUD_DECLINE /*8*/:
                    return this.apa;
                case GamesStatusCodes.STATUS_GAME_NOT_FOUND /*9*/:
                    return this.OH;
                case CommonStatusCodes.DEVELOPER_ERROR /*10*/:
                    return Integer.valueOf(this.Gt);
                default:
                    throw new IllegalStateException("Unknown safe parcelable id=" + c1277a.hR());
            }
        }

        public final int describeContents() {
            pq pqVar = CREATOR;
            return 0;
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof C1443f)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            C1443f c1443f = (C1443f) obj;
            for (C1277a c1277a : aom.values()) {
                if (m5790a(c1277a)) {
                    if (!c1443f.m5790a(c1277a)) {
                        return false;
                    }
                    if (!m5791b(c1277a).equals(c1443f.m5791b(c1277a))) {
                        return false;
                    }
                } else if (c1443f.m5790a(c1277a)) {
                    return false;
                }
            }
            return true;
        }

        public final /* synthetic */ Object freeze() {
            return oS();
        }

        public final String getDepartment() {
            return this.apP;
        }

        public final String getDescription() {
            return this.UO;
        }

        public final String getEndDate() {
            return this.aoK;
        }

        public final String getLocation() {
            return this.apQ;
        }

        public final String getName() {
            return this.mName;
        }

        public final String getStartDate() {
            return this.apa;
        }

        public final String getTitle() {
            return this.OH;
        }

        public final int getType() {
            return this.Gt;
        }

        public final HashMap<String, C1277a<?, ?>> hK() {
            return aom;
        }

        public final boolean hasDepartment() {
            return this.aon.contains(Integer.valueOf(2));
        }

        public final boolean hasDescription() {
            return this.aon.contains(Integer.valueOf(3));
        }

        public final boolean hasEndDate() {
            return this.aon.contains(Integer.valueOf(4));
        }

        public final boolean hasLocation() {
            return this.aon.contains(Integer.valueOf(5));
        }

        public final boolean hasName() {
            return this.aon.contains(Integer.valueOf(6));
        }

        public final boolean hasPrimary() {
            return this.aon.contains(Integer.valueOf(7));
        }

        public final boolean hasStartDate() {
            return this.aon.contains(Integer.valueOf(8));
        }

        public final boolean hasTitle() {
            return this.aon.contains(Integer.valueOf(9));
        }

        public final boolean hasType() {
            return this.aon.contains(Integer.valueOf(10));
        }

        public final int hashCode() {
            int i = 0;
            for (C1277a c1277a : aom.values()) {
                int hashCode;
                if (m5790a(c1277a)) {
                    hashCode = m5791b(c1277a).hashCode() + (i + c1277a.hR());
                } else {
                    hashCode = i;
                }
                i = hashCode;
            }
            return i;
        }

        public final boolean isDataValid() {
            return true;
        }

        public final boolean isPrimary() {
            return this.apR;
        }

        public final C1443f oS() {
            return this;
        }

        public final void writeToParcel(Parcel parcel, int i) {
            pq pqVar = CREATOR;
            pq.m5806a(this, parcel, i);
        }
    }

    /* renamed from: com.google.android.gms.internal.pi.g */
    public static final class C1444g extends ks implements PlacesLived {
        public static final pr CREATOR;
        private static final HashMap<String, C1277a<?, ?>> aom;
        final int CK;
        final Set<Integer> aon;
        boolean apR;
        String mValue;

        static {
            CREATOR = new pr();
            HashMap hashMap = new HashMap();
            aom = hashMap;
            hashMap.put("primary", C1277a.m5275k("primary", 2));
            aom.put("value", C1277a.m5276l("value", 3));
        }

        public C1444g() {
            this.CK = 1;
            this.aon = new HashSet();
        }

        C1444g(Set<Integer> set, int i, boolean z, String str) {
            this.aon = set;
            this.CK = i;
            this.apR = z;
            this.mValue = str;
        }

        protected final boolean m5792a(C1277a c1277a) {
            return this.aon.contains(Integer.valueOf(c1277a.hR()));
        }

        protected final Object m5793b(C1277a c1277a) {
            switch (c1277a.hR()) {
                case DataEvent.TYPE_DELETED /*2*/:
                    return Boolean.valueOf(this.apR);
                case WalletFragmentState.PROCESSING /*3*/:
                    return this.mValue;
                default:
                    throw new IllegalStateException("Unknown safe parcelable id=" + c1277a.hR());
            }
        }

        public final int describeContents() {
            pr prVar = CREATOR;
            return 0;
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof C1444g)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            C1444g c1444g = (C1444g) obj;
            for (C1277a c1277a : aom.values()) {
                if (m5792a(c1277a)) {
                    if (!c1444g.m5792a(c1277a)) {
                        return false;
                    }
                    if (!m5793b(c1277a).equals(c1444g.m5793b(c1277a))) {
                        return false;
                    }
                } else if (c1444g.m5792a(c1277a)) {
                    return false;
                }
            }
            return true;
        }

        public final /* synthetic */ Object freeze() {
            return oT();
        }

        public final String getValue() {
            return this.mValue;
        }

        public final HashMap<String, C1277a<?, ?>> hK() {
            return aom;
        }

        public final boolean hasPrimary() {
            return this.aon.contains(Integer.valueOf(2));
        }

        public final boolean hasValue() {
            return this.aon.contains(Integer.valueOf(3));
        }

        public final int hashCode() {
            int i = 0;
            for (C1277a c1277a : aom.values()) {
                int hashCode;
                if (m5792a(c1277a)) {
                    hashCode = m5793b(c1277a).hashCode() + (i + c1277a.hR());
                } else {
                    hashCode = i;
                }
                i = hashCode;
            }
            return i;
        }

        public final boolean isDataValid() {
            return true;
        }

        public final boolean isPrimary() {
            return this.apR;
        }

        public final C1444g oT() {
            return this;
        }

        public final void writeToParcel(Parcel parcel, int i) {
            pr prVar = CREATOR;
            pr.m5807a(this, parcel, i);
        }
    }

    /* renamed from: com.google.android.gms.internal.pi.h */
    public static final class C1445h extends ks implements Urls {
        public static final ps CREATOR;
        private static final HashMap<String, C1277a<?, ?>> aom;
        final int CK;
        int Gt;
        String XL;
        final Set<Integer> aon;
        private final int apS;
        String mValue;

        static {
            CREATOR = new ps();
            HashMap hashMap = new HashMap();
            aom = hashMap;
            hashMap.put(PlusShare.KEY_CALL_TO_ACTION_LABEL, C1277a.m5276l(PlusShare.KEY_CALL_TO_ACTION_LABEL, 5));
            aom.put("type", C1277a.m5269a("type", 6, new ko().m5264h("home", 0).m5264h("work", 1).m5264h("blog", 2).m5264h(Scopes.PROFILE, 3).m5264h(FitnessActivities.OTHER, 4).m5264h("otherProfile", 5).m5264h("contributor", 6).m5264h("website", 7), false));
            aom.put("value", C1277a.m5276l("value", 4));
        }

        public C1445h() {
            this.apS = 4;
            this.CK = 1;
            this.aon = new HashSet();
        }

        C1445h(Set<Integer> set, int i, String str, int i2, String str2, int i3) {
            this.apS = 4;
            this.aon = set;
            this.CK = i;
            this.XL = str;
            this.Gt = i2;
            this.mValue = str2;
        }

        protected final boolean m5794a(C1277a c1277a) {
            return this.aon.contains(Integer.valueOf(c1277a.hR()));
        }

        protected final Object m5795b(C1277a c1277a) {
            switch (c1277a.hR()) {
                case WalletFragmentState.WALLET_UNAVAILABLE /*4*/:
                    return this.mValue;
                case Dimension.UNIT_MM /*5*/:
                    return this.XL;
                case Error.OTHER /*6*/:
                    return Integer.valueOf(this.Gt);
                default:
                    throw new IllegalStateException("Unknown safe parcelable id=" + c1277a.hR());
            }
        }

        public final int describeContents() {
            ps psVar = CREATOR;
            return 0;
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof C1445h)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            C1445h c1445h = (C1445h) obj;
            for (C1277a c1277a : aom.values()) {
                if (m5794a(c1277a)) {
                    if (!c1445h.m5794a(c1277a)) {
                        return false;
                    }
                    if (!m5795b(c1277a).equals(c1445h.m5795b(c1277a))) {
                        return false;
                    }
                } else if (c1445h.m5794a(c1277a)) {
                    return false;
                }
            }
            return true;
        }

        public final /* synthetic */ Object freeze() {
            return oV();
        }

        public final String getLabel() {
            return this.XL;
        }

        public final int getType() {
            return this.Gt;
        }

        public final String getValue() {
            return this.mValue;
        }

        public final HashMap<String, C1277a<?, ?>> hK() {
            return aom;
        }

        public final boolean hasLabel() {
            return this.aon.contains(Integer.valueOf(5));
        }

        public final boolean hasType() {
            return this.aon.contains(Integer.valueOf(6));
        }

        public final boolean hasValue() {
            return this.aon.contains(Integer.valueOf(4));
        }

        public final int hashCode() {
            int i = 0;
            for (C1277a c1277a : aom.values()) {
                int hashCode;
                if (m5794a(c1277a)) {
                    hashCode = m5795b(c1277a).hashCode() + (i + c1277a.hR());
                } else {
                    hashCode = i;
                }
                i = hashCode;
            }
            return i;
        }

        public final boolean isDataValid() {
            return true;
        }

        @Deprecated
        public final int oU() {
            return 4;
        }

        public final C1445h oV() {
            return this;
        }

        public final void writeToParcel(Parcel parcel, int i) {
            ps psVar = CREATOR;
            ps.m5808a(this, parcel, i);
        }
    }

    static {
        CREATOR = new pj();
        HashMap hashMap = new HashMap();
        aom = hashMap;
        hashMap.put("aboutMe", C1277a.m5276l("aboutMe", 2));
        aom.put("ageRange", C1277a.m5270a("ageRange", 3, C1436a.class));
        aom.put("birthday", C1277a.m5276l("birthday", 4));
        aom.put("braggingRights", C1277a.m5276l("braggingRights", 5));
        aom.put("circledByCount", C1277a.m5273i("circledByCount", 6));
        aom.put("cover", C1277a.m5270a("cover", 7, C1439b.class));
        aom.put("currentLocation", C1277a.m5276l("currentLocation", 8));
        aom.put("displayName", C1277a.m5276l("displayName", 9));
        aom.put("gender", C1277a.m5269a("gender", 12, new ko().m5264h("male", 0).m5264h("female", 1).m5264h(FitnessActivities.OTHER, 2), false));
        aom.put("id", C1277a.m5276l("id", 14));
        aom.put("image", C1277a.m5270a("image", 15, C1440c.class));
        aom.put("isPlusUser", C1277a.m5275k("isPlusUser", 16));
        aom.put("language", C1277a.m5276l("language", 18));
        aom.put("name", C1277a.m5270a("name", 19, C1441d.class));
        aom.put("nickname", C1277a.m5276l("nickname", 20));
        aom.put("objectType", C1277a.m5269a("objectType", 21, new ko().m5264h("person", 0).m5264h("page", 1), false));
        aom.put("organizations", C1277a.m5271b("organizations", 22, C1443f.class));
        aom.put("placesLived", C1277a.m5271b("placesLived", 23, C1444g.class));
        aom.put("plusOneCount", C1277a.m5273i("plusOneCount", 24));
        aom.put("relationshipStatus", C1277a.m5269a("relationshipStatus", 25, new ko().m5264h("single", 0).m5264h("in_a_relationship", 1).m5264h("engaged", 2).m5264h("married", 3).m5264h("its_complicated", 4).m5264h("open_relationship", 5).m5264h("widowed", 6).m5264h("in_domestic_partnership", 7).m5264h("in_civil_union", 8), false));
        aom.put("tagline", C1277a.m5276l("tagline", 26));
        aom.put(PlusShare.KEY_CALL_TO_ACTION_URL, C1277a.m5276l(PlusShare.KEY_CALL_TO_ACTION_URL, 27));
        aom.put("urls", C1277a.m5271b("urls", 28, C1445h.class));
        aom.put("verified", C1277a.m5275k("verified", 29));
    }

    public pi() {
        this.CK = 1;
        this.aon = new HashSet();
    }

    public pi(String str, String str2, C1440c c1440c, int i, String str3) {
        this.CK = 1;
        this.aon = new HashSet();
        this.OS = str;
        this.aon.add(Integer.valueOf(9));
        this.CE = str2;
        this.aon.add(Integer.valueOf(14));
        this.aps = c1440c;
        this.aon.add(Integer.valueOf(15));
        this.apw = i;
        this.aon.add(Integer.valueOf(21));
        this.vf = str3;
        this.aon.add(Integer.valueOf(27));
    }

    pi(Set<Integer> set, int i, String str, C1436a c1436a, String str2, String str3, int i2, C1439b c1439b, String str4, String str5, int i3, String str6, C1440c c1440c, boolean z, String str7, C1441d c1441d, String str8, int i4, List<C1443f> list, List<C1444g> list2, int i5, int i6, String str9, String str10, List<C1445h> list3, boolean z2) {
        this.aon = set;
        this.CK = i;
        this.apl = str;
        this.apm = c1436a;
        this.apn = str2;
        this.apo = str3;
        this.app = i2;
        this.apq = c1439b;
        this.apr = str4;
        this.OS = str5;
        this.ow = i3;
        this.CE = str6;
        this.aps = c1440c;
        this.apt = z;
        this.FR = str7;
        this.apu = c1441d;
        this.apv = str8;
        this.apw = i4;
        this.apx = list;
        this.apy = list2;
        this.apz = i5;
        this.apA = i6;
        this.apB = str9;
        this.vf = str10;
        this.apC = list3;
        this.apD = z2;
    }

    public static pi m5796i(byte[] bArr) {
        Parcel obtain = Parcel.obtain();
        obtain.unmarshall(bArr, 0, bArr.length);
        obtain.setDataPosition(0);
        pi dz = CREATOR.dz(obtain);
        obtain.recycle();
        return dz;
    }

    protected final boolean m5797a(C1277a c1277a) {
        return this.aon.contains(Integer.valueOf(c1277a.hR()));
    }

    protected final Object m5798b(C1277a c1277a) {
        switch (c1277a.hR()) {
            case DataEvent.TYPE_DELETED /*2*/:
                return this.apl;
            case WalletFragmentState.PROCESSING /*3*/:
                return this.apm;
            case WalletFragmentState.WALLET_UNAVAILABLE /*4*/:
                return this.apn;
            case Dimension.UNIT_MM /*5*/:
                return this.apo;
            case Error.OTHER /*6*/:
                return Integer.valueOf(this.app);
            case Error.AVS_DECLINE /*7*/:
                return this.apq;
            case Error.FRAUD_DECLINE /*8*/:
                return this.apr;
            case GamesStatusCodes.STATUS_GAME_NOT_FOUND /*9*/:
                return this.OS;
            case C0366R.styleable.MapAttrs_uiZoomGestures /*12*/:
                return Integer.valueOf(this.ow);
            case GamesStatusCodes.STATUS_INTERRUPTED /*14*/:
                return this.CE;
            case GamesStatusCodes.STATUS_TIMEOUT /*15*/:
                return this.aps;
            case Notifications.NOTIFICATION_TYPE_LEVEL_UP /*16*/:
                return Boolean.valueOf(this.apt);
            case 18:
                return this.FR;
            case TimeUtils.HUNDRED_DAY_FIELD_LEN /*19*/:
                return this.apu;
            case 20:
                return this.apv;
            case 21:
                return Integer.valueOf(this.apw);
            case 22:
                return this.apx;
            case 23:
                return this.apy;
            case 24:
                return Integer.valueOf(this.apz);
            case 25:
                return Integer.valueOf(this.apA);
            case 26:
                return this.apB;
            case 27:
                return this.vf;
            case 28:
                return this.apC;
            case 29:
                return Boolean.valueOf(this.apD);
            default:
                throw new IllegalStateException("Unknown safe parcelable id=" + c1277a.hR());
        }
    }

    public final int describeContents() {
        pj pjVar = CREATOR;
        return 0;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof pi)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        pi piVar = (pi) obj;
        for (C1277a c1277a : aom.values()) {
            if (m5797a(c1277a)) {
                if (!piVar.m5797a(c1277a)) {
                    return false;
                }
                if (!m5798b(c1277a).equals(piVar.m5798b(c1277a))) {
                    return false;
                }
            } else if (piVar.m5797a(c1277a)) {
                return false;
            }
        }
        return true;
    }

    public final /* synthetic */ Object freeze() {
        return oL();
    }

    public final String getAboutMe() {
        return this.apl;
    }

    public final AgeRange getAgeRange() {
        return this.apm;
    }

    public final String getBirthday() {
        return this.apn;
    }

    public final String getBraggingRights() {
        return this.apo;
    }

    public final int getCircledByCount() {
        return this.app;
    }

    public final Cover getCover() {
        return this.apq;
    }

    public final String getCurrentLocation() {
        return this.apr;
    }

    public final String getDisplayName() {
        return this.OS;
    }

    public final int getGender() {
        return this.ow;
    }

    public final String getId() {
        return this.CE;
    }

    public final Image getImage() {
        return this.aps;
    }

    public final String getLanguage() {
        return this.FR;
    }

    public final Name getName() {
        return this.apu;
    }

    public final String getNickname() {
        return this.apv;
    }

    public final int getObjectType() {
        return this.apw;
    }

    public final List<Organizations> getOrganizations() {
        return (ArrayList) this.apx;
    }

    public final List<PlacesLived> getPlacesLived() {
        return (ArrayList) this.apy;
    }

    public final int getPlusOneCount() {
        return this.apz;
    }

    public final int getRelationshipStatus() {
        return this.apA;
    }

    public final String getTagline() {
        return this.apB;
    }

    public final String getUrl() {
        return this.vf;
    }

    public final List<Urls> getUrls() {
        return (ArrayList) this.apC;
    }

    public final HashMap<String, C1277a<?, ?>> hK() {
        return aom;
    }

    public final boolean hasAboutMe() {
        return this.aon.contains(Integer.valueOf(2));
    }

    public final boolean hasAgeRange() {
        return this.aon.contains(Integer.valueOf(3));
    }

    public final boolean hasBirthday() {
        return this.aon.contains(Integer.valueOf(4));
    }

    public final boolean hasBraggingRights() {
        return this.aon.contains(Integer.valueOf(5));
    }

    public final boolean hasCircledByCount() {
        return this.aon.contains(Integer.valueOf(6));
    }

    public final boolean hasCover() {
        return this.aon.contains(Integer.valueOf(7));
    }

    public final boolean hasCurrentLocation() {
        return this.aon.contains(Integer.valueOf(8));
    }

    public final boolean hasDisplayName() {
        return this.aon.contains(Integer.valueOf(9));
    }

    public final boolean hasGender() {
        return this.aon.contains(Integer.valueOf(12));
    }

    public final boolean hasId() {
        return this.aon.contains(Integer.valueOf(14));
    }

    public final boolean hasImage() {
        return this.aon.contains(Integer.valueOf(15));
    }

    public final boolean hasIsPlusUser() {
        return this.aon.contains(Integer.valueOf(16));
    }

    public final boolean hasLanguage() {
        return this.aon.contains(Integer.valueOf(18));
    }

    public final boolean hasName() {
        return this.aon.contains(Integer.valueOf(19));
    }

    public final boolean hasNickname() {
        return this.aon.contains(Integer.valueOf(20));
    }

    public final boolean hasObjectType() {
        return this.aon.contains(Integer.valueOf(21));
    }

    public final boolean hasOrganizations() {
        return this.aon.contains(Integer.valueOf(22));
    }

    public final boolean hasPlacesLived() {
        return this.aon.contains(Integer.valueOf(23));
    }

    public final boolean hasPlusOneCount() {
        return this.aon.contains(Integer.valueOf(24));
    }

    public final boolean hasRelationshipStatus() {
        return this.aon.contains(Integer.valueOf(25));
    }

    public final boolean hasTagline() {
        return this.aon.contains(Integer.valueOf(26));
    }

    public final boolean hasUrl() {
        return this.aon.contains(Integer.valueOf(27));
    }

    public final boolean hasUrls() {
        return this.aon.contains(Integer.valueOf(28));
    }

    public final boolean hasVerified() {
        return this.aon.contains(Integer.valueOf(29));
    }

    public final int hashCode() {
        int i = 0;
        for (C1277a c1277a : aom.values()) {
            int hashCode;
            if (m5797a(c1277a)) {
                hashCode = m5798b(c1277a).hashCode() + (i + c1277a.hR());
            } else {
                hashCode = i;
            }
            i = hashCode;
        }
        return i;
    }

    public final boolean isDataValid() {
        return true;
    }

    public final boolean isPlusUser() {
        return this.apt;
    }

    public final boolean isVerified() {
        return this.apD;
    }

    public final pi oL() {
        return this;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        pj pjVar = CREATOR;
        pj.m5799a(this, parcel, i);
    }
}

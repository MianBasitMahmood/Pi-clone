package com.google.android.gms.internal;

import com.google.android.gms.internal.bv.C1036a;
import java.util.Collections;
import java.util.List;
import org.json.JSONObject;

@ey
public final class fy {
    public final int errorCode;
    public final int orientation;
    public final long qA;
    public final cq qP;
    public final cz qQ;
    public final String qR;
    public final ct qS;
    public final List<String> qw;
    public final List<String> qx;
    public final gu se;
    public final av tL;
    public final String tO;
    public final long tV;
    public final boolean tW;
    public final long tX;
    public final List<String> tY;
    public final String ub;
    public final JSONObject vD;
    public final cr vE;
    public final ay vF;
    public final long vG;
    public final long vH;
    public final C1036a vI;

    @ey
    /* renamed from: com.google.android.gms.internal.fy.a */
    public static final class C1160a {
        public final int errorCode;
        public final ay lS;
        public final JSONObject vD;
        public final cr vE;
        public final long vG;
        public final long vH;
        public final fh vJ;
        public final fj vK;

        public C1160a(fh fhVar, fj fjVar, cr crVar, ay ayVar, int i, long j, long j2, JSONObject jSONObject) {
            this.vJ = fhVar;
            this.vK = fjVar;
            this.vE = crVar;
            this.lS = ayVar;
            this.errorCode = i;
            this.vG = j;
            this.vH = j2;
            this.vD = jSONObject;
        }
    }

    public fy(av avVar, gu guVar, List<String> list, int i, List<String> list2, List<String> list3, int i2, long j, String str, boolean z, cq cqVar, cz czVar, String str2, cr crVar, ct ctVar, long j2, ay ayVar, long j3, long j4, long j5, String str3, JSONObject jSONObject, C1036a c1036a) {
        this.tL = avVar;
        this.se = guVar;
        this.qw = list != null ? Collections.unmodifiableList(list) : null;
        this.errorCode = i;
        this.qx = list2 != null ? Collections.unmodifiableList(list2) : null;
        this.tY = list3 != null ? Collections.unmodifiableList(list3) : null;
        this.orientation = i2;
        this.qA = j;
        this.tO = str;
        this.tW = z;
        this.qP = cqVar;
        this.qQ = czVar;
        this.qR = str2;
        this.vE = crVar;
        this.qS = ctVar;
        this.tX = j2;
        this.vF = ayVar;
        this.tV = j3;
        this.vG = j4;
        this.vH = j5;
        this.ub = str3;
        this.vD = jSONObject;
        this.vI = c1036a;
    }

    public fy(C1160a c1160a, gu guVar, cq cqVar, cz czVar, String str, ct ctVar, C1036a c1036a) {
        gu guVar2 = guVar;
        cq cqVar2 = cqVar;
        cz czVar2 = czVar;
        String str2 = str;
        ct ctVar2 = ctVar;
        this(c1160a.vJ.tL, guVar2, c1160a.vK.qw, c1160a.errorCode, c1160a.vK.qx, c1160a.vK.tY, c1160a.vK.orientation, c1160a.vK.qA, c1160a.vJ.tO, c1160a.vK.tW, cqVar2, czVar2, str2, c1160a.vE, ctVar2, c1160a.vK.tX, c1160a.lS, c1160a.vK.tV, c1160a.vG, c1160a.vH, c1160a.vK.ub, c1160a.vD, c1036a);
    }
}

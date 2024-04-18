package com.google.android.gms.games.appcontent;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.jv;
import java.util.ArrayList;
import java.util.List;

public final class AppContentActionEntity implements SafeParcelable, AppContentAction {
    public static final AppContentActionEntityCreator CREATOR;
    private final int CK;
    private final ArrayList<AppContentConditionEntity> XJ;
    private final String XK;
    private final String XL;
    private final String XM;
    private final Bundle mExtras;
    private final String vc;

    static {
        CREATOR = new AppContentActionEntityCreator();
    }

    AppContentActionEntity(int i, ArrayList<AppContentConditionEntity> arrayList, String str, Bundle bundle, String str2, String str3, String str4) {
        this.CK = i;
        this.XJ = arrayList;
        this.XK = str;
        this.mExtras = bundle;
        this.XL = str2;
        this.XM = str3;
        this.vc = str4;
    }

    public AppContentActionEntity(AppContentAction appContentAction) {
        this.CK = 1;
        this.XK = appContentAction.kI();
        this.mExtras = appContentAction.getExtras();
        this.XL = appContentAction.getLabel();
        this.XM = appContentAction.kJ();
        this.vc = appContentAction.getType();
        List kH = appContentAction.kH();
        int size = kH.size();
        this.XJ = new ArrayList(size);
        for (int i = 0; i < size; i++) {
            this.XJ.add((AppContentConditionEntity) ((AppContentCondition) kH.get(i)).freeze());
        }
    }

    static int m2840a(AppContentAction appContentAction) {
        return jv.hashCode(appContentAction.kH(), appContentAction.kI(), appContentAction.getExtras(), appContentAction.getLabel(), appContentAction.kJ(), appContentAction.getType());
    }

    static boolean m2841a(AppContentAction appContentAction, Object obj) {
        if (!(obj instanceof AppContentAction)) {
            return false;
        }
        if (appContentAction == obj) {
            return true;
        }
        AppContentAction appContentAction2 = (AppContentAction) obj;
        return jv.equal(appContentAction2.kH(), appContentAction.kH()) && jv.equal(appContentAction2.kI(), appContentAction.kI()) && jv.equal(appContentAction2.getExtras(), appContentAction.getExtras()) && jv.equal(appContentAction2.getLabel(), appContentAction.getLabel()) && jv.equal(appContentAction2.kJ(), appContentAction.kJ()) && jv.equal(appContentAction2.getType(), appContentAction.getType());
    }

    static String m2842b(AppContentAction appContentAction) {
        return jv.m5212h(appContentAction).m5211a("Conditions", appContentAction.kH()).m5211a("ContentDescription", appContentAction.kI()).m5211a("Extras", appContentAction.getExtras()).m5211a("Label", appContentAction.getLabel()).m5211a("LabelStyle", appContentAction.kJ()).m5211a("Type", appContentAction.getType()).toString();
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        return m2841a(this, obj);
    }

    public final /* synthetic */ Object freeze() {
        return kK();
    }

    public final Bundle getExtras() {
        return this.mExtras;
    }

    public final String getLabel() {
        return this.XL;
    }

    public final String getType() {
        return this.vc;
    }

    public final int getVersionCode() {
        return this.CK;
    }

    public final int hashCode() {
        return m2840a(this);
    }

    public final boolean isDataValid() {
        return true;
    }

    public final List<AppContentCondition> kH() {
        return new ArrayList(this.XJ);
    }

    public final String kI() {
        return this.XK;
    }

    public final String kJ() {
        return this.XM;
    }

    public final AppContentAction kK() {
        return this;
    }

    public final String toString() {
        return m2842b(this);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        AppContentActionEntityCreator.m2843a(this, parcel, i);
    }
}

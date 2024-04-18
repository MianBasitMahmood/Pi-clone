package com.google.android.gms.games.appcontent;

import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.jv;
import java.util.ArrayList;
import java.util.List;

public final class AppContentCardEntity implements SafeParcelable, AppContentCard {
    public static final AppContentCardEntityCreator CREATOR;
    private final int CK;
    private final String OH;
    private final String UO;
    private final Uri WD;
    private final ArrayList<AppContentConditionEntity> XJ;
    private final String XK;
    private final Uri XN;
    private final ArrayList<AppContentAnnotationEntity> XO;
    private final int XP;
    private final Bundle XQ;
    private final String XR;
    private final int XS;
    private final ArrayList<AppContentActionEntity> mActions;
    private final String vc;

    static {
        CREATOR = new AppContentCardEntityCreator();
    }

    AppContentCardEntity(int i, ArrayList<AppContentActionEntity> arrayList, ArrayList<AppContentAnnotationEntity> arrayList2, ArrayList<AppContentConditionEntity> arrayList3, String str, int i2, String str2, Bundle bundle, Uri uri, Uri uri2, String str3, String str4, int i3, String str5) {
        this.CK = i;
        this.mActions = arrayList;
        this.XO = arrayList2;
        this.XJ = arrayList3;
        this.XK = str;
        this.XP = i2;
        this.UO = str2;
        this.XQ = bundle;
        this.WD = uri;
        this.XN = uri2;
        this.XR = str3;
        this.OH = str4;
        this.XS = i3;
        this.vc = str5;
    }

    public AppContentCardEntity(AppContentCard appContentCard) {
        int i;
        int i2 = 0;
        this.CK = 1;
        this.XK = appContentCard.kI();
        this.XP = appContentCard.kO();
        this.UO = appContentCard.getDescription();
        this.XQ = appContentCard.kP();
        this.WD = appContentCard.getIconImageUri();
        this.XN = appContentCard.kL();
        this.OH = appContentCard.getTitle();
        this.XR = appContentCard.kQ();
        this.XS = appContentCard.kR();
        this.vc = appContentCard.getType();
        List actions = appContentCard.getActions();
        int size = actions.size();
        this.mActions = new ArrayList(size);
        for (i = 0; i < size; i++) {
            this.mActions.add((AppContentActionEntity) ((AppContentAction) actions.get(i)).freeze());
        }
        actions = appContentCard.kN();
        size = actions.size();
        this.XO = new ArrayList(size);
        for (i = 0; i < size; i++) {
            this.XO.add((AppContentAnnotationEntity) ((AppContentAnnotation) actions.get(i)).freeze());
        }
        List kH = appContentCard.kH();
        int size2 = kH.size();
        this.XJ = new ArrayList(size2);
        while (i2 < size2) {
            this.XJ.add((AppContentConditionEntity) ((AppContentCondition) kH.get(i2)).freeze());
            i2++;
        }
    }

    static int m2848a(AppContentCard appContentCard) {
        return jv.hashCode(appContentCard.getActions(), appContentCard.kN(), appContentCard.kH(), appContentCard.kI(), Integer.valueOf(appContentCard.kO()), appContentCard.getDescription(), appContentCard.kP(), appContentCard.getIconImageUri(), appContentCard.kL(), appContentCard.kQ(), appContentCard.getTitle(), Integer.valueOf(appContentCard.kR()), appContentCard.getType());
    }

    static boolean m2849a(AppContentCard appContentCard, Object obj) {
        if (!(obj instanceof AppContentCard)) {
            return false;
        }
        if (appContentCard == obj) {
            return true;
        }
        AppContentCard appContentCard2 = (AppContentCard) obj;
        return jv.equal(appContentCard2.getActions(), appContentCard.getActions()) && jv.equal(appContentCard2.kN(), appContentCard.kN()) && jv.equal(appContentCard2.kH(), appContentCard.kH()) && jv.equal(appContentCard2.kI(), appContentCard.kI()) && jv.equal(Integer.valueOf(appContentCard2.kO()), Integer.valueOf(appContentCard.kO())) && jv.equal(appContentCard2.getDescription(), appContentCard.getDescription()) && jv.equal(appContentCard2.kP(), appContentCard.kP()) && jv.equal(appContentCard2.getIconImageUri(), appContentCard.getIconImageUri()) && jv.equal(appContentCard2.kL(), appContentCard.kL()) && jv.equal(appContentCard2.kQ(), appContentCard.kQ()) && jv.equal(appContentCard2.getTitle(), appContentCard.getTitle()) && jv.equal(Integer.valueOf(appContentCard2.kR()), Integer.valueOf(appContentCard.kR())) && jv.equal(appContentCard2.getType(), appContentCard.getType());
    }

    static String m2850b(AppContentCard appContentCard) {
        return jv.m5212h(appContentCard).m5211a("Actions", appContentCard.getActions()).m5211a("Annotations", appContentCard.kN()).m5211a("Conditions", appContentCard.kH()).m5211a("ContentDescription", appContentCard.kI()).m5211a("CurrentSteps", Integer.valueOf(appContentCard.kO())).m5211a("Description", appContentCard.getDescription()).m5211a("ExtraData", appContentCard.kP()).m5211a("IconImageUri", appContentCard.getIconImageUri()).m5211a("ImageUri", appContentCard.kL()).m5211a("Subtitle", appContentCard.kQ()).m5211a("Title", appContentCard.getTitle()).m5211a("TotalSteps", Integer.valueOf(appContentCard.kR())).m5211a("Type", appContentCard.getType()).toString();
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        return m2849a(this, obj);
    }

    public final /* synthetic */ Object freeze() {
        return kS();
    }

    public final List<AppContentAction> getActions() {
        return new ArrayList(this.mActions);
    }

    public final String getDescription() {
        return this.UO;
    }

    public final Uri getIconImageUri() {
        return this.WD;
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
        return m2848a(this);
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

    public final Uri kL() {
        return this.XN;
    }

    public final List<AppContentAnnotation> kN() {
        return new ArrayList(this.XO);
    }

    public final int kO() {
        return this.XP;
    }

    public final Bundle kP() {
        return this.XQ;
    }

    public final String kQ() {
        return this.XR;
    }

    public final int kR() {
        return this.XS;
    }

    public final AppContentCard kS() {
        return this;
    }

    public final String toString() {
        return m2850b(this);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        AppContentCardEntityCreator.m2851a(this, parcel, i);
    }
}

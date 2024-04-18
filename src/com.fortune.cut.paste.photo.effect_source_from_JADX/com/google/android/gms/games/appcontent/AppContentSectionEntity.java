package com.google.android.gms.games.appcontent;

import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.jv;
import java.util.ArrayList;
import java.util.List;

public final class AppContentSectionEntity implements SafeParcelable, AppContentSection {
    public static final AppContentSectionEntityCreator CREATOR;
    private final int CK;
    private final String OH;
    private final String XK;
    private final Bundle XQ;
    private final String XR;
    private final Uri XY;
    private final ArrayList<AppContentCardEntity> XZ;
    private final ArrayList<AppContentActionEntity> mActions;
    private final String vc;

    static {
        CREATOR = new AppContentSectionEntityCreator();
    }

    AppContentSectionEntity(int i, ArrayList<AppContentActionEntity> arrayList, Uri uri, ArrayList<AppContentCardEntity> arrayList2, String str, Bundle bundle, String str2, String str3, String str4) {
        this.CK = i;
        this.mActions = arrayList;
        this.XY = uri;
        this.XZ = arrayList2;
        this.XK = str;
        this.XQ = bundle;
        this.XR = str2;
        this.OH = str3;
        this.vc = str4;
    }

    public AppContentSectionEntity(AppContentSection appContentSection) {
        int i = 0;
        this.CK = 1;
        this.XY = appContentSection.kY();
        this.XK = appContentSection.kI();
        this.XQ = appContentSection.kP();
        this.XR = appContentSection.kQ();
        this.OH = appContentSection.getTitle();
        this.vc = appContentSection.getType();
        List actions = appContentSection.getActions();
        int size = actions.size();
        this.mActions = new ArrayList(size);
        for (int i2 = 0; i2 < size; i2++) {
            this.mActions.add((AppContentActionEntity) ((AppContentAction) actions.get(i2)).freeze());
        }
        List kZ = appContentSection.kZ();
        int size2 = kZ.size();
        this.XZ = new ArrayList(size2);
        while (i < size2) {
            this.XZ.add((AppContentCardEntity) ((AppContentCard) kZ.get(i)).freeze());
            i++;
        }
    }

    static int m2858a(AppContentSection appContentSection) {
        return jv.hashCode(appContentSection.getActions(), appContentSection.kY(), appContentSection.kZ(), appContentSection.kI(), appContentSection.kP(), appContentSection.kQ(), appContentSection.getTitle(), appContentSection.getType());
    }

    static boolean m2859a(AppContentSection appContentSection, Object obj) {
        if (!(obj instanceof AppContentSection)) {
            return false;
        }
        if (appContentSection == obj) {
            return true;
        }
        AppContentSection appContentSection2 = (AppContentSection) obj;
        return jv.equal(appContentSection2.getActions(), appContentSection.getActions()) && jv.equal(appContentSection2.kY(), appContentSection.kY()) && jv.equal(appContentSection2.kZ(), appContentSection.kZ()) && jv.equal(appContentSection2.kI(), appContentSection.kI()) && jv.equal(appContentSection2.kP(), appContentSection.kP()) && jv.equal(appContentSection2.kQ(), appContentSection.kQ()) && jv.equal(appContentSection2.getTitle(), appContentSection.getTitle()) && jv.equal(appContentSection2.getType(), appContentSection.getType());
    }

    static String m2860b(AppContentSection appContentSection) {
        return jv.m5212h(appContentSection).m5211a("Actions", appContentSection.getActions()).m5211a("BackgroundImageUri", appContentSection.kY()).m5211a("Cards", appContentSection.kZ()).m5211a("ContentDescription", appContentSection.kI()).m5211a("ExtraData", appContentSection.kP()).m5211a("Subtitle", appContentSection.kQ()).m5211a("Title", appContentSection.getTitle()).m5211a("Type", appContentSection.getType()).toString();
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        return m2859a(this, obj);
    }

    public final /* synthetic */ Object freeze() {
        return la();
    }

    public final List<AppContentAction> getActions() {
        return new ArrayList(this.mActions);
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
        return m2858a(this);
    }

    public final boolean isDataValid() {
        return true;
    }

    public final String kI() {
        return this.XK;
    }

    public final Bundle kP() {
        return this.XQ;
    }

    public final String kQ() {
        return this.XR;
    }

    public final Uri kY() {
        return this.XY;
    }

    public final List<AppContentCard> kZ() {
        return new ArrayList(this.XZ);
    }

    public final AppContentSection la() {
        return this;
    }

    public final String toString() {
        return m2860b(this);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        AppContentSectionEntityCreator.m2861a(this, parcel, i);
    }
}

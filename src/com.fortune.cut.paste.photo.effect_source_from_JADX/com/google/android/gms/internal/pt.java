package com.google.android.gms.internal;

import com.google.android.gms.common.data.C0451d;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.internal.pi.C1440c;
import com.google.android.gms.internal.pi.C1442e;
import com.google.android.gms.plus.PlusShare;
import com.google.android.gms.plus.model.people.Person;
import com.google.android.gms.plus.model.people.Person.AgeRange;
import com.google.android.gms.plus.model.people.Person.Cover;
import com.google.android.gms.plus.model.people.Person.Image;
import com.google.android.gms.plus.model.people.Person.Name;
import com.google.android.gms.plus.model.people.Person.Organizations;
import com.google.android.gms.plus.model.people.Person.PlacesLived;
import com.google.android.gms.plus.model.people.Person.Urls;
import java.util.ArrayList;
import java.util.List;

public final class pt extends C0451d implements Person {
    public pt(DataHolder dataHolder, int i) {
        super(dataHolder, i);
    }

    public final /* synthetic */ Object freeze() {
        return oZ();
    }

    public final String getAboutMe() {
        return null;
    }

    public final AgeRange getAgeRange() {
        return null;
    }

    public final String getBirthday() {
        return null;
    }

    public final String getBraggingRights() {
        return null;
    }

    public final int getCircledByCount() {
        return 0;
    }

    public final Cover getCover() {
        return null;
    }

    public final String getCurrentLocation() {
        return null;
    }

    public final String getDisplayName() {
        return getString("displayName");
    }

    public final int getGender() {
        return 0;
    }

    public final String getId() {
        return getString("personId");
    }

    public final Image getImage() {
        return new C1440c(getString("image"));
    }

    public final String getLanguage() {
        return null;
    }

    public final Name getName() {
        return null;
    }

    public final String getNickname() {
        return null;
    }

    public final int getObjectType() {
        return C1442e.ck(getString("objectType"));
    }

    public final /* synthetic */ List getOrganizations() {
        return oW();
    }

    public final /* synthetic */ List getPlacesLived() {
        return oX();
    }

    public final int getPlusOneCount() {
        return 0;
    }

    public final int getRelationshipStatus() {
        return 0;
    }

    public final String getTagline() {
        return null;
    }

    public final String getUrl() {
        return getString(PlusShare.KEY_CALL_TO_ACTION_URL);
    }

    public final /* synthetic */ List getUrls() {
        return oY();
    }

    public final boolean hasAboutMe() {
        return false;
    }

    public final boolean hasAgeRange() {
        return false;
    }

    public final boolean hasBirthday() {
        return false;
    }

    public final boolean hasBraggingRights() {
        return false;
    }

    public final boolean hasCircledByCount() {
        return false;
    }

    public final boolean hasCover() {
        return false;
    }

    public final boolean hasCurrentLocation() {
        return false;
    }

    public final boolean hasDisplayName() {
        return true;
    }

    public final boolean hasGender() {
        return false;
    }

    public final boolean hasId() {
        return true;
    }

    public final boolean hasImage() {
        return true;
    }

    public final boolean hasIsPlusUser() {
        return false;
    }

    public final boolean hasLanguage() {
        return false;
    }

    public final boolean hasName() {
        return false;
    }

    public final boolean hasNickname() {
        return false;
    }

    public final boolean hasObjectType() {
        return true;
    }

    public final boolean hasOrganizations() {
        return false;
    }

    public final boolean hasPlacesLived() {
        return false;
    }

    public final boolean hasPlusOneCount() {
        return false;
    }

    public final boolean hasRelationshipStatus() {
        return false;
    }

    public final boolean hasTagline() {
        return false;
    }

    public final boolean hasUrl() {
        return true;
    }

    public final boolean hasUrls() {
        return false;
    }

    public final boolean hasVerified() {
        return false;
    }

    public final boolean isPlusUser() {
        return false;
    }

    public final boolean isVerified() {
        return false;
    }

    public final ArrayList<Organizations> oW() {
        return null;
    }

    public final ArrayList<PlacesLived> oX() {
        return null;
    }

    public final ArrayList<Urls> oY() {
        return null;
    }

    public final Person oZ() {
        return new pi(getDisplayName(), getId(), (C1440c) getImage(), getObjectType(), getUrl());
    }
}

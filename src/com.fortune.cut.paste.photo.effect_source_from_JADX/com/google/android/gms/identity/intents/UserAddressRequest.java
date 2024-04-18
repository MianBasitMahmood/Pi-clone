package com.google.android.gms.identity.intents;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.identity.intents.model.CountrySpecification;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public final class UserAddressRequest implements SafeParcelable {
    public static final Creator<UserAddressRequest> CREATOR;
    private final int CK;
    List<CountrySpecification> afH;

    public final class Builder {
        final /* synthetic */ UserAddressRequest afI;

        private Builder(UserAddressRequest userAddressRequest) {
            this.afI = userAddressRequest;
        }

        public final Builder addAllowedCountrySpecification(CountrySpecification countrySpecification) {
            if (this.afI.afH == null) {
                this.afI.afH = new ArrayList();
            }
            this.afI.afH.add(countrySpecification);
            return this;
        }

        public final Builder addAllowedCountrySpecifications(Collection<CountrySpecification> collection) {
            if (this.afI.afH == null) {
                this.afI.afH = new ArrayList();
            }
            this.afI.afH.addAll(collection);
            return this;
        }

        public final UserAddressRequest build() {
            if (this.afI.afH != null) {
                this.afI.afH = Collections.unmodifiableList(this.afI.afH);
            }
            return this.afI;
        }
    }

    static {
        CREATOR = new C0994a();
    }

    UserAddressRequest() {
        this.CK = 1;
    }

    UserAddressRequest(int i, List<CountrySpecification> list) {
        this.CK = i;
        this.afH = list;
    }

    public static Builder newBuilder() {
        UserAddressRequest userAddressRequest = new UserAddressRequest();
        userAddressRequest.getClass();
        return new Builder(null);
    }

    public final int describeContents() {
        return 0;
    }

    public final int getVersionCode() {
        return this.CK;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        C0994a.m4105a(this, parcel, i);
    }
}

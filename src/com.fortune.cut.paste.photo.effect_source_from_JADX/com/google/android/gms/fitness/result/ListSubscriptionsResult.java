package com.google.android.gms.fitness.result;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.data.Subscription;
import com.google.android.gms.internal.jv;
import com.google.android.gms.internal.jx;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ListSubscriptionsResult implements Result, SafeParcelable {
    public static final Creator<ListSubscriptionsResult> CREATOR;
    private final int CK;
    private final Status Eb;
    private final List<Subscription> Wu;

    static {
        CREATOR = new C0845e();
    }

    ListSubscriptionsResult(int i, List<Subscription> list, Status status) {
        this.CK = i;
        this.Wu = list;
        this.Eb = status;
    }

    public ListSubscriptionsResult(List<Subscription> list, Status status) {
        this.CK = 3;
        this.Wu = Collections.unmodifiableList(list);
        this.Eb = (Status) jx.m5219b((Object) status, (Object) "status");
    }

    public static ListSubscriptionsResult m2792F(Status status) {
        return new ListSubscriptionsResult(Collections.emptyList(), status);
    }

    private boolean m2793b(ListSubscriptionsResult listSubscriptionsResult) {
        return this.Eb.equals(listSubscriptionsResult.Eb) && jv.equal(this.Wu, listSubscriptionsResult.Wu);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return this == obj || ((obj instanceof ListSubscriptionsResult) && m2793b((ListSubscriptionsResult) obj));
    }

    public Status getStatus() {
        return this.Eb;
    }

    public List<Subscription> getSubscriptions() {
        return this.Wu;
    }

    public List<Subscription> getSubscriptions(DataType dataType) {
        List arrayList = new ArrayList();
        for (Subscription subscription : this.Wu) {
            if (dataType.equals(subscription.jJ())) {
                arrayList.add(subscription);
            }
        }
        return Collections.unmodifiableList(arrayList);
    }

    int getVersionCode() {
        return this.CK;
    }

    public int hashCode() {
        return jv.hashCode(this.Eb, this.Wu);
    }

    public String toString() {
        return jv.m5212h(this).m5211a("status", this.Eb).m5211a("subscriptions", this.Wu).toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        C0845e.m2802a(this, parcel, i);
    }
}

package com.google.android.gms.games.internal.request;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.internal.constants.RequestUpdateResultOutcome;
import com.google.android.gms.internal.jx;
import java.util.HashMap;
import java.util.Set;

public final class RequestUpdateOutcomes {
    private static final String[] adl;
    private final int Iv;
    private final HashMap<String, Integer> adm;

    public static final class Builder {
        private int Iv;
        private HashMap<String, Integer> adm;

        public Builder() {
            this.adm = new HashMap();
            this.Iv = 0;
        }

        public final Builder ek(int i) {
            this.Iv = i;
            return this;
        }

        public final RequestUpdateOutcomes mF() {
            return new RequestUpdateOutcomes(this.adm, null);
        }

        public final Builder m4018z(String str, int i) {
            if (RequestUpdateResultOutcome.isValid(i)) {
                this.adm.put(str, Integer.valueOf(i));
            }
            return this;
        }
    }

    static {
        adl = new String[]{"requestId", "outcome"};
    }

    private RequestUpdateOutcomes(int i, HashMap<String, Integer> hashMap) {
        this.Iv = i;
        this.adm = hashMap;
    }

    public static RequestUpdateOutcomes m4019W(DataHolder dataHolder) {
        Builder builder = new Builder();
        builder.ek(dataHolder.getStatusCode());
        int count = dataHolder.getCount();
        for (int i = 0; i < count; i++) {
            int au = dataHolder.au(i);
            builder.m4018z(dataHolder.m1865c("requestId", i, au), dataHolder.m1864b("outcome", i, au));
        }
        return builder.mF();
    }

    public final Set<String> getRequestIds() {
        return this.adm.keySet();
    }

    public final int getRequestOutcome(String str) {
        jx.m5221b(this.adm.containsKey(str), "Request " + str + " was not part of the update operation!");
        return ((Integer) this.adm.get(str)).intValue();
    }
}

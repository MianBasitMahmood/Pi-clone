package com.google.android.gms.plus.model.moments;

import com.google.android.gms.common.data.Freezable;
import com.google.android.gms.internal.pd;
import com.google.android.gms.internal.pf;
import java.util.HashSet;
import java.util.Set;

public interface Moment extends Freezable<Moment> {

    public static class Builder {
        private String CE;
        private final Set<Integer> aon;
        private String apa;
        private pd api;
        private pd apj;
        private String vc;

        public Builder() {
            this.aon = new HashSet();
        }

        public Moment build() {
            return new pf(this.aon, this.CE, this.api, this.apa, this.apj, this.vc);
        }

        public Builder setId(String str) {
            this.CE = str;
            this.aon.add(Integer.valueOf(2));
            return this;
        }

        public Builder setResult(ItemScope itemScope) {
            this.api = (pd) itemScope;
            this.aon.add(Integer.valueOf(4));
            return this;
        }

        public Builder setStartDate(String str) {
            this.apa = str;
            this.aon.add(Integer.valueOf(5));
            return this;
        }

        public Builder setTarget(ItemScope itemScope) {
            this.apj = (pd) itemScope;
            this.aon.add(Integer.valueOf(6));
            return this;
        }

        public Builder setType(String str) {
            this.vc = str;
            this.aon.add(Integer.valueOf(7));
            return this;
        }
    }

    String getId();

    ItemScope getResult();

    String getStartDate();

    ItemScope getTarget();

    String getType();

    boolean hasId();

    boolean hasResult();

    boolean hasStartDate();

    boolean hasTarget();

    boolean hasType();
}

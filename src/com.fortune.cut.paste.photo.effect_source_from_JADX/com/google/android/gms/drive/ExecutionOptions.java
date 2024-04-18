package com.google.android.gms.drive;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.drive.internal.C0613r;
import com.google.android.gms.internal.jv;

public final class ExecutionOptions {
    public static final int CONFLICT_STRATEGY_KEEP_REMOTE = 1;
    public static final int CONFLICT_STRATEGY_OVERWRITE_REMOTE = 0;
    public static final int MAX_TRACKING_TAG_STRING_LENGTH = 65536;
    private final int OA;
    private final String Oy;
    private final boolean Oz;

    public static final class Builder {
        private int OA;
        private String Oy;
        private boolean Oz;

        public Builder() {
            this.OA = ExecutionOptions.CONFLICT_STRATEGY_OVERWRITE_REMOTE;
        }

        public final ExecutionOptions build() {
            if (this.OA != ExecutionOptions.CONFLICT_STRATEGY_KEEP_REMOTE || this.Oz) {
                return new ExecutionOptions(this.Oy, this.Oz, this.OA);
            }
            throw new IllegalStateException("Cannot use CONFLICT_STRATEGY_KEEP_REMOTE without requesting completion notifications");
        }

        public final Builder setConflictStrategy(int i) {
            if (ExecutionOptions.bb(i)) {
                this.OA = i;
                return this;
            }
            throw new IllegalArgumentException("Unrecognized value for conflict strategy: " + i);
        }

        public final Builder setNotifyOnCompletion(boolean z) {
            this.Oz = z;
            return this;
        }

        public final Builder setTrackingTag(String str) {
            if (ExecutionOptions.bj(str)) {
                this.Oy = str;
                return this;
            }
            Object[] objArr = new Object[ExecutionOptions.CONFLICT_STRATEGY_KEEP_REMOTE];
            objArr[ExecutionOptions.CONFLICT_STRATEGY_OVERWRITE_REMOTE] = Integer.valueOf(ExecutionOptions.MAX_TRACKING_TAG_STRING_LENGTH);
            throw new IllegalArgumentException(String.format("trackingTag must not be null nor empty, and the length must be <= the maximum length (%s)", objArr));
        }
    }

    public ExecutionOptions(String str, boolean z, int i) {
        this.Oy = str;
        this.Oz = z;
        this.OA = i;
    }

    public static void m1995a(GoogleApiClient googleApiClient, ExecutionOptions executionOptions) {
        C0613r c0613r = (C0613r) googleApiClient.m1803a(Drive.DQ);
        if (executionOptions.iw() && !c0613r.iJ()) {
            throw new IllegalStateException("Application must define an exported DriveEventService subclass in AndroidManifest.xml to be notified on completion");
        }
    }

    public static boolean ba(int i) {
        switch (i) {
            case CONFLICT_STRATEGY_KEEP_REMOTE /*1*/:
                return true;
            default:
                return false;
        }
    }

    public static boolean bb(int i) {
        switch (i) {
            case CONFLICT_STRATEGY_OVERWRITE_REMOTE /*0*/:
            case CONFLICT_STRATEGY_KEEP_REMOTE /*1*/:
                return true;
            default:
                return false;
        }
    }

    public static boolean bj(String str) {
        return (str == null || str.isEmpty() || str.length() > MAX_TRACKING_TAG_STRING_LENGTH) ? false : true;
    }

    public final boolean equals(Object obj) {
        if (obj == null || obj.getClass() != getClass()) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        ExecutionOptions executionOptions = (ExecutionOptions) obj;
        return jv.equal(this.Oy, executionOptions.Oy) && this.OA == executionOptions.OA && this.Oz == executionOptions.Oz;
    }

    public final int hashCode() {
        return jv.hashCode(this.Oy, Integer.valueOf(this.OA), Boolean.valueOf(this.Oz));
    }

    public final String iv() {
        return this.Oy;
    }

    public final boolean iw() {
        return this.Oz;
    }

    public final int ix() {
        return this.OA;
    }
}

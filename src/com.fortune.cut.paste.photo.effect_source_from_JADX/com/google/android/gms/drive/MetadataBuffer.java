package com.google.android.gms.drive;

import com.google.android.gms.common.data.DataBuffer;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.internal.C0588m;
import com.google.android.gms.drive.metadata.C0651b;
import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.drive.metadata.internal.C0660e;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import com.google.android.gms.internal.ln;

public final class MetadataBuffer extends DataBuffer<Metadata> {
    private final String OB;
    private C0549a OC;

    /* renamed from: com.google.android.gms.drive.MetadataBuffer.a */
    private static class C0549a extends Metadata {
        private final DataHolder JG;
        private final int La;
        private final int OD;

        public C0549a(DataHolder dataHolder, int i) {
            this.JG = dataHolder;
            this.OD = i;
            this.La = dataHolder.au(i);
        }

        protected <T> T m1998a(MetadataField<T> metadataField) {
            return metadataField.m2325a(this.JG, this.OD, this.La);
        }

        public /* synthetic */ Object freeze() {
            return iy();
        }

        public boolean isDataValid() {
            return !this.JG.isClosed();
        }

        public Metadata iy() {
            MetadataBundle iZ = MetadataBundle.iZ();
            for (MetadataField metadataField : C0660e.iY()) {
                if (!((metadataField instanceof C0651b) || metadataField == ln.RI)) {
                    metadataField.m2326a(this.JG, iZ, this.OD, this.La);
                }
            }
            return new C0588m(iZ);
        }
    }

    public MetadataBuffer(DataHolder dataHolder, String str) {
        super(dataHolder);
        this.OB = str;
        dataHolder.gV().setClassLoader(MetadataBuffer.class.getClassLoader());
    }

    public final Metadata get(int i) {
        C0549a c0549a = this.OC;
        if (c0549a != null && c0549a.OD == i) {
            return c0549a;
        }
        Metadata c0549a2 = new C0549a(this.JG, i);
        this.OC = c0549a2;
        return c0549a2;
    }

    public final String getNextPageToken() {
        return this.OB;
    }
}

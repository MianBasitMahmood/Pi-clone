package com.google.android.gms.drive.metadata.internal;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.UserMetadata;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

/* renamed from: com.google.android.gms.drive.metadata.internal.m */
public class C0668m extends C0665j<UserMetadata> {
    public C0668m(String str, int i) {
        super(str, C0668m.bp(str), Collections.emptyList(), i);
    }

    private String bo(String str) {
        return C0668m.m2393q(getName(), str);
    }

    private static Collection<String> bp(String str) {
        return Arrays.asList(new String[]{C0668m.m2393q(str, "permissionId"), C0668m.m2393q(str, "displayName"), C0668m.m2393q(str, "picture"), C0668m.m2393q(str, "isAuthenticatedUser"), C0668m.m2393q(str, "emailAddress")});
    }

    private static String m2393q(String str, String str2) {
        return "." + str2;
    }

    protected boolean m2394b(DataHolder dataHolder, int i, int i2) {
        return !dataHolder.m1871h(bo("permissionId"), i, i2);
    }

    protected /* synthetic */ Object m2395c(DataHolder dataHolder, int i, int i2) {
        return m2396j(dataHolder, i, i2);
    }

    protected UserMetadata m2396j(DataHolder dataHolder, int i, int i2) {
        String c = dataHolder.m1865c(bo("permissionId"), i, i2);
        if (c == null) {
            return null;
        }
        String c2 = dataHolder.m1865c(bo("displayName"), i, i2);
        String c3 = dataHolder.m1865c(bo("picture"), i, i2);
        Boolean valueOf = Boolean.valueOf(dataHolder.m1866d(bo("isAuthenticatedUser"), i, i2));
        return new UserMetadata(c, c2, c3, valueOf.booleanValue(), dataHolder.m1865c(bo("emailAddress"), i, i2));
    }
}

package com.google.android.gms.drive.metadata.internal;

import android.os.Bundle;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.metadata.C0651b;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import org.json.JSONArray;
import org.json.JSONException;

/* renamed from: com.google.android.gms.drive.metadata.internal.k */
public class C0666k extends C0651b<String> {
    public C0666k(String str, int i) {
        super(str, Collections.singleton(str), Collections.emptySet(), i);
    }

    public static final Collection<String> bn(String str) throws JSONException {
        if (str == null) {
            return null;
        }
        Collection arrayList = new ArrayList();
        JSONArray jSONArray = new JSONArray(str);
        for (int i = 0; i < jSONArray.length(); i++) {
            arrayList.add(jSONArray.getString(i));
        }
        return Collections.unmodifiableCollection(arrayList);
    }

    protected void m2382a(Bundle bundle, Collection<String> collection) {
        bundle.putStringArrayList(getName(), new ArrayList(collection));
    }

    protected /* synthetic */ Object m2383c(DataHolder dataHolder, int i, int i2) {
        return m2384d(dataHolder, i, i2);
    }

    protected Collection<String> m2384d(DataHolder dataHolder, int i, int i2) {
        try {
            return C0666k.bn(dataHolder.m1865c(getName(), i, i2));
        } catch (Throwable e) {
            throw new IllegalStateException("DataHolder supplied invalid JSON", e);
        }
    }

    protected /* synthetic */ Object m2385i(Bundle bundle) {
        return m2386n(bundle);
    }

    protected Collection<String> m2386n(Bundle bundle) {
        return bundle.getStringArrayList(getName());
    }
}

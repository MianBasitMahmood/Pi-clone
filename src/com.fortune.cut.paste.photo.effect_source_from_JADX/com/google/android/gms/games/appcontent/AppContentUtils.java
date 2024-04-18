package com.google.android.gms.games.appcontent;

import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.internal.la;
import java.util.ArrayList;

public final class AppContentUtils {

    private interface AppContentRunner {
        void m2866b(ArrayList<DataHolder> arrayList, int i);
    }

    /* renamed from: com.google.android.gms.games.appcontent.AppContentUtils.1 */
    static class C08551 implements AppContentRunner {
        final /* synthetic */ ArrayList Yb;

        C08551(ArrayList arrayList) {
            this.Yb = arrayList;
        }

        public final void m2867b(ArrayList<DataHolder> arrayList, int i) {
            this.Yb.add(new AppContentActionRef(arrayList, i));
        }
    }

    /* renamed from: com.google.android.gms.games.appcontent.AppContentUtils.2 */
    static class C08562 implements AppContentRunner {
        final /* synthetic */ ArrayList Yb;

        C08562(ArrayList arrayList) {
            this.Yb = arrayList;
        }

        public final void m2868b(ArrayList<DataHolder> arrayList, int i) {
            this.Yb.add(new AppContentAnnotationRef(arrayList, i));
        }
    }

    /* renamed from: com.google.android.gms.games.appcontent.AppContentUtils.3 */
    static class C08573 implements AppContentRunner {
        final /* synthetic */ ArrayList Yb;

        C08573(ArrayList arrayList) {
            this.Yb = arrayList;
        }

        public final void m2869b(ArrayList<DataHolder> arrayList, int i) {
            this.Yb.add(new AppContentConditionRef(arrayList, i));
        }
    }

    /* renamed from: com.google.android.gms.games.appcontent.AppContentUtils.4 */
    static class C08584 implements AppContentRunner {
        final /* synthetic */ DataHolder Yc;
        final /* synthetic */ Bundle Yd;

        C08584(DataHolder dataHolder, Bundle bundle) {
            this.Yc = dataHolder;
            this.Yd = bundle;
        }

        public final void m2870b(ArrayList<DataHolder> arrayList, int i) {
            AppContentTuple appContentTupleRef = new AppContentTupleRef(this.Yc, i);
            this.Yd.putString(appContentTupleRef.getName(), appContentTupleRef.getValue());
        }
    }

    public static ArrayList<AppContentAction> m2871a(DataHolder dataHolder, ArrayList<DataHolder> arrayList, String str, int i) {
        ArrayList<AppContentAction> arrayList2 = new ArrayList();
        DataHolder dataHolder2 = dataHolder;
        String str2 = str;
        m2872a(dataHolder2, 1, str2, "action_id", i, new C08551(arrayList2), arrayList);
        return arrayList2;
    }

    private static void m2872a(DataHolder dataHolder, int i, String str, String str2, int i2, AppContentRunner appContentRunner, ArrayList<DataHolder> arrayList) {
        DataHolder dataHolder2 = (DataHolder) arrayList.get(i);
        Object c = dataHolder.m1865c(str, i2, dataHolder.au(i2));
        if (!TextUtils.isEmpty(c)) {
            int count = dataHolder2.getCount();
            String[] split = c.split(",");
            for (int i3 = 0; i3 < count; i3++) {
                CharSequence c2 = dataHolder2.m1865c(str2, i3, dataHolder2.au(i3));
                if (!TextUtils.isEmpty(c2) && la.m5320b(split, c2)) {
                    appContentRunner.m2866b(arrayList, i3);
                }
            }
        }
    }

    public static ArrayList<AppContentAnnotation> m2873b(DataHolder dataHolder, ArrayList<DataHolder> arrayList, String str, int i) {
        ArrayList<AppContentAnnotation> arrayList2 = new ArrayList();
        DataHolder dataHolder2 = dataHolder;
        String str2 = str;
        m2872a(dataHolder2, 2, str2, "annotation_id", i, new C08562(arrayList2), arrayList);
        return arrayList2;
    }

    public static ArrayList<AppContentCondition> m2874c(DataHolder dataHolder, ArrayList<DataHolder> arrayList, String str, int i) {
        ArrayList<AppContentCondition> arrayList2 = new ArrayList();
        DataHolder dataHolder2 = dataHolder;
        String str2 = str;
        m2872a(dataHolder2, 4, str2, "condition_id", i, new C08573(arrayList2), arrayList);
        return arrayList2;
    }

    public static Bundle m2875d(DataHolder dataHolder, ArrayList<DataHolder> arrayList, String str, int i) {
        Bundle bundle = new Bundle();
        DataHolder dataHolder2 = dataHolder;
        String str2 = str;
        m2872a(dataHolder2, 3, str2, "tuple_id", i, new C08584((DataHolder) arrayList.get(3), bundle), arrayList);
        return bundle;
    }
}

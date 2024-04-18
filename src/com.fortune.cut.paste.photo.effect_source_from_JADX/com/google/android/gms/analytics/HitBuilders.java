package com.google.android.gms.analytics;

import android.text.TextUtils;
import com.google.android.gms.analytics.C0426y.C0425a;
import com.google.android.gms.analytics.ecommerce.Product;
import com.google.android.gms.analytics.ecommerce.ProductAction;
import com.google.android.gms.analytics.ecommerce.Promotion;
import com.google.android.gms.tagmanager.DataLayer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class HitBuilders {

    protected static class HitBuilder<T extends HitBuilder> {
        private Map<String, String> BA;
        ProductAction BB;
        Map<String, List<Product>> BC;
        List<Promotion> BD;
        List<Product> BE;

        protected HitBuilder() {
            this.BA = new HashMap();
            this.BC = new HashMap();
            this.BD = new ArrayList();
            this.BE = new ArrayList();
        }

        public T addImpression(Product product, String str) {
            if (product == null) {
                ae.m1488W("product should be non-null");
            } else {
                Object obj;
                if (str == null) {
                    obj = "";
                }
                if (!this.BC.containsKey(obj)) {
                    this.BC.put(obj, new ArrayList());
                }
                ((List) this.BC.get(obj)).add(product);
            }
            return this;
        }

        public T addProduct(Product product) {
            if (product == null) {
                ae.m1488W("product should be non-null");
            } else {
                this.BE.add(product);
            }
            return this;
        }

        public T addPromotion(Promotion promotion) {
            if (promotion == null) {
                ae.m1488W("promotion should be non-null");
            } else {
                this.BD.add(promotion);
            }
            return this;
        }

        public Map<String, String> build() {
            Map<String, String> hashMap = new HashMap(this.BA);
            if (this.BB != null) {
                hashMap.putAll(this.BB.build());
            }
            int i = 1;
            for (Promotion aq : this.BD) {
                hashMap.putAll(aq.aq(C0405s.m1555B(i)));
                i++;
            }
            i = 1;
            for (Product aq2 : this.BE) {
                hashMap.putAll(aq2.aq(C0405s.m1554A(i)));
                i++;
            }
            int i2 = 1;
            for (Entry entry : this.BC.entrySet()) {
                List<Product> list = (List) entry.getValue();
                String D = C0405s.m1557D(i2);
                int i3 = 1;
                for (Product aq3 : list) {
                    hashMap.putAll(aq3.aq(D + C0405s.m1556C(i3)));
                    i3++;
                }
                if (!TextUtils.isEmpty((CharSequence) entry.getKey())) {
                    hashMap.put(D + "nm", entry.getKey());
                }
                i2++;
            }
            return hashMap;
        }

        protected String get(String str) {
            return (String) this.BA.get(str);
        }

        public final T set(String str, String str2) {
            C0426y.eK().m1600a(C0425a.MAP_BUILDER_SET);
            if (str != null) {
                this.BA.put(str, str2);
            } else {
                ae.m1488W(" HitBuilder.set() called with a null paramName.");
            }
            return this;
        }

        public final T setAll(Map<String, String> map) {
            C0426y.eK().m1600a(C0425a.MAP_BUILDER_SET_ALL);
            if (map != null) {
                this.BA.putAll(new HashMap(map));
            }
            return this;
        }

        public T setCampaignParamsFromUrl(String str) {
            C0426y.eK().m1600a(C0425a.MAP_BUILDER_SET_CAMPAIGN_PARAMS);
            Object ao = an.ao(str);
            if (!TextUtils.isEmpty(ao)) {
                Map an = an.an(ao);
                set("&cc", (String) an.get("utm_content"));
                set("&cm", (String) an.get("utm_medium"));
                set("&cn", (String) an.get("utm_campaign"));
                set("&cs", (String) an.get("utm_source"));
                set("&ck", (String) an.get("utm_term"));
                set("&ci", (String) an.get("utm_id"));
                set("&gclid", (String) an.get("gclid"));
                set("&dclid", (String) an.get("dclid"));
                set("&gmob_t", (String) an.get("gmob_t"));
            }
            return this;
        }

        public T setCustomDimension(int i, String str) {
            set(C0405s.m1561y(i), str);
            return this;
        }

        public T setCustomMetric(int i, float f) {
            set(C0405s.m1562z(i), Float.toString(f));
            return this;
        }

        protected T setHitType(String str) {
            set("&t", str);
            return this;
        }

        public T setNewSession() {
            set("&sc", "start");
            return this;
        }

        public T setNonInteraction(boolean z) {
            set("&ni", an.m1521E(z));
            return this;
        }

        public T setProductAction(ProductAction productAction) {
            this.BB = productAction;
            return this;
        }

        public T setPromotionAction(String str) {
            this.BA.put("&promoa", str);
            return this;
        }
    }

    @Deprecated
    public static class AppViewBuilder extends HitBuilder<AppViewBuilder> {
        public AppViewBuilder() {
            C0426y.eK().m1600a(C0425a.CONSTRUCT_APP_VIEW);
            set("&t", "screenview");
        }

        public /* bridge */ /* synthetic */ Map build() {
            return super.build();
        }
    }

    public static class EventBuilder extends HitBuilder<EventBuilder> {
        public EventBuilder() {
            C0426y.eK().m1600a(C0425a.CONSTRUCT_EVENT);
            set("&t", DataLayer.EVENT_KEY);
        }

        public EventBuilder(String str, String str2) {
            this();
            setCategory(str);
            setAction(str2);
        }

        public /* bridge */ /* synthetic */ Map build() {
            return super.build();
        }

        public EventBuilder setAction(String str) {
            set("&ea", str);
            return this;
        }

        public EventBuilder setCategory(String str) {
            set("&ec", str);
            return this;
        }

        public EventBuilder setLabel(String str) {
            set("&el", str);
            return this;
        }

        public EventBuilder setValue(long j) {
            set("&ev", Long.toString(j));
            return this;
        }
    }

    public static class ExceptionBuilder extends HitBuilder<ExceptionBuilder> {
        public ExceptionBuilder() {
            C0426y.eK().m1600a(C0425a.CONSTRUCT_EXCEPTION);
            set("&t", "exception");
        }

        public /* bridge */ /* synthetic */ Map build() {
            return super.build();
        }

        public ExceptionBuilder setDescription(String str) {
            set("&exd", str);
            return this;
        }

        public ExceptionBuilder setFatal(boolean z) {
            set("&exf", an.m1521E(z));
            return this;
        }
    }

    @Deprecated
    public static class ItemBuilder extends HitBuilder<ItemBuilder> {
        public ItemBuilder() {
            C0426y.eK().m1600a(C0425a.CONSTRUCT_ITEM);
            set("&t", "item");
        }

        public /* bridge */ /* synthetic */ Map build() {
            return super.build();
        }

        public ItemBuilder setCategory(String str) {
            set("&iv", str);
            return this;
        }

        public ItemBuilder setCurrencyCode(String str) {
            set("&cu", str);
            return this;
        }

        public ItemBuilder setName(String str) {
            set("&in", str);
            return this;
        }

        public ItemBuilder setPrice(double d) {
            set("&ip", Double.toString(d));
            return this;
        }

        public ItemBuilder setQuantity(long j) {
            set("&iq", Long.toString(j));
            return this;
        }

        public ItemBuilder setSku(String str) {
            set("&ic", str);
            return this;
        }

        public ItemBuilder setTransactionId(String str) {
            set("&ti", str);
            return this;
        }
    }

    public static class ScreenViewBuilder extends HitBuilder<ScreenViewBuilder> {
        public ScreenViewBuilder() {
            C0426y.eK().m1600a(C0425a.CONSTRUCT_APP_VIEW);
            set("&t", "screenview");
        }

        public /* bridge */ /* synthetic */ Map build() {
            return super.build();
        }
    }

    public static class SocialBuilder extends HitBuilder<SocialBuilder> {
        public SocialBuilder() {
            C0426y.eK().m1600a(C0425a.CONSTRUCT_SOCIAL);
            set("&t", "social");
        }

        public /* bridge */ /* synthetic */ Map build() {
            return super.build();
        }

        public SocialBuilder setAction(String str) {
            set("&sa", str);
            return this;
        }

        public SocialBuilder setNetwork(String str) {
            set("&sn", str);
            return this;
        }

        public SocialBuilder setTarget(String str) {
            set("&st", str);
            return this;
        }
    }

    public static class TimingBuilder extends HitBuilder<TimingBuilder> {
        public TimingBuilder() {
            C0426y.eK().m1600a(C0425a.CONSTRUCT_TIMING);
            set("&t", "timing");
        }

        public TimingBuilder(String str, String str2, long j) {
            this();
            setVariable(str2);
            setValue(j);
            setCategory(str);
        }

        public /* bridge */ /* synthetic */ Map build() {
            return super.build();
        }

        public TimingBuilder setCategory(String str) {
            set("&utc", str);
            return this;
        }

        public TimingBuilder setLabel(String str) {
            set("&utl", str);
            return this;
        }

        public TimingBuilder setValue(long j) {
            set("&utt", Long.toString(j));
            return this;
        }

        public TimingBuilder setVariable(String str) {
            set("&utv", str);
            return this;
        }
    }

    @Deprecated
    public static class TransactionBuilder extends HitBuilder<TransactionBuilder> {
        public TransactionBuilder() {
            C0426y.eK().m1600a(C0425a.CONSTRUCT_TRANSACTION);
            set("&t", "transaction");
        }

        public /* bridge */ /* synthetic */ Map build() {
            return super.build();
        }

        public TransactionBuilder setAffiliation(String str) {
            set("&ta", str);
            return this;
        }

        public TransactionBuilder setCurrencyCode(String str) {
            set("&cu", str);
            return this;
        }

        public TransactionBuilder setRevenue(double d) {
            set("&tr", Double.toString(d));
            return this;
        }

        public TransactionBuilder setShipping(double d) {
            set("&ts", Double.toString(d));
            return this;
        }

        public TransactionBuilder setTax(double d) {
            set("&tt", Double.toString(d));
            return this;
        }

        public TransactionBuilder setTransactionId(String str) {
            set("&ti", str);
            return this;
        }
    }
}

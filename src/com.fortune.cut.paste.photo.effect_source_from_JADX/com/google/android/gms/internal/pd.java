package com.google.android.gms.internal;

import android.os.Parcel;
import android.support.v4.util.TimeUtils;
import com.google.ads.AdSize;
import com.google.android.gms.C0366R;
import com.google.android.gms.common.api.CommonStatusCodes;
import com.google.android.gms.drive.MetadataChangeSet;
import com.google.android.gms.games.GamesStatusCodes;
import com.google.android.gms.games.Notifications;
import com.google.android.gms.internal.kr.C1277a;
import com.google.android.gms.plus.PlusShare;
import com.google.android.gms.plus.model.moments.ItemScope;
import com.google.android.gms.wallet.NotifyTransactionStatusRequest.Status.Error;
import com.google.android.gms.wallet.fragment.Dimension;
import com.google.android.gms.wallet.fragment.WalletFragmentState;
import com.google.android.gms.wearable.DataEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public final class pd extends ks implements ItemScope {
    public static final pe CREATOR;
    private static final HashMap<String, C1277a<?, ?>> aom;
    String CE;
    final int CK;
    String UO;
    double agg;
    double agh;
    String aoA;
    pd aoB;
    String aoC;
    String aoD;
    List<pd> aoE;
    String aoF;
    String aoG;
    String aoH;
    String aoI;
    String aoJ;
    String aoK;
    String aoL;
    String aoM;
    pd aoN;
    String aoO;
    String aoP;
    String aoQ;
    pd aoR;
    pd aoS;
    pd aoT;
    List<pd> aoU;
    String aoV;
    String aoW;
    String aoX;
    String aoY;
    pd aoZ;
    final Set<Integer> aon;
    pd aoo;
    List<String> aop;
    pd aoq;
    String aor;
    String aos;
    String aot;
    List<pd> aou;
    int aov;
    List<pd> aow;
    pd aox;
    List<pd> aoy;
    String aoz;
    String apa;
    String apb;
    String apc;
    pd apd;
    String ape;
    String apf;
    String apg;
    String aph;
    String mName;
    String ov;
    String vc;
    String vf;

    static {
        CREATOR = new pe();
        HashMap hashMap = new HashMap();
        aom = hashMap;
        hashMap.put("about", C1277a.m5270a("about", 2, pd.class));
        aom.put("additionalName", C1277a.m5277m("additionalName", 3));
        aom.put("address", C1277a.m5270a("address", 4, pd.class));
        aom.put("addressCountry", C1277a.m5276l("addressCountry", 5));
        aom.put("addressLocality", C1277a.m5276l("addressLocality", 6));
        aom.put("addressRegion", C1277a.m5276l("addressRegion", 7));
        aom.put("associated_media", C1277a.m5271b("associated_media", 8, pd.class));
        aom.put("attendeeCount", C1277a.m5273i("attendeeCount", 9));
        aom.put("attendees", C1277a.m5271b("attendees", 10, pd.class));
        aom.put("audio", C1277a.m5270a("audio", 11, pd.class));
        aom.put("author", C1277a.m5271b("author", 12, pd.class));
        aom.put("bestRating", C1277a.m5276l("bestRating", 13));
        aom.put("birthDate", C1277a.m5276l("birthDate", 14));
        aom.put("byArtist", C1277a.m5270a("byArtist", 15, pd.class));
        aom.put("caption", C1277a.m5276l("caption", 16));
        aom.put("contentSize", C1277a.m5276l("contentSize", 17));
        aom.put("contentUrl", C1277a.m5276l("contentUrl", 18));
        aom.put("contributor", C1277a.m5271b("contributor", 19, pd.class));
        aom.put("dateCreated", C1277a.m5276l("dateCreated", 20));
        aom.put("dateModified", C1277a.m5276l("dateModified", 21));
        aom.put("datePublished", C1277a.m5276l("datePublished", 22));
        aom.put(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_DESCRIPTION, C1277a.m5276l(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_DESCRIPTION, 23));
        aom.put("duration", C1277a.m5276l("duration", 24));
        aom.put("embedUrl", C1277a.m5276l("embedUrl", 25));
        aom.put("endDate", C1277a.m5276l("endDate", 26));
        aom.put("familyName", C1277a.m5276l("familyName", 27));
        aom.put("gender", C1277a.m5276l("gender", 28));
        aom.put("geo", C1277a.m5270a("geo", 29, pd.class));
        aom.put("givenName", C1277a.m5276l("givenName", 30));
        aom.put("height", C1277a.m5276l("height", 31));
        aom.put("id", C1277a.m5276l("id", 32));
        aom.put("image", C1277a.m5276l("image", 33));
        aom.put("inAlbum", C1277a.m5270a("inAlbum", 34, pd.class));
        aom.put("latitude", C1277a.m5274j("latitude", 36));
        aom.put("location", C1277a.m5270a("location", 37, pd.class));
        aom.put("longitude", C1277a.m5274j("longitude", 38));
        aom.put("name", C1277a.m5276l("name", 39));
        aom.put("partOfTVSeries", C1277a.m5270a("partOfTVSeries", 40, pd.class));
        aom.put("performers", C1277a.m5271b("performers", 41, pd.class));
        aom.put("playerType", C1277a.m5276l("playerType", 42));
        aom.put("postOfficeBoxNumber", C1277a.m5276l("postOfficeBoxNumber", 43));
        aom.put("postalCode", C1277a.m5276l("postalCode", 44));
        aom.put("ratingValue", C1277a.m5276l("ratingValue", 45));
        aom.put("reviewRating", C1277a.m5270a("reviewRating", 46, pd.class));
        aom.put("startDate", C1277a.m5276l("startDate", 47));
        aom.put("streetAddress", C1277a.m5276l("streetAddress", 48));
        aom.put("text", C1277a.m5276l("text", 49));
        aom.put("thumbnail", C1277a.m5270a("thumbnail", 50, pd.class));
        aom.put(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_THUMBNAIL_URL, C1277a.m5276l(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_THUMBNAIL_URL, 51));
        aom.put("tickerSymbol", C1277a.m5276l("tickerSymbol", 52));
        aom.put("type", C1277a.m5276l("type", 53));
        aom.put(PlusShare.KEY_CALL_TO_ACTION_URL, C1277a.m5276l(PlusShare.KEY_CALL_TO_ACTION_URL, 54));
        aom.put("width", C1277a.m5276l("width", 55));
        aom.put("worstRating", C1277a.m5276l("worstRating", 56));
    }

    public pd() {
        this.CK = 1;
        this.aon = new HashSet();
    }

    pd(Set<Integer> set, int i, pd pdVar, List<String> list, pd pdVar2, String str, String str2, String str3, List<pd> list2, int i2, List<pd> list3, pd pdVar3, List<pd> list4, String str4, String str5, pd pdVar4, String str6, String str7, String str8, List<pd> list5, String str9, String str10, String str11, String str12, String str13, String str14, String str15, String str16, String str17, pd pdVar5, String str18, String str19, String str20, String str21, pd pdVar6, double d, pd pdVar7, double d2, String str22, pd pdVar8, List<pd> list6, String str23, String str24, String str25, String str26, pd pdVar9, String str27, String str28, String str29, pd pdVar10, String str30, String str31, String str32, String str33, String str34, String str35) {
        this.aon = set;
        this.CK = i;
        this.aoo = pdVar;
        this.aop = list;
        this.aoq = pdVar2;
        this.aor = str;
        this.aos = str2;
        this.aot = str3;
        this.aou = list2;
        this.aov = i2;
        this.aow = list3;
        this.aox = pdVar3;
        this.aoy = list4;
        this.aoz = str4;
        this.aoA = str5;
        this.aoB = pdVar4;
        this.aoC = str6;
        this.aoD = str7;
        this.ov = str8;
        this.aoE = list5;
        this.aoF = str9;
        this.aoG = str10;
        this.aoH = str11;
        this.UO = str12;
        this.aoI = str13;
        this.aoJ = str14;
        this.aoK = str15;
        this.aoL = str16;
        this.aoM = str17;
        this.aoN = pdVar5;
        this.aoO = str18;
        this.aoP = str19;
        this.CE = str20;
        this.aoQ = str21;
        this.aoR = pdVar6;
        this.agg = d;
        this.aoS = pdVar7;
        this.agh = d2;
        this.mName = str22;
        this.aoT = pdVar8;
        this.aoU = list6;
        this.aoV = str23;
        this.aoW = str24;
        this.aoX = str25;
        this.aoY = str26;
        this.aoZ = pdVar9;
        this.apa = str27;
        this.apb = str28;
        this.apc = str29;
        this.apd = pdVar10;
        this.ape = str30;
        this.apf = str31;
        this.vc = str32;
        this.vf = str33;
        this.apg = str34;
        this.aph = str35;
    }

    public pd(Set<Integer> set, pd pdVar, List<String> list, pd pdVar2, String str, String str2, String str3, List<pd> list2, int i, List<pd> list3, pd pdVar3, List<pd> list4, String str4, String str5, pd pdVar4, String str6, String str7, String str8, List<pd> list5, String str9, String str10, String str11, String str12, String str13, String str14, String str15, String str16, String str17, pd pdVar5, String str18, String str19, String str20, String str21, pd pdVar6, double d, pd pdVar7, double d2, String str22, pd pdVar8, List<pd> list6, String str23, String str24, String str25, String str26, pd pdVar9, String str27, String str28, String str29, pd pdVar10, String str30, String str31, String str32, String str33, String str34, String str35) {
        this.aon = set;
        this.CK = 1;
        this.aoo = pdVar;
        this.aop = list;
        this.aoq = pdVar2;
        this.aor = str;
        this.aos = str2;
        this.aot = str3;
        this.aou = list2;
        this.aov = i;
        this.aow = list3;
        this.aox = pdVar3;
        this.aoy = list4;
        this.aoz = str4;
        this.aoA = str5;
        this.aoB = pdVar4;
        this.aoC = str6;
        this.aoD = str7;
        this.ov = str8;
        this.aoE = list5;
        this.aoF = str9;
        this.aoG = str10;
        this.aoH = str11;
        this.UO = str12;
        this.aoI = str13;
        this.aoJ = str14;
        this.aoK = str15;
        this.aoL = str16;
        this.aoM = str17;
        this.aoN = pdVar5;
        this.aoO = str18;
        this.aoP = str19;
        this.CE = str20;
        this.aoQ = str21;
        this.aoR = pdVar6;
        this.agg = d;
        this.aoS = pdVar7;
        this.agh = d2;
        this.mName = str22;
        this.aoT = pdVar8;
        this.aoU = list6;
        this.aoV = str23;
        this.aoW = str24;
        this.aoX = str25;
        this.aoY = str26;
        this.aoZ = pdVar9;
        this.apa = str27;
        this.apb = str28;
        this.apc = str29;
        this.apd = pdVar10;
        this.ape = str30;
        this.apf = str31;
        this.vc = str32;
        this.vf = str33;
        this.apg = str34;
        this.aph = str35;
    }

    protected final boolean m5772a(C1277a c1277a) {
        return this.aon.contains(Integer.valueOf(c1277a.hR()));
    }

    protected final Object m5773b(C1277a c1277a) {
        switch (c1277a.hR()) {
            case DataEvent.TYPE_DELETED /*2*/:
                return this.aoo;
            case WalletFragmentState.PROCESSING /*3*/:
                return this.aop;
            case WalletFragmentState.WALLET_UNAVAILABLE /*4*/:
                return this.aoq;
            case Dimension.UNIT_MM /*5*/:
                return this.aor;
            case Error.OTHER /*6*/:
                return this.aos;
            case Error.AVS_DECLINE /*7*/:
                return this.aot;
            case Error.FRAUD_DECLINE /*8*/:
                return this.aou;
            case GamesStatusCodes.STATUS_GAME_NOT_FOUND /*9*/:
                return Integer.valueOf(this.aov);
            case CommonStatusCodes.DEVELOPER_ERROR /*10*/:
                return this.aow;
            case CommonStatusCodes.LICENSE_CHECK_FAILED /*11*/:
                return this.aox;
            case C0366R.styleable.MapAttrs_uiZoomGestures /*12*/:
                return this.aoy;
            case CommonStatusCodes.ERROR /*13*/:
                return this.aoz;
            case GamesStatusCodes.STATUS_INTERRUPTED /*14*/:
                return this.aoA;
            case GamesStatusCodes.STATUS_TIMEOUT /*15*/:
                return this.aoB;
            case Notifications.NOTIFICATION_TYPE_LEVEL_UP /*16*/:
                return this.aoC;
            case 17:
                return this.aoD;
            case 18:
                return this.ov;
            case TimeUtils.HUNDRED_DAY_FIELD_LEN /*19*/:
                return this.aoE;
            case 20:
                return this.aoF;
            case 21:
                return this.aoG;
            case 22:
                return this.aoH;
            case 23:
                return this.UO;
            case 24:
                return this.aoI;
            case 25:
                return this.aoJ;
            case 26:
                return this.aoK;
            case 27:
                return this.aoL;
            case 28:
                return this.aoM;
            case 29:
                return this.aoN;
            case MetadataChangeSet.MAX_PUBLIC_PROPERTIES_PER_RESOURCE /*30*/:
                return this.aoO;
            case Notifications.NOTIFICATION_TYPES_ALL /*31*/:
                return this.aoP;
            case AdSize.LANDSCAPE_AD_HEIGHT /*32*/:
                return this.CE;
            case 33:
                return this.aoQ;
            case 34:
                return this.aoR;
            case 36:
                return Double.valueOf(this.agg);
            case 37:
                return this.aoS;
            case 38:
                return Double.valueOf(this.agh);
            case 39:
                return this.mName;
            case 40:
                return this.aoT;
            case 41:
                return this.aoU;
            case 42:
                return this.aoV;
            case 43:
                return this.aoW;
            case 44:
                return this.aoX;
            case 45:
                return this.aoY;
            case 46:
                return this.aoZ;
            case 47:
                return this.apa;
            case 48:
                return this.apb;
            case 49:
                return this.apc;
            case AdSize.PORTRAIT_AD_HEIGHT /*50*/:
                return this.apd;
            case 51:
                return this.ape;
            case 52:
                return this.apf;
            case 53:
                return this.vc;
            case 54:
                return this.vf;
            case 55:
                return this.apg;
            case 56:
                return this.aph;
            default:
                throw new IllegalStateException("Unknown safe parcelable id=" + c1277a.hR());
        }
    }

    public final int describeContents() {
        pe peVar = CREATOR;
        return 0;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof pd)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        pd pdVar = (pd) obj;
        for (C1277a c1277a : aom.values()) {
            if (m5772a(c1277a)) {
                if (!pdVar.m5772a(c1277a)) {
                    return false;
                }
                if (!m5773b(c1277a).equals(pdVar.m5773b(c1277a))) {
                    return false;
                }
            } else if (pdVar.m5772a(c1277a)) {
                return false;
            }
        }
        return true;
    }

    public final /* synthetic */ Object freeze() {
        return oI();
    }

    public final ItemScope getAbout() {
        return this.aoo;
    }

    public final List<String> getAdditionalName() {
        return this.aop;
    }

    public final ItemScope getAddress() {
        return this.aoq;
    }

    public final String getAddressCountry() {
        return this.aor;
    }

    public final String getAddressLocality() {
        return this.aos;
    }

    public final String getAddressRegion() {
        return this.aot;
    }

    public final List<ItemScope> getAssociated_media() {
        return (ArrayList) this.aou;
    }

    public final int getAttendeeCount() {
        return this.aov;
    }

    public final List<ItemScope> getAttendees() {
        return (ArrayList) this.aow;
    }

    public final ItemScope getAudio() {
        return this.aox;
    }

    public final List<ItemScope> getAuthor() {
        return (ArrayList) this.aoy;
    }

    public final String getBestRating() {
        return this.aoz;
    }

    public final String getBirthDate() {
        return this.aoA;
    }

    public final ItemScope getByArtist() {
        return this.aoB;
    }

    public final String getCaption() {
        return this.aoC;
    }

    public final String getContentSize() {
        return this.aoD;
    }

    public final String getContentUrl() {
        return this.ov;
    }

    public final List<ItemScope> getContributor() {
        return (ArrayList) this.aoE;
    }

    public final String getDateCreated() {
        return this.aoF;
    }

    public final String getDateModified() {
        return this.aoG;
    }

    public final String getDatePublished() {
        return this.aoH;
    }

    public final String getDescription() {
        return this.UO;
    }

    public final String getDuration() {
        return this.aoI;
    }

    public final String getEmbedUrl() {
        return this.aoJ;
    }

    public final String getEndDate() {
        return this.aoK;
    }

    public final String getFamilyName() {
        return this.aoL;
    }

    public final String getGender() {
        return this.aoM;
    }

    public final ItemScope getGeo() {
        return this.aoN;
    }

    public final String getGivenName() {
        return this.aoO;
    }

    public final String getHeight() {
        return this.aoP;
    }

    public final String getId() {
        return this.CE;
    }

    public final String getImage() {
        return this.aoQ;
    }

    public final ItemScope getInAlbum() {
        return this.aoR;
    }

    public final double getLatitude() {
        return this.agg;
    }

    public final ItemScope getLocation() {
        return this.aoS;
    }

    public final double getLongitude() {
        return this.agh;
    }

    public final String getName() {
        return this.mName;
    }

    public final ItemScope getPartOfTVSeries() {
        return this.aoT;
    }

    public final List<ItemScope> getPerformers() {
        return (ArrayList) this.aoU;
    }

    public final String getPlayerType() {
        return this.aoV;
    }

    public final String getPostOfficeBoxNumber() {
        return this.aoW;
    }

    public final String getPostalCode() {
        return this.aoX;
    }

    public final String getRatingValue() {
        return this.aoY;
    }

    public final ItemScope getReviewRating() {
        return this.aoZ;
    }

    public final String getStartDate() {
        return this.apa;
    }

    public final String getStreetAddress() {
        return this.apb;
    }

    public final String getText() {
        return this.apc;
    }

    public final ItemScope getThumbnail() {
        return this.apd;
    }

    public final String getThumbnailUrl() {
        return this.ape;
    }

    public final String getTickerSymbol() {
        return this.apf;
    }

    public final String getType() {
        return this.vc;
    }

    public final String getUrl() {
        return this.vf;
    }

    public final String getWidth() {
        return this.apg;
    }

    public final String getWorstRating() {
        return this.aph;
    }

    public final HashMap<String, C1277a<?, ?>> hK() {
        return aom;
    }

    public final boolean hasAbout() {
        return this.aon.contains(Integer.valueOf(2));
    }

    public final boolean hasAdditionalName() {
        return this.aon.contains(Integer.valueOf(3));
    }

    public final boolean hasAddress() {
        return this.aon.contains(Integer.valueOf(4));
    }

    public final boolean hasAddressCountry() {
        return this.aon.contains(Integer.valueOf(5));
    }

    public final boolean hasAddressLocality() {
        return this.aon.contains(Integer.valueOf(6));
    }

    public final boolean hasAddressRegion() {
        return this.aon.contains(Integer.valueOf(7));
    }

    public final boolean hasAssociated_media() {
        return this.aon.contains(Integer.valueOf(8));
    }

    public final boolean hasAttendeeCount() {
        return this.aon.contains(Integer.valueOf(9));
    }

    public final boolean hasAttendees() {
        return this.aon.contains(Integer.valueOf(10));
    }

    public final boolean hasAudio() {
        return this.aon.contains(Integer.valueOf(11));
    }

    public final boolean hasAuthor() {
        return this.aon.contains(Integer.valueOf(12));
    }

    public final boolean hasBestRating() {
        return this.aon.contains(Integer.valueOf(13));
    }

    public final boolean hasBirthDate() {
        return this.aon.contains(Integer.valueOf(14));
    }

    public final boolean hasByArtist() {
        return this.aon.contains(Integer.valueOf(15));
    }

    public final boolean hasCaption() {
        return this.aon.contains(Integer.valueOf(16));
    }

    public final boolean hasContentSize() {
        return this.aon.contains(Integer.valueOf(17));
    }

    public final boolean hasContentUrl() {
        return this.aon.contains(Integer.valueOf(18));
    }

    public final boolean hasContributor() {
        return this.aon.contains(Integer.valueOf(19));
    }

    public final boolean hasDateCreated() {
        return this.aon.contains(Integer.valueOf(20));
    }

    public final boolean hasDateModified() {
        return this.aon.contains(Integer.valueOf(21));
    }

    public final boolean hasDatePublished() {
        return this.aon.contains(Integer.valueOf(22));
    }

    public final boolean hasDescription() {
        return this.aon.contains(Integer.valueOf(23));
    }

    public final boolean hasDuration() {
        return this.aon.contains(Integer.valueOf(24));
    }

    public final boolean hasEmbedUrl() {
        return this.aon.contains(Integer.valueOf(25));
    }

    public final boolean hasEndDate() {
        return this.aon.contains(Integer.valueOf(26));
    }

    public final boolean hasFamilyName() {
        return this.aon.contains(Integer.valueOf(27));
    }

    public final boolean hasGender() {
        return this.aon.contains(Integer.valueOf(28));
    }

    public final boolean hasGeo() {
        return this.aon.contains(Integer.valueOf(29));
    }

    public final boolean hasGivenName() {
        return this.aon.contains(Integer.valueOf(30));
    }

    public final boolean hasHeight() {
        return this.aon.contains(Integer.valueOf(31));
    }

    public final boolean hasId() {
        return this.aon.contains(Integer.valueOf(32));
    }

    public final boolean hasImage() {
        return this.aon.contains(Integer.valueOf(33));
    }

    public final boolean hasInAlbum() {
        return this.aon.contains(Integer.valueOf(34));
    }

    public final boolean hasLatitude() {
        return this.aon.contains(Integer.valueOf(36));
    }

    public final boolean hasLocation() {
        return this.aon.contains(Integer.valueOf(37));
    }

    public final boolean hasLongitude() {
        return this.aon.contains(Integer.valueOf(38));
    }

    public final boolean hasName() {
        return this.aon.contains(Integer.valueOf(39));
    }

    public final boolean hasPartOfTVSeries() {
        return this.aon.contains(Integer.valueOf(40));
    }

    public final boolean hasPerformers() {
        return this.aon.contains(Integer.valueOf(41));
    }

    public final boolean hasPlayerType() {
        return this.aon.contains(Integer.valueOf(42));
    }

    public final boolean hasPostOfficeBoxNumber() {
        return this.aon.contains(Integer.valueOf(43));
    }

    public final boolean hasPostalCode() {
        return this.aon.contains(Integer.valueOf(44));
    }

    public final boolean hasRatingValue() {
        return this.aon.contains(Integer.valueOf(45));
    }

    public final boolean hasReviewRating() {
        return this.aon.contains(Integer.valueOf(46));
    }

    public final boolean hasStartDate() {
        return this.aon.contains(Integer.valueOf(47));
    }

    public final boolean hasStreetAddress() {
        return this.aon.contains(Integer.valueOf(48));
    }

    public final boolean hasText() {
        return this.aon.contains(Integer.valueOf(49));
    }

    public final boolean hasThumbnail() {
        return this.aon.contains(Integer.valueOf(50));
    }

    public final boolean hasThumbnailUrl() {
        return this.aon.contains(Integer.valueOf(51));
    }

    public final boolean hasTickerSymbol() {
        return this.aon.contains(Integer.valueOf(52));
    }

    public final boolean hasType() {
        return this.aon.contains(Integer.valueOf(53));
    }

    public final boolean hasUrl() {
        return this.aon.contains(Integer.valueOf(54));
    }

    public final boolean hasWidth() {
        return this.aon.contains(Integer.valueOf(55));
    }

    public final boolean hasWorstRating() {
        return this.aon.contains(Integer.valueOf(56));
    }

    public final int hashCode() {
        int i = 0;
        for (C1277a c1277a : aom.values()) {
            int hashCode;
            if (m5772a(c1277a)) {
                hashCode = m5773b(c1277a).hashCode() + (i + c1277a.hR());
            } else {
                hashCode = i;
            }
            i = hashCode;
        }
        return i;
    }

    public final boolean isDataValid() {
        return true;
    }

    public final pd oI() {
        return this;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        pe peVar = CREATOR;
        pe.m5774a(this, parcel, i);
    }
}

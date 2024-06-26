package android.support.v4.text;

import com.google.android.gms.games.GamesStatusCodes;
import com.google.android.gms.games.Notifications;
import java.util.Locale;

public final class BidiFormatter {
    private static final int DEFAULT_FLAGS = 2;
    private static final BidiFormatter DEFAULT_LTR_INSTANCE;
    private static final BidiFormatter DEFAULT_RTL_INSTANCE;
    private static TextDirectionHeuristicCompat DEFAULT_TEXT_DIRECTION_HEURISTIC = null;
    private static final int DIR_LTR = -1;
    private static final int DIR_RTL = 1;
    private static final int DIR_UNKNOWN = 0;
    private static final String EMPTY_STRING = "";
    private static final int FLAG_STEREO_RESET = 2;
    private static final char LRE = '\u202a';
    private static final char LRM = '\u200e';
    private static final String LRM_STRING;
    private static final char PDF = '\u202c';
    private static final char RLE = '\u202b';
    private static final char RLM = '\u200f';
    private static final String RLM_STRING;
    private final TextDirectionHeuristicCompat mDefaultTextDirectionHeuristicCompat;
    private final int mFlags;
    private final boolean mIsRtlContext;

    public static final class Builder {
        private int mFlags;
        private boolean mIsRtlContext;
        private TextDirectionHeuristicCompat mTextDirectionHeuristicCompat;

        public Builder() {
            initialize(BidiFormatter.isRtlLocale(Locale.getDefault()));
        }

        public Builder(boolean z) {
            initialize(z);
        }

        public Builder(Locale locale) {
            initialize(BidiFormatter.isRtlLocale(locale));
        }

        private void initialize(boolean z) {
            this.mIsRtlContext = z;
            this.mTextDirectionHeuristicCompat = BidiFormatter.DEFAULT_TEXT_DIRECTION_HEURISTIC;
            this.mFlags = BidiFormatter.FLAG_STEREO_RESET;
        }

        public final Builder stereoReset(boolean z) {
            if (z) {
                this.mFlags |= BidiFormatter.FLAG_STEREO_RESET;
            } else {
                this.mFlags &= -3;
            }
            return this;
        }

        public final Builder setTextDirectionHeuristic(TextDirectionHeuristicCompat textDirectionHeuristicCompat) {
            this.mTextDirectionHeuristicCompat = textDirectionHeuristicCompat;
            return this;
        }

        private static BidiFormatter getDefaultInstanceFromContext(boolean z) {
            return z ? BidiFormatter.DEFAULT_RTL_INSTANCE : BidiFormatter.DEFAULT_LTR_INSTANCE;
        }

        public final BidiFormatter build() {
            if (this.mFlags == BidiFormatter.FLAG_STEREO_RESET && this.mTextDirectionHeuristicCompat == BidiFormatter.DEFAULT_TEXT_DIRECTION_HEURISTIC) {
                return getDefaultInstanceFromContext(this.mIsRtlContext);
            }
            return new BidiFormatter(this.mFlags, this.mTextDirectionHeuristicCompat, null);
        }
    }

    private static class DirectionalityEstimator {
        private static final byte[] DIR_TYPE_CACHE;
        private static final int DIR_TYPE_CACHE_SIZE = 1792;
        private int charIndex;
        private final boolean isHtml;
        private char lastChar;
        private final int length;
        private final String text;

        static {
            DIR_TYPE_CACHE = new byte[DIR_TYPE_CACHE_SIZE];
            for (int i = BidiFormatter.DIR_UNKNOWN; i < DIR_TYPE_CACHE_SIZE; i += BidiFormatter.DIR_RTL) {
                DIR_TYPE_CACHE[i] = Character.getDirectionality(i);
            }
        }

        DirectionalityEstimator(String str, boolean z) {
            this.text = str;
            this.isHtml = z;
            this.length = str.length();
        }

        int getEntryDir() {
            this.charIndex = BidiFormatter.DIR_UNKNOWN;
            int i = BidiFormatter.DIR_UNKNOWN;
            int i2 = BidiFormatter.DIR_UNKNOWN;
            int i3 = BidiFormatter.DIR_UNKNOWN;
            while (this.charIndex < this.length && i == 0) {
                switch (dirTypeForward()) {
                    case BidiFormatter.DIR_UNKNOWN /*0*/:
                        if (i3 != 0) {
                            i = i3;
                            break;
                        }
                        return BidiFormatter.DIR_LTR;
                    case BidiFormatter.DIR_RTL /*1*/:
                    case BidiFormatter.FLAG_STEREO_RESET /*2*/:
                        if (i3 != 0) {
                            i = i3;
                            break;
                        }
                        return BidiFormatter.DIR_RTL;
                    case GamesStatusCodes.STATUS_GAME_NOT_FOUND /*9*/:
                        break;
                    case GamesStatusCodes.STATUS_INTERRUPTED /*14*/:
                    case GamesStatusCodes.STATUS_TIMEOUT /*15*/:
                        i3 += BidiFormatter.DIR_RTL;
                        i2 = BidiFormatter.DIR_LTR;
                        break;
                    case Notifications.NOTIFICATION_TYPE_LEVEL_UP /*16*/:
                    case (byte) 17:
                        i3 += BidiFormatter.DIR_RTL;
                        i2 = BidiFormatter.DIR_RTL;
                        break;
                    case (byte) 18:
                        i3 += BidiFormatter.DIR_LTR;
                        i2 = BidiFormatter.DIR_UNKNOWN;
                        break;
                    default:
                        i = i3;
                        break;
                }
            }
            if (i == 0) {
                return BidiFormatter.DIR_UNKNOWN;
            }
            if (i2 != 0) {
                return i2;
            }
            while (this.charIndex > 0) {
                switch (dirTypeBackward()) {
                    case GamesStatusCodes.STATUS_INTERRUPTED /*14*/:
                    case GamesStatusCodes.STATUS_TIMEOUT /*15*/:
                        if (i != i3) {
                            i3 += BidiFormatter.DIR_LTR;
                            break;
                        }
                        return BidiFormatter.DIR_LTR;
                    case Notifications.NOTIFICATION_TYPE_LEVEL_UP /*16*/:
                    case (byte) 17:
                        if (i != i3) {
                            i3 += BidiFormatter.DIR_LTR;
                            break;
                        }
                        return BidiFormatter.DIR_RTL;
                    case (byte) 18:
                        i3 += BidiFormatter.DIR_RTL;
                        break;
                    default:
                        break;
                }
            }
            return BidiFormatter.DIR_UNKNOWN;
        }

        int getExitDir() {
            this.charIndex = this.length;
            int i = BidiFormatter.DIR_UNKNOWN;
            int i2 = BidiFormatter.DIR_UNKNOWN;
            while (this.charIndex > 0) {
                switch (dirTypeBackward()) {
                    case BidiFormatter.DIR_UNKNOWN /*0*/:
                        if (i2 != 0) {
                            if (i != 0) {
                                break;
                            }
                            i = i2;
                            break;
                        }
                        return BidiFormatter.DIR_LTR;
                    case BidiFormatter.DIR_RTL /*1*/:
                    case BidiFormatter.FLAG_STEREO_RESET /*2*/:
                        if (i2 != 0) {
                            if (i != 0) {
                                break;
                            }
                            i = i2;
                            break;
                        }
                        return BidiFormatter.DIR_RTL;
                    case GamesStatusCodes.STATUS_GAME_NOT_FOUND /*9*/:
                        break;
                    case GamesStatusCodes.STATUS_INTERRUPTED /*14*/:
                    case GamesStatusCodes.STATUS_TIMEOUT /*15*/:
                        if (i != i2) {
                            i2 += BidiFormatter.DIR_LTR;
                            break;
                        }
                        return BidiFormatter.DIR_LTR;
                    case Notifications.NOTIFICATION_TYPE_LEVEL_UP /*16*/:
                    case (byte) 17:
                        if (i != i2) {
                            i2 += BidiFormatter.DIR_LTR;
                            break;
                        }
                        return BidiFormatter.DIR_RTL;
                    case (byte) 18:
                        i2 += BidiFormatter.DIR_RTL;
                        break;
                    default:
                        if (i != 0) {
                            break;
                        }
                        i = i2;
                        break;
                }
            }
            return BidiFormatter.DIR_UNKNOWN;
        }

        private static byte getCachedDirectionality(char c) {
            return c < '\u0700' ? DIR_TYPE_CACHE[c] : Character.getDirectionality(c);
        }

        byte dirTypeForward() {
            this.lastChar = this.text.charAt(this.charIndex);
            if (Character.isHighSurrogate(this.lastChar)) {
                int codePointAt = Character.codePointAt(this.text, this.charIndex);
                this.charIndex += Character.charCount(codePointAt);
                return Character.getDirectionality(codePointAt);
            }
            this.charIndex += BidiFormatter.DIR_RTL;
            byte cachedDirectionality = getCachedDirectionality(this.lastChar);
            if (!this.isHtml) {
                return cachedDirectionality;
            }
            if (this.lastChar == '<') {
                return skipTagForward();
            }
            if (this.lastChar == '&') {
                return skipEntityForward();
            }
            return cachedDirectionality;
        }

        byte dirTypeBackward() {
            this.lastChar = this.text.charAt(this.charIndex + BidiFormatter.DIR_LTR);
            if (Character.isLowSurrogate(this.lastChar)) {
                int codePointBefore = Character.codePointBefore(this.text, this.charIndex);
                this.charIndex -= Character.charCount(codePointBefore);
                return Character.getDirectionality(codePointBefore);
            }
            this.charIndex += BidiFormatter.DIR_LTR;
            byte cachedDirectionality = getCachedDirectionality(this.lastChar);
            if (!this.isHtml) {
                return cachedDirectionality;
            }
            if (this.lastChar == '>') {
                return skipTagBackward();
            }
            if (this.lastChar == ';') {
                return skipEntityBackward();
            }
            return cachedDirectionality;
        }

        private byte skipTagForward() {
            int i = this.charIndex;
            while (this.charIndex < this.length) {
                String str = this.text;
                int i2 = this.charIndex;
                this.charIndex = i2 + BidiFormatter.DIR_RTL;
                this.lastChar = str.charAt(i2);
                if (this.lastChar == '>') {
                    return (byte) 12;
                }
                if (this.lastChar == '\"' || this.lastChar == '\'') {
                    char c = this.lastChar;
                    while (this.charIndex < this.length) {
                        String str2 = this.text;
                        int i3 = this.charIndex;
                        this.charIndex = i3 + BidiFormatter.DIR_RTL;
                        char charAt = str2.charAt(i3);
                        this.lastChar = charAt;
                        if (charAt == c) {
                            break;
                        }
                    }
                }
            }
            this.charIndex = i;
            this.lastChar = '<';
            return (byte) 13;
        }

        private byte skipTagBackward() {
            int i = this.charIndex;
            while (this.charIndex > 0) {
                String str = this.text;
                int i2 = this.charIndex + BidiFormatter.DIR_LTR;
                this.charIndex = i2;
                this.lastChar = str.charAt(i2);
                if (this.lastChar != '<') {
                    if (this.lastChar == '>') {
                        break;
                    } else if (this.lastChar == '\"' || this.lastChar == '\'') {
                        char c = this.lastChar;
                        while (this.charIndex > 0) {
                            String str2 = this.text;
                            int i3 = this.charIndex + BidiFormatter.DIR_LTR;
                            this.charIndex = i3;
                            char charAt = str2.charAt(i3);
                            this.lastChar = charAt;
                            if (charAt == c) {
                                break;
                            }
                        }
                    }
                } else {
                    return (byte) 12;
                }
            }
            this.charIndex = i;
            this.lastChar = '>';
            return (byte) 13;
        }

        private byte skipEntityForward() {
            while (this.charIndex < this.length) {
                String str = this.text;
                int i = this.charIndex;
                this.charIndex = i + BidiFormatter.DIR_RTL;
                char charAt = str.charAt(i);
                this.lastChar = charAt;
                if (charAt == ';') {
                    break;
                }
            }
            return (byte) 12;
        }

        private byte skipEntityBackward() {
            int i = this.charIndex;
            while (this.charIndex > 0) {
                String str = this.text;
                int i2 = this.charIndex + BidiFormatter.DIR_LTR;
                this.charIndex = i2;
                this.lastChar = str.charAt(i2);
                if (this.lastChar != '&') {
                    if (this.lastChar == ';') {
                        break;
                    }
                }
                return (byte) 12;
            }
            this.charIndex = i;
            this.lastChar = ';';
            return (byte) 13;
        }
    }

    static {
        DEFAULT_TEXT_DIRECTION_HEURISTIC = TextDirectionHeuristicsCompat.FIRSTSTRONG_LTR;
        LRM_STRING = Character.toString(LRM);
        RLM_STRING = Character.toString(RLM);
        DEFAULT_LTR_INSTANCE = new BidiFormatter(false, FLAG_STEREO_RESET, DEFAULT_TEXT_DIRECTION_HEURISTIC);
        DEFAULT_RTL_INSTANCE = new BidiFormatter(true, FLAG_STEREO_RESET, DEFAULT_TEXT_DIRECTION_HEURISTIC);
    }

    public static BidiFormatter getInstance() {
        return new Builder().build();
    }

    public static BidiFormatter getInstance(boolean z) {
        return new Builder(z).build();
    }

    public static BidiFormatter getInstance(Locale locale) {
        return new Builder(locale).build();
    }

    private BidiFormatter(boolean z, int i, TextDirectionHeuristicCompat textDirectionHeuristicCompat) {
        this.mIsRtlContext = z;
        this.mFlags = i;
        this.mDefaultTextDirectionHeuristicCompat = textDirectionHeuristicCompat;
    }

    public final boolean isRtlContext() {
        return this.mIsRtlContext;
    }

    public final boolean getStereoReset() {
        return (this.mFlags & FLAG_STEREO_RESET) != 0;
    }

    private String markAfter(String str, TextDirectionHeuristicCompat textDirectionHeuristicCompat) {
        boolean isRtl = textDirectionHeuristicCompat.isRtl((CharSequence) str, (int) DIR_UNKNOWN, str.length());
        if (!this.mIsRtlContext && (isRtl || getExitDir(str) == DIR_RTL)) {
            return LRM_STRING;
        }
        if (!this.mIsRtlContext || (isRtl && getExitDir(str) != DIR_LTR)) {
            return EMPTY_STRING;
        }
        return RLM_STRING;
    }

    private String markBefore(String str, TextDirectionHeuristicCompat textDirectionHeuristicCompat) {
        boolean isRtl = textDirectionHeuristicCompat.isRtl((CharSequence) str, (int) DIR_UNKNOWN, str.length());
        if (!this.mIsRtlContext && (isRtl || getEntryDir(str) == DIR_RTL)) {
            return LRM_STRING;
        }
        if (!this.mIsRtlContext || (isRtl && getEntryDir(str) != DIR_LTR)) {
            return EMPTY_STRING;
        }
        return RLM_STRING;
    }

    public final boolean isRtl(String str) {
        return this.mDefaultTextDirectionHeuristicCompat.isRtl((CharSequence) str, (int) DIR_UNKNOWN, str.length());
    }

    public final String unicodeWrap(String str, TextDirectionHeuristicCompat textDirectionHeuristicCompat, boolean z) {
        boolean isRtl = textDirectionHeuristicCompat.isRtl((CharSequence) str, (int) DIR_UNKNOWN, str.length());
        StringBuilder stringBuilder = new StringBuilder();
        if (getStereoReset() && z) {
            stringBuilder.append(markBefore(str, isRtl ? TextDirectionHeuristicsCompat.RTL : TextDirectionHeuristicsCompat.LTR));
        }
        if (isRtl != this.mIsRtlContext) {
            stringBuilder.append(isRtl ? RLE : LRE);
            stringBuilder.append(str);
            stringBuilder.append(PDF);
        } else {
            stringBuilder.append(str);
        }
        if (z) {
            stringBuilder.append(markAfter(str, isRtl ? TextDirectionHeuristicsCompat.RTL : TextDirectionHeuristicsCompat.LTR));
        }
        return stringBuilder.toString();
    }

    public final String unicodeWrap(String str, TextDirectionHeuristicCompat textDirectionHeuristicCompat) {
        return unicodeWrap(str, textDirectionHeuristicCompat, true);
    }

    public final String unicodeWrap(String str, boolean z) {
        return unicodeWrap(str, this.mDefaultTextDirectionHeuristicCompat, z);
    }

    public final String unicodeWrap(String str) {
        return unicodeWrap(str, this.mDefaultTextDirectionHeuristicCompat, true);
    }

    private static boolean isRtlLocale(Locale locale) {
        return TextUtilsCompat.getLayoutDirectionFromLocale(locale) == DIR_RTL;
    }

    private static int getExitDir(String str) {
        return new DirectionalityEstimator(str, false).getExitDir();
    }

    private static int getEntryDir(String str) {
        return new DirectionalityEstimator(str, false).getEntryDir();
    }
}

package com.google.android.gms.analytics;

public class ae {
    private static GoogleAnalytics BL;
    private static volatile boolean BM;
    private static Logger BN;

    static {
        BM = false;
    }

    private ae() {
    }

    public static void m1485T(String str) {
        Logger logger = getLogger();
        if (logger != null) {
            logger.error(str);
        }
    }

    public static void m1486U(String str) {
        Logger logger = getLogger();
        if (logger != null) {
            logger.info(str);
        }
    }

    public static void m1487V(String str) {
        Logger logger = getLogger();
        if (logger != null) {
            logger.verbose(str);
        }
    }

    public static void m1488W(String str) {
        Logger logger = getLogger();
        if (logger != null) {
            logger.warn(str);
        }
    }

    public static boolean ff() {
        return getLogger() != null && getLogger().getLogLevel() == 0;
    }

    static Logger getLogger() {
        synchronized (ae.class) {
            if (BM) {
                if (BN == null) {
                    BN = new C0404p();
                }
                Logger logger = BN;
                return logger;
            }
            if (BL == null) {
                BL = GoogleAnalytics.eY();
            }
            if (BL != null) {
                logger = BL.getLogger();
                return logger;
            }
            return null;
        }
    }
}

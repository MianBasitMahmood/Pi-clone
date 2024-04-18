package com.chartboost.sdk.impl;

import java.nio.ByteOrder;
import java.util.logging.Level;
import java.util.logging.Logger;

public class bt extends cg {
    static final Logger f786a;
    static final boolean f787b;
    public static final ByteOrder f788c;
    static final int f789d;
    static final cy f790e;

    static {
        f786a = Logger.getLogger("com.mongodb");
        f787b = Boolean.getBoolean("DEBUG.MONGO");
        if (f786a.getLevel() == null) {
            if (f787b) {
                f786a.setLevel(Level.ALL);
            } else {
                f786a.setLevel(Level.WARNING);
            }
        }
        f788c = ByteOrder.LITTLE_ENDIAN;
        f789d = Integer.parseInt(System.getProperty("MONGO.POOLSIZE", "10"));
        f790e = new cy(-1, -1, -1);
    }
}

package com.google.android.gms.internal;

import android.support.v4.media.TransportMediator;
import android.support.v4.view.MotionEventCompat;
import com.google.android.gms.cast.Cast;
import com.google.android.gms.wallet.fragment.Dimension;
import com.google.android.gms.wallet.fragment.WalletFragmentState;
import com.google.android.gms.wearable.DataEvent;
import java.io.IOException;

public final class qo {
    private int ayM;
    private int ayN;
    private int ayO;
    private int ayP;
    private int ayQ;
    private int ayR;
    private int ayS;
    private int ayT;
    private int ayU;
    private final byte[] buffer;

    private qo(byte[] bArr, int i, int i2) {
        this.ayR = Integer.MAX_VALUE;
        this.ayT = 64;
        this.ayU = 67108864;
        this.buffer = bArr;
        this.ayM = i;
        this.ayN = i + i2;
        this.ayP = i;
    }

    public static long m5930A(long j) {
        return (j >>> 1) ^ (-(1 & j));
    }

    public static qo m5931a(byte[] bArr, int i, int i2) {
        return new qo(bArr, i, i2);
    }

    public static int gR(int i) {
        return (i >>> 1) ^ (-(i & 1));
    }

    public static qo m5932p(byte[] bArr) {
        return m5931a(bArr, 0, bArr.length);
    }

    private void rK() {
        this.ayN += this.ayO;
        int i = this.ayN;
        if (i > this.ayR) {
            this.ayO = i - this.ayR;
            this.ayN -= this.ayO;
            return;
        }
        this.ayO = 0;
    }

    public final void m5933a(qw qwVar) throws IOException {
        int rG = rG();
        if (this.ayS >= this.ayT) {
            throw qv.rX();
        }
        rG = gS(rG);
        this.ayS++;
        qwVar.m2147b(this);
        gP(0);
        this.ayS--;
        gT(rG);
    }

    public final void m5934a(qw qwVar, int i) throws IOException {
        if (this.ayS >= this.ayT) {
            throw qv.rX();
        }
        this.ayS++;
        qwVar.m2147b(this);
        gP(qz.m6008y(i, 4));
        this.ayS--;
    }

    public final void gP(int i) throws qv {
        if (this.ayQ != i) {
            throw qv.rV();
        }
    }

    public final boolean gQ(int i) throws IOException {
        switch (qz.hk(i)) {
            case WalletFragmentState.UNKNOWN /*0*/:
                rC();
                return true;
            case DataEvent.TYPE_CHANGED /*1*/:
                rJ();
                return true;
            case DataEvent.TYPE_DELETED /*2*/:
                gW(rG());
                return true;
            case WalletFragmentState.PROCESSING /*3*/:
                rA();
                gP(qz.m6008y(qz.hl(i), 4));
                return true;
            case WalletFragmentState.WALLET_UNAVAILABLE /*4*/:
                return false;
            case Dimension.UNIT_MM /*5*/:
                rI();
                return true;
            default:
                throw qv.rW();
        }
    }

    public final int gS(int i) throws qv {
        if (i < 0) {
            throw qv.rS();
        }
        int i2 = this.ayP + i;
        int i3 = this.ayR;
        if (i2 > i3) {
            throw qv.rR();
        }
        this.ayR = i2;
        rK();
        return i3;
    }

    public final void gT(int i) {
        this.ayR = i;
        rK();
    }

    public final void gU(int i) {
        if (i > this.ayP - this.ayM) {
            throw new IllegalArgumentException("Position " + i + " is beyond current " + (this.ayP - this.ayM));
        } else if (i < 0) {
            throw new IllegalArgumentException("Bad position " + i);
        } else {
            this.ayP = this.ayM + i;
        }
    }

    public final byte[] gV(int i) throws IOException {
        if (i < 0) {
            throw qv.rS();
        } else if (this.ayP + i > this.ayR) {
            gW(this.ayR - this.ayP);
            throw qv.rR();
        } else if (i <= this.ayN - this.ayP) {
            Object obj = new byte[i];
            System.arraycopy(this.buffer, this.ayP, obj, 0, i);
            this.ayP += i;
            return obj;
        } else {
            throw qv.rR();
        }
    }

    public final void gW(int i) throws IOException {
        if (i < 0) {
            throw qv.rS();
        } else if (this.ayP + i > this.ayR) {
            gW(this.ayR - this.ayP);
            throw qv.rR();
        } else if (i <= this.ayN - this.ayP) {
            this.ayP += i;
        } else {
            throw qv.rR();
        }
    }

    public final int getPosition() {
        return this.ayP - this.ayM;
    }

    public final void rA() throws IOException {
        int rz;
        do {
            rz = rz();
            if (rz == 0) {
                return;
            }
        } while (gQ(rz));
    }

    public final long rB() throws IOException {
        return rH();
    }

    public final int rC() throws IOException {
        return rG();
    }

    public final boolean rD() throws IOException {
        return rG() != 0;
    }

    public final int rE() throws IOException {
        return gR(rG());
    }

    public final long rF() throws IOException {
        return m5930A(rH());
    }

    public final int rG() throws IOException {
        byte rN = rN();
        if (rN >= null) {
            return rN;
        }
        int i = rN & TransportMediator.KEYCODE_MEDIA_PAUSE;
        byte rN2 = rN();
        if (rN2 >= null) {
            return i | (rN2 << 7);
        }
        i |= (rN2 & TransportMediator.KEYCODE_MEDIA_PAUSE) << 7;
        rN2 = rN();
        if (rN2 >= null) {
            return i | (rN2 << 14);
        }
        i |= (rN2 & TransportMediator.KEYCODE_MEDIA_PAUSE) << 14;
        rN2 = rN();
        if (rN2 >= null) {
            return i | (rN2 << 21);
        }
        i |= (rN2 & TransportMediator.KEYCODE_MEDIA_PAUSE) << 21;
        rN2 = rN();
        i |= rN2 << 28;
        if (rN2 >= null) {
            return i;
        }
        for (int i2 = 0; i2 < 5; i2++) {
            if (rN() >= null) {
                return i;
            }
        }
        throw qv.rT();
    }

    public final long rH() throws IOException {
        long j = 0;
        for (int i = 0; i < 64; i += 7) {
            byte rN = rN();
            j |= ((long) (rN & TransportMediator.KEYCODE_MEDIA_PAUSE)) << i;
            if ((rN & Cast.MAX_NAMESPACE_LENGTH) == 0) {
                return j;
            }
        }
        throw qv.rT();
    }

    public final int rI() throws IOException {
        return (((rN() & MotionEventCompat.ACTION_MASK) | ((rN() & MotionEventCompat.ACTION_MASK) << 8)) | ((rN() & MotionEventCompat.ACTION_MASK) << 16)) | ((rN() & MotionEventCompat.ACTION_MASK) << 24);
    }

    public final long rJ() throws IOException {
        byte rN = rN();
        byte rN2 = rN();
        return ((((((((((long) rN2) & 255) << 8) | (((long) rN) & 255)) | ((((long) rN()) & 255) << 16)) | ((((long) rN()) & 255) << 24)) | ((((long) rN()) & 255) << 32)) | ((((long) rN()) & 255) << 40)) | ((((long) rN()) & 255) << 48)) | ((((long) rN()) & 255) << 56);
    }

    public final int rL() {
        if (this.ayR == Integer.MAX_VALUE) {
            return -1;
        }
        return this.ayR - this.ayP;
    }

    public final boolean rM() {
        return this.ayP == this.ayN;
    }

    public final byte rN() throws IOException {
        if (this.ayP == this.ayN) {
            throw qv.rR();
        }
        byte[] bArr = this.buffer;
        int i = this.ayP;
        this.ayP = i + 1;
        return bArr[i];
    }

    public final byte[] readBytes() throws IOException {
        int rG = rG();
        if (rG > this.ayN - this.ayP || rG <= 0) {
            return gV(rG);
        }
        Object obj = new byte[rG];
        System.arraycopy(this.buffer, this.ayP, obj, 0, rG);
        this.ayP = rG + this.ayP;
        return obj;
    }

    public final double readDouble() throws IOException {
        return Double.longBitsToDouble(rJ());
    }

    public final float readFloat() throws IOException {
        return Float.intBitsToFloat(rI());
    }

    public final String readString() throws IOException {
        int rG = rG();
        if (rG > this.ayN - this.ayP || rG <= 0) {
            return new String(gV(rG), "UTF-8");
        }
        String str = new String(this.buffer, this.ayP, rG, "UTF-8");
        this.ayP = rG + this.ayP;
        return str;
    }

    public final int rz() throws IOException {
        if (rM()) {
            this.ayQ = 0;
            return 0;
        }
        this.ayQ = rG();
        if (this.ayQ != 0) {
            return this.ayQ;
        }
        throw qv.rU();
    }

    public final byte[] m5935s(int i, int i2) {
        if (i2 == 0) {
            return qz.azq;
        }
        Object obj = new byte[i2];
        System.arraycopy(this.buffer, this.ayM + i, obj, 0, i2);
        return obj;
    }
}

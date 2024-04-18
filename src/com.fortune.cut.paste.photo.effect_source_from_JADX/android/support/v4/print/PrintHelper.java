package android.support.v4.print;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build.VERSION;
import java.io.FileNotFoundException;

public final class PrintHelper {
    public static final int COLOR_MODE_COLOR = 2;
    public static final int COLOR_MODE_MONOCHROME = 1;
    public static final int ORIENTATION_LANDSCAPE = 1;
    public static final int ORIENTATION_PORTRAIT = 2;
    public static final int SCALE_MODE_FILL = 2;
    public static final int SCALE_MODE_FIT = 1;
    PrintHelperVersionImpl mImpl;

    interface PrintHelperVersionImpl {
        int getColorMode();

        int getOrientation();

        int getScaleMode();

        void printBitmap(String str, Bitmap bitmap);

        void printBitmap(String str, Uri uri) throws FileNotFoundException;

        void setColorMode(int i);

        void setOrientation(int i);

        void setScaleMode(int i);
    }

    private static final class PrintHelperKitkatImpl implements PrintHelperVersionImpl {
        private final PrintHelperKitkat mPrintHelper;

        PrintHelperKitkatImpl(Context context) {
            this.mPrintHelper = new PrintHelperKitkat(context);
        }

        public final void setScaleMode(int i) {
            this.mPrintHelper.setScaleMode(i);
        }

        public final int getScaleMode() {
            return this.mPrintHelper.getScaleMode();
        }

        public final void setColorMode(int i) {
            this.mPrintHelper.setColorMode(i);
        }

        public final int getColorMode() {
            return this.mPrintHelper.getColorMode();
        }

        public final void setOrientation(int i) {
            this.mPrintHelper.setOrientation(i);
        }

        public final int getOrientation() {
            return this.mPrintHelper.getOrientation();
        }

        public final void printBitmap(String str, Bitmap bitmap) {
            this.mPrintHelper.printBitmap(str, bitmap);
        }

        public final void printBitmap(String str, Uri uri) throws FileNotFoundException {
            this.mPrintHelper.printBitmap(str, uri);
        }
    }

    private static final class PrintHelperStubImpl implements PrintHelperVersionImpl {
        int mColorMode;
        int mOrientation;
        int mScaleMode;

        private PrintHelperStubImpl() {
            this.mScaleMode = PrintHelper.SCALE_MODE_FILL;
            this.mColorMode = PrintHelper.SCALE_MODE_FILL;
            this.mOrientation = PrintHelper.SCALE_MODE_FIT;
        }

        public final void setScaleMode(int i) {
            this.mScaleMode = i;
        }

        public final int getColorMode() {
            return this.mColorMode;
        }

        public final void setColorMode(int i) {
            this.mColorMode = i;
        }

        public final void setOrientation(int i) {
            this.mOrientation = i;
        }

        public final int getOrientation() {
            return this.mOrientation;
        }

        public final int getScaleMode() {
            return this.mScaleMode;
        }

        public final void printBitmap(String str, Bitmap bitmap) {
        }

        public final void printBitmap(String str, Uri uri) {
        }
    }

    public static boolean systemSupportsPrint() {
        if (VERSION.SDK_INT >= 19) {
            return true;
        }
        return false;
    }

    public PrintHelper(Context context) {
        if (systemSupportsPrint()) {
            this.mImpl = new PrintHelperKitkatImpl(context);
        } else {
            this.mImpl = new PrintHelperStubImpl();
        }
    }

    public final void setScaleMode(int i) {
        this.mImpl.setScaleMode(i);
    }

    public final int getScaleMode() {
        return this.mImpl.getScaleMode();
    }

    public final void setColorMode(int i) {
        this.mImpl.setColorMode(i);
    }

    public final int getColorMode() {
        return this.mImpl.getColorMode();
    }

    public final void setOrientation(int i) {
        this.mImpl.setOrientation(i);
    }

    public final int getOrientation() {
        return this.mImpl.getOrientation();
    }

    public final void printBitmap(String str, Bitmap bitmap) {
        this.mImpl.printBitmap(str, bitmap);
    }

    public final void printBitmap(String str, Uri uri) throws FileNotFoundException {
        this.mImpl.printBitmap(str, uri);
    }
}

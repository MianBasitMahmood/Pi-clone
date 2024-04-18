package com.fortune.cut.paste.photo.effect;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import com.google.android.gms.drive.DriveFile;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;

public class InternalStorageContentProvider extends ContentProvider {
    public static final Uri f1034a;
    private static final HashMap<String, String> f1035b;

    static {
        f1034a = Uri.parse("content://eu.janmuller.android.simplecropimage.example/");
        HashMap hashMap = new HashMap();
        f1035b = hashMap;
        hashMap.put(".jpg", "image/jpeg");
        f1035b.put(".jpeg", "image/jpeg");
    }

    public boolean onCreate() {
        try {
            File file = new File(getContext().getFilesDir(), "img_cutpaste.jpg");
            if (!file.exists()) {
                file.createNewFile();
                getContext().getContentResolver().notifyChange(f1034a, null);
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public String getType(Uri uri) {
        String uri2 = uri.toString();
        for (String str : f1035b.keySet()) {
            if (uri2.endsWith(str)) {
                return (String) f1035b.get(str);
            }
        }
        return null;
    }

    public ParcelFileDescriptor openFile(Uri uri, String str) throws FileNotFoundException {
        File file = new File(getContext().getFilesDir(), "img_cutpaste.jpg");
        if (file.exists()) {
            return ParcelFileDescriptor.open(file, DriveFile.MODE_READ_WRITE);
        }
        throw new FileNotFoundException(uri.getPath());
    }

    public int delete(Uri uri, String str, String[] strArr) {
        return 0;
    }

    public Uri insert(Uri uri, ContentValues contentValues) {
        return null;
    }

    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        return null;
    }

    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return 0;
    }
}

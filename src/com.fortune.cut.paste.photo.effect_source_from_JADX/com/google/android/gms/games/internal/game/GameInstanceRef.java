package com.google.android.gms.games.internal.game;

import com.google.android.gms.common.data.C0451d;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.internal.constants.PlatformType;
import com.google.android.gms.internal.jv;

public final class GameInstanceRef extends C0451d implements GameInstance {
    GameInstanceRef(DataHolder dataHolder, int i) {
        super(dataHolder, i);
    }

    public final String getApplicationId() {
        return getString("external_game_id");
    }

    public final String getDisplayName() {
        return getString("instance_display_name");
    }

    public final String getPackageName() {
        return getString("package_name");
    }

    public final int jC() {
        return getInteger("platform_type");
    }

    public final boolean ml() {
        return getInteger("real_time_support") > 0;
    }

    public final boolean mm() {
        return getInteger("turn_based_support") > 0;
    }

    public final boolean mn() {
        return getInteger("piracy_check") > 0;
    }

    public final boolean mo() {
        return getInteger("installed") > 0;
    }

    public final String toString() {
        return jv.m5212h(this).m5211a("ApplicationId", getApplicationId()).m5211a("DisplayName", getDisplayName()).m5211a("SupportsRealTime", Boolean.valueOf(ml())).m5211a("SupportsTurnBased", Boolean.valueOf(mm())).m5211a("PlatformType", PlatformType.dZ(jC())).m5211a("PackageName", getPackageName()).m5211a("PiracyCheckEnabled", Boolean.valueOf(mn())).m5211a("Installed", Boolean.valueOf(mo())).toString();
    }
}

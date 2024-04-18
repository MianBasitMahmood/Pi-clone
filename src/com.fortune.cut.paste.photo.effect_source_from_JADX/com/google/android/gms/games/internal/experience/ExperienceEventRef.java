package com.google.android.gms.games.internal.experience;

import com.google.android.gms.common.data.C0451d;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.GameRef;

public final class ExperienceEventRef extends C0451d implements ExperienceEvent {
    private final GameRef acr;

    public ExperienceEventRef(DataHolder dataHolder, int i) {
        super(dataHolder, i);
        if (aS("external_game_id")) {
            this.acr = null;
        } else {
            this.acr = new GameRef(this.JG, this.KZ);
        }
    }

    public final String getIconImageUrl() {
        return getString("icon_url");
    }
}

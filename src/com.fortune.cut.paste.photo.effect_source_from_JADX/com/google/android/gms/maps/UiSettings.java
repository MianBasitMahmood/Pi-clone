package com.google.android.gms.maps;

import android.os.RemoteException;
import com.google.android.gms.maps.internal.IUiSettingsDelegate;
import com.google.android.gms.maps.model.RuntimeRemoteException;

public final class UiSettings {
    private final IUiSettingsDelegate alH;

    UiSettings(IUiSettingsDelegate iUiSettingsDelegate) {
        this.alH = iUiSettingsDelegate;
    }

    public final boolean isCompassEnabled() {
        try {
            return this.alH.isCompassEnabled();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final boolean isIndoorLevelPickerEnabled() {
        try {
            return this.alH.isIndoorLevelPickerEnabled();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final boolean isMapToolbarEnabled() {
        try {
            return this.alH.isMapToolbarEnabled();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final boolean isMyLocationButtonEnabled() {
        try {
            return this.alH.isMyLocationButtonEnabled();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final boolean isRotateGesturesEnabled() {
        try {
            return this.alH.isRotateGesturesEnabled();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final boolean isScrollGesturesEnabled() {
        try {
            return this.alH.isScrollGesturesEnabled();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final boolean isTiltGesturesEnabled() {
        try {
            return this.alH.isTiltGesturesEnabled();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final boolean isZoomControlsEnabled() {
        try {
            return this.alH.isZoomControlsEnabled();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final boolean isZoomGesturesEnabled() {
        try {
            return this.alH.isZoomGesturesEnabled();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void setAllGesturesEnabled(boolean z) {
        try {
            this.alH.setAllGesturesEnabled(z);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void setCompassEnabled(boolean z) {
        try {
            this.alH.setCompassEnabled(z);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void setIndoorLevelPickerEnabled(boolean z) {
        try {
            this.alH.setIndoorLevelPickerEnabled(z);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void setMapToolbarEnabled(boolean z) {
        try {
            this.alH.setMapToolbarEnabled(z);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void setMyLocationButtonEnabled(boolean z) {
        try {
            this.alH.setMyLocationButtonEnabled(z);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void setRotateGesturesEnabled(boolean z) {
        try {
            this.alH.setRotateGesturesEnabled(z);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void setScrollGesturesEnabled(boolean z) {
        try {
            this.alH.setScrollGesturesEnabled(z);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void setTiltGesturesEnabled(boolean z) {
        try {
            this.alH.setTiltGesturesEnabled(z);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void setZoomControlsEnabled(boolean z) {
        try {
            this.alH.setZoomControlsEnabled(z);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void setZoomGesturesEnabled(boolean z) {
        try {
            this.alH.setZoomGesturesEnabled(z);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }
}

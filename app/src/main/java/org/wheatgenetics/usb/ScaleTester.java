package org.wheatgenetics.usb;

/**
 * Uses:
 * android.app.Activity
 * android.support.annotation.NonNull
 *
 * org.wheatgenetics.usb.ExtraDevice
 */

public class ScaleTester extends java.lang.Object
{
    private final android.app.Activity              activity                  ;
    private       org.wheatgenetics.usb.ExtraDevice extraDeviceInstance = null;

    private org.wheatgenetics.usb.ExtraDevice extraDevice()
    {
        if (null == this.extraDeviceInstance)
            this.extraDeviceInstance = new org.wheatgenetics.usb.ExtraDevice(this.activity, 519);
        return this.extraDeviceInstance;
    }

    public ScaleTester(@android.support.annotation.NonNull final android.app.Activity activity)
    {
        super();

        assert null != activity;
        this.activity = activity;
    }

    public java.lang.String information() { return this.extraDevice().information(); }
}
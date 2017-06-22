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

    public java.lang.String read()
    {
        final byte buffer[]    = new byte[128]                  ;
        final int  returnValue = this.extraDevice().read(buffer);

        if (returnValue > 0)
            return java.lang.String.format(
                "length: %d, buffer: %s", returnValue, buffer.toString());
        else
            return java.lang.String.format("length: %d", returnValue);
    }
}
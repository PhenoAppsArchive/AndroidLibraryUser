package org.wheatgenetics.usb;

/**
 * Uses:
 * android.app.Activity
 * android.support.annotation.NonNull
 * android.support.annotation.RestrictTo
 * android.support.annotation.RestrictTo.Scope
 *
 * org.wheatgenetics.usb.ExtraDevice
 * org.wheatgenetics.usb.ExtraDeviceTester
 * org.wheatgenetics.usb.Scale
 */
public class ScaleTester extends org.wheatgenetics.usb.ExtraDeviceTester
{
    @android.support.annotation.RestrictTo(android.support.annotation.RestrictTo.Scope.SUBCLASSES)
    @java.lang.Override org.wheatgenetics.usb.ExtraDevice extraDevice()
    {
        if (null == this.extraDeviceInstance)
            this.extraDeviceInstance = new org.wheatgenetics.usb.Scale(this.getActivity());
        return this.extraDeviceInstance;
    }

    public ScaleTester(@android.support.annotation.NonNull final android.app.Activity activity)
    { super(activity); }
}
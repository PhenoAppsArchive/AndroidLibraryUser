package org.wheatgenetics.usb;

/**
 * Uses:
 * android.app.Activity
 *
 * androidx.annotation.NonNull
 * androidx.annotation.RestrictTo
 * androidx.annotation.RestrictTo.Scope
 *
 * org.wheatgenetics.usb.ExtraDevice
 * org.wheatgenetics.usb.ExtraDeviceTester
 * org.wheatgenetics.usb.Scale
 */
public class ScaleTester extends org.wheatgenetics.usb.ExtraDeviceTester
{
    @androidx.annotation.RestrictTo(androidx.annotation.RestrictTo.Scope.SUBCLASSES)
    @java.lang.Override org.wheatgenetics.usb.ExtraDevice extraDevice()
    {
        if (null == this.extraDeviceInstance)
            this.extraDeviceInstance = new org.wheatgenetics.usb.Scale(this.getActivity());
        return this.extraDeviceInstance;
    }

    public ScaleTester(@androidx.annotation.NonNull final android.app.Activity activity)
    { super(activity); }
}
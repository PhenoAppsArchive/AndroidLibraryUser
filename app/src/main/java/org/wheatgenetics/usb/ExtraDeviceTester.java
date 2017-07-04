package org.wheatgenetics.usb;

/**
 * Uses:
 * android.app.Activity
 * android.support.annotation.NonNull
 *
 * org.wheatgenetics.usb.Device.Exception
 * org.wheatgenetics.usb.ExtraDevice
 */

public class ExtraDeviceTester extends java.lang.Object
{
    // region Fields
    private final android.app.Activity              activity                  ;
                  org.wheatgenetics.usb.ExtraDevice extraDeviceInstance = null;
    // endregion

    // region Package Methods
    android.app.Activity getActivity() { return this.activity; }

    org.wheatgenetics.usb.ExtraDevice extraDevice()
    {
        if (null == this.extraDeviceInstance) this.extraDeviceInstance =
            new org.wheatgenetics.usb.ExtraDevice(this.getActivity(), /* productId => */ 513);
        return this.extraDeviceInstance;
    }
    // endregion

    // region Public Methods
    public ExtraDeviceTester(
    @android.support.annotation.NonNull final android.app.Activity activity)
    {
        super();

        assert null != activity;
        this.activity = activity;
    }

    public java.lang.String information()
    { return "information: " + this.extraDevice().information(); }

    public java.lang.String handlingFormattedRead()
    {
        try { return this.extraDevice().formattedRead(); }
        catch (final org.wheatgenetics.usb.Device.Exception e) { return e.getMessage(); }
    }
    // endregion
}
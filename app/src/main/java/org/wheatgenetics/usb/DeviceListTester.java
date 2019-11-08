package org.wheatgenetics.usb;

/**
 * Uses:
 * android.annotation.SuppressLint
 * android.app.Activity
 *
 * androidx.annotation.NonNull
 *
 * org.wheatgenetics.usb.DeviceList
 */
@java.lang.SuppressWarnings({"ClassExplicitlyExtendsObject"})
public class DeviceListTester extends java.lang.Object
{
    // region Fields
    private final android.app.Activity             activity                 ;
    private       org.wheatgenetics.usb.DeviceList deviceListInstance = null;
    // endregion

    private org.wheatgenetics.usb.DeviceList deviceList()
    {
        if (null == this.deviceListInstance)
            this.deviceListInstance = new org.wheatgenetics.usb.DeviceList(this.activity);
        return this.deviceListInstance;
    }

    public DeviceListTester(@androidx.annotation.NonNull final android.app.Activity activity)
    { super(); this.activity = activity; }

    // region Public Methods
    @android.annotation.SuppressLint({"DefaultLocale"}) public java.lang.String size()
    { return java.lang.String.format("size: %d", this.deviceList().size()); }

    public java.lang.String information()
    { return "information: " + this.deviceList().information(); }
    // endregion
}
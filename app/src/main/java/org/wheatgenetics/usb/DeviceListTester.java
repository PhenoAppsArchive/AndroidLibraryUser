package org.wheatgenetics.usb;

/**
 * Uses:
 * android.app.Activity
 * android.support.annotation.NonNull
 *
 * org.wheatgenetics.usb.DeviceList
 */

public class DeviceListTester extends java.lang.Object
{
    private final android.app.Activity             activity                 ;
    private       org.wheatgenetics.usb.DeviceList deviceListInstance = null;

    private org.wheatgenetics.usb.DeviceList deviceList()
    {
        if (null == this.deviceListInstance)
            this.deviceListInstance = new org.wheatgenetics.usb.DeviceList(this.activity);
        return this.deviceListInstance;
    }

    public DeviceListTester(@android.support.annotation.NonNull final android.app.Activity activity)
    {
        super();

        assert null != activity;
        this.activity = activity;
    }

    public java.lang.String size()
    { return java.lang.String.format("size: %d", this.deviceList() .size()); }

    public java.lang.String information() { return this.deviceList().information(); }
}
package org.wheatgenetics.usb;

/**
 * Uses:
 * android.hardware.usb.UsbManager
 * android.support.annotation.NonNull
 *
 * org.wheatgenetics.usb.DeviceList
 */

public class DeviceListTester extends java.lang.Object
{
    private final android.hardware.usb.UsbManager  usbManager               ;
    private       org.wheatgenetics.usb.DeviceList deviceListInstance = null;

    private org.wheatgenetics.usb.DeviceList deviceList()
    {
        if (null == this.deviceListInstance)
            this.deviceListInstance = new org.wheatgenetics.usb.DeviceList(this.usbManager);
        return this.deviceListInstance;
    }

    public DeviceListTester(@android.support.annotation.NonNull
    final android.hardware.usb.UsbManager usbManager)
    {
        super();

        assert null != usbManager;
        this.usbManager = usbManager;
    }

    public java.lang.String size()
    { return java.lang.String.format("size: %d", this.deviceList() .size()); }

    public java.lang.String devices() { return "devices: " + this.deviceList().toString(); }
}
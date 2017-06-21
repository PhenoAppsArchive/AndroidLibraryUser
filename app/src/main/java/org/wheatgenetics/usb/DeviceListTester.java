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
    private final android.hardware.usb.UsbManager  usbManager       ;
    private       org.wheatgenetics.usb.DeviceList deviceList = null;

    public DeviceListTester(@android.support.annotation.NonNull
    final android.hardware.usb.UsbManager usbManager)
    {
        super();

        assert null != usbManager;
        this.usbManager = usbManager;
    }

    public java.lang.String testSize()
    {
        if (null == this.deviceList)
            this.deviceList = new org.wheatgenetics.usb.DeviceList(this.usbManager);
        return java.lang.String.format("deviceList.size() == %d", this.deviceList.size());
    }
}
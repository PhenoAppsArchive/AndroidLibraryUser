package org.wheatgenetics.usb;

/**
 * Uses:
 * android.app.Activity
 * android.support.annotation.NonNull
 *
 * org.wheatgenetics.usb.Device.Exception
 * org.wheatgenetics.usb.DeviceReader
 * org.wheatgenetics.usb.DeviceReader.Handler
 * org.wheatgenetics.usb.ExtraDevice
 */

public class ScaleTester extends java.lang.Object
{
    public interface Displayer { public abstract void display(java.lang.String s); }

    // region Fields
    private final android.app.Activity                        activity ;
    private final org.wheatgenetics.usb.ScaleTester.Displayer displayer;

    private org.wheatgenetics.usb.ExtraDevice  extraDeviceInstance  = null;
    private org.wheatgenetics.usb.DeviceReader deviceReaderInstance = null;
    // endregion

    // region Private Methods
    private org.wheatgenetics.usb.ExtraDevice extraDevice()
    {
        if (null == this.extraDeviceInstance)
            this.extraDeviceInstance = new org.wheatgenetics.usb.ExtraDevice(this.activity, 513);
        return this.extraDeviceInstance;
    }

    private java.lang.String formattedRead() throws org.wheatgenetics.usb.Device.Exception
    { return this.extraDevice().formattedRead(); }

    private void display(final java.lang.String s)
    {
        assert null != this.displayer;
        this.displayer.display(s);
    }

    private org.wheatgenetics.usb.DeviceReader deviceReader()
    {
        if (null == this.deviceReaderInstance)
            this.deviceReaderInstance = new org.wheatgenetics.usb.DeviceReader(
                new org.wheatgenetics.usb.DeviceReader.Handler()
                {
                    @java.lang.Override
                    public java.lang.String formattedRead()
                    throws org.wheatgenetics.usb.Device.Exception
                    { return org.wheatgenetics.usb.ScaleTester.this.formattedRead(); }

                    @java.lang.Override
                    public void publish(final java.lang.String data)
                    { org.wheatgenetics.usb.ScaleTester.this.display(data); }

                    @java.lang.Override
                    public void reportError(final java.lang.String message)
                    { org.wheatgenetics.usb.ScaleTester.this.display(message); }
                });
        return this.deviceReaderInstance;
    }
    // endregion

    // region Public Methods
    public ScaleTester(@android.support.annotation.NonNull final android.app.Activity activity,
    @android.support.annotation.NonNull final org.wheatgenetics.usb.ScaleTester.Displayer displayer)
    {
        super();

        assert null != activity;
        this.activity = activity;

        assert null != displayer;
        this.displayer = displayer;
    }

    public java.lang.String information()
    { return "information: " + this.extraDevice().information(); }

    public java.lang.String handlingFormattedRead()
    {
        try                                                    { return this.formattedRead(); }
        catch (final org.wheatgenetics.usb.Device.Exception e) { return e.getMessage()      ; }
    }

    public void    executeReader() { this.deviceReader().execute()      ; }
    public boolean cancelReader () { return this.deviceReader().cancel(); }
    // endregion
}
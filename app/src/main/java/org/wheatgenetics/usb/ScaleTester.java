package org.wheatgenetics.usb;

/**
 * Uses:
 * android.app.Activity
 * android.support.annotation.NonNull
 *
 * org.wheatgenetics.usb.Device.Exception
 * org.wheatgenetics.usb.Device.Handler
 * org.wheatgenetics.usb.ExtraDevice
 */

public class ScaleTester extends java.lang.Object
{
    public interface Displayer { public abstract void display(java.lang.String s); }

    private final android.app.Activity                        activity ;
    private final org.wheatgenetics.usb.ScaleTester.Displayer displayer;

    private org.wheatgenetics.usb.ExtraDevice extraDeviceInstance = null;

    private void display(final java.lang.String s)
    {
        assert null != this.displayer;
        this.displayer.display(s);
    }

    private org.wheatgenetics.usb.ExtraDevice extraDevice()
    {
        if (null == this.extraDeviceInstance)
            this.extraDeviceInstance = new org.wheatgenetics.usb.ExtraDevice(this.activity, 513,
                new org.wheatgenetics.usb.Device.Handler()
                {
                    @java.lang.Override
                    public void publish(final byte[] buffer)
                    { org.wheatgenetics.usb.ScaleTester.this.display(buffer.toString()); }

                    @java.lang.Override
                    public void reportError(final java.lang.String message)
                    { org.wheatgenetics.usb.ScaleTester.this.display(message); }
                });
        return this.extraDeviceInstance;
    }

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

    public java.lang.String read()
    {
        final byte buffer[] = new byte[128];
              int  length                  ;
        try { length = this.extraDevice().read(buffer); }
        catch (final org.wheatgenetics.usb.Device.Exception e) { return e.getMessage(); }
        return java.lang.String.format("length: %d, buffer: %s", length, buffer.toString());
    }

    public void readContinuously() { this.extraDevice().readContinuously(); }
}
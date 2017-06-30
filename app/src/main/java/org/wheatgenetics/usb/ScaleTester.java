package org.wheatgenetics.usb;

/**
 * Uses:
 * android.app.Activity
 * android.support.annotation.NonNull
 *
 * org.wheatgenetics.usb.Device.Exception
 * org.wheatgenetics.usb.Scale
 */

public class ScaleTester extends java.lang.Object
{
    // region Fields
    private final android.app.Activity        activity            ;
    private       org.wheatgenetics.usb.Scale scaleInstance = null;
    // endregion

    private org.wheatgenetics.usb.Scale scale()
    {
        if (null == this.scaleInstance)
            this.scaleInstance = new org.wheatgenetics.usb.Scale(this.activity);
        return this.scaleInstance;
    }

    // region Public Methods
    public ScaleTester(@android.support.annotation.NonNull final android.app.Activity activity)
    {
        super();

        assert null != activity;
        this.activity = activity;
    }

    public java.lang.String information() { return "information: " + this.scale().information(); }

    public java.lang.String handlingFormattedRead()
    {
        try { return this.scale().formattedRead(); }
        catch (final org.wheatgenetics.usb.Device.Exception e) { return e.getMessage(); }
    }
    // endregion
}
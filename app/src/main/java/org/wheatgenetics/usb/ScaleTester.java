package org.wheatgenetics.usb;

/**
 * Uses:
 * android.app.Activity
 * android.support.annotation.NonNull
 *
 * org.wheatgenetics.usb.Device.Exception
 * org.wheatgenetics.usb.Scale
 * org.wheatgenetics.usb.ScaleReader
 * org.wheatgenetics.usb.ScaleReader.Handler
 */

public class ScaleTester extends java.lang.Object
{
    public interface Displayer { public abstract void display(java.lang.String s); }

    // region Fields
    private final android.app.Activity                        activity ;
    private final org.wheatgenetics.usb.ScaleTester.Displayer displayer;

    private org.wheatgenetics.usb.Scale       scaleInstance       = null;
    private org.wheatgenetics.usb.ScaleReader scaleReaderInstance = null;
    // endregion

    // region Private Methods
    private org.wheatgenetics.usb.Scale scale()
    {
        if (null == this.scaleInstance)
            this.scaleInstance = new org.wheatgenetics.usb.Scale(this.activity);
        return this.scaleInstance;
    }

    private java.lang.String formattedRead() throws org.wheatgenetics.usb.Device.Exception
    { return this.scale().formattedRead(); }

    private void display(final java.lang.String s)
    {
        assert null != this.displayer;
        this.displayer.display(s);
    }

    private org.wheatgenetics.usb.ScaleReader scaleReader()
    {
        if (null == this.scaleReaderInstance)
            this.scaleReaderInstance = new org.wheatgenetics.usb.ScaleReader(this.activity,
                new org.wheatgenetics.usb.ScaleReader.Handler()
                {
                    @java.lang.Override
                    public void publish(final java.lang.String data)
                    { org.wheatgenetics.usb.ScaleTester.this.display(data); }

                    @java.lang.Override
                    public void reportException(final java.lang.String message)
                    { org.wheatgenetics.usb.ScaleTester.this.display(message); }
                });
        return this.scaleReaderInstance;
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

    public java.lang.String information() { return "information: " + this.scale().information(); }

    public java.lang.String handlingFormattedRead()
    {
        try                                                    { return this.formattedRead(); }
        catch (final org.wheatgenetics.usb.Device.Exception e) { return e.getMessage()      ; }
    }

    public void    executeReader() {        this.scaleReader().execute(); }
    public boolean cancelReader () { return this.scaleReader().cancel (); }
    // endregion
}
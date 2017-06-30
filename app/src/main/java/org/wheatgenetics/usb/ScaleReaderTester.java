package org.wheatgenetics.usb;

/**
 * Uses:
 * android.app.Activity
 * android.support.annotation.NonNull
 *
 * org.wheatgenetics.usb.ScaleReader
 * org.wheatgenetics.usb.ScaleReader.Handler
 *
 */

public class ScaleReaderTester extends java.lang.Object
{
    public interface Displayer { public abstract void display(java.lang.String s); }

    // region Fields
    private final android.app.Activity                              activity ;
    private final org.wheatgenetics.usb.ScaleReaderTester.Displayer displayer;

    private org.wheatgenetics.usb.ScaleReader scaleReaderInstance = null;
    // endregion

    // region Private Methods
    private org.wheatgenetics.usb.ScaleReader scaleReader()
    {
        if (null == this.scaleReaderInstance)
            this.scaleReaderInstance = new org.wheatgenetics.usb.ScaleReader(this.activity,
                new org.wheatgenetics.usb.ScaleReader.Handler()
                {
                    @java.lang.Override
                    public void publish(final java.lang.String data)
                    { org.wheatgenetics.usb.ScaleReaderTester.this.display(data); }

                    @java.lang.Override
                    public void reportException(final java.lang.String message)
                    { org.wheatgenetics.usb.ScaleReaderTester.this.display(message); }
                });
        return this.scaleReaderInstance;
    }

    private void display(final java.lang.String s)
    {
        assert null != this.displayer;
        this.displayer.display(s);
    }
    // endregion

    // region Public Methods
    public ScaleReaderTester(
    @android.support.annotation.NonNull final android.app.Activity activity,
    @android.support.annotation.NonNull
        final org.wheatgenetics.usb.ScaleReaderTester.Displayer displayer)
    {
        super();

        assert null != activity;
        this.activity = activity;

        assert null != displayer;
        this.displayer = displayer;
    }

    public void    executeReader() {        this.scaleReader().execute(); }
    public boolean cancelReader () { return this.scaleReader().cancel (); }
    // endregion
}
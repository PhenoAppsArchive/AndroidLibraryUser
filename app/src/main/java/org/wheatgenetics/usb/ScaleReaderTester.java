package org.wheatgenetics.usb;

/**
 * Uses:
 * android.app.Activity
 * android.support.annotation.NonNull
 *
 * org.wheatgenetics.usb.ScaleReader
 * org.wheatgenetics.usb.ScaleReader.Handler
 * org.wheatgenetics.usb.ScaleExceptionAlertDialog
 * org.wheatgenetics.usb.ScaleExceptionAlertDialog.Handler
 */

public class ScaleReaderTester extends java.lang.Object
{
    public interface Publisher { public abstract void publish(java.lang.String data); }

    // region Fields
    private final android.app.Activity                              activity ;
    private final org.wheatgenetics.usb.ScaleReaderTester.Publisher publisher;

    private org.wheatgenetics.usb.ScaleReader scaleReaderInstance                     = null;
    private org.wheatgenetics.usb.ScaleExceptionAlertDialog scaleExceptionAlertDialog = null;
    // endregion

    // region Private Methods
    private void publish(final java.lang.String data)
    {
        assert null != this.publisher;
        this.publisher.publish(data);
    }

    private org.wheatgenetics.usb.ScaleReader scaleReader()
    {
        if (null == this.scaleReaderInstance)
            this.scaleReaderInstance = new org.wheatgenetics.usb.ScaleReader(this.activity,
                new org.wheatgenetics.usb.ScaleReader.Handler()
                {
                    @java.lang.Override
                    public void publish(final java.lang.String data)
                    { org.wheatgenetics.usb.ScaleReaderTester.this.publish(data); }

                    @java.lang.Override
                    public void reportException(final java.lang.String message)
                    { org.wheatgenetics.usb.ScaleReaderTester.this.reportException(message); }
                });
        return this.scaleReaderInstance;
    }

    private void reportException(final java.lang.String message)
    {
        this.scaleReader().cancel();
        if (null == this.scaleExceptionAlertDialog) this.scaleExceptionAlertDialog =
            new org.wheatgenetics.usb.ScaleExceptionAlertDialog(this.activity,
                new org.wheatgenetics.usb.ScaleExceptionAlertDialog.Handler()
                {
                    @java.lang.Override
                    public void tryAgain()
                    { org.wheatgenetics.usb.ScaleReaderTester.this.executeReader(); }

                    @java.lang.Override
                    public void ignore() {}
                });
        this.scaleExceptionAlertDialog.show(message);
    }
    // endregion

    // region Public Methods
    public ScaleReaderTester(
    @android.support.annotation.NonNull final android.app.Activity activity,
    @android.support.annotation.NonNull
        final org.wheatgenetics.usb.ScaleReaderTester.Publisher publisher)
    {
        super();

        assert null != activity;
        this.activity = activity;

        assert null != publisher;
        this.publisher = publisher;
    }

    public void    executeReader() {        this.scaleReader().execute(); }
    public boolean cancelReader () { return this.scaleReader().cancel (); }
    // endregion
}
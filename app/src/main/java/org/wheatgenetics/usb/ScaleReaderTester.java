package org.wheatgenetics.usb;

/**
 * Uses:
 * android.app.Activity
 *
 * androidx.annotation.NonNull
 *
 * org.wheatgenetics.usb.Device.Exception
 * org.wheatgenetics.usb.DeviceReader
 * org.wheatgenetics.usb.ScaleReader
 * org.wheatgenetics.usb.ScaleReader.Handler
 * org.wheatgenetics.usb.ScaleExceptionAlertDialog
 * org.wheatgenetics.usb.ScaleExceptionAlertDialog.Handler
 *
 * org.wheatgenetics.usb.DeviceReaderTester
 * org.wheatgenetics.usb.DeviceReaderTester.Publisher
 */
public class ScaleReaderTester extends org.wheatgenetics.usb.DeviceReaderTester
{
    private org.wheatgenetics.usb.ScaleExceptionAlertDialog scaleExceptionAlertDialog = null;

    private void reportException(final org.wheatgenetics.usb.Device.Exception e)
    {
        this.cancelReader();
        if (null == this.scaleExceptionAlertDialog) this.scaleExceptionAlertDialog =
            new org.wheatgenetics.usb.ScaleExceptionAlertDialog(this.getActivity(),
                new org.wheatgenetics.usb.ScaleExceptionAlertDialog.Handler()
                {
                    @java.lang.Override public void tryAgain()
                    { org.wheatgenetics.usb.ScaleReaderTester.this.executeReader(); }

                    @java.lang.Override public void ignore() {}
                });
        this.scaleExceptionAlertDialog.testingShow(e);
    }

    @java.lang.Override org.wheatgenetics.usb.DeviceReader deviceReader()
    {
        if (null == this.deviceReaderInstance)
            this.deviceReaderInstance = new org.wheatgenetics.usb.ScaleReader(this.getActivity(),
                /* handler => */ new org.wheatgenetics.usb.ScaleReader.Handler()
                    {
                        @java.lang.Override public void publish(final java.lang.String data)
                        { org.wheatgenetics.usb.ScaleReaderTester.this.publish(data); }

                        @java.lang.Override
                        public void reportException(final org.wheatgenetics.usb.Device.Exception e)
                        { org.wheatgenetics.usb.ScaleReaderTester.this.reportException(e); }
                    });
        return this.deviceReaderInstance;
    }

    public ScaleReaderTester(
    @androidx.annotation.NonNull final android.app.Activity                               activity ,
    @androidx.annotation.NonNull final org.wheatgenetics.usb.DeviceReaderTester.Publisher publisher)
    { super(activity, publisher); }
}
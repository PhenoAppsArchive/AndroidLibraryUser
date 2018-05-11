package org.wheatgenetics.usb;

/**
 * Uses:
 * android.app.Activity
 * android.support.annotation.NonNull
 *
 * org.wheatgenetics.usb.Device.Exception
 * org.wheatgenetics.usb.DeviceReader
 * org.wheatgenetics.usb.DeviceReader.DataSource
 * org.wheatgenetics.usb.DeviceReader.Handler
 * org.wheatgenetics.usb.ExtraDevice
 */
@java.lang.SuppressWarnings("ClassExplicitlyExtendsObject")
public class DeviceReaderTester extends java.lang.Object
{
    public interface Publisher { public abstract void publish(java.lang.String data); }

    // region Fields
    private final android.app.Activity                               activity ;
    private final org.wheatgenetics.usb.DeviceReaderTester.Publisher publisher;

            org.wheatgenetics.usb.DeviceReader deviceReaderInstance = null;
    private org.wheatgenetics.usb.ExtraDevice  extraDevice          = null;
    // endregion

    private java.lang.String formattedRead() throws org.wheatgenetics.usb.Device.Exception
    {
        if (null == this.extraDevice)
            this.extraDevice = new org.wheatgenetics.usb.ExtraDevice(this.getActivity(),
                org.wheatgenetics.usb.Scale.ELANEVendorId  ,
                org.wheatgenetics.usb.Scale.ELANEProductIds);
        return this.extraDevice.formattedRead();
    }

    // region Package Methods
    void publish(final java.lang.String data)
    {
        assert null != this.publisher;
        this.publisher.publish(data);
    }

    android.app.Activity getActivity() { return this.activity; }

    org.wheatgenetics.usb.DeviceReader deviceReader()
    {
        if (null == this.deviceReaderInstance)
            this.deviceReaderInstance = new org.wheatgenetics.usb.DeviceReader(
                /* handler => */ new org.wheatgenetics.usb.DeviceReader.Handler()
                {
                    @java.lang.Override
                    public void publish(final java.lang.String data)
                    { org.wheatgenetics.usb.DeviceReaderTester.this.publish(data); }

                    @java.lang.Override
                    public void reportException(final org.wheatgenetics.usb.Device.Exception e)
                    {
                        assert null != e;
                        org.wheatgenetics.usb.DeviceReaderTester.this.publish(e.getMessage());
                    }
                }, /* dataSource => */ new org.wheatgenetics.usb.DeviceReader.DataSource()
                {
                    @java.lang.Override
                    public java.lang.String formattedRead()
                    throws org.wheatgenetics.usb.Device.Exception
                    { return org.wheatgenetics.usb.DeviceReaderTester.this.formattedRead(); }
                });
        return this.deviceReaderInstance;
    }
    // endregion

    // region Public Methods
    public DeviceReaderTester(
    @android.support.annotation.NonNull final android.app.Activity activity,
    @android.support.annotation.NonNull
        final org.wheatgenetics.usb.DeviceReaderTester.Publisher publisher)
    {
        super();

        this.activity  = activity ;
        this.publisher = publisher;
    }

    public void    executeReader() {        this.deviceReader().execute(); }
    public boolean cancelReader () { return this.deviceReader().cancel (); }
    // endregion
}
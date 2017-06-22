package org.wheatgenetics.androidlibraryuser;

/**
 * Uses:
 * android.content.Intent
 * android.net.Uri
 * android.os.Bundle
 * android.support.v7.app.AppCompatActivity
 * android.view.Menu
 * android.view.MenuInflater
 * android.view.MenuItem
 * android.view.View
 * android.widget.TextView
 *
 * org.wheatgenetics.about.OtherApps
 * org.wheatgenetics.about.OtherApps.Index
 * org.wheatgenetics.about.OtherAppsAlertDialog
 * org.wheatgenetics.about.OtherAppsAlertDialog.Handler
 * org.wheatgenetics.androidlibrary.R
 * org.wheatgenetics.androidlibraryuser.R
 * org.wheatgenetics.changelog.ChangeLogAlertDialog
 * org.wheatgenetics.usb.DeviceListTester
 * org.wheatgenetics.usb.ScaleTester
 * org.wheatgenetics.zxing.BarcodeScanner
 */

public class MainActivity extends android.support.v7.app.AppCompatActivity
{
    private org.wheatgenetics.zxing.BarcodeScanner           barcodeScanner       = null;
    private org.wheatgenetics.changelog.ChangeLogAlertDialog changeLogAlertDialog = null;
    private org.wheatgenetics.about.OtherAppsAlertDialog     otherAppsAlertDialog = null;
    private org.wheatgenetics.usb.DeviceListTester           deviceListTester     = null;
    private org.wheatgenetics.usb.ScaleTester                scaleTester          = null;

    private int deviceListButtonClickCount = 0, scaleButtonClickCount = 0;

    // region Private Methods
    private void setTextViewText(final java.lang.String text)
    {
        final android.widget.TextView textView = (android.widget.TextView)
            this.findViewById(org.wheatgenetics.androidlibraryuser.R.id.textView);
        assert null != text;
        textView.setText(text);
    }

    private void handleOtherAppsAlertDialogItemClick(final java.lang.String uriString)
    {
        this.startActivity(new android.content.Intent(
            android.content.Intent.ACTION_VIEW, android.net.Uri.parse(uriString)));
    }
    // endregion

    // region Overridden Methods
    @java.lang.Override
    protected void onCreate(final android.os.Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        this.setContentView(org.wheatgenetics.androidlibraryuser.R.layout.activity_main);
    }

    @java.lang.Override
    public boolean onCreateOptionsMenu(final android.view.Menu menu)
    {
        new android.view.MenuInflater(this).inflate(
            org.wheatgenetics.androidlibrary.R.menu.camera_options_menu, menu);
        return true;
    }

    @java.lang.Override
    public boolean onOptionsItemSelected(final android.view.MenuItem item)
    {
        assert null != item;
        switch (item.getItemId())
        {
            case org.wheatgenetics.androidlibrary.R.id.cameraOptionsMenuItem:
                if (null == this.barcodeScanner)
                    this.barcodeScanner = new org.wheatgenetics.zxing.BarcodeScanner(this);
                this.barcodeScanner.scan();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @java.lang.Override
    protected void onActivityResult(final int requestCode,
    final int resultCode, final android.content.Intent data)
    {
        java.lang.String barcode = org.wheatgenetics.zxing.BarcodeScanner.parseActivityResult(
            requestCode, resultCode, data);
        if (null == barcode) barcode = "null";
        this.setTextViewText(barcode);
    }
    // endregion

    // region Event Handlers
    public void onChangeLogButtonClick(final android.view.View view) throws java.io.IOException
    {
        if (null == this.changeLogAlertDialog) this.changeLogAlertDialog =
            new org.wheatgenetics.changelog.ChangeLogAlertDialog(
                this, org.wheatgenetics.androidlibraryuser.R.raw.changelog);
        this.changeLogAlertDialog.show();
    }

    public void onOtherAppsButtonClick(final android.view.View view)
    {
        if (null == this.otherAppsAlertDialog)
            this.otherAppsAlertDialog = new org.wheatgenetics.about.OtherAppsAlertDialog(this,
                new org.wheatgenetics.about.OtherApps(
                    org.wheatgenetics.about.OtherApps.Index.INVENTORY),
                new org.wheatgenetics.about.OtherAppsAlertDialog.Handler()
                {
                    @java.lang.Override
                    public void handleItemClick(final java.lang.String uriString)
                    {
                        org.wheatgenetics.androidlibraryuser.MainActivity.
                            this.handleOtherAppsAlertDialogItemClick(uriString);
                    }
                });
        this.otherAppsAlertDialog.show();
    }

    public void onDeviceListButtonClick(final android.view.View view)
    {
        if (null == this.deviceListTester)
            this.deviceListTester = new org.wheatgenetics.usb.DeviceListTester(this);

        if (0 == this.deviceListButtonClickCount)
            this.setTextViewText(this.deviceListTester.size());
        else
            this.setTextViewText(this.deviceListTester.information());

        if (this.deviceListButtonClickCount >= 1)
            this.deviceListButtonClickCount = 0;
        else
            this.deviceListButtonClickCount++;
    }

    public void onScaleButtonClick(final android.view.View view)
    {
        if (null == this.scaleTester)
            this.scaleTester = new org.wheatgenetics.usb.ScaleTester(this);

        if (0 == this.scaleButtonClickCount)
            this.setTextViewText(this.scaleTester.information());
        else
            this.setTextViewText(this.scaleTester.read());

        if (this.scaleButtonClickCount >= 1)
            this.scaleButtonClickCount = 0;
        else
            this.scaleButtonClickCount++;
    }
    // endregion
}
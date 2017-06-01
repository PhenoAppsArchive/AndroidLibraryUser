package org.wheatgenetics.androidlibraryuser;

/**
 * Uses:
 * android.content.Intent
 * android.os.Bundle
 * android.support.v7.app.AppCompatActivity
 * android.view.Menu
 * android.view.MenuInflater
 * android.view.MenuItem
 * android.view.View
 * android.widget.TextView
 *
 * org.wheatgenetics.androidlibrary.R
 * org.wheatgenetics.androidlibrary.Utils
 * org.wheatgenetics.androidlibraryuser.BuildConfig
 * org.wheatgenetics.androidlibraryuser.R
 * org.wheatgenetics.changelog.ChangeLogAlertDialog
 * org.wheatgenetics.zxing.BarcodeScanner
 */

public class MainActivity extends android.support.v7.app.AppCompatActivity
{
    private android.widget.TextView                          textView                   ;
    private org.wheatgenetics.changelog.ChangeLogAlertDialog changeLogAlertDialog = null;
    private org.wheatgenetics.zxing.BarcodeScanner           barcodeScanner       = null;

    private void scan()
    {
        if (null == this.barcodeScanner)
            this.barcodeScanner = new org.wheatgenetics.zxing.BarcodeScanner(this);
        this.barcodeScanner.scan();
    }

    @java.lang.Override
    protected void onCreate(final android.os.Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        this.setContentView(org.wheatgenetics.androidlibraryuser.R.layout.activity_main);

        this.textView = (android.widget.TextView)
            this.findViewById(org.wheatgenetics.androidlibraryuser.R.id.textView);
        if (org.wheatgenetics.androidlibraryuser.BuildConfig.DEBUG && null == this.textView)
            throw new java.lang.AssertionError();
        final int number = 2;
        this.textView.setText(java.lang.String.format("doubleOf(%d) is %d",
            number, org.wheatgenetics.androidlibrary.Utils.doubleOf(number)));
    }

    @java.lang.Override
    public boolean onCreateOptionsMenu(final android.view.Menu menu)
    {
        new android.view.MenuInflater(this).inflate(
            org.wheatgenetics.androidlibrary.R.menu.camera_options_menu, menu);
        assert null != menu;
        menu.findItem(org.wheatgenetics.androidlibrary.R.id.cameraOptionsMenuItem).setVisible(true);
        return true;
    }

    @java.lang.Override
    public boolean onOptionsItemSelected(final android.view.MenuItem item)
    {
        assert null != item;
        switch (item.getItemId())
        {
            case org.wheatgenetics.androidlibrary.R.id.cameraOptionsMenuItem:
                this.scan();
                break;
        }
        return true;
    }

    @java.lang.Override
    protected void onActivityResult(final int requestCode,
    final int resultCode, final android.content.Intent data)
    {
        java.lang.String barcode = org.wheatgenetics.zxing.BarcodeScanner.parseActivityResult(
            requestCode, resultCode, data);
        if (null == barcode) barcode = "null";

        assert null != this.textView;
        this.textView.setText(barcode);
    }

    public void onChangeLogButtonClick(final android.view.View view) throws java.io.IOException
    {
        if (null == this.changeLogAlertDialog) this.changeLogAlertDialog =
            new org.wheatgenetics.changelog.ChangeLogAlertDialog(
                this, org.wheatgenetics.androidlibraryuser.R.raw.changelog);
        this.changeLogAlertDialog.show();
    }

    public void onScanButtonClick(final android.view.View view)
    { this.scan(); }
}
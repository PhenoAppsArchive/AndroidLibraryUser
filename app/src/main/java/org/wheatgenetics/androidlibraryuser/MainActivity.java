package org.wheatgenetics.androidlibraryuser;

/**
 * Uses:
 * android.os.Bundle
 * android.support.v7.app.AppCompatActivity
 * android.view.View
 * android.widget.TextView
 *
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

    public void onChangeLogButtonClick(final android.view.View view) throws java.io.IOException
    {
        if (null == this.changeLogAlertDialog) this.changeLogAlertDialog =
            new org.wheatgenetics.changelog.ChangeLogAlertDialog(
                this, org.wheatgenetics.androidlibraryuser.R.raw.changelog);
        this.changeLogAlertDialog.show();
    }

    public void onScanButtonClick(final android.view.View view)
    {
        if (null == this.barcodeScanner)
            this.barcodeScanner = new org.wheatgenetics.zxing.BarcodeScanner(this);
        this.barcodeScanner.scan();
    }
}
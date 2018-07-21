package org.wheatgenetics.androidlibraryuser;

/** Uses:
 * android.content.Intent
 * android.content.pm.PackageInfo
 * android.content.pm.PackageManager.NameNotFoundException
 * android.os.Bundle
 * android.support.annotation.IntRange
 * android.support.v7.app.AppCompatActivity
 * android.view.Menu
 * android.view.MenuInflater
 * android.view.MenuItem
 * android.view.View
 * android.view.View.OnClickListener
 * android.widget.Button
 * android.widget.EditText
 * android.widget.TextView
 *
 * org.wheatgenetics.javalib.Utils
 * org.wheatgenetics.javalib.Utils.Response
 *
 * org.wheatgenetics.about.AboutAlertDialog
 * org.wheatgenetics.about.OtherApps.Index
 * org.wheatgenetics.about.OtherAppsAlertDialog
 * org.wheatgenetics.androidlibrary.DebouncingEditorActionListener
 * org.wheatgenetics.androidlibrary.DebouncingEditorActionListener.Receiver
 * org.wheatgenetics.androidlibrary.R
 * org.wheatgenetics.androidlibrary.Utils
 * org.wheatgenetics.changelog.ChangeLogAlertDialog
 * org.wheatgenetics.usb.DeviceListTester
 * org.wheatgenetics.usb.DeviceReaderTester
 * org.wheatgenetics.usb.DeviceReaderTester.Publisher
 * org.wheatgenetics.usb.ExtraDeviceTester
 * org.wheatgenetics.usb.ScaleReaderTester
 * org.wheatgenetics.usb.ScaleReaderTester.Publisher
 * org.wheatgenetics.usb.ScaleTester
 * org.wheatgenetics.zxing.BarcodeScanner
 *
 * org.wheatgenetics.androidlibraryuser.BuildConfig
 * org.wheatgenetics.androidlibraryuser.R
 * org.wheatgenetics.androidlibraryuser.WebViewActivity
 */
public class MainActivity extends android.support.v7.app.AppCompatActivity
implements org.wheatgenetics.androidlibrary.DebouncingEditorActionListener.Receiver
{
    // region Fields
    private android.widget.TextView textView = null;
    private android.widget.Button toastAndGetButton = null, otherAppsButton = null,
        deviceListButton = null, scaleButton = null, scaleReaderButton = null;
    private android.widget.EditText editText = null;

    private org.wheatgenetics.zxing.BarcodeScanner           barcodeScanner       = null;
    private org.wheatgenetics.changelog.ChangeLogAlertDialog changeLogAlertDialog = null;
    private org.wheatgenetics.about.OtherAppsAlertDialog     otherAppsAlertDialog = null;
    private org.wheatgenetics.about.AboutAlertDialog         aboutAlertDialog     = null;
    private org.wheatgenetics.usb.DeviceListTester           deviceListTester     = null;
    private org.wheatgenetics.usb.ExtraDeviceTester          extraDeviceTester    = null;
    private org.wheatgenetics.usb.ScaleTester                scaleTester          = null;
    private org.wheatgenetics.usb.DeviceReaderTester         deviceReaderTester   = null;
    private org.wheatgenetics.usb.ScaleReaderTester          scaleReaderTester    = null;

    @android.support.annotation.IntRange(from = 0) private int toastAndGetButtonClickCount = 0,
        otherAppsButtonClickCount = 0, deviceListButtonClickCount  = 0,
        scaleButtonClickCount     = 0, scaleReaderButtonClickCount = 0;

    private android.content.Intent intentInstance = null;
    // endregion

    // region Private Methods
    // region Button Private Methods
    private static void setButtonText(final android.widget.Button button,
    final java.lang.String text) { assert null != button; button.setText(text); }


    private void setToastAndGetButtonText(final java.lang.String text)
    {
        org.wheatgenetics.androidlibraryuser.MainActivity.setButtonText(
            this.toastAndGetButton, text);
    }

    private void setOtherAppsButtonText(final java.lang.String text)
    { org.wheatgenetics.androidlibraryuser.MainActivity.setButtonText(this.otherAppsButton, text); }

    private void setDeviceListButtonText(final java.lang.String text)
    {
        org.wheatgenetics.androidlibraryuser.MainActivity.setButtonText(
            this.deviceListButton, text);
    }

    private void setScaleButtonText(final java.lang.String text)
    { org.wheatgenetics.androidlibraryuser.MainActivity.setButtonText(this.scaleButton, text); }

    private void setScaleReaderButtonText(final java.lang.String text)
    {
        org.wheatgenetics.androidlibraryuser.MainActivity.setButtonText(
            this.scaleReaderButton, text);
    }


    private void resetToastAndGetButtonText() { this.setToastAndGetButtonText("Short Toast"     ); }
    private void resetOtherAppsButtonText  () { this.setOtherAppsButtonText ("Other Apps"       ); }
    private void resetDeviceListButtonText () { this.setDeviceListButtonText("DeviceList.size()"); }

    private void resetScaleButtonText() { this.setScaleButtonText("ExtraDevice.information()"); }

    private void resetScaleReaderButtonText()
    { this.setScaleReaderButtonText("DeviceReader.execute()"); }
    // endregion

    // region textView Private Methods
    private void setTextViewText(final java.lang.String text)
    { assert null != this.textView; this.textView.setText(text); }

    private void setAndInvalidateTextViewText(final java.lang.String text)
    {
        this.setTextViewText(text);
        assert null != this.textView; this.textView.invalidate();
    }
    // endregion

    private android.content.Intent intent(
    final java.lang.String content, final java.lang.String encoding)
    {
        if (null == this.intentInstance) this.intentInstance = new android.content.Intent(
            this, org.wheatgenetics.androidlibraryuser.WebViewActivity.class);

        this.intentInstance.putExtra(
            org.wheatgenetics.androidlibraryuser.WebViewActivity.CONTENT, content);
        this.intentInstance.putExtra(
            org.wheatgenetics.androidlibraryuser.WebViewActivity.ENCODING, encoding);

        return this.intentInstance;
    }

    private void showChangeLog()
    {
        if (null == this.changeLogAlertDialog)
            this.changeLogAlertDialog = new org.wheatgenetics.changelog.ChangeLogAlertDialog(
                /* activity               => */ this,
                /* changeLogRawResourceId => */
                    org.wheatgenetics.androidlibraryuser.R.raw.changelog);
        this.changeLogAlertDialog.show();
    }
    // endregion

    // region Overridden Methods
    @java.lang.Override protected void onCreate(final android.os.Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        this.setContentView(org.wheatgenetics.androidlibraryuser.R.layout.activity_main);


        this.textView = (android.widget.TextView)
            this.findViewById(org.wheatgenetics.androidlibraryuser.R.id.textView);


        this.toastAndGetButton = (android.widget.Button)
            this.findViewById(org.wheatgenetics.androidlibraryuser.R.id.toastAndGetButton);
        this.resetToastAndGetButtonText();

        this.otherAppsButton = (android.widget.Button)
            this.findViewById(org.wheatgenetics.androidlibraryuser.R.id.otherAppsButton);
        this.resetOtherAppsButtonText();

        this.deviceListButton = (android.widget.Button)
            this.findViewById(org.wheatgenetics.androidlibraryuser.R.id.deviceListButton);
        this.resetDeviceListButtonText();

        this.scaleButton = (android.widget.Button)
            this.findViewById(org.wheatgenetics.androidlibraryuser.R.id.scaleButton);
        this.resetScaleButtonText();

        this.scaleReaderButton = (android.widget.Button)
            this.findViewById(org.wheatgenetics.androidlibraryuser.R.id.scaleReaderButton);
        this.resetScaleReaderButtonText();


        this.editText = (android.widget.EditText)
            this.findViewById(org.wheatgenetics.androidlibraryuser.R.id.editText);
        new org.wheatgenetics.androidlibrary.DebouncingEditorActionListener(this.editText, this,
            org.wheatgenetics.androidlibraryuser.BuildConfig.DEBUG, /* delayMillis => */ 1000);
    }

    @java.lang.Override public boolean onCreateOptionsMenu(final android.view.Menu menu)
    {
        new android.view.MenuInflater(this).inflate(
            org.wheatgenetics.androidlibrary.R.menu.camera_options_menu, menu);
        return true;
    }

    @java.lang.Override public boolean onOptionsItemSelected(final android.view.MenuItem item)
    {
        assert null != item; switch (item.getItemId())
        {
            case org.wheatgenetics.androidlibrary.R.id.cameraOptionsMenuItem:
                if (null == this.barcodeScanner)
                    this.barcodeScanner = new org.wheatgenetics.zxing.BarcodeScanner(this);
                this.barcodeScanner.scan();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @java.lang.Override protected void onActivityResult(final int requestCode,
    final int resultCode, final android.content.Intent data)
    {
        this.setTextViewText(org.wheatgenetics.javalib.Utils.replaceIfNull(
            org.wheatgenetics.zxing.BarcodeScanner.parseActivityResult(
                requestCode, resultCode, data),
            "null"));
    }

    // region org.wheatgenetics.androidlibrary.DebouncingEditorActionListener.Receiver Overridden Method
    @java.lang.Override public void receiveText(final java.lang.String text)
    {
        assert null != this.textView; this.textView.setText(text) ;
        assert null != this.editText; this.editText.requestFocus();
    }
    // endregion
    // endregion

    // region Event Handlers
    public void onToastAndGetButtonClick(final android.view.View view)
    {
        switch (this.toastAndGetButtonClickCount)
        {
            case 0: org.wheatgenetics.androidlibrary.Utils.showShortToast(this, "short"); break;
            case 1: org.wheatgenetics.androidlibrary.Utils.showLongToast (this, "long" ); break;

            case 2:
                final org.wheatgenetics.javalib.Utils.Response response;
                {
                    java.net.URL url;
                    try
                    {
                        url = new java.net.URL(             // throws java.net.MalformedURLException
                            /* protocol => */ "http"           ,
                            /* host     => */ "www.example.org",
                            /* file     => */ "index.html"     );
                    }
                    catch (final java.net.MalformedURLException e) { url = null; }
                    response = org.wheatgenetics.javalib.Utils.threadedGet(url);
                }
                if (null == response)
                    this.setTextViewText("response is null");
                else
                    this.startActivity(this.intent(response.content(), response.contentEncoding()));
                break;

            case 3: this.showChangeLog(); break;
        }

        switch (this.toastAndGetButtonClickCount)
        {
            case 0:
                this.toastAndGetButtonClickCount++;
                this.setToastAndGetButtonText("Long Toast");
                break;

            case 1:
                this.toastAndGetButtonClickCount++;
                this.setToastAndGetButtonText("http://www.example.org/");
                break;

            case 2:
                this.toastAndGetButtonClickCount++;
                this.setToastAndGetButtonText("ChangeLog");
                break;

            default: this.toastAndGetButtonClickCount = 0; this.resetToastAndGetButtonText(); break;
        }
    }

    public void onOtherAppsButtonClick(final android.view.View view)
    {
        switch (this.otherAppsButtonClickCount)
        {
            case 0:
                if (null == this.otherAppsAlertDialog)
                    this.otherAppsAlertDialog = new org.wheatgenetics.about.OtherAppsAlertDialog(
                        this, org.wheatgenetics.about.OtherApps.Index.INVENTORY);
                break;

            case 1:
                if (null == this.aboutAlertDialog)
                {
                    java.lang.String versionName;
                    try
                    {
                        final android.content.pm.PackageInfo packageInfo =
                            this.getPackageManager().getPackageInfo(
                                this.getPackageName(), /* flags => */ 0);
                        assert null != packageInfo; versionName = packageInfo.versionName;
                    }
                    catch (final android.content.pm.PackageManager.NameNotFoundException e)
                    { versionName = org.wheatgenetics.javalib.Utils.adjust(null); }

                    this.aboutAlertDialog = new org.wheatgenetics.about.AboutAlertDialog(this,
                        "About Android Library User", versionName, new java.lang.String[]{
                            "msg1: test (http://www.google.com/ )",
                            "msg2: (http://www.google.com/) test" ,
                            "msg3: abc http://www.google.com/ def"},
                        org.wheatgenetics.about.OtherApps.Index.INVENTORY,
                        new android.view.View.OnClickListener()
                        {
                            @java.lang.Override public void onClick(final android.view.View v)
                            {
                                org.wheatgenetics.androidlibraryuser.MainActivity
                                    .this.showChangeLog();
                            }
                        });
                } break;
        }

        switch (this.otherAppsButtonClickCount)
        {
            case 0: this.otherAppsAlertDialog.show(); break;
            case 1: this.aboutAlertDialog.show    (); break;
        }

        switch (this.otherAppsButtonClickCount)
        {
            case 0: this.otherAppsButtonClickCount++  ; this.setOtherAppsButtonText("About"); break;
            case 1: this.otherAppsButtonClickCount = 0; this.resetOtherAppsButtonText()     ; break;
        }
    }

    public void onDeviceListButtonClick(final android.view.View view)
    {
        if (null == this.deviceListTester)
            this.deviceListTester = new org.wheatgenetics.usb.DeviceListTester(this);

        switch (this.deviceListButtonClickCount)
        {
            case 0: this.setTextViewText(this.deviceListTester.size       ()); break;
            case 1: this.setTextViewText(this.deviceListTester.information()); break;
        }

        switch (this.deviceListButtonClickCount)
        {
            case 0:
                this.deviceListButtonClickCount++;
                this.setDeviceListButtonText("DeviceList.information()"); break;

            default: this.deviceListButtonClickCount = 0; this.resetDeviceListButtonText(); break;
        }
    }

    public void onScaleButtonClick(final android.view.View view)
    {
        switch (this.scaleButtonClickCount)
        {
            case 0: case 1:
                if (null == this.extraDeviceTester)
                    this.extraDeviceTester = new org.wheatgenetics.usb.ExtraDeviceTester(this);
                break;

            case 2: case 3:
                if (null == this.scaleTester)
                    this.scaleTester = new org.wheatgenetics.usb.ScaleTester(this);
                break;
        }

        switch (this.scaleButtonClickCount)
        {
            case 0: this.setTextViewText(this.extraDeviceTester.information          ()); break;
            case 1: this.setTextViewText(this.extraDeviceTester.handlingFormattedRead()); break;
            case 2: this.setTextViewText(this.scaleTester.information                ()); break;
            case 3: this.setTextViewText(this.scaleTester.handlingFormattedRead      ()); break;
        }

        switch (this.scaleButtonClickCount)
        {
            case 0: case 1: case 2: this.scaleButtonClickCount++  ; break;
            default               : this.scaleButtonClickCount = 0; break;
        }

        switch (this.scaleButtonClickCount)
        {
            case 0 : this.resetScaleButtonText()                           ; break;
            case 1 : this.setScaleButtonText("ExtraDevice.formattedRead()"); break;
            case 2 : this.setScaleButtonText("Scale.information()"        ); break;
            case 3 : this.setScaleButtonText("Scale.formattedRead()"      ); break;
            default: this.setScaleButtonText("Error!"                     ); break;
        }
    }

    public void onScaleReaderButtonClick(final android.view.View view)
    {
        switch (this.scaleReaderButtonClickCount)
        {
            case 0: case 1:
                if (null == this.deviceReaderTester)
                    this.deviceReaderTester = new org.wheatgenetics.usb.DeviceReaderTester(this,
                        new org.wheatgenetics.usb.DeviceReaderTester.Publisher()
                        {
                            @java.lang.Override public void publish(final java.lang.String data)
                            {
                                org.wheatgenetics.androidlibraryuser.MainActivity
                                    .this.setAndInvalidateTextViewText(data);
                            }
                        });
                break;

            case 2: case 3:
                if (null == this.scaleReaderTester)
                    this.scaleReaderTester = new org.wheatgenetics.usb.ScaleReaderTester(this,
                        new org.wheatgenetics.usb.ScaleReaderTester.Publisher()
                        {
                            @java.lang.Override public void publish(final java.lang.String data)
                            {
                                org.wheatgenetics.androidlibraryuser.MainActivity
                                    .this.setAndInvalidateTextViewText(data);
                            }
                        });
                break;
        }

        switch (this.scaleReaderButtonClickCount)
        {
            case 0: this.deviceReaderTester.executeReader(); break;
            case 1: this.deviceReaderTester.cancelReader (); break;
            case 2: this.scaleReaderTester.executeReader (); break;
            case 3: this.scaleReaderTester.cancelReader  (); break;
        }

        switch (this.scaleReaderButtonClickCount)
        {
            case 0: case 1: case 2: this.scaleReaderButtonClickCount++  ; break;
            default               : this.scaleReaderButtonClickCount = 0; break;
        }

        switch (this.scaleReaderButtonClickCount)
        {
            case 0 : this.resetScaleReaderButtonText()                     ; break;
            case 1 : this.setScaleReaderButtonText("DeviceReader.cancel()"); break;
            case 2 : this.setScaleReaderButtonText("ScaleReader.execute()"); break;
            case 3 : this.setScaleReaderButtonText("ScaleReader.cancel()" ); break;
            default: this.setScaleReaderButtonText("Error!"               ); break;
        }
    }
    // endregion
}
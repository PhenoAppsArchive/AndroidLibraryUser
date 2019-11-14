package org.wheatgenetics.androidlibraryuser;

/**
 * Uses:
 * android.content.Intent
 * android.os.Bundle
 * android.webkit.WebView
 *
 * androidx.appcompat.app.AppCompatActivity
 *
 * org.wheatgenetics.androidlibraryuser.R
 */
public class WebViewActivity extends androidx.appcompat.app.AppCompatActivity
{
    static final java.lang.String CONTENT = "content", ENCODING = "encoding";

    @java.lang.Override protected void onCreate(final android.os.Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        this.setContentView(org.wheatgenetics.androidlibraryuser.R.layout.activity_web_view);

        final android.content.Intent intent  = this.getIntent();
        final android.webkit.WebView webView =
            this.findViewById(org.wheatgenetics.androidlibraryuser.R.id.webView);
        assert null != webView; webView.loadData(
            /* data => */ intent.getStringExtra(
                org.wheatgenetics.androidlibraryuser.WebViewActivity.CONTENT),
            /* mimeType => */ "text/html",
            /* encoding => */ intent.getStringExtra(
                org.wheatgenetics.androidlibraryuser.WebViewActivity.ENCODING));
    }
}
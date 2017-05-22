package org.wheatgenetics.androidlibraryuser;

/**
 * Uses:
 * android.os.Bundle
 * android.support.v7.app.AppCompatActivity
 * android.widget.TextView
 *
 * org.wheatgenetics.androidlibrary.Utils
 * org.wheatgenetics.androidlibraryuser.R
 */

public class MainActivity extends android.support.v7.app.AppCompatActivity
{
    @java.lang.Override
    protected void onCreate(final android.os.Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        this.setContentView(org.wheatgenetics.androidlibraryuser.R.layout.activity_main);

        final int                     number   = 2;
        final android.widget.TextView textView = (android.widget.TextView)
            this.findViewById(org.wheatgenetics.androidlibraryuser.R.id.textView);
        assert textView != null;
        textView.setText(java.lang.String.format("doubleOf(%d) is %d",
            number, org.wheatgenetics.androidlibrary.Utils.doubleOf(number)));
    }
}
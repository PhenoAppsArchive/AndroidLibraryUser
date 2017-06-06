package org.wheatgenetics.androidlibraryuser;

/**
 * Uses:
 * android.os.Bundle
 * android.support.v7.app.AppCompatActivity
 * android.widget.TextView
 *
 * org.wheatgenetics.androidlibraryuser.R
 * org.wheatgenetics.javalib.Utils
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
        assert null != textView;
        textView.setText(java.lang.String.format("doubleOf(%d) is %d",
            number, org.wheatgenetics.javalib.Utils.doubleOf(number)));
    }
}
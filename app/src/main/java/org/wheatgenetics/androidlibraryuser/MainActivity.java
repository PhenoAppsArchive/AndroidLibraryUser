package org.wheatgenetics.androidlibraryuser;

/**
 * Uses:
 * android.os.Bundle
 * android.support.v7.app.AppCompatActivity
 * android.view.View
 * android.widget.TextView
 *
 * org.wheatgenetics.androidlibrary.Utils
 * org.wheatgenetics.androidlibraryuser.R
 */

public class MainActivity extends android.support.v7.app.AppCompatActivity
{
    private org.wheatgenetics.changelog.ChangeLogAlertDialog changeLogAlertDialog = null;

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

    public void onClick(final android.view.View view)
    {
        if (this.changeLogAlertDialog == null) this.changeLogAlertDialog =
            new org.wheatgenetics.changelog.ChangeLogAlertDialog(
                this, org.wheatgenetics.androidlibraryuser.R.raw.changelog);
    }
}
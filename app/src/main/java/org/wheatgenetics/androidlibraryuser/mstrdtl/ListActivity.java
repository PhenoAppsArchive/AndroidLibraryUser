package org.wheatgenetics.androidlibraryuser.mstrdtl;

/**
 * Uses:
 * org.wheatgenetics.javalib.mstrdtl.Items
 *
 * org.wheatgenetics.androidlibrary.mstrdtl.ListActivity
 * org.wheatgenetics.androidlibrary.mstrdtl.OnePaneAdapter
 *
 * org.wheatgenetics.androidlibraryuser.mstrdtl.Items
 * org.wheatgenetics.androidlibraryuser.mstrdtl.OnePaneAdapter
 */
public class ListActivity extends org.wheatgenetics.androidlibrary.mstrdtl.ListActivity
{
    // region Overridden Methods
    @java.lang.Override protected org.wheatgenetics.javalib.mstrdtl.Items items()
    { return org.wheatgenetics.androidlibraryuser.mstrdtl.Items.ITEMS(); }

    @java.lang.Override
    protected org.wheatgenetics.androidlibrary.mstrdtl.OnePaneAdapter makeOnePaneAdapter()
    { return new org.wheatgenetics.androidlibraryuser.mstrdtl.OnePaneAdapter(this.items()); }
    // endregion
}
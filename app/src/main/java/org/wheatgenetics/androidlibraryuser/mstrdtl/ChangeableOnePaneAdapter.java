package org.wheatgenetics.androidlibraryuser.mstrdtl;

/**
 * Uses:
 * org.wheatgenetics.javalib.mstrdtl.Items
 *
 * org.wheatgenetics.androidlibrary.mstrdtl.OnePaneAdapter
 *
 * org.wheatgenetics.androidlibraryuser.mstrdtl.ChangeableItemActivity
 */
class ChangeableOnePaneAdapter extends org.wheatgenetics.androidlibrary.mstrdtl.OnePaneAdapter
{
    ChangeableOnePaneAdapter(final org.wheatgenetics.javalib.mstrdtl.Items items) { super(items); }

    @java.lang.Override protected java.lang.Class concreteItemActivityClass()
    { return org.wheatgenetics.androidlibraryuser.mstrdtl.ChangeableItemActivity.class; }
}
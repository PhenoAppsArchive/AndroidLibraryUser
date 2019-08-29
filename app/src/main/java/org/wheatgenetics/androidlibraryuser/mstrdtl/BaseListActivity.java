package org.wheatgenetics.androidlibraryuser.mstrdtl;

/**
 * Uses:
 * android.support.annotation.RestrictTo
 * android.support.annotation.RestrictTo.Scope
 *
 * org.wheatgenetics.javalib.mstrdtl.Items
 *
 * org.wheatgenetics.androidlibrary.mstrdtl.ListActivity
 *
 * org.wheatgenetics.androidlibraryuser.mstrdtl.TestItems
 */
abstract class BaseListActivity extends org.wheatgenetics.androidlibrary.mstrdtl.ListActivity
{
    @android.support.annotation.RestrictTo(android.support.annotation.RestrictTo.Scope.SUBCLASSES)
    @java.lang.Override protected org.wheatgenetics.javalib.mstrdtl.Items items()
    { return org.wheatgenetics.androidlibraryuser.mstrdtl.TestItems.TEST_ITEMS(); }
}
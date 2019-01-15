package org.wheatgenetics.androidlibraryuser.mstrdtl;

/**
 * Uses:
 * android.support.annotation.RestrictTo
 * android.support.annotation.RestrictTo.Scope
 *
 * org.wheatgenetics.androidlibrary.mstrdtl.OnePaneAdapter
 *
 * org.wheatgenetics.androidlibraryuser.mstrdtl.BaseListActivity
 * org.wheatgenetics.androidlibraryuser.mstrdtl.OnePaneAdapter
 */
public class ListActivity extends org.wheatgenetics.androidlibraryuser.mstrdtl.BaseListActivity
{
    // region Overridden Methods
    @android.support.annotation.RestrictTo(android.support.annotation.RestrictTo.Scope.SUBCLASSES)
    @java.lang.Override
    protected org.wheatgenetics.androidlibrary.mstrdtl.OnePaneAdapter makeOnePaneAdapter()
    { return new org.wheatgenetics.androidlibraryuser.mstrdtl.OnePaneAdapter(this.items()); }
    // endregion
}
package org.wheatgenetics.androidlibraryuser.mstrdtl;

/**
 * Uses:
 * androidx.annotation.NonNull
 * androidx.annotation.RestrictTo
 * androidx.annotation.RestrictTo.Scope
 *
 * org.wheatgenetics.javalib.mstrdtl.Items
 * org.wheatgenetics.javalib.mstrdtl.TestItems
 *
 * org.wheatgenetics.androidlibrary.mstrdtl.ItemActivity
 *
 * org.wheatgenetics.androidlibraryuser.mstrdtl.ListActivity
 */
public class ItemActivity extends org.wheatgenetics.androidlibrary.mstrdtl.ItemActivity
{
    private org.wheatgenetics.javalib.mstrdtl.Items itemsInstance = null;               // lazy load

    // region Overridden Methods
    @androidx.annotation.RestrictTo(androidx.annotation.RestrictTo.Scope.SUBCLASSES)
    @java.lang.Override @androidx.annotation.NonNull
    protected org.wheatgenetics.javalib.mstrdtl.Items items()
    {
        if (null == this.itemsInstance) this.itemsInstance =
            new org.wheatgenetics.javalib.mstrdtl.TestItems().fromJson(this.getJson());
        return this.itemsInstance;
    }

    @androidx.annotation.RestrictTo(androidx.annotation.RestrictTo.Scope.SUBCLASSES)
    @java.lang.Override protected java.lang.Class listActivityClass()
    { return org.wheatgenetics.androidlibraryuser.mstrdtl.ListActivity.class; }
    // endregion
}
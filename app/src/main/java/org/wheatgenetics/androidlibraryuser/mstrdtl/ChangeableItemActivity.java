package org.wheatgenetics.androidlibraryuser.mstrdtl;

/**
 * Uses:
 * android.support.annotation.NonNull
 * android.support.annotation.RestrictTo
 * android.support.annotation.RestrictTo.Scope
 *
 * org.wheatgenetics.javalib.mstrdtl.Item
 * org.wheatgenetics.javalib.mstrdtl.Items
 * org.wheatgenetics.javalib.mstrdtl.TestItem
 * org.wheatgenetics.javalib.mstrdtl.TestItems
 *
 * org.wheatgenetics.androidlibrary.mstrdtl.ChangeableItemActivity
 *
 * org.wheatgenetics.androidlibraryuser.mstrdtl.ChangeItemAlertDialog
 * org.wheatgenetics.androidlibraryuser.mstrdtl.ChangeItemAlertDialog.Handler
 * org.wheatgenetics.androidlibraryuser.mstrdtl.ChangeableListActivity
 */
public class ChangeableItemActivity
extends org.wheatgenetics.androidlibrary.mstrdtl.ChangeableItemActivity
{
    // region Fields
    private org.wheatgenetics.javalib.mstrdtl.Items               itemsInstance = null; // lazy load
    private org.wheatgenetics.androidlibraryuser.mstrdtl.ChangeItemAlertDialog
        changeItemAlertDialogInstance = null;                                           // lazy load
    // endregion

    private org.wheatgenetics.androidlibraryuser.mstrdtl.ChangeItemAlertDialog
    changeItemAlertDialog()
    {
        if (null == this.changeItemAlertDialogInstance) this.changeItemAlertDialogInstance =
            new org.wheatgenetics.androidlibraryuser.mstrdtl.ChangeItemAlertDialog(this,
                new org.wheatgenetics.androidlibraryuser.mstrdtl.ChangeItemAlertDialog.Handler()
                {
                    @java.lang.Override public void handleChangeItemDone()
                    {
                        org.wheatgenetics.androidlibraryuser.mstrdtl
                            .ChangeableItemActivity.this.refreshSinceItemHasChanged();
                    }
                });
        return this.changeItemAlertDialogInstance;
    }

    // region Overridden Methods
    @android.support.annotation.RestrictTo(android.support.annotation.RestrictTo.Scope.SUBCLASSES)
    @java.lang.Override @android.support.annotation.NonNull
    protected org.wheatgenetics.javalib.mstrdtl.Items items()
    {
        if (null == this.itemsInstance) this.itemsInstance =
            new org.wheatgenetics.javalib.mstrdtl.TestItems().fromJson(this.getJson());
        return this.itemsInstance;
    }

    @android.support.annotation.RestrictTo(android.support.annotation.RestrictTo.Scope.SUBCLASSES)
    @java.lang.Override protected java.lang.Class listActivityClass()
    { return org.wheatgenetics.androidlibraryuser.mstrdtl.ChangeableListActivity.class; }

    @java.lang.Override public void change(
    @android.support.annotation.NonNull final org.wheatgenetics.javalib.mstrdtl.Item item)
    { this.changeItemAlertDialog().show((org.wheatgenetics.javalib.mstrdtl.TestItem) item); }
    // endregion
}
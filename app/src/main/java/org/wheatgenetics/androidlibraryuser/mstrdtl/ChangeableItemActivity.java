package org.wheatgenetics.androidlibraryuser.mstrdtl;

/**
 * Uses:
 * android.support.annotation.NonNull
 *
 * org.wheatgenetics.javalib.mstrdtl.Item
 *
 * org.wheatgenetics.androidlibrary.mstrdtl.ItemFragment.GetterChanger
 *
 * org.wheatgenetics.androidlibraryuser.mstrdtl.BaseItemActivity
 * org.wheatgenetics.androidlibraryuser.mstrdtl.ChangeItemAlertDialog
 * org.wheatgenetics.androidlibraryuser.mstrdtl.ChangeItemAlertDialog.Handler
 * org.wheatgenetics.androidlibraryuser.mstrdtl.ChangeableListActivity
 * org.wheatgenetics.androidlibraryuser.mstrdtl.Item
 */
public class ChangeableItemActivity
extends    org.wheatgenetics.androidlibraryuser.mstrdtl.BaseItemActivity
implements org.wheatgenetics.androidlibrary.mstrdtl.ItemFragment.GetterChanger
{
    private org.wheatgenetics.androidlibraryuser.mstrdtl.ChangeItemAlertDialog              // lazy
        changeItemAlertDialogInstance = null;                                               //  load

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
    @java.lang.Override protected java.lang.Class listActivityClass()
    { return org.wheatgenetics.androidlibraryuser.mstrdtl.ChangeableListActivity.class; }

    // region org.wheatgenetics.androidlibrary.mstrdtl.ItemFragment.GetterChanger Overridden Method
    @java.lang.Override public void change(
    @android.support.annotation.NonNull final org.wheatgenetics.javalib.mstrdtl.Item item)
    { this.changeItemAlertDialog().show((org.wheatgenetics.androidlibraryuser.mstrdtl.Item) item); }
    // endregion
    // endregion
}
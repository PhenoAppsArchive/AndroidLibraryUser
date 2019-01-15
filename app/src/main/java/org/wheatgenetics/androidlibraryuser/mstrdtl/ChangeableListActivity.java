package org.wheatgenetics.androidlibraryuser.mstrdtl;

/**
 * Uses:
 * android.support.annotation.NonNull
 * android.support.annotation.RestrictTo
 * android.support.annotation.RestrictTo.Scope
 *
 * org.wheatgenetics.javalib.mstrdtl.Item
 *
 * org.wheatgenetics.androidlibrary.mstrdtl.ItemFragment.GetterChanger
 * org.wheatgenetics.androidlibrary.mstrdtl.OnePaneAdapter
 *
 * org.wheatgenetics.androidlibraryuser.mstrdtl.BaseListActivity
 * org.wheatgenetics.androidlibraryuser.mstrdtl.ChangeItemAlertDialog
 * org.wheatgenetics.androidlibraryuser.mstrdtl.ChangeItemAlertDialog.Handler
 * org.wheatgenetics.androidlibraryuser.mstrdtl.ChangeableOnePaneAdapter
 * org.wheatgenetics.androidlibraryuser.mstrdtl.Item
 */
public class ChangeableListActivity
extends    org.wheatgenetics.androidlibraryuser.mstrdtl.BaseListActivity
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
                            .ChangeableListActivity.this.refreshSinceItemHasChanged();
                    }
                });
        return this.changeItemAlertDialogInstance;
    }

    // region Overridden Methods
    @android.support.annotation.RestrictTo(android.support.annotation.RestrictTo.Scope.SUBCLASSES)
    @java.lang.Override
    protected org.wheatgenetics.androidlibrary.mstrdtl.OnePaneAdapter makeOnePaneAdapter()
    {
        return new org.wheatgenetics.androidlibraryuser.mstrdtl.ChangeableOnePaneAdapter(
            this.items());
    }

    // region org.wheatgenetics.androidlibrary.mstrdtl.ItemFragment.GetterChanger Overridden Method
    @java.lang.Override public void change(
    @android.support.annotation.NonNull final org.wheatgenetics.javalib.mstrdtl.Item item)
    { this.changeItemAlertDialog().show((org.wheatgenetics.androidlibraryuser.mstrdtl.Item) item); }
    // endregion
    // endregion
}
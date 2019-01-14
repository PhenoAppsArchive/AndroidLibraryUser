package org.wheatgenetics.androidlibraryuser.mstrdtl;

/**
 * Uses:
 * android.support.annotation.IntRange
 * android.support.annotation.NonNull
 *
 * org.wheatgenetics.javalib.mstrdtl.Item
 *
 * org.wheatgenetics.androidlibrary.mstrdtl.ItemActivity
 * org.wheatgenetics.androidlibrary.mstrdtl.ItemFragment.GetterChanger
 *
 * org.wheatgenetics.androidlibraryuser.mstrdtl.ChangeableItem
 * org.wheatgenetics.androidlibraryuser.mstrdtl.ChangeableItems
 * org.wheatgenetics.androidlibraryuser.mstrdtl.ChangeableListActivity
 */
public class ChangeableItemActivity extends org.wheatgenetics.androidlibrary.mstrdtl.ItemActivity
implements org.wheatgenetics.androidlibrary.mstrdtl.ItemFragment.GetterChanger
{
    // region Overridden Methods
    @java.lang.Override protected java.lang.Class listActivityClass()
    { return org.wheatgenetics.androidlibraryuser.mstrdtl.ChangeableListActivity.class; }

    // region org.wheatgenetics.androidlibrary.mstrdtl.ItemFragment.GetterChange Overridden Methods
    @java.lang.Override public org.wheatgenetics.javalib.mstrdtl.Item get(
    @android.support.annotation.IntRange(from = org.wheatgenetics.javalib.mstrdtl.Item.MIN_POSITION)
        final int position)
    { return org.wheatgenetics.androidlibraryuser.mstrdtl.ChangeableItems.ITEMS().get(position); }

    @java.lang.Override public void change(
    @android.support.annotation.NonNull final org.wheatgenetics.javalib.mstrdtl.Item item)
    {
        ((org.wheatgenetics.androidlibraryuser.mstrdtl.ChangeableItem) item).setContent(
            "changed in one-pane mode");
    }
    // endregion
    // endregion
}
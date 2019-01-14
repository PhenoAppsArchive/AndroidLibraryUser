package org.wheatgenetics.androidlibraryuser.mstrdtl;

/**
 * Uses:
 * android.support.annotation.IntRange
 * android.support.annotation.NonNull
 * android.support.annotation.Nullable
 * android.support.annotation.RestrictTo
 * android.support.annotation.RestrictTo.Scope
 *
 * org.wheatgenetics.javalib.mstrdtl.Item
 * org.wheatgenetics.javalib.mstrdtl.Items
 *
 * org.wheatgenetics.androidlibraryuser.mstrdtl.Item
 */
@java.lang.SuppressWarnings({"ClassExplicitlyExtendsObject"})
class Items extends java.lang.Object implements org.wheatgenetics.javalib.mstrdtl.Items
{
    @android.support.annotation.RestrictTo(android.support.annotation.RestrictTo.Scope.SUBCLASSES)
    static final int MAX_POSITION = 24;

    // region Fields
    private java.util.List<org.wheatgenetics.androidlibraryuser.mstrdtl.Item>               // lazy
        itemsInstance = null;                                                               //  load
    private static org.wheatgenetics.androidlibraryuser.mstrdtl.Items                       // lazy
        ITEMS_INSTANCE = null;                                                              //  load
    // endregion

    @android.support.annotation.NonNull
    private java.util.List<org.wheatgenetics.androidlibraryuser.mstrdtl.Item> items()
    {
        if (null == this.itemsInstance)
            // noinspection Convert2Diamond
            this.itemsInstance =
                new java.util.ArrayList<org.wheatgenetics.androidlibraryuser.mstrdtl.Item>();
        return this.itemsInstance;
    }

    // region Overridden Methods
    @java.lang.Override
    public void add(@android.support.annotation.NonNull org.wheatgenetics.javalib.mstrdtl.Item item)
    { this.items().add((org.wheatgenetics.androidlibraryuser.mstrdtl.Item) item); }

    @java.lang.Override public void append()
    { this.add(new org.wheatgenetics.androidlibraryuser.mstrdtl.Item(this.size())); }

    @android.support.annotation.IntRange(from = org.wheatgenetics.javalib.mstrdtl.Item.MIN_POSITION)
    @java.lang.Override public int size()
    { return null == this.itemsInstance ? 0 : this.itemsInstance.size(); }

    @android.support.annotation.Nullable @java.lang.Override
    public org.wheatgenetics.javalib.mstrdtl.Item get(
    @android.support.annotation.IntRange(from = org.wheatgenetics.javalib.mstrdtl.Item.MIN_POSITION)
        final int position)
    {
        if (position < org.wheatgenetics.javalib.mstrdtl.Item.MIN_POSITION)
            throw new java.lang.IllegalArgumentException(
                org.wheatgenetics.javalib.mstrdtl.Item.TOO_SMALL_POSITION_MESSAGE);
        return null == this.itemsInstance ? null : this.itemsInstance.get(position);
    }
    // endregion

    static org.wheatgenetics.androidlibraryuser.mstrdtl.Items ITEMS()
    {
        if (null == ITEMS_INSTANCE)
        {
            ITEMS_INSTANCE = new org.wheatgenetics.androidlibraryuser.mstrdtl.Items();

            for (int position = org.wheatgenetics.androidlibraryuser.mstrdtl.Item.MIN_POSITION;
            position <= org.wheatgenetics.androidlibraryuser.mstrdtl.Items.MAX_POSITION; position++)
                ITEMS_INSTANCE.add(
                    new org.wheatgenetics.androidlibraryuser.mstrdtl.Item(position));
        }
        return ITEMS_INSTANCE;
    }
}
package org.wheatgenetics.androidlibraryuser.mstrdtl;

/**
 * Uses:
 * org.wheatgenetics.androidlibraryuser.mstrdtl.ChangeableItem
 * org.wheatgenetics.androidlibraryuser.mstrdtl.Items
 */
class ChangeableItems extends org.wheatgenetics.androidlibraryuser.mstrdtl.Items
{
    private static org.wheatgenetics.androidlibraryuser.mstrdtl.ChangeableItems             // lazy
        ITEMS_INSTANCE = null;                                                              //  load

    @java.lang.Override public void append()
    { this.add(new org.wheatgenetics.androidlibraryuser.mstrdtl.ChangeableItem(this.size())); }

    static org.wheatgenetics.androidlibraryuser.mstrdtl.ChangeableItems ITEMS()
    {
        if (null == ITEMS_INSTANCE)
        {
            ITEMS_INSTANCE = new org.wheatgenetics.androidlibraryuser.mstrdtl.ChangeableItems();

            final int
                MIN_POSITION =
                    org.wheatgenetics.androidlibraryuser.mstrdtl.ChangeableItem.MIN_POSITION,
                MAX_POSITION =
                    org.wheatgenetics.androidlibraryuser.mstrdtl.ChangeableItems.MAX_POSITION;
            for (int position = MIN_POSITION; position <= MAX_POSITION; position++)
                ITEMS_INSTANCE.add(
                    new org.wheatgenetics.androidlibraryuser.mstrdtl.ChangeableItem(position));
        }
        return ITEMS_INSTANCE;
    }
}
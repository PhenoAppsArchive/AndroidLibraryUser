package org.wheatgenetics.androidlibraryuser.mstrdtl;

/**
 * Uses:
 * android.support.annotation.NonNull
 *
 * org.wheatgenetics.javalib.mstrdtl.TestItems
 */
@java.lang.SuppressWarnings({"ClassExplicitlyExtendsObject"})
class TestItems extends java.lang.Object
{
    private static org.wheatgenetics.javalib.mstrdtl.TestItems TEST_ITEMS_INSTANCE = null;

    @android.support.annotation.NonNull
    static org.wheatgenetics.javalib.mstrdtl.TestItems TEST_ITEMS()
    {
        if (null == org.wheatgenetics.androidlibraryuser.mstrdtl.TestItems.TEST_ITEMS_INSTANCE)
            org.wheatgenetics.androidlibraryuser.mstrdtl.TestItems.TEST_ITEMS_INSTANCE =
                new org.wheatgenetics.javalib.mstrdtl.TestItems();
        return org.wheatgenetics.androidlibraryuser.mstrdtl.TestItems.TEST_ITEMS_INSTANCE;
    }
}
package org.wheatgenetics.androidlibraryuser.mstrdtl;

/**
 * Uses:
 * android.support.annotation.IntRange
 *
 * org.wheatgenetics.javalib.mstrdtl.ChangeableItem
 *
 * org.wheatgenetics.androidlibraryuser.mstrdtl.Item
 */
class ChangeableItem extends org.wheatgenetics.androidlibraryuser.mstrdtl.Item
implements org.wheatgenetics.javalib.mstrdtl.ChangeableItem
{
    ChangeableItem(@android.support.annotation.IntRange(from =
    org.wheatgenetics.javalib.mstrdtl.Item.MIN_POSITION) final int position) { super(position); }

    @java.lang.Override public void setContent(final java.lang.String content)
    { this.content = this.getContent().concat('\n' + content); }
}
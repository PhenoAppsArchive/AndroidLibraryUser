package org.wheatgenetics.androidlibraryuser.mstrdtl;

/**
 * Uses:
 * android.support.annotation.IntRange
 * android.support.annotation.NonNull
 * android.support.annotation.RestrictTo
 * android.support.annotation.RestrictTo.Scope
 *
 * org.wheatgenetics.javalib.mstrdtl.Item
 */
@java.lang.SuppressWarnings({"ClassExplicitlyExtendsObject"})
class Item extends java.lang.Object implements org.wheatgenetics.javalib.mstrdtl.Item
{
    // region Fields
    @android.support.annotation.IntRange(from = org.wheatgenetics.javalib.mstrdtl.Item.MIN_POSITION)
    private final int position;

    @android.support.annotation.NonNull private final java.lang.String title;

    @android.support.annotation.RestrictTo(android.support.annotation.RestrictTo.Scope.SUBCLASSES)
    @android.support.annotation.NonNull java.lang.String content;
    // endregion

    @android.support.annotation.IntRange(from = org.wheatgenetics.javalib.mstrdtl.Item.MIN_POSITION)
    private int getPosition() { return this.position; }

    @java.lang.SuppressWarnings({"DefaultLocale"}) Item(
    @android.support.annotation.IntRange(from = org.wheatgenetics.javalib.mstrdtl.Item.MIN_POSITION)
        final int position)
    {
        super();

        if (position < org.wheatgenetics.javalib.mstrdtl.Item.MIN_POSITION)
            throw new java.lang.IllegalArgumentException(
                org.wheatgenetics.javalib.mstrdtl.Item.TOO_SMALL_POSITION_MESSAGE);
        this.position = position;
        this.title    = java.lang.String.format("Item %d", position + 1);

        final java.lang.StringBuilder builder = new java.lang.StringBuilder();
        builder.append("Content of ").append(this.getTitle()).append(':');
        for (int i = org.wheatgenetics.javalib.mstrdtl.Item.MIN_POSITION; i <= position; i++)
            builder.append("\nMore information here.");
        this.content = builder.toString();
    }

    // region Overridden Methods
    @android.support.annotation.NonNull @java.lang.Override public java.lang.String getTitle()
    { return this.title; }

    @android.support.annotation.NonNull @java.lang.Override public java.lang.String getContent()
    { return this.content; }

    @android.support.annotation.NonNull @java.lang.Override
    public java.lang.String getPositionAsString()
    { return java.lang.String.valueOf(this.getPosition()); }
    // endregion
}
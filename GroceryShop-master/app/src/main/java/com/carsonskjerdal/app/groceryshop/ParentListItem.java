package com.carsonskjerdal.app.groceryshop;

/**
 * Created by Carson on 2017-12-05.
 * <p>
 * Feel free to use code just give credit please :)
 */

import java.util.List;

/**
 * Interface for implementing required methods in a parent list item.
 */
public interface ParentListItem {

    /**
     * Getter for the list of this parent list item's child list items.
     * <p>
     * If list is empty, the parent list item has no children.
     *
     * @return A {@link List} of the children of this {@link ParentListItem}
     */
    List<?> getChildItemList();

    /**
     * Getter used to determine if this {@link ParentListItem}'s
     * {@link android.view.View} should show up initially as expanded.
     *
     * @return true if expanded, false if not
     */
    boolean isInitiallyExpanded();
}

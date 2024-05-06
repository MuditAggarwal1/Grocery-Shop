package com.carsonskjerdal.app.groceryshop;




import java.util.List;

/**
 * Created by Carson on 2017-11-22.
 * <p>
 * Feel free to use code just give credit please :)
 */

public final class Products implements ParentListItem {

    private String name;
    private String image;
    private List<ProductsChild> mChildrenList;

    public Products(String name, String image, List<ProductsChild> productsChildren){

        this.name = name;
        this.image = image;
        mChildrenList = productsChildren;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getImage() {
        return image;
    }


    @Override
    public List<?> getChildItemList() {
        return mChildrenList;
    }

    @Override
    public boolean isInitiallyExpanded() {
        return false;
    }
}

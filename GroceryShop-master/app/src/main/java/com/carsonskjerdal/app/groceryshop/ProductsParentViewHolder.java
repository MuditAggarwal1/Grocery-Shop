package com.carsonskjerdal.app.groceryshop;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.View;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Carson on 2017-11-28.
 * <p>
 * Feel free to use code just give credit please :)
 */

public class ProductsParentViewHolder extends ParentViewHolder{

    public TextView mTitleTextView;
    public ImageView mIconView;
    public ImageView mParentDropDownArrow;

    private static final float INITIAL_POSITION = 0.0f;
    private static final float ROTATED_POSITION = 180f;

    public ProductsParentViewHolder(View itemView) {
        super(itemView);

        mTitleTextView = itemView.findViewById(R.id.name);
        mIconView = itemView.findViewById(R.id.image);
        mParentDropDownArrow = itemView.findViewById(R.id.parent_list_item_expand_arrow);
    }

    public void bind(@NonNull Products product) {

        //set the text of item
        mTitleTextView.setText(product.getName());

        //set item image
        Resources res = itemView.getContext().getResources();
        String uri = product.getImage();
        mIconView.setImageResource(res.getIdentifier(uri, "drawable", BuildConfig.APPLICATION_ID));
    }

    @Override
    public void setExpanded(boolean expanded) {
        super.setExpanded(expanded);

        if (expanded) {
            mParentDropDownArrow.setRotation(ROTATED_POSITION);
        } else {
            mParentDropDownArrow.setRotation(INITIAL_POSITION);
        }

    }

    @Override
    public void onExpansionToggled(boolean expanded) {
        super.onExpansionToggled(expanded);

        RotateAnimation rotateAnimation;
        if (expanded) { // rotate clockwise
            rotateAnimation = new RotateAnimation(ROTATED_POSITION,
                    INITIAL_POSITION,
                    RotateAnimation.RELATIVE_TO_SELF, 0.5f,
                    RotateAnimation.RELATIVE_TO_SELF, 0.5f);
        } else { // rotate counterclockwise
            rotateAnimation = new RotateAnimation(-1 * ROTATED_POSITION,
                    INITIAL_POSITION,
                    RotateAnimation.RELATIVE_TO_SELF, 0.5f,
                    RotateAnimation.RELATIVE_TO_SELF, 0.5f);
        }

        rotateAnimation.setDuration(200);
        rotateAnimation.setFillAfter(true);
        mParentDropDownArrow.startAnimation(rotateAnimation);

    }
}

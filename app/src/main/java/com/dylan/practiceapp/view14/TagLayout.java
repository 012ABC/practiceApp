package com.dylan.practiceapp.view14;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * description
 *
 * @author created by ABC
 * @date 2019/6/4 16:07
 */
public class TagLayout extends ViewGroup {

    private List<Rect> childrenBounds = new ArrayList<>();

    public TagLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int widthUsed = 0;
        int heightUsed = 0;
        int lineHeight = 0;
        int lineWidthUse = 0;
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);

        for (int i = 0; i < getChildCount(); i++) {
            View child = getChildAt(i);
            measureChildWithMargins(child, widthMeasureSpec, 0, heightMeasureSpec, heightUsed);
            if (widthMode != MeasureSpec.UNSPECIFIED &&
                    lineWidthUse + child.getMeasuredWidth() > widthSize) {
                lineWidthUse = 0;
                heightUsed += lineHeight;
                measureChildWithMargins(child, widthMeasureSpec, 0, heightMeasureSpec, heightUsed);
            }
            Rect childBounds;
            if (childrenBounds.size() <= i) {
                childBounds = new Rect();
                childrenBounds.add(childBounds);
            } else {
                childBounds = childrenBounds.get(i);
            }
            childBounds.set(lineWidthUse, heightUsed, lineWidthUse + child.getMeasuredWidth(),
                    heightUsed + child.getMeasuredHeight());


            lineWidthUse += child.getMeasuredWidth();
            widthUsed = Math.max(lineWidthUse, widthUsed);
            lineHeight = Math.max(lineHeight, child.getMeasuredHeight());
        }

        int measuredWidth = widthUsed;
        heightUsed += lineHeight;
        int measuredHeight = heightUsed;
        setMeasuredDimension(measuredWidth, measuredHeight);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        for (int i = 0; i < getChildCount(); i++) {
            View child = getChildAt(i);
            Rect childRect = childrenBounds.get(i);
            child.layout(childRect.left, childRect.top, childRect.right, childRect.bottom);
        }
    }

    @Override
    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new MarginLayoutParams(getContext(), attributeSet);
    }
}

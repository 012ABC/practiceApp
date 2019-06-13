package com.dylan.practiceapp.view14;

import android.content.Context;
import androidx.appcompat.widget.AppCompatImageView;
import android.util.AttributeSet;

/**
 * description
 *
 * @author created by ABC
 * @date 2019/6/3 15:12
 */
public class SquareImageView extends AppCompatImageView {


    public SquareImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        int size = Math.max(measuredHeight, measuredWidth);
        setMeasuredDimension(size, size);
    }

}

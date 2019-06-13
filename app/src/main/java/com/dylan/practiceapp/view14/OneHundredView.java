package com.dylan.practiceapp.view14;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

/**
 * description
 *
 * @author created by ABC
 * @date 2019/6/3 14:56
 */
public class OneHundredView extends View {

    public OneHundredView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        setMeasuredDimension(100,100);
    }
}

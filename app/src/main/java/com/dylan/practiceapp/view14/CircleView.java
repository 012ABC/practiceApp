package com.dylan.practiceapp.view14;

import android.content.Context;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import com.dylan.practiceapp.util.ScreenUtils;

/**
 * description
 *
 * @author created by ABC
 * @date 2019/6/3 15:41
 */
public class CircleView extends View {

    private Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);

    private float radius = ScreenUtils.dip2px(80);

    public CircleView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int measuredWidth;
        int measuredHeight;
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);


    }
}

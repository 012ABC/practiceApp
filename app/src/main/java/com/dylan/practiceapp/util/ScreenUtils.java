package com.dylan.practiceapp.util;

import android.content.res.Resources;

/**
 * description
 *
 * @author created by ABC
 * @date 2019/6/3 09:43
 */
public class ScreenUtils {
    /**
     * dip转为 px
     */
    public static int dip2px(float dipValue) {
        final float scale = Resources.getSystem().getDisplayMetrics().density;
        return (int) (dipValue * scale + 0.5f);
    }
}

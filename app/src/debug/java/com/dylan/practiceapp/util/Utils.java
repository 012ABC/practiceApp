package com.dylan.practiceapp.util;

import android.app.Activity;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;

/**
 * description
 *
 * @author created by ABC
 * @date 2019/6/11 09:37
 */
public class Utils {

    public static void drawBadge(Activity activity) {
        ViewGroup decorview = ((ViewGroup) activity.getWindow().getDecorView());
        View badge = new View(activity);
        badge.setBackgroundColor(Color.GREEN);
        decorview.addView(badge,100,100);
    }
}

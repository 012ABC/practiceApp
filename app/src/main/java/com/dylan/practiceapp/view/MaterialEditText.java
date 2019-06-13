package com.dylan.practiceapp.view;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import androidx.appcompat.widget.AppCompatEditText;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;

import com.dylan.practiceapp.R;
import com.dylan.practiceapp.util.ScreenUtils;

/**
 * description
 *
 * @author created by ABC
 * @date 2019/6/3 09:36
 */
public class MaterialEditText extends AppCompatEditText {

    private static final float TEXT_SIZE = ScreenUtils.dip2px(12);
    private static final float TEXT_PADDING = ScreenUtils.dip2px(8);
    private static final float VERTICAL_OFFSET = ScreenUtils.dip2px(38);
    private static final float HORIZONTAL_OFFSET = ScreenUtils.dip2px(5);
    private static final float VERTICAL_OFFSET_EXTRA = ScreenUtils.dip2px(16);

    private Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);

    private boolean floatingLabelShow;

    private ObjectAnimator animator;

    private float floatingLabelFraction;

    private boolean useFloatingLabel = true;
    private Rect backGroundPadding = new Rect();

    public MaterialEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attributeSet) {
        TypedArray typedValue = context.obtainStyledAttributes(attributeSet, R.styleable.MaterialEditText);
        useFloatingLabel = typedValue.getBoolean(R.styleable.MaterialEditText_useFloatingLabel, true);
        mPaint.setTextSize(TEXT_SIZE);
        setTopPadding();
        setPadding(getPaddingLeft(), (int) (getPaddingTop() + TEXT_SIZE + TEXT_PADDING), getPaddingRight(),
                getPaddingBottom());
        addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (floatingLabelShow && TextUtils.isEmpty(s)) {
                    floatingLabelShow = !floatingLabelShow;
                    getAnimator().reverse();
                } else if (!floatingLabelShow && !TextUtils.isEmpty(s)) {
                    floatingLabelShow = !floatingLabelShow;
                    getAnimator().start();
                }
            }
        });
        typedValue.recycle();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        mPaint.setAlpha((int) floatingLabelFraction * 0xff);
        canvas.drawText(getHint().toString(), HORIZONTAL_OFFSET,
                VERTICAL_OFFSET - floatingLabelFraction * VERTICAL_OFFSET_EXTRA, mPaint);
    }

    public float getFloatingLabelFraction() {
        return floatingLabelFraction;
    }

    public void setFloatingLabelFraction(float floatingLabelFraction) {
        this.floatingLabelFraction = floatingLabelFraction;
        invalidate();
    }

    public ObjectAnimator getAnimator() {
        if (animator == null) {
            animator = ObjectAnimator.ofFloat(MaterialEditText.this, "floatingLabelFraction"
                    , 0, 1);
        }
        return animator;
    }

    public void setUseFloatingLabel(boolean useFloatingLabel) {
        if (this.useFloatingLabel != useFloatingLabel) {
            this.useFloatingLabel = useFloatingLabel;
            setTopPadding();
        }
    }

    private void setTopPadding() {
        getBackground().getPadding(backGroundPadding);
        if (useFloatingLabel) {
            setPadding(backGroundPadding.left, (int) (backGroundPadding.top + TEXT_SIZE + TEXT_PADDING)
                    , backGroundPadding.right, backGroundPadding.bottom);
        } else {
            setPadding(backGroundPadding.left, (int) (backGroundPadding.top - TEXT_PADDING - TEXT_SIZE)
                    , backGroundPadding.right, backGroundPadding.bottom);
        }
    }
}

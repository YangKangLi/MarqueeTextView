package com.github.yangkangli.marquee_text_view;


import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatTextView;

public class MarqueeTextView extends AppCompatTextView {

    // 刚显示时不滚动保持的时间
    private static final int FIRST_HOLD_TIME = 100;
    // 滚动之间的间隔
    private static final int MARGIN_BETWEEN = 100;
    // 每次移动的横跨长度，可用于控制速度
    private static final int MOVE_STEP = 5;

    // 标记是否测量
    private boolean shouldMarquee = false;

    // 文字宽度
    private int textWidth;

    // 控件宽度
    private int viewWidth;

    private Paint paint;

    private Paint.FontMetricsInt metrics;

    // 文字X,Y轴的坐标
    private float posX1, posX2, posY;

    // 中间的间隙
    private int marginBetween;

    // 每次绘制时移动的距离
    private int moveStep;

    // 第一次绘制时停留的时间（单位毫秒）
    private int firstHoldTime;

    private String text;

    private Handler handler;


    public MarqueeTextView(@NonNull Context context) {
        super(context);
        init(null);
    }

    public MarqueeTextView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(attrs);
    }

    public MarqueeTextView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs);
    }

    private void init(@Nullable AttributeSet attrs) {
        paint = getPaint();
        handler = new Handler(Looper.getMainLooper());
        metrics = new Paint.FontMetricsInt();
        if (attrs != null) {
            TypedArray array = getContext().obtainStyledAttributes(attrs, R.styleable.MarqueeTextView);
            marginBetween = array.getDimensionPixelSize(R.styleable.MarqueeTextView_marquee_margin_between, MARGIN_BETWEEN);
            moveStep = array.getInt(R.styleable.MarqueeTextView_marquee_move_step, MOVE_STEP);
            firstHoldTime = array.getInt(R.styleable.MarqueeTextView_marquee_first_hold_time, FIRST_HOLD_TIME);
            array.recycle();
        } else {
            marginBetween = MARGIN_BETWEEN;
            moveStep = MOVE_STEP;
            firstHoldTime = FIRST_HOLD_TIME;
        }
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);

        // 计算得到文字的宽度和控件的宽度
        text = getText().toString();
        textWidth = (int) paint.measureText(text);
        viewWidth = getWidth();

        // 移除所有消息
        handler.removeCallbacksAndMessages(null);

        // 初始化是否需要滚动(文字的宽度大于控件的宽度，则需要滚动)
        boolean marquee = textWidth > viewWidth;
        paint.getFontMetricsInt(metrics);
        posY = Math.abs(metrics.top) + getPaddingTop();
        if (marquee) {
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    posX1 = 0;
                    shouldMarquee = true;
                    invalidate();
                }
            }, firstHoldTime);
        }
        shouldMarquee = false;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        if (shouldMarquee) {
            calculatePosition();
            canvas.drawText(text, posX1, posY, paint);
            canvas.drawText(text, posX2, posY, paint);
            invalidate();
        } else {
            super.onDraw(canvas);
        }
    }

    /**
     * 计算位置
     */
    private void calculatePosition() {
        posX1 -= moveStep;
        // 如果第一个文本还在显示，则第二个文本按照第一个文本的位置计算
        if (posX1 < 0 && Math.abs(posX1) <= textWidth) {
            posX2 = posX1 + textWidth + marginBetween;
        } else {
            posX2 -= moveStep;
            posX1 = posX2 + textWidth + marginBetween;
        }
    }
}

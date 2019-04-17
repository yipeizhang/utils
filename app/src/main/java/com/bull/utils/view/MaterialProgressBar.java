package com.bull.utils.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

public class MaterialProgressBar extends View {

    private int mStartAngle = 0;

    private int mSweepAngle = 20;

    private static final int YOUNG_STAGE = 10;
    private static final int STRONG_STAGE_1 = 11;
    private static final int STRONG_STAGE_2 = 12;
    private static final int STRONG_STAGE_3 = 13;
    private static final int OLD_STAGE = 14;
    private int mProgressStage = YOUNG_STAGE;

    private Paint mPaint = new Paint();

    private int mStrokeWidth = dip2px(getContext(), 3);

    public MaterialProgressBar(Context context) {
        super(context);
        initPaint();
    }

    public MaterialProgressBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        initPaint();
    }

    private void initPaint(){
        mPaint.setAntiAlias(true);
        mPaint.setStrokeWidth(mStrokeWidth);
        mPaint.setColor(Color.parseColor("#D81B60"));
        mPaint.setStyle(Paint.Style.STROKE);
    }

    /**
     * 设置加载条的颜色
     * @param colorRes
     */
    public void setColor(int colorRes) {
        mPaint.setColor(getContext().getResources().getColor(colorRes));
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        realDraw(canvas);
    }



    private void realDraw(Canvas canvas){
        int diameter = getWidth() > getHeight() ? getHeight() - mStrokeWidth * 2: getWidth() - mStrokeWidth * 2;
        RectF rect = new RectF(mStrokeWidth, mStrokeWidth, diameter, diameter);
        switch (mProgressStage){
            case YOUNG_STAGE:
                mSweepAngle += 3;
                mStartAngle += 2;
                if (mSweepAngle > 60) {
                    mProgressStage = STRONG_STAGE_1;
                }
                break;
            case STRONG_STAGE_1:
                mSweepAngle += 6;
                mStartAngle += 2;
                if (mSweepAngle > 150) {
                    mProgressStage = STRONG_STAGE_2;
                }
                break;
            case STRONG_STAGE_2:
                mSweepAngle += 8;
                mStartAngle += 2;
                if (mSweepAngle > 240) {
                    mProgressStage = STRONG_STAGE_3;
                }
                break;
            case STRONG_STAGE_3:
                mSweepAngle += 10;
                mStartAngle += 2;
                if (mSweepAngle > 330) {
                    mProgressStage = OLD_STAGE;
                }
                break;
            case OLD_STAGE:
                mStartAngle += 6;
                mSweepAngle -= 4;
                if (mSweepAngle < 20) {
                    mProgressStage = YOUNG_STAGE;
                }
                break;
        }
        canvas.drawArc(rect, mStartAngle, mSweepAngle, false, mPaint);
        invalidate();
    }

    private static int dip2px(Context context, float dpValue) {
        float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }
}

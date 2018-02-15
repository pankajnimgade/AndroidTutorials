/*
 *  Copyright 2017 The Android Open Source Project
 *  Licensed under the @{PK Solutions} , Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *       http://www.example.org/licenses/LICENSE-2.0 {this is not required (^.^) }
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package com.test.sdg.newfeatures.activities.circle.animation;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewDebug;

/**
 * Created by Pankaj Nimgade on 2/15/2018.
 */

public class CircleView extends View {

    private static final int DEFAULT_CIRCLE_COLOR = Color.BLUE;

    private int circleColor = DEFAULT_CIRCLE_COLOR;
    private Paint paint;
    private float radius;
    private float strokeWidth;


    public CircleView(Context context) {
        super(context);
    }

    public CircleView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        paint = new Paint();
        paint.setAntiAlias(true);
    }

    public void setCircleColor(int circleColor) {
        this.circleColor = circleColor;
        invalidate();
    }


    @ViewDebug.CapturedViewProperty
    public final void setRadius(float radius) {
        this.radius = radius;
    }

    @ViewDebug.CapturedViewProperty
    public final void setStrokeWidth(float strokeWidth) {
        this.strokeWidth = strokeWidth;
    }

    public int getCircleColor() {
        return circleColor;
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        super.onDraw(canvas);

        int w = getWidth();
        int h = getHeight();

        int pl = getPaddingLeft();
        int pr = getPaddingRight();
        int pt = getPaddingTop();
        int pb = getPaddingBottom();

        int usableWidth = w - (pl + pr);
        int usableHeight = h - (pt + pb);

        if (radius <= 0.0) {
            radius = Math.min(usableWidth, usableHeight) / 2;
        }
        int cx = pl + (usableWidth / 2);
        int cy = pt + (usableHeight / 2);

        paint.setColor(circleColor);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(strokeWidth);
        paint.setPathEffect(new DashPathEffect(new float[]{4, 45}, 0));
        paint.setFakeBoldText(true);
        canvas.drawCircle(cx, cy, radius, paint);

    }
}

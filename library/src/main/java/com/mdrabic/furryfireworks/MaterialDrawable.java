package com.mdrabic.furryfireworks;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.drawable.BitmapDrawable;
import android.os.SystemClock;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;

/**
 * A drawable that animates its bitmap on {@link android.graphics.drawable.BitmapDrawable#setVisible(boolean, boolean)}
 * (true, true) in a way that is recommended by the Material style guide.
 *
 * {@see http://www.google.com/design/spec/patterns/imagery-treatment.html}
 */
public class MaterialDrawable extends BitmapDrawable {

    private static final String TAG = MaterialDrawable.class.getSimpleName();
    private static final float FULL_DURATION = 3000f;
    private static final float SAT_DURATION = FULL_DURATION;
    private static final float GAMMA_DURATION = FULL_DURATION * .75f;
    private static final float ALPHA_DURATION = FULL_DURATION * .5f;

    private boolean animating;
    private long startTime;
    private ColorMatrix matrix = new ColorMatrix();
    private Interpolator interpolator = new DecelerateInterpolator();

    public MaterialDrawable(Resources res, Bitmap bitmap) {
        super(res, bitmap);
    }

    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (!animating) {
            super.draw(canvas);
        } else {
            long elapsed = SystemClock.uptimeMillis() - startTime;
            float percentComplete = elapsed / FULL_DURATION;
            if (percentComplete >= 1f) {
                animating = false;
                super.draw(canvas);
            } else {
                //animate saturation
                if ((elapsed / SAT_DURATION) < 1f) {
                    float interpolation = interpolator.getInterpolation(elapsed / SAT_DURATION);
                    matrix.setSaturation(interpolation);
                }

                //animate alpha
                if ((elapsed / ALPHA_DURATION) < 1f) {
                    float interpolation = interpolator.getInterpolation(elapsed / ALPHA_DURATION);
                    matrix.setAlpha(interpolation);
                }

                //animate gamma
                if ((elapsed / GAMMA_DURATION) < 1f) {
                    float interpolation = interpolator.getInterpolation(elapsed / GAMMA_DURATION);
                    matrix.setGamma(translateGamma(interpolation));
                }

                setColorFilter(new ColorMatrixColorFilter(matrix));
                super.draw(canvas);
            }
        }
    }

    @Override
    public boolean setVisible(boolean visible, boolean restart) {
        if (visible && restart) {
            animating = true;
            startTime = SystemClock.uptimeMillis();
            matrix.setAlpha(0);
            setColorFilter(new ColorMatrixColorFilter(matrix));
        }
        return super.setVisible(visible, restart);
    }


    /*
     * Translate gamma to a value between 0 and 5 where 0 translates to 1 (100%) and
     * 0 translates to 0 (0%). Setting the max gamma to greater than 5 causes the whites
     * to be blown out a little too much, IMO.
     */
    private static float translateGamma(float percent) {
        return 5 - (5 * percent);
    }
}

package com.mdrabic.furryfireworks;

/**
 * A {@link android.graphics.ColorMatrix} with support for setting gamma and alpha values.
 */
public class ColorMatrix extends android.graphics.ColorMatrix {

    public ColorMatrix() {
        super();
    }

    public ColorMatrix(float[] src) {
        super(src);
    }

    public ColorMatrix(android.graphics.ColorMatrix src) {
        super(src);
    }

    public ColorMatrix(ColorMatrix src) {
        super(src.getArray());
    }

    public void setAlpha(float alpha) {
        float[] m = getArray();
        m[18] = alpha;
        set(m);
    }

    public void setGamma(float gamma) {
        float[] m = getArray();
        m[4] = gamma;
        m[9] = gamma;
        m[14] = gamma;
        set(m);
    }
}

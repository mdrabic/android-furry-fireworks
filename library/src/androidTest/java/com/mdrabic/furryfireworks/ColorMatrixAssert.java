package com.mdrabic.furryfireworks;


import org.assertj.core.api.AbstractAssert;

/**
 * Custom assertions for {@link com.mdrabic.furryfireworks.ColorMatrix}.
 */
public class ColorMatrixAssert extends AbstractAssert<ColorMatrixAssert, ColorMatrix> {

    public ColorMatrixAssert(ColorMatrix actual) {
        super(actual, ColorMatrixAssert.class);
    }

    public static ColorMatrixAssert assertThat(ColorMatrix matrix) {
        return new ColorMatrixAssert(matrix);
    }

    public ColorMatrixAssert hasAlpha(float alpha) {
        isNotNull();

        float actualAlpha = actual.getArray()[18];
        if (actualAlpha != alpha) {
            failWithMessage("Expected alpha is %s but was %s", actualAlpha, alpha);
        }

        return this;
    }

    public ColorMatrixAssert hasGamma(float gamma) {
        isNotNull();

        float[] m = actual.getArray();
        if (m[4] != gamma)
            failWithMessage("Expected gamma at matrix[4] is %s but was %s.", gamma, m[4]);
        if (m[9] != gamma)
            failWithMessage("Expected gamma at matrix[9] is %s but was %s.", gamma, m[9]);
        if (m[14] != gamma)
            failWithMessage("Expected gamma at matrix[14] is %s but was %s.", gamma, m[14]);

        return this;
    }
}

package com.mdrabic.furryfireworks;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

@Config(emulateSdk = 18) //19+ is not supported
@RunWith(RobolectricTestRunner.class)
public class ColorMatrixTest {

    @Test
    public void testSetAlpha() {
        ColorMatrix matrix = new ColorMatrix();
        matrix.setAlpha(.5f);
        ColorMatrixAssert.assertThat(matrix).hasAlpha(.5f);
    }

    @Test
    public void testSetGamma() {
        ColorMatrix matrix = new ColorMatrix();
        matrix.setGamma(.5f);
        ColorMatrixAssert.assertThat(matrix).hasGamma(.5f);
    }
}

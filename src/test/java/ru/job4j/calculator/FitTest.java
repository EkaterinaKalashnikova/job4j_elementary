package ru.job4j.calculator;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class FitTest {
    @Test
    public void testCalculateManWeightReturnsCorrectWeight() {
        short heightMan = 187;
        double expectedWeight = (heightMan - Fit.BASE_HEIGHT_MAN) * Fit.WEIGHT_COEFFICIENT;
        double actualWeight = Fit.calculateManWeight(heightMan);
        assertEquals(expectedWeight, actualWeight, 0.01);
    }

    @Test
    public void testCalculateManWeightReturnsZeroWhenHeightManEqualsBaseHeightMan() {
        short heightMan = Fit.BASE_HEIGHT_MAN;
        double actualWeight = Fit.calculateManWeight(heightMan);
        assertEquals(0, actualWeight, 0.01);
    }
}
    

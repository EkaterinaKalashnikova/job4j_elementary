package ru.job4j.calculator;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class FitTest {
    @Test
    void givenHeightManWhenCalculateIdealWeightThenCorrect() {
        short heightMan = 187;
        double expectedWeight = (heightMan - Fit.BASE_HEIGHT_MAN) * Fit.WEIGHT_COEFFICIENT;
        double actualWeight = Fit.calculateIdealWeight(heightMan, Fit.BASE_HEIGHT_MAN);
        assertThat(actualWeight).isEqualTo(expectedWeight);
    }

    @Test
    void givenHeightWomanWhenCalculateIdealWeightThenCorrect() {
        short heightWoman = 170;
        double expectedWeight = (heightWoman - Fit.BASE_HEIGHT_WOMAN) * Fit.WEIGHT_COEFFICIENT;
        double actualWeight = Fit.calculateIdealWeight(heightWoman, Fit.BASE_HEIGHT_WOMAN);
        assertThat(actualWeight).isEqualTo(expectedWeight);
    }

    @Test
    void givenShortManHeightWhenCalculateIdealWeightThenZeroOrNegative() {
        short heightMan = 100;
        double expectedWeight = (heightMan - Fit.BASE_HEIGHT_MAN) * Fit.WEIGHT_COEFFICIENT;
        double actualWeight = Fit.calculateIdealWeight(heightMan, Fit.BASE_HEIGHT_MAN);
        assertThat(actualWeight).isEqualTo(expectedWeight);
    }

    @Test
    void givenShortWomanHeightWhenCalculateIdealWeightThenZeroOrNegative() {
        short heightWoman = 110;
        double expectedWeight = (heightWoman - Fit.BASE_HEIGHT_WOMAN) * Fit.WEIGHT_COEFFICIENT;
        double actualWeight = Fit.calculateIdealWeight(heightWoman, Fit.BASE_HEIGHT_WOMAN);
        assertThat(actualWeight).isEqualTo(expectedWeight);
    }
}
    /**  @Test
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
    }*/

    

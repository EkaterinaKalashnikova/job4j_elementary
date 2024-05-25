package ru.job4j.calculator;

/**
 * Класс Fit предназначен для расчёта идеального веса
 * для мужчин и женщин на основе их роста
 */
public class Fit {
    protected static final short BASE_HEIGHT_MAN = 100;
    protected static final short BASE_HEIGHT_WOMAN = 110;
    protected static final double WEIGHT_COEFFICIENT = 1.15;

    /**
     * Метод рассчитывает идеальный вес на основе роста и базового значения роста
     *
     * @param height     рост человека
     * @param baseHeight базовое значение роста для расчета
     * @return идеальный вес для введенного значения роста
     */
    public static double calculateIdealWeight(short height, short baseHeight) {
        return (height - baseHeight) * WEIGHT_COEFFICIENT;
    }

    public static void main(String[] args) {
        short heightMan = 187;
        short heightWoman = 170;

        double manWeight = calculateIdealWeight(heightMan, BASE_HEIGHT_MAN);
        System.out.printf("Man %d is %.2f%n", heightMan, manWeight);

        double womanWeight = calculateIdealWeight(heightWoman, BASE_HEIGHT_WOMAN);
        System.out.printf("Woman %d is %.2f%n", heightWoman, womanWeight);
    }
}


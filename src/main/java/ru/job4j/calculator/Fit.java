package ru.job4j.calculator;

/**
 * Класс Fit предназначен для расчёта идеального веса
 * для мужчин и женщин на основе их роста
 */
public class Fit {
    protected static final short BASE_HEIGHT_MAN = 100;
    private static final short BASE_HEIGHT_WOMAN = 110;
    protected static final double WEIGHT_COEFFICIENT = 1.15;

    /**
     * Метод рассчитывает идеальный вес мужчины
     * @param heightMan рост мужчины
     * @return идеальный вес для введенного значения роста
     */
    public static double calculateManWeight(short heightMan) {
        return (heightMan - BASE_HEIGHT_MAN) * WEIGHT_COEFFICIENT;
    }

    /**
     * Метод рассчитывает идеальный вес женщины
     * @param heightWoman рост женщины
     * @return идеальный вес для введенного значения роста
     */
    public static double calculateWomanWeight(short heightWoman) {
        return (heightWoman - BASE_HEIGHT_WOMAN) * WEIGHT_COEFFICIENT;
    }

    public static void main(String[] args) {
        short heightMan = 187;
        short heightWoman = 170;
        double man = Fit.calculateManWeight(heightMan);
        System.out.println(String.format("Man %d is %.2f", heightMan, man));
        double woman = Fit.calculateWomanWeight(heightWoman);
        System.out.println(String.format("Woman %d is %.2f", heightWoman, woman));
    }
}

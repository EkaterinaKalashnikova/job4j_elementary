package ru.job4j.hashmap;

import java.util.*;

public record AnalyzeByMap() {
    public static double averageScore(List<Pupil> pupils) {
        int counter = 0;
        double sum = 0;
        for (Pupil pupil : pupils) {
            for (Subject sub : pupil.subjects()) {
                sum += sub.score();
                counter++;
            }
        }
        return sum / counter;
    }

    public static List<Label> averageScoreByPupil(List<Pupil> pupils) {
        List<Label> list = new ArrayList<>();
        for (Pupil pupil : pupils) {
            double sum = 0;
            double sumAll = 0;
            for (Subject sub : pupil.subjects()) {
                sum += sub.score();
                sumAll = sum / pupil.subjects().size();
            }
            list.add(new Label(pupil.name(), sumAll));
        }
        return list;
    }

    public static List<Label> averageScoreBySubject(List<Pupil> pupils) {
        Map<String, Integer> maps = new LinkedHashMap<>();
        search(pupils, maps);
        List<Label> list = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : maps.entrySet()) {
            list.add(new Label(entry.getKey(), (double) entry.getValue() / pupils.size()));
        }
        return list;
    }

    private static void search(List<Pupil> pupils, Map<String, Integer> maps) {
        for (Pupil pupil : pupils) {
            for (Subject sub : pupil.subjects()) {
                Integer sum = maps.get(sub.name());
                if (sum == null) {
                    sum = sub.score();
                } else {
                    sum += sub.score();
                }
                maps.put(sub.name(), sum);
            }
        }
    }

    public static Label bestStudent(List<Pupil> pupils) {
        List<Label> bestStudents = new ArrayList<>();
        for (Pupil pupil : pupils) {
            double sum = 0;
            for (Subject sub : pupil.subjects()) {
                sum += sub.score();
            }
            bestStudents.add(new Label(pupil.name(), sum));
            bestStudents.sort(Label::compareTo);
        }
        return bestStudents.get(bestStudents.size() - 1);
    }

    public static Label bestSubject(List<Pupil> pupils) {
        Map<String, Integer> maps = new LinkedHashMap<>();
        List<Label> bestSubjects = new ArrayList<>();
        search(pupils, maps);
        for (Map.Entry<String, Integer> entry : maps.entrySet()) {
            bestSubjects.add(new Label(entry.getKey(), entry.getValue()));
        }
        bestSubjects.sort(Label::compareTo);
        return bestSubjects.get(bestSubjects.size() - 1);
    }
}

package ru.job4j.algo;

import java.util.*;

public class BankMaxLoadTimeSet {
    public static int[] findMaxLoadTime(List<int[]> visitTimes) {
        if (visitTimes.isEmpty()) {
            return new int[]{0, 0};
        }

        Set<Integer> uniqueTimes = new HashSet<>();
        List<Event> events = new ArrayList<>();

        for (int[] times : visitTimes) {
            uniqueTimes.add(times[0]);
            uniqueTimes.add(times[1]);
            events.add(new Event(times[0], EventType.ARRIVAL));
            events.add(new Event(times[1], EventType.DEPARTURE));
        }

        events.sort(Comparator.comparingInt(e -> e.time));

        int left = 0, right = 0;
        int currentLoad = 0, maxLoad = 0;
        int maxLoadStartTime = 0, maxLoadEndTime = 0;

        while (right < events.size()) {
            while (right < events.size() && events.get(right).time == events.get(left).time) {
                if (events.get(right).type.equals(EventType.ARRIVAL)) {
                    currentLoad++;
                } else {
                    currentLoad--;
                }
                right++;
            }

            if (currentLoad > maxLoad) {
                maxLoad = currentLoad;
                maxLoadStartTime = events.get(left).time;
                maxLoadEndTime = (right < events.size()) ? events.get(right).time : events.get(left).time;
            }

            left = right;
        }

        return new int[]{maxLoadStartTime, maxLoadEndTime};
    }

    static class Event implements Comparable<BankMaxLoadTime.Event> {
        int time;
        EventType type;

        Event(int time, EventType type) {
            this.time = time;
            this.type = type;
        }

        @Override
        public int compareTo(BankMaxLoadTime.Event other) {
            if (this.time == other.time) {
                return this.type == EventType.ARRIVAL ? -1 : 1;
            }
            return Integer.compare(this.time, other.time);
        }
    }

    enum EventType {
        ARRIVAL, DEPARTURE
    }
}

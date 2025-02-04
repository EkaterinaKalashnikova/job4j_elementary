package ru.job4j.algo;

import java.util.*;

public class BankMaxLoadTime {

    public static int[] findMaxLoadTime(List<int[]> visitTimes) {
        if (visitTimes.isEmpty()) {
            return new int[]{0, 0};
        }
        /**Set<Event> uniqueEvents = new HashSet<>();*/
        List<Event> events = new ArrayList<>();
        for (int[] times : visitTimes) {
            /** Преобразуем пары вход и выход в список событий */
            events.add(new Event(times[0], EventType.ARRIVAL));
            events.add(new Event(times[1], EventType.DEPARTURE));
        }
        /** сортируем события по времени
         Collections.sort(events);*/
        events.sort(Comparator.naturalOrder());
        int currentLoad = 0;
        int maxLoad = 0;
        int maxLoadStartTime = 0;
        int maxLoadEndTime = 0;
        int lastTime = 0;
        int lastCurrentValue = 0;
        boolean flagDupl = false;
        /**  подсчет максимальной нагрузки*/
        for (Event event : events) {
            if (currentLoad > maxLoad & lastCurrentValue != event.time) {
                maxLoad = currentLoad;
                maxLoadStartTime = lastTime;
                maxLoadEndTime = event.time;
            }
            lastTime = event.time;
            if (lastTime != lastCurrentValue & !flagDupl) {
                if (event.type == EventType.ARRIVAL) {
                    currentLoad++;
                } else {
                    currentLoad--;
                }
            } else if (flagDupl) {
                flagDupl = false;
            }
            if (lastTime == lastCurrentValue) {
                flagDupl = true;
            }
            lastCurrentValue = lastTime;
        }
        return new int[]{maxLoadStartTime, maxLoadEndTime};
    }

    static class Event implements Comparable<Event> {
        int time;
        EventType type;

        Event(int time, EventType type) {
            this.time = time;
            this.type = type;
        }

        @Override
        public int compareTo(Event other) {
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


package ru.job4j.queue;

import java.util.Deque;

public class ReconstructPhrase {
    private final Deque<Character> descendingElements;

    private final Deque<Character> evenElements;

    private StringBuilder stringBuilder = new StringBuilder();

    private StringBuilder getStringBuilder = new StringBuilder();

    public ReconstructPhrase(Deque<Character> descendingElements, Deque<Character> evenElements) {
        this.descendingElements = descendingElements;
        this.evenElements = evenElements;
    }

    private String getEvenElements() {
        while (evenElements.size() > 0) {
            for (int i = 0; i < evenElements.size() - 1; i++) {
                if (i % 2 == 0) {
                    stringBuilder.append(evenElements.pollFirst());
                    evenElements.poll();
                }
            }
        }
        return stringBuilder.toString();
    }

    private String getDescendingElements() {
        for (int i = descendingElements.size(); i > 0; i--) {
            getStringBuilder.append(descendingElements.pollLast());
        }
        return getStringBuilder.toString();
    }

    public String getReconstructPhrase() {
        return getEvenElements() + getDescendingElements();
    }
}


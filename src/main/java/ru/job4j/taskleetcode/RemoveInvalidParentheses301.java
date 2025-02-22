package ru.job4j.taskleetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RemoveInvalidParentheses301 {
    private String inputString;
    private int stringLength;
    private Set<String> validParenthesesSet = new HashSet<>();

    /** Function to start the removal of invalid parentheses*/
    public List<String> removeInvalidParentheses(String s) {
        this.inputString = s;
        this.stringLength = s.length();

        int leftCount = 0, rightCount = 0;
        /** First pass to count necessary removals*/
        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                ++leftCount;
            } else if (ch == ')') {
                if (leftCount > 0) {
                    --leftCount;
                } else {
                    ++rightCount;
                }
            }
        }
        /** Start the DFS traversal*/
        depthFirstSearch(0, leftCount, rightCount, 0, 0, "");
        /** Convert the set of valid combinations to a list*/
        return new ArrayList<>(validParenthesesSet);
    }

    /** Helper function to perform DFS, removing invalid parentheses*/
    private void depthFirstSearch(int currentIndex, int leftRemovals, int rightRemovals, int leftCount, int rightCount, String currentStr) {
        /** Base case: end of string reached*/
        if (currentIndex == stringLength) {
            if (leftRemovals == 0 && rightRemovals == 0) {
                validParenthesesSet.add(currentStr);
            }
            return;
        }
        /** Pruning: check if we can skip the current character*/
        if (stringLength - currentIndex < leftRemovals + rightRemovals || leftCount < rightCount) {
            return;
        }

        char currentChar = inputString.charAt(currentIndex);
        /** Check if we can discard a left parenthesis*/
        if (currentChar == '(' && leftRemovals > 0) {
            depthFirstSearch(currentIndex + 1,
                    leftRemovals - 1,
                    rightRemovals, leftCount, rightCount, currentStr);
        }
        /** Check if we can discard a right parenthesis*/
        if (currentChar == ')' && rightRemovals > 0) {
            depthFirstSearch(currentIndex + 1,
                    leftRemovals,
                    rightRemovals - 1,
                    leftCount, rightCount, currentStr);
        }

        /** Either keep the current character or increase the respective counter*/
        int increaseLeft = currentChar == '(' ? 1 : 0;
        int increaseRight = currentChar == ')' ? 1 : 0;
        depthFirstSearch(currentIndex + 1,
                leftRemovals,
                rightRemovals,
                leftCount + increaseLeft,
                rightCount + increaseRight,
                currentStr + currentChar);
    }
}



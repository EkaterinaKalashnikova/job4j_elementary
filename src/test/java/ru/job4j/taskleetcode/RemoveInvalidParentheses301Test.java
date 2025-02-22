package ru.job4j.taskleetcode;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class RemoveInvalidParentheses301Test {
    @Test
    void whenValidStringThenSameStringReturned() {
        RemoveInvalidParentheses301 remover = new RemoveInvalidParentheses301();
        List<String> result = remover.removeInvalidParentheses("()()");
        assertThat(result).containsExactly("()()");
    }

    @Test
    void whenExtraClosingParenthesisThenRemoveIt() {
        RemoveInvalidParentheses301 remover = new RemoveInvalidParentheses301();
        List<String> result = remover.removeInvalidParentheses("())");
        assertThat(result).containsExactly("()");
    }

    @Test
    void whenExtraOpeningParenthesisThenRemoveIt() {
        RemoveInvalidParentheses301 remover = new RemoveInvalidParentheses301();
        List<String> result = remover.removeInvalidParentheses("(()");
        assertThat(result).containsExactly("()");
    }

    @Test
    void whenComplexCaseThenReturnAllValidCombinations() {
        RemoveInvalidParentheses301 remover = new RemoveInvalidParentheses301();
        List<String> result = remover.removeInvalidParentheses("(a)())()");
        assertThat(result).containsExactlyInAnyOrder("(a())()", "(a)()()");
    }

    @Test
    void whenAllInvalidParenthesesThenReturnEmptyString() {
        RemoveInvalidParentheses301 remover = new RemoveInvalidParentheses301();
        List<String> result = remover.removeInvalidParentheses(")))((");
        assertThat(result).containsExactly("");
    }

    @Test
    void whenNoParenthesesThenReturnSameString() {
        RemoveInvalidParentheses301 remover = new RemoveInvalidParentheses301();
        List<String> result = remover.removeInvalidParentheses("abc");
        assertThat(result).containsExactly("abc");
    }

    @Test
    void whenEmptyStringThenReturnEmptyList() {
        RemoveInvalidParentheses301 remover = new RemoveInvalidParentheses301();
        List<String> result = remover.removeInvalidParentheses("");
        assertThat(result).containsExactly("");
    }
}
    

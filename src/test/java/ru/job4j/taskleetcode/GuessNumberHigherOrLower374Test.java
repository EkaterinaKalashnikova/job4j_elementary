package ru.job4j.taskleetcode;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class GuessNumberHigherOrLower374Test {
    @Test
    void whenTargetIsMiddleThenReturnMiddle() {
        GuessNumberHigherOrLower374 game = new GuessNumberHigherOrLower374(50);
        assertThat(game.guessNumber(100)).isEqualTo(50);
    }

    @Test
    void whenTargetIsLowerBoundThenReturnOne() {
        GuessNumberHigherOrLower374 game = new GuessNumberHigherOrLower374(1);
        assertThat(game.guessNumber(100)).isEqualTo(1);
    }

    @Test
    void whenTargetIsUpperBoundThenReturnN() {
        GuessNumberHigherOrLower374 game = new GuessNumberHigherOrLower374(100);
        assertThat(game.guessNumber(100)).isEqualTo(100);
    }

    @Test
    void whenTargetIsRandomNumberThenReturnCorrectNumber() {
        GuessNumberHigherOrLower374 game = new GuessNumberHigherOrLower374(73);
        assertThat(game.guessNumber(100)).isEqualTo(73);
    }

    @Test
    void whenNIsOneAndTargetIsOneThenReturnOne() {
        GuessNumberHigherOrLower374 game = new GuessNumberHigherOrLower374(1);
        assertThat(game.guessNumber(1)).isEqualTo(1);
    }
}
    

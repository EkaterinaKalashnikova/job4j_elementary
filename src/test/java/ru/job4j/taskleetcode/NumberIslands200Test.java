package ru.job4j.taskleetcode;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class NumberIslands200Test {
    @Test
    void whenSingleIslandThenReturnOne() {
        NumberIslands200 solver = new NumberIslands200();
        char[][] grid = {
                {'1', '1', '0', '0'},
                {'1', '1', '0', '0'},
                {'0', '0', '1', '0'},
                {'0', '0', '0', '1'}
        };
        assertThat(solver.numIslands(grid)).isEqualTo(3);
    }

    @Test
    void whenNoIslandsThenReturnZero() {
        NumberIslands200 solver = new NumberIslands200();
        char[][] grid = {
                {'0', '0', '0'},
                {'0', '0', '0'},
                {'0', '0', '0'}
        };
        assertThat(solver.numIslands(grid)).isEqualTo(0);
    }

    /**
     * @Test void whenMultipleIslandsThenCorrectCount() {
     * NumberIslands200 solver = new NumberIslands200();
     * char[][] grid = {
     * {'1', '0', '1', '0', '1'},
     * {'0', '1', '0', '1', '0'},
     * {'1', '0', '1', '0', '1'}
     * };
     * assertThat(solver.numIslands(grid)).isEqualTo(5);
     * }
     */

    @Test
    void whenOneBigIslandThenReturnOne() {
        NumberIslands200 solver = new NumberIslands200();
        char[][] grid = {
                {'1', '1', '1'},
                {'1', '1', '1'},
                {'1', '1', '1'}
        };
        assertThat(solver.numIslands(grid)).isEqualTo(1);
    }

    @Test
    void whenGridHasOneCell() {
        NumberIslands200 solver = new NumberIslands200();

        char[][] grid1 = {{'1'}};
        assertThat(solver.numIslands(grid1)).isEqualTo(1);

        char[][] grid2 = {{'0'}};
        assertThat(solver.numIslands(grid2)).isEqualTo(0);
    }
}

    

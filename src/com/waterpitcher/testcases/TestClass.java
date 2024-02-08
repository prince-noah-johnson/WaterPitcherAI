package com.waterpitcher.testcases;

import com.waterpitcher.AStarAlgorithm;
import com.waterpitcher.Input;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TestClass {
    @Test
    void getMinStepsUsingAStarSolution() {
        AStarAlgorithm sol = new AStarAlgorithm(new Input(List.of(2, 3, 4), 9));

        assertEquals(sol.findMinStepsUsingAStar(), 6);

        AStarAlgorithm sol2 = new AStarAlgorithm(new Input(List.of(1, 5), 1));
        assertEquals(sol2.findMinStepsUsingAStar(), 2);
    }

    @Test
    void getMinStepsUsingAStarNoSolution() {
        AStarAlgorithm sol = new AStarAlgorithm(new Input(List.of(2, 4, 6), 1));

        assertEquals(sol.findMinStepsUsingAStar(), -1);
    }


    @Test
    void heuristic() {
        AStarAlgorithm sol = new AStarAlgorithm(new Input(List.of(1, 2), 4));

        assertEquals(sol.estimateHeuristic(1), 5);
    }


}
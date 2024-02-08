package com.waterpitcher;

import java.util.HashMap;
import java.util.Map;

public class AStarAlgorithm {
    private static final int INFINITY = 1_000_000_000;
    private final Input input;

    public AStarAlgorithm(Input input) {
        this.input = input;
    }

    public int findMinStepsUsingAStar() {
        if (input.getTarget() % calculateTotalGCD() != 0) {
            return -1;
        }

        int numPitchers = input.getCapacity().size();

        PitchersState initialState = new PitchersState(numPitchers + 1);

        java.util.PriorityQueue<PriorityQueue> priorityQueue = new java.util.PriorityQueue<>();

        priorityQueue.add(new PriorityQueue(0, initialState));

        Map<PitchersState, Integer> minStepsMap = new HashMap<>();

        minStepsMap.put(initialState, 0);

        while (!priorityQueue.isEmpty()) {
            var currentContainer = priorityQueue.poll();
            if (currentContainer.getPitcherState().getLastElement() == input.getTarget()) {
                return minStepsMap.get(currentContainer.getPitcherState());
            }

            int newCost = minStepsMap.get(currentContainer.getPitcherState()) + 1;

            for (int i = 0; i <= numPitchers; i++) {
                for (int j = 0; j <= numPitchers; j++) {
                    if (i == j) continue;
                    PitchersState nextState = new PitchersState(currentContainer.getPitcherState());
                    int x = nextState.getPitchers().get(i);
                    int y = nextState.getPitchers().get(j);
                    int capacity = (j < numPitchers) ? input.getCapacity().get(j) : INFINITY;
                    nextState.getPitchers().set(i, Math.max(0, x + y - capacity));
                    nextState.getPitchers().set(j, Math.min(capacity, x + y));

                    if (!minStepsMap.containsKey(nextState) || newCost < minStepsMap.get(nextState)) {
                        minStepsMap.put(nextState, newCost);
                        priorityQueue.add(new PriorityQueue(newCost + estimateHeuristic(nextState.getLastElement()), nextState));
                    }
                }
            }

            for (int i = 0; i < numPitchers; i++) {
                PitchersState nextState = new PitchersState(currentContainer.getPitcherState());
                nextState.getPitchers().set(i, input.getCapacity().get(i));
                if (!minStepsMap.containsKey(nextState) || newCost < minStepsMap.get(nextState)) {
                    minStepsMap.put(nextState, newCost);
                    priorityQueue.add(new PriorityQueue(newCost + estimateHeuristic(nextState.getLastElement()), nextState));
                }
            }
        }
        return -1;
    }

    public int estimateHeuristic(int current) {
        return (int) ((Math.abs(input.getTarget() - current)) / input.getAvgCapacity());
    }

    public int calculateGCD(int a, int b) {
        if (b == 0) return a;
        return calculateGCD(b, a % b);
    }

    public int calculateTotalGCD() {
        return input.getCapacity().stream().reduce(0, this::calculateGCD);
    }

}

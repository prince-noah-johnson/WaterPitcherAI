package com.waterpitcher;

import java.util.List;

public class Input {
    private List<Integer> capacity;
    private int target;

    private double avgCapacity;

    public Input(List<Integer> capacity, int target) {
        this.capacity = capacity;
        this.target = target;
        this.avgCapacity = -1;
    }

    public double getAvgCapacity() {
        if (avgCapacity == -1) {
            avgCapacity = this.capacity.stream().mapToInt(e->e).average().orElse(1.0);
        }
        return avgCapacity;
    }

    public List<Integer> getCapacity() {
        return capacity;
    }

    public int getTarget() {
        return target;
    }

    @Override
    public String toString() {
        return "Input{" +
                "capacity=" + capacity +
                ", target=" + target +
                '}';
    }
}
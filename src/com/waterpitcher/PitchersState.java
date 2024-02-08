package com.waterpitcher;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class PitchersState {
    private List<Integer> pitchers;

    public PitchersState(PitchersState other) {
        this.pitchers = new ArrayList<>(other.getPitchers());
    }

    public PitchersState(int n) {
        pitchers = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            pitchers.add(0);
        }
    }

    public List<Integer> getPitchers() {
        return pitchers;
    }

    public int getLastElement() {
        return this.pitchers.get(pitchers.size() - 1);
    }


    @Override
    public String toString() {
        return "PitcherState{" +
                "pitchers=" + pitchers +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PitchersState that = (PitchersState) o;
        return Objects.equals(pitchers, that.pitchers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pitchers);
    }

    public static class PriorityQueue implements Comparable<PriorityQueue> {
        private final Integer cost;
        private final PitchersState pitchersState;

        public PriorityQueue(int cost, PitchersState pitchersState) {
            this.cost = cost;
            this.pitchersState = pitchersState;
        }

        @Override
        public int compareTo(PriorityQueue o) {
            if (!this.cost.equals(o.getCost())) {
                return this.cost.compareTo(o.getCost());
            }
            for (int i = 0; i < this.pitchersState.getPitchers().size(); i++) {
                if (!this.pitchersState.getPitchers().get(i).equals(o.getPitcherState().getPitchers().get(i))) {
                    return this.pitchersState.getPitchers().get(i).compareTo(o.getPitcherState().getPitchers().get(i));
                }
            }
            return 0;
        }

        public Integer getCost() {
            return cost;
        }

        public PitchersState getPitcherState() {
            return pitchersState;
        }

        @Override
        public String toString() {
            return "PQContainer{" +
                    "cost=" + cost +
                    ", pitcherState=" + pitchersState +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            PriorityQueue that = (PriorityQueue) o;
            return Objects.equals(cost, that.cost) && Objects.equals(pitchersState, that.pitchersState);
        }

        @Override
        public int hashCode() {
            return Objects.hash(cost, pitchersState);
        }
    }
}
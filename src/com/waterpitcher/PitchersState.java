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
}
package com.gradetracker.model;

public enum GradingScale {
    SCALE_1_6(1.0, 6.0),
    SCALE_0_15(0, 15);

    private final double min;
    private final double max;

    GradingScale(double min, double max) {
        this.min = min;
        this.max = max;
    }

    public double getMin() {
        return min;
    }

    public double getMax() {
        return max;
    }
}
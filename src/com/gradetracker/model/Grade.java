package com.gradetracker.model;

import java.time.LocalDateTime;

public class Grade implements Comparable<Grade> {
    private String gradeId;
    private double gradeValue;
    private String description;
    private double weight;
    private LocalDateTime dateEntered;
    private String schoolType;

    @Override
    public int compareTo(Grade o) {
        return 0;
    }
}

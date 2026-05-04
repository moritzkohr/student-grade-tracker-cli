package com.gradetracker.main.java.model;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Grade implements Serializable, Comparable<Grade> {
    private String gradeId;
    private double gradeValue;
    private String description;
    private double weight;
    private LocalDateTime dateEntered;
    private String schoolType;
}

package com.gradetracker.main.java.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class Student implements Serializable {
    private String name;
    private Bundesland bundesland;
    private String schoolTrack;
    private int transitionYear;
    private int exitYear;
    private ArrayList<SchoolYear> schoolYears;
    private LocalDateTime profileCreated;


}

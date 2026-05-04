package com.gradetracker.main.java.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class SchoolClass implements Serializable {
    private string classId;
    private String className;
    private String classCode;
    private String schoolType;
    private ArrayList<Grade> grades;
    private LocalDateTime dateAdded;
}


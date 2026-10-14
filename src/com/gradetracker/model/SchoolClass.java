package com.gradetracker.model;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class SchoolClass {
    private String classId;
    private String className;
    private String classCode;
    private String schoolType;
    private ArrayList<Grade> grades;
    private LocalDateTime dateAdded;
}


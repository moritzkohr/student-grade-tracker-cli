package com.gradetracker.main.java.model;

import java.io.Serializable;
import java.util.ArrayList;

public class SchoolYear implements Serializable {
    private String yearId;
    private int jahrgangsstufe;
    private String schoolType;
    private ArrayList<SchoolClass> classes;
}

package com.gradetracker.model;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Student {

    private String name;
    private SchoolTrack schoolTrack;
    private Bundesland bundesland;
    private int transitionYear;
    private int exitYear;
    private ArrayList<SchoolYear> schoolYears;
    private LocalDateTime profileCreated;

    public Student(String name, SchoolTrack schoolTrack, Bundesland bundesland){
        if (name == null|| name.trim().isEmpty()){
            throw new IllegalArgumentException("Name darf nicht leer sein!");
        }
        if (schoolTrack == null){
            throw new IllegalArgumentException("Schulart darf nicht leer sein!");
        }
        if (bundesland == null){
            throw new IllegalArgumentException("Bundesland darf nicht leer sein!");
        }
        this.name = name;
        this.schoolTrack = schoolTrack;
        this.bundesland = bundesland;
        this.schoolYears = new ArrayList<>();
        this.profileCreated = LocalDateTime.now();
    }

    //Constructor for CSVHandler reconstruction
    public Student(String name, SchoolTrack schoolTrack, Bundesland bundesland, int transitionYear, int exitYear, LocalDateTime profileCreated) {
        this.name = name;
        this.schoolTrack = schoolTrack;
        this.bundesland = bundesland;
        this.transitionYear = transitionYear;
        this.exitYear = exitYear;
        this.profileCreated = profileCreated;
        this.schoolYears = new ArrayList<>();
    }

    public void addSchoolYear(SchoolYear schoolYear){
        if (schoolYear == null){
            throw new IllegalArgumentException("Schuljahr darf nicht leer sein!");
        }
        schoolYears.add(schoolYear);
    }

    public void removeSchoolYear(SchoolYear schoolYear){
        schoolYears.remove(schoolYear);
    }

    public SchoolYear getSchoolYearByJahrgangsstufe(int jahrgangsstufe) {
        for (SchoolYear schoolYear : schoolYears) {
            if (schoolYear.getJahrgangsstufe() == jahrgangsstufe){       //TODO: getter and setter in schoolYear.java
                return schoolYear;
            }
        }
        return null;
    }

    public double calculateOverallGPA(){
        return 0; //TODO: GradeCalculator needs a class
    }

    public

    //Getters and Setters

    public ArrayList<SchoolYear> getSchoolYears(){
        return schoolYears;
    }

    public LocalDateTime getProfileCreated() {
        return profileCreated;
    }

    public Bundesland getBundesland() {
        return bundesland;
    }

    public void setBundesland(Bundesland bundesland) {
        if (bundesland == null){
            throw new IllegalArgumentException("Bundesland darf nicht leer sein!");
        }
        this.bundesland = bundesland;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()){
            throw new IllegalArgumentException("Name darf nicht leer sein!");
        }
        this.name = name;
    }

    public SchoolTrack getSchoolTrack() {
        return schoolTrack;
    }

    public void setSchoolTrack(SchoolTrack schoolTrack) {
        if (schoolTrack == null){
            throw new IllegalArgumentException("Schulart darf nicht leer sein!");
        }
        this.schoolTrack = schoolTrack;
    }

    public int getTransitionYear() {
        return transitionYear;
    }

    public void setTransitionYear(int transitionYear) {
        //TODO: validate against state rules via ValidationService before calling
        this.transitionYear = transitionYear;
    }

    public int getExitYear() {
        return exitYear;
    }

    public void setExitYear(int exitYear) {
        this.exitYear = exitYear;
    }
}

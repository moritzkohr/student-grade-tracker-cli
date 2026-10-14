package com.gradetracker.model;

import java.util.ArrayList;

public class SchoolYear {
    private String yearId;
    private int jahrgangsstufe;
    private GradingScale gradingScale;
    private ArrayList<SchoolClass> classes;

    public SchoolYear(int jahrgangsstufe, GradingScale gradingScale) {
        if (gradingScale == null) {
            throw new IllegalArgumentException("Notensystem darf nicht leer sein");
        }
        this.jahrgangsstufe = jahrgangsstufe;
        this.gradingScale = gradingScale;
        this.yearId = "year_"+jahrgangsstufe;
        this.classes=new ArrayList<>();
    }

    public void addClass(SchoolClass schoolClass) {
        if (schoolClass == null) {
            throw new IllegalArgumentException("Fach darf nicht leer sein");
        }
        this.classes.add(schoolClass);
    }

    public void removeClass(SchoolClass schoolClass) {
        this.classes.remove(schoolClass);
    }

    public SchoolClass getSchoolClassByCode(String schoolClassCode) {
        for (SchoolClass schoolClass : classes) {
            if (schoolClass.getClassCode().equals(schoolClassCode)){
                return schoolClass;
            }
        }
        return null;
    }

    public double calculateYearGPA(){
        return 0; //TODO: GPA Calculator
    }

    public int getClassCount(){
        return this.classes.size();
    }

    //Getters and Setters

    public String getYearId() {
        return yearId;
    }

    public int getJahrgangsstufe() {
        return jahrgangsstufe;
    }

    public GradingScale getGradingScale() {
        return gradingScale;
    }

    public ArrayList<SchoolClass> getClasses() {
        return classes;
    }
}

package com.mycompany.schooldatabase;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.*;


/**
 *
 * @author Brooks
 */
public class Student extends Person {

    //Need itinerary array
    
    protected static final ArrayList<String> dataPoints = new ArrayList<String>(Arrays.asList("First Name", "Last Name", "Social Security Number", "Phone Number", "GPA"));
    protected static final ArrayList<String> dataPointIdentifiers = new ArrayList<String>(Arrays.asList("firstname", "lastname", "social", "phonenum", "gpa"));

//    public Student (String firstName, String lastName, String social) {
//        super(firstName, lastName, social, PersonEnum.STUDENT);
//    }

    public Student (String cLine) {
        super(cLine, PersonEnum.STUDENT);
        if (!super.personData.containsKey("gpa"))
            setGPA(0.0);
    }
    
    public void setGPA(String gpa) {
        //Should probably ensure the GPA is maximum 2 decimal places here
        super.personData.put("gpa", gpa);
    }
    
    public void setGPA(double gpa) {
        super.personData.put("gpa", Double.toString(gpa));
    }
    
    public Double getGPA () {
        return new Double((String) super.personData.get("gpa"));
    }
        
    @Override
    public String toString() {
        return (super.toString() + "\r\n" + "GPA: " + getGPA() + "\r\n\r\n");
    }
}
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
    private HashMap<String, Object> personData;
    
    public Student (String firstName, String lastName, String social) {
        super(firstName, lastName, social, PersonEnum.STUDENT);
    }

    public Student (String cLine) {
        super(cLine, PersonEnum.STUDENT);
        setGPA(createGPA());
    }
    
    public Double createGPA() {
        return ((double)Math.round(((super.randomGen.nextDouble() * 2.5 + 1.5))*100)/100);
    }    
    
    public void setGPA(String gpa) {
        //Should probably ensure the GPA is maximum 2 decimal places here
        super.personData.put("gpa", new Double(gpa));
    }
    
    public void setGPA(double gpa) {
        super.personData.put("gpa", new Double(gpa));
    }
    
    public Double getGPA () {
        return (Double) super.personData.get("gpa");
    }
        
    @Override
    public String toString() {
        return (super.toString() + "\r\n" + "GPA: " + getGPA() + "\r\n\r\n");
    }
}
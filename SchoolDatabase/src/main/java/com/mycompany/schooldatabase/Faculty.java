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
public class Faculty extends Person {
    
    protected static final ArrayList<String> dataPoints = new ArrayList<String>(Arrays.asList("First Name", "Last Name", "Social Security Number", "Phone Number", "Tenured (Y/N)"));    
    protected static final ArrayList<String> dataPointIdentifiers = new ArrayList<String>(Arrays.asList("firstname", "lastname", "social", "phonenum", "tenured"));
    
//    public Faculty(String firstName, String lastName, String social){
//        super(firstName, lastName, social, PersonEnum.FACULTY);
//    }
    
    public Faculty(String cLine){
        super(cLine, PersonEnum.FACULTY);
    }
    
    public void setTenured() {
        super.personData.put("tenured", "true");
    }
    
    public Boolean getTenured() {
        return new Boolean ((String) super.personData.get("tenured"));
    }
    
    @Override
    public String toString() {
        String tenured;
        if (getTenured())
            tenured = "Y";
        else tenured = "N";
        return (super.toString() + "\r\n" + "Tenured: " + tenured + "\r\n\r\n");
    }    
    
}
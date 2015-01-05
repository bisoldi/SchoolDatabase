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
public class Staff extends Person {
    
    protected static final ArrayList<String> dataPoints = new ArrayList<String>(Arrays.asList("First Name", "Last Name", "Social Security Number", "Phone Number"));    
    protected static final ArrayList<String> dataPointIdentifiers = new ArrayList<String>(Arrays.asList("firstname", "lastname", "social", "phonenum"));    
    
//    public Staff(String firstName, String lastName, String social){
//        super(firstName, lastName, social, PersonEnum.STAFF);
//    }
    
    public Staff(String cLine){
        super(cLine, PersonEnum.STAFF);
        setSeniority(0);
    }
    
    public void setSeniority(int years) {
        super.personData.put("seniority", Integer.toString(years));
    }
    
    public Integer getSeniority() {
        return new Integer((String) super.personData.get("seniority"));
    }
    
    @Override
    public String toString() {
        return (super.toString() + "\r\n" + "Seniority: " + getSeniority().toString() + " years" + "\r\n\r\n");
    }    
}
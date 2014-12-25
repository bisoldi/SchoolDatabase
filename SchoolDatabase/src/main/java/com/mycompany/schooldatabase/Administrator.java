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
public class Administrator extends Person {
    
    private HashMap<String, Object> personData;
    
    public Administrator(String firstName, String lastName, String social) {
        super(firstName, lastName, social, PersonEnum.ADMINISTRATOR);
    }
    
    public Administrator(String cLine) {
        super(cLine, PersonEnum.ADMINISTRATOR);
        setSeniority(super.randomGen.nextInt(34)+1);
    }
    
    public void setSeniority(int years) {
        super.personData.put("seniority", new Integer(years));
    }
    
    public Integer getSeniority() {
        return ((Integer) super.personData.get("seniority"));
    }
    
    @Override
    public String toString() {
        return (super.toString() + "\r\n" + "Seniority: " + getSeniority() + " years" + "\r\n\r\n");
    }
    
}
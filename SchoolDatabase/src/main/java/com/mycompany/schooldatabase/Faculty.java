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
    
    private HashMap<String, Object> personData;
    
    public Faculty(String firstName, String lastName, String social){
        super(firstName, lastName, social, PersonEnum.FACULTY);
    }
    
    public Faculty(String cLine){
        super(cLine, PersonEnum.FACULTY);
        switch (super.randomGen.nextInt(2)) {
            case 0: setTenured();
                    break;
            case 1: super.personData.put("tenured", new Boolean(false));
                    break;
        }
    }
    
    public void setTenured() {
        super.personData.put("tenured", new Boolean(true));
    }
    
    public Boolean getTenured() {
        return (Boolean) super.personData.get("tenured");
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
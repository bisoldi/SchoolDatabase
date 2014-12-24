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
    
    private HashMap<String, Object> personData;
    
    public Staff(String firstName, String lastName, String social){
        super(firstName, lastName, social, PersonEnum.STAFF);
    }
    
    public Staff(String cLine){
        super(cLine, PersonEnum.STAFF);
    }       
    
}
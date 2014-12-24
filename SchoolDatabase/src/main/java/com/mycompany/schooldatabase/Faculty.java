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
    }
    
}
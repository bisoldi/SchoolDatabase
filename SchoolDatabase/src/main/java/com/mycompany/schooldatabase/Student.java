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
    HashMap<String, Object> personData;
                
    public Student (String firstName, String lastName, String social) {
        super(firstName, lastName, social, PersonEnum.STUDENT);
        personData = new HashMap<>();
        setDataMap(personData);
    }
    
//    public Student (Scanner fullInfoScanner) {
//        super(fullInfoScanner, PersonEnum.STUDENT);
//    }

}

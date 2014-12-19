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
public class SchoolUserSystem {
    
    FileOperations fileOps; 
    PersonCollection collection;
        
    public SchoolUserSystem() {
        fileOps = new FileOperations();
        PersonCollection collection = fileOps.readOneTimeFile();
        
        for (Person per : collection) {
            System.out.println(per);
        }
    }
    
    public void createUsers() {       
    }
}

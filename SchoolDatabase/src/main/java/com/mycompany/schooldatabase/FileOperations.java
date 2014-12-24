package com.mycompany.schooldatabase;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.*;
import java.util.Scanner;
import java.util.*;
import com.google.common.base.Joiner;

/**
 *
 * @author Brooks
 */
public class FileOperations {
    
    public FileOperations() {
    }
        
    public PersonCollection readOneTimeFile() {
    
        PersonCollection collect = new PersonCollection();
        Scanner scan = null;
        
        try {
            scan = new Scanner(new BufferedReader(new FileReader("names.txt")));
            
            while (scan.hasNextLine()) {
//                String firstName = scan.next();
//                String lastName = scan.next();
//                String social = scan.next();
//                collect.addRandomPerson(firstName, lastName, social);
                
                collect.addRandomPerson(scan.nextLine());
            }
        } catch (FileNotFoundException fnfe) {
            System.out.println("FileNotFoundException"); 
        } finally {
            if (scan != null) {
                scan.close();
            }
        }
        return collect;
    }
    
//    public boolean writeFile(PersonCollection coll) {
//        
//    }
}

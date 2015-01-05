package com.mycompany.schooldatabase;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.*;
import java.io.*;


/**
 *
 * @author Brooks
 */
public class SchoolUserSystem {
    
    FileOperations fileOps; 
    PersonCollection collection;
    BufferedReader reader;
        
    public SchoolUserSystem() {
        fileOps = new FileOperations();
        
        try {
            collection = fileOps.readFile();
        } catch (IOException ioe) {
            System.out.println("I caught an IOException while trying to read file");            
        }
        
        mainMenu();

        try {
            fileOps.writeFile(collection);
        } catch (IOException ioe) {
            System.out.println("I caught an IOException while trying to write file");
        }
    }
    
    public void mainMenu() {
        String input = "";
        do {
            reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("1- Add Person");
            System.out.println("2- Edit Person");
            System.out.println("3- Review Person");
            System.out.println("4- Exit");
            try {
                input = reader.readLine();
                
                switch (input) {
                    case "1":   addPerson();
                                break;
                    case "2":   editPerson();
                                break;
                    case "3":   reviewPerson();
                                break;
                }
            } catch (IOException ioe) {
                System.out.println("IOException while reading from console");
            }
        } while (!input.equals("4"));                
    }
    
    public void addPerson() {
        
        String input = "";
        do {
            System.out.println("\r\n");
            System.out.println("1- Add Student");
            System.out.println("2- Add Faculty");
            System.out.println("3- Add Staff");
            System.out.println("4- Add Administrator");
            System.out.println("5- Exit");
            try {
                input = reader.readLine();
                
                switch (input) {
                    case "1":   addPerson(PersonEnum.STUDENT);
                                break;
                    case "2":   addPerson(PersonEnum.FACULTY);
                                break;                            
                    case "3":   addPerson(PersonEnum.STAFF);
                                break;
                    case "4":   addPerson(PersonEnum.ADMINISTRATOR);
                                break;
                }
            } catch (IOException ioe) {
                System.out.println("IOException while reading from console");
            }
            
        } while (!input.equals("1") && !input.equals("2") && !input.equals("3") && !input.equals("4"));
    }
    
    public void addPerson(PersonEnum type) {
        ArrayList<String> inputDescriptions = type.getInputs();
        Iterator<String> iter = type.getInputIdentifiers().iterator();
        StringBuilder personInfo = new StringBuilder();
        
        String input = "";
        
        System.out.println("Enter " + type + " information below:");
        for (String str : inputDescriptions) {
            System.out.print(str + ":     ");
            try {
                input = reader.readLine();
                System.out.println("\r\n");
                personInfo.append(iter.next());
                personInfo.append(":");
                personInfo.append(input);
                personInfo.append(",");
            } catch (IOException ioe) {
                System.out.println("IOException while reading from console");
            }
        }
        collection.addPerson(personInfo.toString(), type);
    }
    
    public void editPerson() {
        System.out.println("This functionality not yet implemented");
    }
    
    public void reviewPerson() {
        System.out.println("This functionality not yet implemented");
    }
}

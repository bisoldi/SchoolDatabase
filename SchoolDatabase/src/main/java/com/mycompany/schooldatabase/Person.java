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
public class Person {
    
    private final String firstName;
    private final String lastName;
    private final String idNum;
    private final String social;
    private final PersonEnum type;
    private final String phoneNum;
    private final String email;
    
    private static final Random randomGen = new Random();
    private HashMap<String, Object> personData;
    
    public Person(String firstName, String lastName, String social, PersonEnum type) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.social = social;
        this.type = type;        
        idNum = createID();

        //initialize fields not passed in
        phoneNum = "";
        email = "";
    }
    
    protected void setDataMap(HashMap<String, Object> personData) {
        this.personData = personData;
    }
    
//    /** 
//     * Constructs a new Person that initializes its member fields from the Scanner and PersonEnum.  The entire line is read from the Scanner and 
//     * broken down into tokens using " " (space) as the delimiter and assuming all String objects.
//     * @param scanner the Scanner containing all of the data needed to initialize the Person in order (first name, last name, social security number)
//     * @param type the PersonEnum containing the type of Person this is
//     * 
//     * TODO: Need to do some error checking on the Scanner object and the String that comes out of it
//     */
//    public Person(Scanner scanner, PersonEnum type) {
//        this.firstName = scanner.next();
//        this.lastName = scanner.next();
//        this.social = scanner.next();
//        
//        this.type = type;
//        idNum = createID();
//        
//        //initialize fields not passed in
//        phoneNum = "";
//        email = "";                
//    }
        
    private String createID () {
        /*  Author debated whether to have the subclass pass the prefix for the ID# into this method and return the ID#
        *   or to pass the subclass instance itself and have this method update the ID# either directly or through a method 
        *   call to the subclass instance.  Ultimately decided to pass the prefix in and return the ID# as it's clearer. 
        */
        String idNumber = type.getPrefix();
        
        for (int i = type.getPrefix().length(); i < (type.getIDLength() + type.getPrefix().length()); i++) {
            idNumber += randomGen.nextInt(9);
        }
        return idNumber;
    }
    
    public String getIDNumber() {
        return idNum;
    }
       
    public String getFirstName() {
        return firstName;
    }
    
    public String getLastName() {
        return lastName;
    }
    
    public String getFullName() {
        return firstName + " " + lastName;
    }
    
    public String getSocial() {
        return social;
    }
    
    /**
     * Returns the String representation of this Person.  The String representation of a Person contains the first and last name and type.
     * @return 
     */
    @Override
    public String toString() {
        return (firstName + " " + lastName + " (" + type + ") - " + idNum);
    }
    
}

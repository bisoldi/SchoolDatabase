package com.mycompany.schooldatabase;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.*;
import com.google.common.base.Splitter;


/**
 *
 * @author Brooks
 */
public class Person {
    
//    private final String firstName;
//    private final String lastName;
//    private final String idNum;
//    private final String social;
//    private final PersonEnum type;
//    private final String phoneNum;
//    private final String email;
    
    private static final Random randomGen = new Random();
    protected HashMap<String, Object> personData = new HashMap<>();
    
    public Person(String firstName, String lastName, String social, PersonEnum type) {
//        this.firstName = firstName;
//        this.lastName = lastName;
//        this.social = social;
//        this.type = type;        
//        this.idNum = createID();
//
//        //initialize fields not passed in
//        phoneNum = "";
//        email = "";
        
        personData.put("firstname", firstName);
        personData.put("lastname", lastName);
        personData.put("social", social);
        personData.put("type", type);
        personData.put("idnum", createID(type));
        personData.put("phonenum", createPhoneNum());
        personData.put("email", firstName+"."+lastName+"@brooks.edu");        
    }
    
    public Person(String cLine, PersonEnum type) {
        List<String> list = Splitter.on(",").splitToList(cLine);
        personData.put("type", type);
        
        for (String str : list) {
            List<String> keyValue = Splitter.on(":").splitToList(str);
            String key = keyValue.get(0);
            String value = keyValue.get(1);
            personData.put(keyValue.get(0), keyValue.get(1));
        }
        personData.put("phonenum", createPhoneNum());
        personData.put("idnum", createID(type));
        personData.put("email", getFirstName() + "." + getLastName() + "@brooks.edu");
    }
    
//    protected void setDataMap(HashMap<String, Object> personData) {
//        this.personData = personData;
//        this.personData.put("firstname", this.firstName);
//        this.personData.put("lastname", this.lastName);
//        this.personData.put("social", this.social);
//        this.personData.put("type", this.type);
//        this.personData.put("idnum", this.idNum);
//        this.personData.put("phonenum", this.phoneNum);
//        this.personData.put("email", email);
//    }   
        
    private String createID (PersonEnum type) {
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
    
    private String createPhoneNum() {
        String phone = "(";
        
        for (int i = 0; i < 10; i++) {
            switch (i) {
                case 3: phone += ")";
                        break;
                case 6: phone += "-";
                        break;
            }
            phone += randomGen.nextInt(9);
        }
        
        return phone;
    }
    
    public String getIDNumber() {
        return (String)personData.get("idnum");
    }
       
    public String getFirstName() {
        return (String)personData.get("firstname");
    }
    
    public String getLastName() {
        return (String)personData.get("lastname");
    }
    
    public String getFullName() {
        return getFirstName() + " " + getLastName();
    }
    
    public String getSocial() {
        return (String)personData.get("social");
    }
    
    public PersonEnum getType() {
        return (PersonEnum) personData.get("type");
    }
    
    public String getPhoneNumber() {
        return (String) personData.get("phonenum");
    }
    
    /**
     * Returns the String representation of this Person.  The String representation of a Person contains the first and last name and type.
     * @return 
     */
    @Override
    public String toString() {
        return (getFullName() + " (" + getType() + ") - " + getIDNumber() + " - " + getPhoneNumber());
    }
    
    public void setSpecificData(String key, Object value) {
        personData.put(key, value);
    }
    
    public Object getPersonData(String key) {
        if (personData.containsKey(key))
            return personData.get(key);
        else throw new NoSuchElementException((String)personData.get("idnum") + " has no data for " + key);
    }
}

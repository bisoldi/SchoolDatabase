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
    
    protected static final Random randomGen = new Random();
    protected HashMap<String, Object> personData = new HashMap<>();
    
    public Person(String cLine, PersonEnum type) {
                
        StringBuilder strB = new StringBuilder(cLine);
        personData.put("type", type);
        
        if (strB.charAt(strB.length()-1) == ',')
            strB.deleteCharAt(strB.length()-1);
        
        List<String> list = Splitter.on(",").splitToList(strB.toString());
        
        for (String str : list) {
            List<String> keyValue = Splitter.on(":").splitToList(str);
            try {
                String key = keyValue.get(0);
                String value = keyValue.get(1);
                personData.put(keyValue.get(0), keyValue.get(1));
            } catch (IndexOutOfBoundsException npe) {
                System.out.println("Null found at " + keyValue.get(0));
            }
        }
        
        if (!personData.containsKey("idnum"))
            personData.put("idnum", createID(type));
        if (!personData.containsKey("email")) {
            personData.put("email", getFirstName() + "." + getLastName() + "@brooks.edu");
            
        }
    }
    
    private String createID (PersonEnum type) {
        /*  Author debated whether to have the subclass pass the prefix for the ID# into this method and return the ID#
        *   or to pass the subclass instance itself and have this method update the ID# either directly or through a method 
        *   call to the subclass instance.  Ultimately decided to pass the prefix in and return the ID# as it's clearer. 
        */
        StringBuilder idNumber = new StringBuilder(type.getPrefix());
        
        for (int i = type.getPrefix().length(); i < (type.getIDLength() + type.getPrefix().length()); i++) {
            idNumber.append(randomGen.nextInt(9));
        }
        return idNumber.toString();
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
    
    public String getEmail() {
        return (String) personData.get("email");
    }
    
    /**
     * Returns the String representation of this Person.  The String representation of a Person contains the first and last name and type.
     * @return 
     */
    @Override
    public String toString() {
        return ("Full Name: " + getFullName() + " (" + getType() + ")\r\n" + 
                "ID#: " + getIDNumber() + " - Social Security: *" + getSocial().substring(5) + "\r\n" + 
                "Phone Number: " + getPhoneNumber() + " - Email Address: " + getEmail());
    }
    
    public void setPersonData(String key, Object value) {
        personData.put(key, value);
    }
    
    public Object getPersonData(String key) {
        if (personData.containsKey(key))
            return personData.get(key);
        else throw new NoSuchElementException((String)personData.get("idnum") + " has no data for " + key);
    }
    
    public String personWriter() {
        Set<String> set = personData.keySet();
        StringBuilder writer = new StringBuilder();
        
        for (String key : set) {
            writer.append(key);
            writer.append(":");
            writer.append((personData.get(key)).toString());
            writer.append(",");
        }
        //writer.deleteCharAt(writer.length()-1);
        return writer.toString();
    }
}
package com.mycompany.schooldatabase;

/*
 * 
 * 
 * 
 */

import java.util.*;
import java.lang.*;

/**
 * Manages the collections of Person class and all subclasses.
 * Maintains two HashMaps, to lookup a person by last name as well as ID#
 * @author Brooks
 */
public class PersonCollection implements Iterable<Person> {
    
    private final HashMap<String, Person> hmapID;
    private final HashMap<String, Person> hmapName; //this needs to be a Guava MultiMap or something because of the potential for duplicate keys
    private final LinkedList<Person> list;
    
    /**
     * Instantiates the two HashMaps being used to hold Person objects
     */
    public PersonCollection() {
        hmapID = new HashMap<>();
        hmapName = new HashMap<>();
        list = new LinkedList<>();
        
    }

    /**
     * Creates a new Person based on the String containing the Person information.
     * Important to note, this method is only used when instantiating a Person class for an existing Person.  The type
     * of person should be contained within the String parameter.
     * @param cLine the String containing the Person information
     */
    public void addPerson(String cLine) {
        addPerson(PersonEnum.getNewPerson(cLine));        
    }
    
    /**
     * Creates a new Person based on the String containing the Person information and the PersonEnum enum which dictates the type of Person to instantiate.
     * @param cLine the String containing the Person information
     * @param type  the type of Person to create
     */
    public void addPerson(String cLine, PersonEnum type) {
        addPerson(type.createPerson(cLine));
    }
    
    /**
     * Adds a Person to the collection.
     * @param person The Person to be added to the collection.
     */
    private void addPerson(Person person) {
        hmapID.put(person.getIDNumber(), person);
        hmapName.put(person.getLastName(), person);   
        list.add(getPositionSorted(person.getLastName()), person);
    }
    
    /**
     * Returns the integer position of the String within the alphabetized LinkedList 
     * @param name the String to compare against all elements within the LinkedList and find its alphabetized position
     * @return the alphabetical position of the String within the LinkedList
     */
    private int getPositionSorted(String name) {
        for (int i = 0; i < list.size(); i++) {
            if (name.compareToIgnoreCase(list.get(i).getLastName()) < 0)
                return i;
        }
        return list.size();
    }
    
    @Override
    public PersonCollectionIterator iterator() {
        return new PersonCollectionIterator(hmapID, hmapName, list);
    }

//    public static String verifyEmail(String first, String last) {
//        
//    }
}

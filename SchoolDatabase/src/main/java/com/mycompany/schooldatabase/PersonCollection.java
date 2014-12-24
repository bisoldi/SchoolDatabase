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
    private final HashMap<String, Person> hmapName;
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
     * Creates a randomly selected Person using the information provided and adds it to the collection
     * @param firstName 
     * @param lastName
     * @param social 
     */
    public void addRandomPerson(String firstName, String lastName, String social) {
        PersonEnum type = PersonEnum.ADMINISTRATOR.getRandomType(); //this looks dumb and I expect to get called out on it
        addPerson(type.createPerson(firstName, lastName, social));
    }
    
    public void addRandomPerson(String cLine) {
        PersonEnum type = PersonEnum.ADMINISTRATOR.getRandomType();  //this looks dumb and I expect to get called out on it
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

}

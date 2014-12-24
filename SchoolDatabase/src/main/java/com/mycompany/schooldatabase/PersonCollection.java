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
    
    /**
     * Instantiates a Student using the information held in the Scanner and adds it to the collection
     * @param scan The full Person information (first name, last name, social security number)
     */
//    private void addStudent(Scanner scan) {
//        Student student = new Student(new Scanner(scan.nextLine()));
//        
//        hmapID.put(student.getIDNumber(), student);
//        hmapName.put(student.getLastName(), student);
//    }

    /**
     * Instantiates a Faculty using the information held in the Scanner and adds it to the collection
     * @param scan The full Person information (first name, last name, social security number)
     */
//    private void addFaculty(Scanner scan) {
//        Faculty faculty = new Faculty(new Scanner(scan.nextLine()));
//        
//        hmapID.put(faculty.getIDNumber(), faculty);
//        hmapName.put(faculty.getLastName(), faculty);        
//    }
    
    /**
     * Instantiates an Administrator using the information held in the Scanner and adds it to the collection
     * @param scan The full Person information (first name, last name, social security number)
     */
//    private void addAdministrator(Scanner scan) {
//        Administrator admin = new Administrator(new Scanner(scan.nextLine()));
//        
//        hmapID.put(admin.getIDNumber(), admin);
//        hmapName.put(admin.getLastName(), admin); 
//    }
    
    /**
     * Instantiates a Staff using the information held in the Scanner and adds it to the collection
     * @param scan The full Person information (first name, last name, social security number)
     */
//    private void addStaff(Scanner scan) {
//        Staff staff = new Staff(new Scanner(scan.nextLine()));
//        
//        hmapID.put(staff.getIDNumber(), staff);
//        hmapName.put(staff.getLastName(), staff); 
//    }
    
    @Override
    public PersonCollectionIterator iterator() {
        return new PersonCollectionIterator(hmapID, hmapName, list);
    }

}

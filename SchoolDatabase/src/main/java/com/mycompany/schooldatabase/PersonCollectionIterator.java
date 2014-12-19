package com.mycompany.schooldatabase;

/*
 * 
 * 
 * 
 */


import java.util.*;

/**
 *
 * @author Brooks
 */
public class PersonCollectionIterator implements Iterator<Person> {
    private HashMap<String, Person> hmapID;
    private HashMap<String, Person> hmapName;
    private LinkedList<Person> list;
    private int listCount;
    private boolean canRemove;
    
    public PersonCollectionIterator(HashMap<String, Person> hmapID, HashMap<String, Person> hmapName, LinkedList<Person> list) {
        this.hmapID = hmapID;
        this.hmapName = hmapName;
        this.list = list;
        listCount = 0;
        canRemove = false;
    }
    
    @Override
    public boolean hasNext() {
        return (listCount != list.size());
    }
    
    @Override
    public Person next() {
        if (this.hasNext()) {
            canRemove = true;
            return list.get(listCount++);
        }
        throw new NoSuchElementException();
    }
    
    @Override
    public void remove() {
        if (canRemove) {
            hmapID.remove(((Person) list.get(listCount)).getIDNumber());
            hmapName.remove(((Person) list.get(listCount)).getLastName());
            list.remove(listCount);
            canRemove = false;
        }
        else throw new IllegalStateException();
    }
    
    /**
     * Resets the iterator back to the top (beginning) of the list
     */
    public void reset() {
        listCount = 0;
    }
}

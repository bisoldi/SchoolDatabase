package com.mycompany.schooldatabase;

/**
 * Enum class enumerating 4 different kinds of people with associated 
 * description ("Staff", "Faculty", "Administrator", "Student"), prefix
 * ("S" for Student, "F" for Faculty, "A" for Administrator and "ST" for Staff)
 * and its expected ID# length.
 *
 * @author Brooks Isoldi
 */


import java.util.*;

/**
 * 
 * @author Brooks
 */
public enum PersonEnum {
    STUDENT ("Student", "S", 7) {
        
        @Override
        public Person createPerson(String firstName, String lastName, String social) { 
            return new Student(firstName, lastName, social);
        }
        
        @Override
        public Person createPerson(String cLine) { 
            return new Student(cLine);
        }        
    },
    
    FACULTY ("Faculty", "F", 7) {
        
        @Override
        public Person createPerson(String firstName, String lastName, String social) {
            return new Faculty(firstName, lastName, social);
        }
        
        @Override
        public Person createPerson(String cLine) {
            return new Faculty(cLine);
        }        
    },
    
    ADMINISTRATOR ("Administrator", "A", 7) {
        
        @Override
        public Person createPerson(String firstName, String lastName, String social) {
            return new Administrator(firstName, lastName, social);
        }
        
        @Override
        public Person createPerson(String cLine) {
            return new Administrator(cLine);
        }
    },
    
    STAFF ("Staff", "ST", 7) {
        
        @Override
        public Person createPerson(String firstName, String lastName, String social) {
            return new Staff(firstName, lastName, social);
        }
        
        @Override
        public Person createPerson(String cLine) {
            return new Staff(cLine);
        }        
    };
    
    private final String descr;
    private final String prefix;
    private final int idLength;
    
    public abstract Person createPerson(String firstName, String lastName, String social);
    public abstract Person createPerson(String cLine);
    
    /**
     * Sets the description, prefix and idLength fields
     * 
     * @param descr The String describing the enumerated value
     * @param prefix The String containing the ID prefix of the enumerated value
     * @param idLength The expected length of the ID# of the enumerated value (currently defaulted to 7)
     */
    private PersonEnum(String descr, String prefix, int idLength) {
        this.descr = descr;
        this.prefix = prefix;
        this.idLength = idLength;
    }
    
    /**
     * Acessor for the prefix for this enumerated value
     * @return The String prefix of this enumerated value
     */
    String getPrefix() {
        return prefix;
    }
    
    /**
     * Returns a randomly selected Person.  Must be called on a Person type.
     * @return A randomly selected Person enum value
     */
    public PersonEnum getRandomType() {
        Random ran = new Random();
        return this.values()[ran.nextInt(this.values().length)];
    }
    
    /**
     * Accessor for the expected length of the ID#
     * @return The number of digits expected in the ID#
     */
    int getIDLength() {
        return idLength;
    }
    
    /**
     * The description of this enumerated value (Overrides the Object toString method)
     * @return The String description of this enumerated value
     */
    @Override
    public String toString() {
        return descr;
    }
       
}

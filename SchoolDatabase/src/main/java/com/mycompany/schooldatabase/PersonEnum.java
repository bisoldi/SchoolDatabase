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
import com.google.common.base.Splitter;


/**
 * 
 * @author Brooks
 */
public enum PersonEnum {
    STUDENT ("Student", "S", 7) {
        
//        @Override
//        public Person createPerson(String firstName, String lastName, String social) { 
//            return new Student(firstName, lastName, social);
//        }
        
        @Override
        public Person createPerson(String cLine) {             
            return new Student(cLine);
        }
        
        @Override
        public ArrayList<String> getInputs() {
            return Student.dataPoints;
        }
        
        @Override
        public ArrayList<String> getInputIdentifiers() {
            return Student.dataPointIdentifiers;
        }
    },
    
    FACULTY ("Faculty", "F", 7) {
        
//        @Override
//        public Person createPerson(String firstName, String lastName, String social) {
//            return new Faculty(firstName, lastName, social);
//        }
        
        @Override
        public Person createPerson(String cLine) {
            StringBuilder str = new StringBuilder(cLine);
            List<String> list = Splitter.on(":").splitToList(str.substring(str.indexOf("tenured:"), str.indexOf(",", str.indexOf("tenured:"))));
            if (list.get(1).equalsIgnoreCase("Y")) {
                str.delete(str.indexOf("tenured:"), str.indexOf(",", str.indexOf("tenured:"))+1);
                str.append("tenured:true,");
            }
            else if (list.get(1).equalsIgnoreCase("N")) {
                str.delete(str.indexOf("tenured:"), str.indexOf(",", str.indexOf("tenured:")+1));                
                str.append("tenured:false,");
            }
            return new Faculty(str.toString());
        }
        
        @Override
        public ArrayList<String> getInputs() {
            return Faculty.dataPoints;
        }
        
        @Override
        public ArrayList<String> getInputIdentifiers() {
            return Faculty.dataPointIdentifiers;
        }
    },
    
    ADMINISTRATOR ("Administrator", "A", 7) {
        
//        @Override
//        public Person createPerson(String firstName, String lastName, String social) {
//            return new Administrator(firstName, lastName, social);
//        }
        
        @Override
        public Person createPerson(String cLine) {
            return new Administrator(cLine);
        }
        
        @Override
        public ArrayList<String> getInputs() {
            return Administrator.dataPoints;
        }
        
        @Override
        public ArrayList<String> getInputIdentifiers() {
            return Administrator.dataPointIdentifiers;
        }
        
    },
    
    STAFF ("Staff", "ST", 7) {
        
//        @Override
//        public Person createPerson(String firstName, String lastName, String social) {
//            return new Staff(firstName, lastName, social);
//        }
        
        @Override
        public Person createPerson(String cLine) {
            return new Staff(cLine);
        }
        
        @Override
        public ArrayList<String> getInputs() {
            return Staff.dataPoints;
        }
        
        @Override
        public ArrayList<String> getInputIdentifiers() {
            return Staff.dataPointIdentifiers;
        }
        
    };
    
    private final String descr;
    private final String prefix;
    private final int idLength;
    
//    public abstract Person createPerson(String firstName, String lastName, String social);
    public abstract Person createPerson(String cLine);
    public abstract ArrayList<String> getInputs();
    public abstract ArrayList<String> getInputIdentifiers();
    
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
    
//    /**
//     * Returns a randomly selected Person.  Must be called on a Person type.
//     * @return A randomly selected Person enum value
//     */
//    public static PersonEnum getRandomType() {
//        Random ran = new Random();
//        return values()[ran.nextInt(values().length)];
//    }
    
    public static Person getNewPerson(String cLine) {
        
        int start = cLine.indexOf("type:");
        int end = cLine.indexOf(",", start);
        
        String typeStr = cLine.substring(start + 5, end);
        cLine = new StringBuilder(cLine).delete(start, end+1).toString();
        PersonEnum type = null;
        
        switch (typeStr) {
            case "Student":     type = STUDENT;
                                break;
                
            case "Faculty":     type = FACULTY;
                                break;
                
            case "Administrator":   type = ADMINISTRATOR;
                                    break;

            case "Staff":       type = STAFF;
                                break;
        }
        if (type == null) {
            throw new NullPointerException("Trying to create an unknown type of person");
        }
        return type.createPerson(cLine);
        //Should do some checking here to make sure we're not dereferencing a null pointer
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

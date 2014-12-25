package com.mycompany.schooldatabase;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.*;
import java.util.Scanner;
import java.nio.file.*;
import java.nio.charset.*;



/**
 *
 * @author Brooks
 */
public class FileOperations {
    
    public FileOperations() {
    }
        
    public PersonCollection readOneTimeFile() {
    
        PersonCollection collection = new PersonCollection();
        
        try (Scanner scan = new Scanner(new BufferedReader(new FileReader("names.txt")))) {
            
            while (scan.hasNextLine()) {
//                String firstName = scan.next();
//                String lastName = scan.next();
//                String social = scan.next();
//                collect.addRandomPerson(firstName, lastName, social);
                
                collection.addRandomPerson(scan.nextLine());
            }
        } catch (FileNotFoundException fnfe) {
            System.out.println("I caught a FileNotFoundException"); 
        } 
        
        return collection;
    }
    
    public boolean writeFile(PersonCollection collection) throws IOException {
        Path path = Paths.get("personFile.txt");
        PersonCollectionIterator iter = collection.iterator();
        
        System.out.println("About to write file");
               
        try (BufferedWriter writer = Files.newBufferedWriter(path, StandardCharsets.UTF_8)) {
            while (iter.hasNext()) {
                writer.write(iter.next().personWriter());
                if (iter.hasNext())
                    writer.newLine();
            }
        } catch (FileNotFoundException fnfe) {
            System.out.println("I caught a FileNotFoundException");
        }
        
        return true;
    }
}

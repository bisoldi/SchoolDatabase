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
        
    public PersonCollection readFile() throws IOException {
        PersonCollection collection = new PersonCollection();
        Path path = Paths.get("personFile.txt");
        
        try (BufferedReader reader = Files.newBufferedReader(path, StandardCharsets.UTF_8)) {
            String cLine = null;
            while ((cLine = reader.readLine()) != null) {
                collection.addPerson(cLine);
            }
        }
        
        return collection;
    }
    
    public boolean writeFile(PersonCollection collection) throws IOException {
        Path path = Paths.get("personFile.txt");
        PersonCollectionIterator iter = collection.iterator();
                       
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
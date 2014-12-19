package com.mycompany.schooldatabase;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.*;

/**
 *
 * @author Brooks
 */
public class Administrator extends Person {
    
    public Administrator(String firstName, String lastName, String social) {
        super(firstName, lastName, social, PersonEnum.ADMINISTRATOR);
    }
    
    public Administrator (Scanner fullInfoScanner) {
        super(fullInfoScanner, PersonEnum.ADMINISTRATOR);
    }
    
}
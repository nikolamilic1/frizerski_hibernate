/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.frizerski.util;

/**
 *
 * @author Korisnik
 */
public class FrizerskiException extends Exception{
    private String poruka;

   
    public FrizerskiException(String poruka) {
        this.poruka=poruka;  
    }
    
     public String getPoruka() {
        return poruka;
    }
    
    
    
    
}

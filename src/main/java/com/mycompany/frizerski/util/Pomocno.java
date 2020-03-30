/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.frizerski.util;

import com.mycompany.frizerski.controller.Obrada;
import com.mycompany.frizerski.controller.ObradaDjelatnik;
import com.mycompany.frizerski.controller.ObradaKlijent;
import com.mycompany.frizerski.model.Djelatnik;
import com.mycompany.frizerski.model.Klijent;
import org.mindrot.jbcrypt.BCrypt;

/**
 *
 * @author Korisnik
 */
public class Pomocno {
    
    public static Djelatnik LOGIRAN;
    /**
     *
     */
    
    public static String getNazivAplikacije() {
        return "Frizerski APP";
    }
    
    public static void pocetniInsert() {
        
        Djelatnik o = new Djelatnik();
        
        o.setIme("Nikola");
        o.setPrezime("Milić");
        o.setBrojtelefona("+38532111222");
        o.setEmail("nikk.mil@gmail.com");
        o.setAdresa("Ivana pl. Zajca 7");
        o.setIban("CH2789144528499724123");
        o.setLozinka(BCrypt.hashpw("n", BCrypt.gensalt()));
    
    
    ObradaDjelatnik obradaDjelatnik = new ObradaDjelatnik(o);
        try {
            obradaDjelatnik.create();
        } catch (FrizerskiException e) {
            System.out.println(e.getPoruka());
        }
        
        Klijent k = new Klijent();
        
        k.setIme("Pero");
        k.setPrezime("Perić");
        k.setBrojtelefona("+38595999555");
        k.setEmail("pero.peric@perkani.per");
        k.setAdresa("Perićevo Brdo bb.");
        
        ObradaKlijent obradaKlijent = new ObradaKlijent(k);
        try {
            obradaKlijent.create();
        } catch (FrizerskiException e) {
            System.out.println(e.getPoruka());
        }
    }
}


        
 
        
        
 
    
    
    



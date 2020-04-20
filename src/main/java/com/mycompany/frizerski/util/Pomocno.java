/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.frizerski.util;

import com.mycompany.frizerski.controller.Obrada;
import com.mycompany.frizerski.controller.ObradaDjelatnik;
import com.mycompany.frizerski.controller.ObradaKlijent;
import com.mycompany.frizerski.controller.ObradaTermin;
import com.mycompany.frizerski.controller.ObradaUsluga;
import com.mycompany.frizerski.model.Djelatnik;
import com.mycompany.frizerski.model.Klijent;
import com.mycompany.frizerski.model.Termin;
import com.mycompany.frizerski.model.Usluga;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.Locale;
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
    private final static DecimalFormat df = df();
    
    
    public static  Date convertToDateViaInstant(LocalDate dateToConvert) {
        return  java.util.Date.from(dateToConvert.atStartOfDay()
        .atZone(ZoneId.systemDefault())
        .toInstant());
    }
    
    public static LocalDate convertToLocalDateViaInstant(Date dateToConvert) {
        return dateToConvert.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate();
    }
    
    public static String getFormatCijelogBroja(long i) {
        DecimalFormat dfCijeliBroj = new DecimalFormat("#");
        return dfCijeliBroj.format(i);
    }
    
    
    public static String getFormatDecimalniBroj(BigDecimal b) {
        return df.format(b);
    }
    
    public static int getCijeliBrojIzStringa(String s) {
        try {
            return  Integer.parseInt(s);
        } catch (Exception e) {
            return 0;
        }
    }
    
    public static BigDecimal getDecimalniBrojIzStringa(String s) {
        try {
            return new BigDecimal(df.parse(s).doubleValue());
        } catch (Exception e) {
            return BigDecimal.ZERO;
        }
    }
    
    
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
        
        
       
        
        Usluga u = new Usluga();
        u.setNaziv("Šišanje žensko");
        u.setCijena(new BigDecimal(200));
        u.setTrajanje(1);
        
        ObradaUsluga obradaUsluga = new ObradaUsluga(u);
        try {
            obradaUsluga.create();
        } catch (FrizerskiException e) {
            System.out.println(e.getPoruka());
        }
        
        
        
    
        Termin t = new Termin();
        t.setDjelatnik(o);
        t.setKlijent(k);
        t.setVrijeme(new Date());
        t.setStatus("Izvršava se...");      
        t.getUsluge().add(u);
        
        
        
        ObradaTermin obradaTermin = new ObradaTermin(t);
        try {
            obradaTermin.create();
        } catch (FrizerskiException e) {
            System.out.println(e.getPoruka());
        }
        
       
        
    }

    private static DecimalFormat df() {
        NumberFormat nf = NumberFormat.getNumberInstance(new Locale("hr","HR"));
        DecimalFormat dfl = (DecimalFormat) nf;
        dfl.applyPattern("#,###.00");
        return dfl;
    }
}


        
 
        
        
 
    
    
    



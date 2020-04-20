/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.frizerski;

import com.mycompany.frizerski.util.Pomocno;
import com.mycompany.frizerski.view.SplashScreen;
import com.mycompany.javaedu21.util.HibernateUtil;
import org.hibernate.Session;

/**
 *
 * @author Korisnik
 */
public class Start {

    public Start() {

       // Pomocno.pocetniInsert();
        new SplashScreen().setVisible(true);

    }

    public static void main(String[] args) {
        new Start();
    }
   
}

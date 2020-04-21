/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.frizerski;

import com.mycompany.frizerski.view.SplashScreen;

/**
 *
 * @author Korisnik
 */
public class Start {

    public Start() {

        //SPomocno.pocetniInsert();
        new SplashScreen().setVisible(true);

    }

    public static void main(String[] args) {
        new Start();
    }

}

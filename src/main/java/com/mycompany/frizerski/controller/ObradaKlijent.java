/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.frizerski.controller;


import com.mycompany.frizerski.model.Klijent;
import com.mycompany.frizerski.util.FrizerskiException;
import java.util.List;

/**
 *
 * @author Korisnik
 */
public class ObradaKlijent extends Obrada<Klijent>{
    public ObradaKlijent(Klijent klijent) {
        super(klijent);
        
    }
    public ObradaKlijent() {
        super();
    }
    
    @Override
    public List<Klijent> getPodaci() {
        return session.createQuery("from Klijent").list();
        
    }
    
    @Override
    protected  void kontrolaCreate() throws  FrizerskiException {
        kontrolaIme();
    }    
    
    @Override
    protected  void kontrolaUpdate() throws FrizerskiException {
        
    }
    
    @Override
    protected void kontrolaDelete() throws FrizerskiException{
        
    }
    
    
    private void kontrolaIme() throws FrizerskiException {
        if(entitet.getIme().length()>50) {
            throw new FrizerskiException(("Ime mora biti kraće od 50 znakova"));
        }
    }
    
    @Override
    public void nakonSpremanja() throws FrizerskiException {
        
    }
    
    
    
    
    
}


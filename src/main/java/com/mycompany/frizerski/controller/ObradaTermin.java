/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.frizerski.controller;

import com.mycompany.frizerski.model.Termin;
import com.mycompany.frizerski.util.FrizerskiException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Korisnik
 */
public class ObradaTermin extends Obrada<Termin>{

    public ObradaTermin(Termin entitet) {
        super(entitet);
    }

    public ObradaTermin() {
        super();
    }

    @Override
    public Termin create() throws FrizerskiException {
        kontrolaCreate();
        save();
        nakonSpremanja();
        return entitet;
        
    }
    
    @Override
    public Termin update() throws FrizerskiException {
       kontrolaUpdate();
       save();
       nakonSpremanja();
       return entitet;
    }
    
    private void save() {
        session.beginTransaction();
        session.save(entitet);
        entitet.getUsluge().forEach((t)->{
        session.save(t);
                });
        session.getTransaction().commit();
   }
    
    public void ocistiUsluge() {
        session.beginTransaction();
        entitet.getUsluge().forEach((t)->{
        session.delete(t);
                });
         session.getTransaction().commit();
         entitet.setUsluge(new ArrayList<>());
         
    }
    
    @Override
    protected void kontrolaCreate() throws FrizerskiException {
        
    }

    @Override
    protected void kontrolaUpdate() throws FrizerskiException {
        
    }

    @Override
    protected void kontrolaDelete() throws FrizerskiException {
       // ocistiUsluge();
        kontrolaBrisanjeTermin(); 
    }

    @Override
    public List<Termin> getPodaci() {
        
        return session.createQuery("from Termin").list();
        
    }

    @Override
    public void nakonSpremanja() throws FrizerskiException {
        
    }

    

    private void kontrolaBrisanjeTermin() throws FrizerskiException  {
        if (entitet.getUsluge().size()>0) {
            throw  new FrizerskiException("Ne mogu obrisati jer su usluge vezane na termin");
        } 
    }
    
}

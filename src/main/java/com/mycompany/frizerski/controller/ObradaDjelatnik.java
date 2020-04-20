/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.frizerski.controller;

import com.mycompany.frizerski.model.Djelatnik;
import com.mycompany.frizerski.util.FrizerskiException;
import java.util.List;
import org.mindrot.jbcrypt.BCrypt;


/**
 *
 * @author Korisnik
 */
public class ObradaDjelatnik extends Obrada<Djelatnik> {
    
    public ObradaDjelatnik(Djelatnik djelatnik) {
        super(djelatnik);
                  }
    
    public ObradaDjelatnik() {
        super();
    }
    
    /**
     *
     * @return
     */
    @Override
    public List<Djelatnik> getPodaci() {
        return session.createQuery("from Djelatnik").list();
    }
    @Override
    protected void kontrolaCreate() throws FrizerskiException {
        kontrolaIme();
     //   kontrolaLozinka();
    }

    @Override
    protected void kontrolaUpdate() throws FrizerskiException {
        
    }

    @Override
    protected void kontrolaDelete() throws FrizerskiException {
        if (entitet.getTermini().size()>0
         ) {
            throw  new FrizerskiException("Ne mogu obrisati jer radi termin");
        }
    }

    

    
    private void kontrolaIme() throws FrizerskiException {
        if(entitet.getIme().length()>50) {
            throw  new FrizerskiException("Ime mora biti kraće od 50 znakova");
        }
    }
    
    
    
    @Override
    public void nakonSpremanja() throws FrizerskiException {
        
    }
    
    public  Djelatnik autoriziraj(String email, String lozinka) {
        List<Djelatnik> lista = session.createQuery("from Djelatnik d "
        + " where d.email=:email").setParameter("email", email).list();
        if (lista==null || lista.isEmpty()) {
            return null;
            
        }
        Djelatnik d = lista.get(0);
        if(d == null) {
            return null;
        }
    return BCrypt.checkpw(lozinka, d.getLozinka()) ? d : null;
    }
    
    private void kontrolaLozinka() throws FrizerskiException{
        if(entitet.getLozinka()==null || entitet.getLozinka().trim().length()==0){
            throw new FrizerskiException("Obavezno lozinka");
        }
    }
}
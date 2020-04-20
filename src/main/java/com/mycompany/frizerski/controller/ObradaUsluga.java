/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.frizerski.controller;

import com.mycompany.frizerski.model.Usluga;
import com.mycompany.frizerski.util.FrizerskiException;
import java.util.List;

/**
 *
 * @author Korisnik
 */
public class ObradaUsluga extends Obrada<Usluga>{

    public ObradaUsluga(Usluga usluga) {
        super(usluga);
    }

    public ObradaUsluga() {
        super();
    }

    
    
    
    @Override
    protected void kontrolaCreate() throws FrizerskiException {
    }

    @Override
    protected void kontrolaUpdate() throws FrizerskiException {
    }

    @Override
    protected void kontrolaDelete() throws FrizerskiException {
    }

    @Override
    public List<Usluga> getPodaci() {
        return session.createQuery("from Usluga").list();
    }
    
    public List<Usluga> getPodaci(String uvjet) {
        return session.createQuery("from Usluga p "
                + " where p.naziv like :uvjet ")
                .setParameter("uvjet", "%" + uvjet + "%")
                .setMaxResults(20).list();
    }

    @Override
    public void nakonSpremanja() throws FrizerskiException {
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.frizerski.controller;

import com.mycompany.frizerski.model.Entitet;
import com.mycompany.frizerski.util.FrizerskiException;
import com.mycompany.frizerski.util.HibernateUtil;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author Korisnik
 * @param <T>
 */
public abstract class Obrada<T> {
    
    protected T entitet;
    protected Session session;
    protected abstract void kontrolaCreate() throws FrizerskiException;
    protected abstract void kontrolaUpdate() throws FrizerskiException;
    protected abstract void kontrolaDelete() throws FrizerskiException;
    public abstract List<T> getPodaci();
    public abstract  void nakonSpremanja() throws FrizerskiException;


public Obrada(T entitet){
        this();
        this.entitet=entitet;
    }

    public Obrada() {
        session = HibernateUtil.getSessionFactory().openSession();
    }

    public T getEntitet() {
        return entitet;
    }

    public void setEntitet(T entitet) {
        this.entitet = entitet;
    }
    
    public T create() throws FrizerskiException{
        kontrolaCreate();
        save();
        nakonSpremanja();
        return entitet;
    }
    
    public void createAll(List<T> lista) throws FrizerskiException{
    
        session.beginTransaction();
        for(T sl : lista){
            this.entitet=sl;
            kontrolaCreate();
            session.save(sl);
            nakonSpremanja();
        }
        session.getTransaction().commit();
        
        
    }
    
    public T update() throws FrizerskiException{
        kontrolaUpdate();
        save();
        nakonSpremanja();
        return entitet;
    }
    
    public boolean delete() throws FrizerskiException{
        kontrolaDelete();
        session.beginTransaction();
        session.delete(entitet);
        session.getTransaction().commit();
        //provjeriti da li je obrisano. Vjerojatno će entitet.getSifra biti null
        return true;
    }
    
    private void save(){
        session.beginTransaction();
        session.save(entitet);
        session.getTransaction().commit();
    }
}
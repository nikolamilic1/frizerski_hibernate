/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.frizerski.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

/**
 *
 * @author Korisnik
 */
@Entity(name = "termin")
public class Termin extends Entitet{
         
    
    @ManyToOne
    private Djelatnik djelatnik;
    
    @ManyToOne
    private Klijent klijent;
           
    private Date vrijeme;
    
    private Boolean status;

    @ManyToMany
    @JoinTable(name = "stavka")
    private List<Usluga> usluge = new ArrayList<>();

    public Djelatnik getDjelatnik() {
        return djelatnik;
    }

    public void setDjelatnik(Djelatnik djelatnik) {
        this.djelatnik = djelatnik;
    }

    public Klijent getKlijent() {
        return klijent;
    }

    public void setKlijent(Klijent klijent) {
        this.klijent = klijent;
    }

    public Date getVrijeme() {
        return vrijeme;
    }

    public void setVrijeme(Date vrijeme) {
        this.vrijeme = vrijeme;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public List<Usluga> getUsluge() {
        return usluge;
    }

    public void setUsluge(List<Usluga> usluge) {
        this.usluge = usluge;
    }

    
}

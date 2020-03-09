/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.frizerski.model;

import java.util.Date;
import javax.persistence.Entity;

/**
 *
 * @author Korisnik
 */
@Entity
public class Usluga extends Entitet{
    
    private String naziv;
    private Integer cijena;
    private Date trajanje;

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public Integer getCijena() {
        return cijena;
    }

    public void setCijena(Integer cijena) {
        this.cijena = cijena;
    }

    public Date getTrajanje() {
        return trajanje;
    }

    public void setTrajanje(Date trajanje) {
        this.trajanje = trajanje;
    }
    
    
     
}

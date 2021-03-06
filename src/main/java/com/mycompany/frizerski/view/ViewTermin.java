/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.frizerski.view;

import com.github.lgooddatepicker.components.DatePickerSettings;
import com.mycompany.frizerski.controller.ObradaDjelatnik;
import com.mycompany.frizerski.controller.ObradaKlijent;
import com.mycompany.frizerski.controller.ObradaTermin;
import com.mycompany.frizerski.controller.ObradaUsluga;
import com.mycompany.frizerski.model.Djelatnik;
import com.mycompany.frizerski.model.Klijent;
import com.mycompany.frizerski.model.Termin;
import com.mycompany.frizerski.model.Usluga;
import com.mycompany.frizerski.util.FrizerskiException;
import com.mycompany.frizerski.util.Pomocno;
import java.awt.event.KeyEvent;
import java.util.Date;
import java.util.Locale;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

/**
 *
 * @author Korisnik
 */
public class ViewTermin extends javax.swing.JFrame {

    private final ObradaTermin obrada;
    private final ObradaUsluga obradaUsluga;

    /**
     * Creates new form ViewTermin
     */
    public ViewTermin() {
        initComponents();
        obrada = new ObradaTermin();
        obradaUsluga = new ObradaUsluga();
        postInitComponents();

        ucitajKlijente();
        ucitajDjelatnike();
        ucitaj();

        obrada.setEntitet(new Termin());
        DatePickerSettings dps = new DatePickerSettings(new Locale("hr", "HR"));
        dps.setFormatForDatesCommonEra("dd.MM.yyyy");
        dpVrijeme.setSettings(dps);
    }

    private void postInitComponents() {
        setTitle("Termini - " + Pomocno.LOGIRAN.getPrezime());
        ucitaj();
    }

    private void ucitajDjelatnike() {
        DefaultComboBoxModel<Djelatnik> m = new DefaultComboBoxModel<>();
        new ObradaDjelatnik().getPodaci().forEach(s -> m.addElement(s));
        cmbDjelatnik.setModel(m);
    }

    private void ucitajKlijente() {
        DefaultComboBoxModel<Klijent> k = new DefaultComboBoxModel<>();
        new ObradaKlijent().getPodaci().forEach(s -> k.addElement(s));
        cmbKlijent.setModel(k);
    }

    private void ucitaj() {
        DefaultListModel<Termin> m = new DefaultListModel<>();
        obrada.getPodaci().forEach(s -> m.addElement(s));
        lstPodaci.setModel(m);
    }

    private void ucitajVrijednosti() {
        obrada.getEntitet().setStatus(txtStatus.getText());

        //obrada.getEntitet().setDjelatnik(cmbDjelatnik.getModel().getElementAt(cmbDjelatnik.getSelectedIndex()));
        //.getEntitet().setKlijent(cmbKlijent.getModel().getElementAt(cmbKlijent.getSelectedIndex()));
        obrada.getEntitet().setDjelatnik((Djelatnik) cmbDjelatnik.getSelectedItem());
        obrada.getEntitet().setKlijent((Klijent) cmbKlijent.getSelectedItem());
        if (dpVrijeme.getDate() != null) {
            Date d = Pomocno.convertToDateViaInstant(dpVrijeme.getDate());
            obrada.getEntitet().setVrijeme(d);
        }
        // obrada.getEntitet().setVrijeme(new Date());

        try {
            DefaultListModel<Usluga> m = (DefaultListModel<Usluga>) lstZakazaneUsluge.getModel();
            obrada.ocistiUsluge();

            for (int i = 0; i < m.getSize(); i++) {
                obrada.getEntitet().getUsluge().add(m.get(i));

            }

        } catch (Exception e) {
        }
    }

    private void postaviVrijednosti() {
        txtStatus.setText(obrada.getEntitet().getStatus());

        //  txtVrijeme.setText(obrada.getEntitet().getVrijeme().toString());   
        if (obrada.getEntitet().getVrijeme() == null) {
            dpVrijeme.setDate(null);

        } else {
            dpVrijeme.setDate(Pomocno.convertToLocalDateViaInstant(obrada.getEntitet().getVrijeme()));
        }

        postaviKlijenta();
        postaviDjelatnike();
        postaviUsluge();

    }

    private void postaviKlijenta() {
        for (int i = 0; i < cmbKlijent.getModel().getSize(); i++) {
            if (cmbKlijent.getModel().getElementAt(i).getSifra().equals(
                    obrada.getEntitet().getKlijent().getSifra())) {
                cmbKlijent.setSelectedIndex(i);
                break;
            }
        }
    }

    private void postaviDjelatnike() {
        for (int i = 0; i < cmbDjelatnik.getModel().getSize(); i++) {
            if (cmbDjelatnik.getModel().getElementAt(i).getSifra().equals(
                    obrada.getEntitet().getDjelatnik().getSifra())) {
                cmbDjelatnik.setSelectedIndex(i);
                break;
            }
        }
    }

    private void postaviUsluge() {
        DefaultListModel<Usluga> m = new DefaultListModel<>();
        obrada.getEntitet().getUsluge().forEach(c -> {
            m.addElement(c);
        });
        lstZakazaneUsluge.setModel(m);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        lstPodaci = new javax.swing.JList<>();
        btnDodajNovi = new javax.swing.JButton();
        btnPromjeni = new javax.swing.JButton();
        btnObrisi = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        cmbDjelatnik = new javax.swing.JComboBox<>();
        cmbKlijent = new javax.swing.JComboBox<>();
        txtStatus = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        lstZakazaneUsluge = new javax.swing.JList<>();
        jScrollPane3 = new javax.swing.JScrollPane();
        lstSveUsluge = new javax.swing.JList<>();
        btnTrazi = new javax.swing.JButton();
        txtUvjet = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        dpVrijeme = new com.github.lgooddatepicker.components.DatePicker();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        lstPodaci.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                lstPodaciValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(lstPodaci);

        btnDodajNovi.setText("Dodaj novi");
        btnDodajNovi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDodajNoviActionPerformed(evt);
            }
        });

        btnPromjeni.setText("Promjeni");
        btnPromjeni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPromjeniActionPerformed(evt);
            }
        });

        btnObrisi.setText("Obriši");
        btnObrisi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnObrisiActionPerformed(evt);
            }
        });

        jLabel1.setText("Klijent");

        jLabel2.setText("Djelatnik");

        jLabel4.setText("Status");

        lstZakazaneUsluge.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lstZakazaneUslugeMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(lstZakazaneUsluge);

        lstSveUsluge.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lstSveUslugeMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(lstSveUsluge);

        btnTrazi.setText("Traži");
        btnTrazi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTraziActionPerformed(evt);
            }
        });

        txtUvjet.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtUvjetKeyPressed(evt);
            }
        });

        jLabel5.setText("Zakazane usluge");

        jLabel6.setText("Vrijeme");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnDodajNovi)
                        .addGap(18, 18, 18)
                        .addComponent(btnPromjeni)
                        .addGap(18, 18, 18)
                        .addComponent(btnObrisi))
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbKlijent, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cmbDjelatnik, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtStatus)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(dpVrijeme, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtUvjet)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnTrazi))))
                    .addComponent(jLabel5))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 372, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(btnTrazi)
                                    .addComponent(txtUvjet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane3))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(cmbKlijent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cmbDjelatnik, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel6)
                                .addGap(18, 18, 18)
                                .addComponent(dpVrijeme, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(42, 42, 42)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(btnDodajNovi)
                                    .addComponent(btnPromjeni)
                                    .addComponent(btnObrisi)))
                            .addComponent(jScrollPane2))))
                .addGap(21, 21, 21))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lstPodaciValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_lstPodaciValueChanged
        if (evt.getValueIsAdjusting()) {
            return;
        }
        obrada.setEntitet(lstPodaci.getSelectedValue());
        if (obrada.getEntitet() == null) {
            return;
        }
        postaviVrijednosti();
    }//GEN-LAST:event_lstPodaciValueChanged

    private void btnDodajNoviActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDodajNoviActionPerformed
        try {
            obrada.setEntitet(new Termin());
            ucitajVrijednosti();
            obrada.create();
            ucitaj();
        } catch (FrizerskiException ex) {
            JOptionPane.showMessageDialog(null, ex.getPoruka());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }//GEN-LAST:event_btnDodajNoviActionPerformed

    private void btnPromjeniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPromjeniActionPerformed

        if (obrada.getEntitet() == null) {
            JOptionPane.showMessageDialog(null, "Prvo odaberite stavku");
            return;
        }

        ucitajVrijednosti();
        try {
            obrada.update();
            ucitaj();
        } catch (FrizerskiException e) {
            JOptionPane.showMessageDialog(null, e.getPoruka());
        }

    }//GEN-LAST:event_btnPromjeniActionPerformed

    private void btnObrisiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnObrisiActionPerformed
        if (obrada.getEntitet() == null) {
            JOptionPane.showMessageDialog(null, "Prvo odaberite stavku");
            return;
        }
        try {

            obrada.delete();
            ucitaj();
        } catch (FrizerskiException e) {
            JOptionPane.showMessageDialog(null, e.getPoruka());
        }
    }//GEN-LAST:event_btnObrisiActionPerformed


    private void txtUvjetKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUvjetKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            ucitajSveUsluge();
        }

    }//GEN-LAST:event_txtUvjetKeyPressed

    private void btnTraziActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTraziActionPerformed
        ucitajSveUsluge();
    }//GEN-LAST:event_btnTraziActionPerformed

    private void lstZakazaneUslugeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lstZakazaneUslugeMouseClicked
        if (evt.getClickCount() == 2) {
            int index = lstZakazaneUsluge.locationToIndex(evt.getPoint());
            DefaultListModel<Usluga> m = (DefaultListModel<Usluga>) lstZakazaneUsluge.getModel();
            m.remove(index);
            lstZakazaneUsluge.repaint();

        }
    }//GEN-LAST:event_lstZakazaneUslugeMouseClicked

    private void lstSveUslugeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lstSveUslugeMouseClicked
        if (evt.getClickCount() == 2) {
            int index = lstSveUsluge.locationToIndex(evt.getPoint());
            Usluga u = lstSveUsluge.getModel().getElementAt(index);

            DefaultListModel<Usluga> m;

            try {
                m = (DefaultListModel<Usluga>) lstZakazaneUsluge.getModel();
            } catch (Exception e) {
                m = new DefaultListModel<>();
                lstZakazaneUsluge.setModel(m);
            }
            m.addElement(u);
            lstZakazaneUsluge.repaint();
        }
    }//GEN-LAST:event_lstSveUslugeMouseClicked

    private void ucitajSveUsluge() {
        DefaultListModel<Usluga> m = new DefaultListModel<>();
        obradaUsluga.getPodaci(txtUvjet.getText().trim()).forEach(s -> m.addElement(s));
        lstSveUsluge.setModel(m);
    }

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDodajNovi;
    private javax.swing.JButton btnObrisi;
    private javax.swing.JButton btnPromjeni;
    private javax.swing.JButton btnTrazi;
    private javax.swing.JComboBox<Djelatnik> cmbDjelatnik;
    private javax.swing.JComboBox<Klijent> cmbKlijent;
    private com.github.lgooddatepicker.components.DatePicker dpVrijeme;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JList<Termin> lstPodaci;
    private javax.swing.JList<Usluga> lstSveUsluge;
    private javax.swing.JList<Usluga> lstZakazaneUsluge;
    private javax.swing.JTextField txtStatus;
    private javax.swing.JTextField txtUvjet;
    // End of variables declaration//GEN-END:variables

}

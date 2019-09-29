package no.hiof.trondag;

import java.time.LocalDate;
import java.util.ArrayList;

public abstract class Produksjon {
    private String tittel, beskrivelse;
    private double spilletid;
    private LocalDate utgivelsesdato;
    private Person regissor;
    private ArrayList<Rolle> rolleListe;


    public Produksjon(String tittel, String beskrivelse, double spilletid, LocalDate utgivelsesdato){
        this.tittel = tittel;
        this.beskrivelse = beskrivelse;
        this.spilletid = spilletid;
        this.utgivelsesdato = utgivelsesdato;
    }

    public Produksjon(String tittel, double spilletid){
        this.tittel = tittel;
        this.spilletid = spilletid;
    }

    public Produksjon(String tittel){
        this.tittel = tittel;
    }

    public void leggTilEnRolle(Rolle enRolle){
        rolleListe.add(enRolle);
    }

    public void leggTilMangeRoller(ArrayList<Rolle> flereRoller){
        rolleListe.addAll(flereRoller);
    }

    public ArrayList<Rolle> getRolleListe() {
        return rolleListe;
    }

    public Person getRegissor() {
        return regissor;
    }

    public void setRegissor(Person regissor) {
        this.regissor = regissor;
    }

    public String getBeskrivelse() {
        return beskrivelse;
    }

    public void setBeskrivelse(String beskrivelse) {
        this.beskrivelse = beskrivelse;
    }

    public LocalDate getUtgivelsesdato() {
        return utgivelsesdato;
    }

    public void setUtgivelsesdato(LocalDate utgivelsesdato) {
        this.utgivelsesdato = utgivelsesdato;
    }

    public String getTittel() {
        return tittel;
    }

    public void setTittel(String tittel) {
        this.tittel = tittel;
    }

    public double getSpilletid() {
        return spilletid;
    }

    public void setSpilletid(double spilletid) {
        this.spilletid = spilletid;
    }
}


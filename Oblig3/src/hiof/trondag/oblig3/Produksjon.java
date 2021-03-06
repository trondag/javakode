package hiof.trondag.oblig3;

import java.time.LocalDate;
import java.util.ArrayList;

public class Produksjon {

    private String tittel;
    private String beskrivelse;
    private double spilletid;
    private LocalDate utgivelsesdato;
    private Person regissor;
    private ArrayList<Rolle> roller = new ArrayList<>();

    public ArrayList<Rolle> getRoller() {
        return roller;
    }

    public Produksjon(String tittel, String beskrivelse, double spilletid, LocalDate utgivelsesdato, Person regissor) {
        this.tittel = tittel;
        this.spilletid = spilletid;
        this.beskrivelse = beskrivelse;
        this.utgivelsesdato = utgivelsesdato;
        this.regissor = regissor;
    }

    public Produksjon(String tittel, LocalDate utgivelsesdato){
        this.tittel = tittel;
        this.utgivelsesdato = utgivelsesdato;
    }

    public Produksjon(String tittel, double spilletid) {
        this.tittel = tittel;
        this.spilletid = spilletid;
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


    public void leggTilEnRolle(Rolle enRolle){
        this.roller.add(enRolle);
    }

    public void leggTilMangeRoller(ArrayList<Rolle> flereRoller){
        this.roller.addAll(flereRoller);
    }

    public void skrivUtRoller(){
        System.out.println("Skuespillere i produksjonen " + tittel + ":");
        for (Rolle rolle:this.roller
             ) {
            System.out.println(rolle.toString());
        }
    }

    @Override
    public String toString(){
        return "Produksjonen " + getTittel() + " er utgitt " + getUtgivelsesdato() + ", og er regissert av " + getRegissor()
                + ".\nBeskrivelse: " + getBeskrivelse() + "\nSpilletid: " + getSpilletid() + " minutter.";
    }
}

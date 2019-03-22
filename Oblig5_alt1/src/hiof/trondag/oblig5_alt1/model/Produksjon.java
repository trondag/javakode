package hiof.trondag.oblig5_alt1.model;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 * Representerer en produksjon av enten film eller episode.
 * Holder på tittel, beskrivelse, spilletid, utgivelsesdato, regissør og roller.
 */

public abstract class Produksjon {

    private String tittel;
    private String beskrivelse;
    private double spilletid;
    private LocalDate utgivelsesdato;
    private Person regissor;
    private ArrayList<Rolle> roller = new ArrayList<>();

    public Produksjon() {
    }

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

    public Produksjon(String tittel, String beskrivelse, double spilletid, LocalDate utgivelsesdato){
        this.tittel = tittel;
        this.beskrivelse = beskrivelse;
        this.spilletid = spilletid;
        this.utgivelsesdato = utgivelsesdato;
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

    /**
     * Tar imot en rolle som skal legges til i episoden/filmen
     *
     * @param enRolle Rollen som skal legges til
     */

    public void leggTilEnRolle(Rolle enRolle){
        this.roller.add(enRolle);
    }

    /**
     * Legger til en ArrayList med roller
     *
     * @param flereRoller Rollelisten som skal legges til
     */

    public void leggTilMangeRoller(ArrayList<Rolle> flereRoller){
        this.roller.addAll(flereRoller);
    }

    /**
     * Ordner en pen utskrift av en en film/episode
     * @return String med informasjon om filmen/episoden
     */

    @Override
    public String toString(){
        return "Produksjonen " + getTittel() + " er utgitt " + getUtgivelsesdato() + ", og er regissert av " + getRegissor()
                + ".\nBeskrivelse: " + getBeskrivelse() + "\nSpilletid: " + getSpilletid() + " minutter.";
    }

    /**
     * Returnerer en String med en pen utskrift av timer og minutter
     *
     * @return String timer og minutter pent formattert
     */

    //Returnerer timer og minutter som en pen string.
    public String getSpilletidTilMinOgSek(){
        int minutter = (int) this.spilletid % 60;
        int timer = (int) (this.spilletid - minutter) / 60;
        return timer + " timer og " + minutter + " minutter";
    }
}

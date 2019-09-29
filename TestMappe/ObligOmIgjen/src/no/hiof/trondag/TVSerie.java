package no.hiof.trondag;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;

public class TVSerie implements Comparable<TVSerie>{
    private String tittel, beskrivelse;
    private LocalDate utgivelsesdato;
    private ArrayList<Episode> episodeListe;
    private double gjennomsnittligSpilletid;
    private int antallSesonger;

    public TVSerie(String tittel, String beskrivelse, LocalDate utgivelsesdato) {
        this.tittel = tittel;
        this.beskrivelse = beskrivelse;
        this.utgivelsesdato = utgivelsesdato;
        this.episodeListe = new ArrayList<>();
        this.antallSesonger = 0;
    }

    public void leggTilEpisode(Episode episode){
        if (episode.getSesongNummer() > antallSesonger + 1) {
            System.out.println("Ikke tillatt å legge til episoder fra sesong to høyere");
            return;
        } else if (episode.getSesongNummer() > antallSesonger)
            antallSesonger++;
        episodeListe.add(episode);
        double snitt = 0;
        for (Episode enEpisode : episodeListe){
            snitt += enEpisode.getSpilletid();
        }
        gjennomsnittligSpilletid = snitt / episodeListe.size();
    }

    @Override
    public String toString(){
        return "Tittel: " + tittel + ": " + beskrivelse;
    }

    public ArrayList<Episode> hentEpisoderISesong(int sesong){
        ArrayList<Episode> episoder = new ArrayList<>();
        for (Episode enEpisode : this.episodeListe){
            if (enEpisode.getSesongNummer() == sesong)
                episoder.add(enEpisode);
        }
        return episoder;
    }

    @Override
    public int compareTo(TVSerie annenTVSerie){
        return annenTVSerie.tittel.compareTo(this.tittel);
    }

    public ArrayList<Rolle> hentRollebesetning(){
        ArrayList<Rolle> rolleliste = new ArrayList<>();
        for (Episode episode : episodeListe){
            for (Rolle rolle : episode.getRolleListe()){
                if (!rolleliste.contains(rolle)){
                    rolleliste.add(rolle);
                }
            }
        }
        return rolleliste;
    }

    public void SkrivUtSkuespillere(){
        HashMap<Person, Integer> personListe = new HashMap<>();
        for (Episode episode : episodeListe){
            for (Rolle rolle : episode.getRolleListe()){
                if(!personListe.containsKey(rolle.getSkuespiller())){
                    Integer antallSpilt = personListe.get(rolle.getSkuespiller());
                    personListe.replace(rolle.getSkuespiller(), ++antallSpilt);
                } else {
                    personListe.put(rolle.getSkuespiller(), 1);
                }
            }
        }
    }

    public double getGjennomsnittligSpilletid() {
        return gjennomsnittligSpilletid;
    }

    public int getAntallSesonger(){
        return antallSesonger;
    }

    public String getTittel() {
        return tittel;
    }

    public void setTittel(String tittel) {
        this.tittel = tittel;
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

    public ArrayList<Episode> getEpisodeListe() {
        return episodeListe;
    }

    public void setEpisodeListe(ArrayList<Episode> episodeListe) {
        this.episodeListe = episodeListe;
    }
}

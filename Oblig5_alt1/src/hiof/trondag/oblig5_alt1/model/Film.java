package hiof.trondag.oblig5_alt1.model;

import java.time.LocalDate;
import java.util.Comparator;

/**
 * Representerer en film, holder på tittel, beskrivelse, spilletid, utgivelsesdato, regissør.
 * Alle instansvariablene er arvet fra Produksjon
 */

public class Film extends Produksjon implements Comparable<Film>{


    private String bildePath;
    public static final Comparator<Film> PAA_TITTEL_STIGENDE = new SorterTittelStigende();
    public static final Comparator<Film> PAA_TITTEL_SYNKENDE = new SorterTittelSynkende();
    public static final Comparator<Film> PAA_DATO_STIGENDE = new SorterDatoStigende();
    public static final Comparator<Film> PAA_DATO_SYNKENDE = new SorterDatoSynkende();

    public Film(String tittel, String beskrivelse, double spilletid, LocalDate utgivelsesdato, Person regissor){
        super(tittel, beskrivelse, spilletid, utgivelsesdato, regissor);
    }

    public Film(String tittel, String beskrivelse, double spilletid, LocalDate utgivelsesdato, String bildePath){
        super(tittel, beskrivelse, spilletid, utgivelsesdato);
        this.bildePath = bildePath;
    }

    public Film(){}


    public String getBildePath() { return bildePath; }

    public void setBildePath(String bildePath) { this.bildePath = bildePath; }

    /**
     *  En metode som raskt setter alle instansvariablene i et filmobjekt
     * @param tittel tittelen (String)
     * @param beskrivelse beskrivelse av filmen (String)
     * @param spilletid spilletiden i minutter (Double)
     * @param utgivelsesDato utgivelsesdato (LocalDate)
     */

    public void settEgenskaper(String tittel, String beskrivelse, Double spilletid, LocalDate utgivelsesDato){
        //Stor forbokstav på tittel
        tittel = tittel.toLowerCase();
        tittel = tittel.substring(0,1).toUpperCase() + tittel.substring(1).toLowerCase();

        this.setTittel(tittel);
        this.setBeskrivelse(beskrivelse);
        this.setSpilletid(spilletid);
        this.setUtgivelsesdato(utgivelsesDato);
    }

    /**
     * Lager en pen utskrift med "film (utgivelsesår)
     * @return String med pen utskrift
     */

    @Override
    public String toString(){
        return getTittel() + " (" + getUtgivelsesdato().getYear() + ")";
    }

    /**
     * Sammenligner en film på tittelen
     *
     * @param enFilm Et filmobjekt som skal sammenlignes med this
     * @return Filmobjektet som skal først i lista
     */

    @Override
    public int compareTo(Film enFilm){
        return this.getTittel().compareTo(enFilm.getTittel());
    }

    /**
     * Sorterer på tittel stigende
     */

    private static class SorterTittelStigende implements Comparator<Film> {
        public int compare(Film f1, Film f2) {
            return f1.compareTo(f2);
        }
    }

    /**
     * Sorterer på tittel synkende
     */

    private static class SorterTittelSynkende implements Comparator<Film> {
        public int compare(Film f1, Film f2){
            return f2.compareTo(f1);
        }
    }

    /**
     * Sorterer på dato stigende
     */

    private static class SorterDatoStigende implements Comparator<Film> {
        public int compare(Film f1, Film f2){
            return f2.getUtgivelsesdato().compareTo(f1.getUtgivelsesdato());
        }
    }

    /**
     * Sorterer på dato synkende
     */

    private static class SorterDatoSynkende implements Comparator<Film> {
        public int compare(Film f1, Film f2) {
            return f1.getUtgivelsesdato().compareTo(f2.getUtgivelsesdato());
        }
    }
}

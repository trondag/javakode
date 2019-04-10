package hiof.trondag;

import java.time.LocalDate;

public class Film {
    private String tittel;
    private String beskrivelse;
    private Double spilletid;
    private LocalDate utgivelsesDato;
    private String bildePath;
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public Double getSpilletid() {
        return spilletid;
    }

    public void setSpilletid(Double spilletid) {
        this.spilletid = spilletid;
    }

    public LocalDate getUtgivelsesDato() {
        return utgivelsesDato;
    }

    public void setUtgivelsesDato(LocalDate utgivelsesDato) {
        this.utgivelsesDato = utgivelsesDato;
    }

    public String getBildePath() {
        return bildePath;
    }

    public void setBildePath(String bildePath) {
        this.bildePath = bildePath;
    }

    public Film(String tittel, String beskrivelse, Double spilletid, LocalDate utgivelsesDato, String bildePath) {
        this.tittel = tittel;
        this.beskrivelse = beskrivelse;
        this.spilletid = spilletid;
        this.utgivelsesDato = utgivelsesDato;
        this.bildePath = bildePath;
    }

    @Override
    public String toString(){
        return tittel + " (" + utgivelsesDato.getYear() + ")";
    }
}

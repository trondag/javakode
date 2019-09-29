package no.hiof.trondag;

public class Episode extends Produksjon implements Comparable<Episode>{
    private int episodeNummer, sesongNummer;

    public Episode(int episodeNummer, int sesongNummer, String tittel, double spilletid) {
        super(tittel, spilletid);
        this.episodeNummer = episodeNummer;
        this.sesongNummer = sesongNummer;
    }

    public Episode(int episodeNummer, int sesongNummer, String tittel) {
        super(tittel);
        this.episodeNummer = episodeNummer;
        this.sesongNummer = sesongNummer;
    }

    @Override
    public String toString(){
        return "tittel: " + super.getTittel() + " spilletid: " + super.getSpilletid() + " minutter";
    }

    @Override
    public int compareTo(Episode annenEpisode){
        if (((Integer) this.sesongNummer).equals(annenEpisode.sesongNummer)){
            return Integer.compare(this.episodeNummer, annenEpisode.episodeNummer);
        } else {
            return Integer.compare(this.sesongNummer, annenEpisode.sesongNummer);
        }
    }

    public int getEpisodeNummer() {
        return episodeNummer;
    }

    public void setEpisodeNummer(int episodeNummer) {
        this.episodeNummer = episodeNummer;
    }

    public int getSesongNummer() {
        return sesongNummer;
    }

    public void setSesongNummer(int sesongNummer) {
        this.sesongNummer = sesongNummer;
    }
}

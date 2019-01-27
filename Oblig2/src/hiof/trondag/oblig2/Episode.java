package hiof.trondag.oblig2;

public class Episode{
        //Instansvariabler
    private String episodeTittel;
    private int episodeNummer;
    private int sesongNummer;

        //--------------------------//
        //Konstruktør uten spilletid//
        //--------------------------//
    public Episode(String episodeTittel, int episodeNummer, int sesongNummer){
        this.episodeTittel = episodeTittel;
        this.episodeNummer = episodeNummer;
        this.sesongNummer = sesongNummer;
    }

    private Double spilletid;
        //-------------------------//
        //Konstruktør med spilletid//
        //-------------------------//
    public Episode(String episodeTittel, int episodeNummer, int sesongNummer, Double spilletid) {
        this.episodeTittel = episodeTittel;
        this.episodeNummer = episodeNummer;
        this.sesongNummer = sesongNummer;
        this.spilletid = spilletid;
    }
        //----------------------//
        //-----GETTERS----------//
        //----------------------//

    public String getEpisodeTittel() {
        return episodeTittel;
    }

    public int getEpisodeNummer() {
        return episodeNummer;
    }

    public int getSesongNummer() {
        return sesongNummer;
    }

    public Double getSpilletid() {
        return spilletid;
    }

    //-------------------------------//
    // OVERRIDE TOSTRING() oppgave 5 //
    //-------------------------------//

    @Override
    public String toString(){
        return "Tittel: " + episodeTittel + "\nNummer: E:" + episodeNummer + " S:" + sesongNummer + "\nSpilletid: " + spilletid;
    }

    public void setSpilletid(Double spilletid) {
        this.spilletid = spilletid;
    }
}

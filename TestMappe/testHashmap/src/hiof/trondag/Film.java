package hiof.trondag;

public class Film {
    private String tittel;
    private int utgivelsesår;

    public Film(String tittel, int utgivelsesår) {
        this.tittel = tittel;
        this.utgivelsesår = utgivelsesår;
    }

    public String getTittel() {
        return tittel;
    }

    public void setTittel(String tittel) {
        this.tittel = tittel;
    }

    public int getUtgivelsesår() {
        return utgivelsesår;
    }

    public void setUtgivelsesår(int utgivelsesår) {
        this.utgivelsesår = utgivelsesår;
    }
}

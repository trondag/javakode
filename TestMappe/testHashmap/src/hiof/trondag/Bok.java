package hiof.trondag;

public class Bok {
    private String tittel;
    private int utgivelsesAar;
    private int sideTall;

    Bok(String tittel, int utgivelsesAar, int sideTall){
        this.tittel = tittel;
        this.utgivelsesAar = utgivelsesAar;
        this.sideTall = sideTall;
    }

    public String getTittel(){
        return tittel;
    }

    public int getUtgivelsesAar(){
        return utgivelsesAar;
    }

    public int getSideTall(){
        return sideTall;
    }

    public void setTittel(String tittel){
        this.tittel = tittel;
    }

    public void setUtgivelsesAar(int utgivelsesAar){
        this.utgivelsesAar = utgivelsesAar;
    }

    public void setSideTall(int sideTall){
        this.sideTall = sideTall;
    }

    @Override
    public String toString(){
        return this.tittel;
    }
}

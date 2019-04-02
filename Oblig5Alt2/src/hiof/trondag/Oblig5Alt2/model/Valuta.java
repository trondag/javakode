package hiof.trondag.Oblig5Alt2.model;


public class Valuta {
    private String countryname;
    private String countrycode;
    private String currencycode;
    private double value;

    public Valuta(String land, String landKode, String valutaKode, double valutaKurs) {
        this.countryname = land;
        this.countrycode = landKode;
        this.currencycode = valutaKode;
        this.value = valutaKurs;
    }

    public String getCountryname() {
        return countryname;
    }

    public void setCountryname(String countryname) {
        this.countryname = countryname;
    }

    public String getCountrycode() {
        return countrycode;
    }

    public void setCountrycode(String countrycode) {
        this.countrycode = countrycode;
    }

    public String getCurrencycode() {
        return currencycode;
    }

    public void setCurrencycode(String currencycode) {
        this.currencycode = currencycode;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    @Override
    public String toString(){
        return this.countrycode + " (" + this.countryname + ")";
    }
}

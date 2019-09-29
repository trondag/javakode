package no.hiof.trondg.huskvasken.model;

import com.google.gson.annotations.SerializedName;

public abstract class Rutine {

    @SerializedName("navn")
    private String navn;

    public Rutine(String navn) {
        this.navn = navn;
    }

    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }
}

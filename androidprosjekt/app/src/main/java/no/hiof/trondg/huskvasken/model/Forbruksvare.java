package no.hiof.trondg.huskvasken.model;

import com.google.gson.annotations.SerializedName;

import java.time.LocalDate;

public class Forbruksvare extends Rutine {

    @SerializedName("bytteFrekvens")
    private int bytteFrekvens; //Hvor mange dager mellom hvert bytte

    private LocalDate sistByttet;

    public Forbruksvare(String navn, int bytteFrekvens) {
        super(navn);
        this.bytteFrekvens = bytteFrekvens;
    }

    public int getBytteFrekvens() {
        return bytteFrekvens;
    }

    public void setBytteFrekvens(int bytteFrekvens) {
        this.bytteFrekvens = bytteFrekvens;
    }

    public LocalDate getSistByttet() {
        return sistByttet;
    }

    public void setSistByttet(LocalDate sistByttet) {
        this.sistByttet = sistByttet;
    }

    public String toString(){
        return this.getNavn();
    }
}

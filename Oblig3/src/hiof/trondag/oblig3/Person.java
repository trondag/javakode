package hiof.trondag.oblig3;

import java.time.LocalDate;

public class Person {
    private String fornavn;
    private String etternavn;
    private LocalDate fodselsDag;
    private String hjemland;

    public Person(String fornavn, String etternavn, LocalDate fodselsDag, String hjemland) {
        this.fornavn = fornavn;
        this.etternavn = etternavn;
        this.fodselsDag = fodselsDag;
        this.hjemland = hjemland;
    }

    public String getFornavn() {
        return fornavn;
    }

    public String getEtternavn() {
        return etternavn;
    }

    public LocalDate getFodselsDag() {
        return fodselsDag;
    }

    public String getHjemland() {
        return hjemland;
    }

    public String getFulltNavn() {
        return fornavn + " " + etternavn;
    }

    @Override
    public String toString(){
        return "Personen " + getFulltNavn() + " er født den " + getFodselsDag() + " og kommer fra " + getHjemland();
    }
}

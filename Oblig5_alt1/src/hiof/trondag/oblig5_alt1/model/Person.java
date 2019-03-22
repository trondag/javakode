package hiof.trondag.oblig5_alt1.model;

import java.time.LocalDate;

/**
 * Representerer en person, holder på fornavn, etternavn, fødselsdag og hjemland
 */

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

    /**
     * Returnerer personens fulle navn
     *
     * @return String med personens fulle navn
     */

    public String getFulltNavn() {
        return fornavn + " " + etternavn;
    }

    /**
     * Gir en pen utskrift av en person, hvor han/hun er født, og fødselsdag
     * @return String med informasjon om person
     */

    @Override
    public String toString(){
        return "Personen " + getFulltNavn() + " er født den " + getFodselsDag() + " og kommer fra " + getHjemland();
    }
}

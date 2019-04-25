package no.hiof.trondag;

public class Bruker {
    private String brukerNavn, fornavn, etternavn;

    public Bruker(String brukerNavn, String fornavn, String etternavn){
        this.brukerNavn = brukerNavn;
        this.fornavn = fornavn;
        this.etternavn = etternavn;
    }

    public String getBrukerNavn() {
        return brukerNavn;
    }

    public String getFornavn() {
        return fornavn;
    }

    public String getEtternavn() {
        return etternavn;
    }

    private void slettFil(Fil fil){
        if (this.brukerNavn.equals(fil.getEier().getBrukerNavn())){
            fil = null;
        }
    }
}

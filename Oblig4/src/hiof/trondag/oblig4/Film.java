package hiof.trondag.oblig4;

import java.time.LocalDate;

public class Film extends Produksjon {


    public Film(String tittel, String beskrivelse, double spilletid, LocalDate utgivelsesdato, Person regissor){
        super(tittel, beskrivelse, spilletid, utgivelsesdato, regissor);
    }

    @Override
    public String toString(){
        return "Filmen " + getTittel() + " er utgitt " + getUtgivelsesdato() + ", og er regissert av " + getRegissor()
                + ".\nBeskrivelse: " + getBeskrivelse() + "\nSpilletid: " + getSpilletid() + " minutter.";
    }
}

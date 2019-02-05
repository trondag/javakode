package hiof.trondag.oblig3;

import java.time.LocalDate;

public class Film extends Produksjon {


    public Film(String tittel, String beskrivelse, double spilletid, LocalDate utgivelsesdato, Person regissor){
        super(tittel, beskrivelse, spilletid, utgivelsesdato, regissor);
    }
}

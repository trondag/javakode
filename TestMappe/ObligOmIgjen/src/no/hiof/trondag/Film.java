package no.hiof.trondag;

import java.time.LocalDate;

public class Film extends Produksjon {

    Film(String tittel, String beskrivelse, double spilletid, LocalDate utgivelsesdato){
        super(tittel, beskrivelse, spilletid, utgivelsesdato);
    }

    @Override
    public String toString(){
        return "Filmen " + this.getTittel() + " ble gitt ut i år " + super.getUtgivelsesdato().getYear();
    }
}

package no.hiof.trondag;

public class Bilde extends Fil {
    private int opplosningX, oppplosningY;

    public Bilde(long storrelse, String filSti, Bruker eier, int opplosningX, int oppplosningY) {
        super(storrelse, filSti, eier);
        this.opplosningX = opplosningX;
        this.oppplosningY = oppplosningY;
    }
}

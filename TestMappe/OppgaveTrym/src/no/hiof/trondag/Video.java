package no.hiof.trondag;

public class Video extends Fil implements Streamable {
    private double spilletid;
    private int opplosningX, opplosningY;

    public Video(long storrelse, String filSti, Bruker eier, double spilletid, int opplosningX, int opplosningY) {
        super(storrelse, filSti, eier);
        this.spilletid = spilletid;
        this.opplosningX = opplosningX;
        this.opplosningY = opplosningY;
    }

    @Override
    public void lastDelerAvFil() {

    }
}

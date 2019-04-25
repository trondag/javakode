package no.hiof.trondag;

public class Lyd extends Fil implements Streamable {
    private double spilletid;

    public Lyd(long storrelse, String filSti, Bruker eier, double spilletid) {
        super(storrelse, filSti, eier);
        this.spilletid = spilletid;
    }

    @Override
    public void lastDelerAvFil() {

    }
}

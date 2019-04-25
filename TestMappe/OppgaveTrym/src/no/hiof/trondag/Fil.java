package no.hiof.trondag;

public abstract class Fil {
    private long storrelse;
    private String filSti;
    private Bruker eier;

    public long getStorrelse() {
        return storrelse;
    }

    public String getFilSti() {
        return filSti;
    }

    public Bruker getEier() {
        return eier;
    }

    public Fil(long storrelse, String filSti, Bruker eier){
        this.storrelse = storrelse;
        this.filSti = filSti;
        this.eier = eier;
    }
}

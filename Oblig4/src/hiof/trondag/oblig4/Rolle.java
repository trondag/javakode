package hiof.trondag.oblig4;

public class Rolle {
    private String rolleFornavn;
    private String rolleEtternavn;
    private Person skuespiller;

    public Rolle(String rolleFornavn, String rolleEtternavn, Person skuespiller) {
        this.rolleFornavn = rolleFornavn;
        this.rolleEtternavn = rolleEtternavn;
        this.skuespiller = skuespiller;
    }

    public String getRolleFornavn() {
        return rolleFornavn;
    }

    public String getRolleEtternavn() {
        return rolleEtternavn;
    }

    public Person getSkuespiller() {
        return skuespiller;
    }

    @Override
    public String toString(){
        return "Rollen " + this.getRolleFornavn() + this.getRolleEtternavn() + " er spilt av " + this.getSkuespiller().getFulltNavn();
    }
}

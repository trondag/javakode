package hiof.trondag.oblig5_alt1.model;

/**
 * Holder på en Rolle, holder på fornavn og etternavn til rollen, og dens skuespiller
 */

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

    /**
     * Gir en pen utskrift av en rolle
     *
     * @return String med informasjon om rollen
     */

    @Override
    public String toString(){
        return "Rollen " + this.getRolleFornavn() + this.getRolleEtternavn() + " er spilt av " + this.getSkuespiller().getFulltNavn();
    }
}

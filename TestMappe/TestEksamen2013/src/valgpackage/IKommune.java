package valgpackage;
/**
 * Valgresultater for en kommune i kommunevalg
 * @author Administrator
 */
public interface IKommune {
    /**
     * Selvforklarende get-metoder
     */
    public String getNavn();
    public String getFylkesNavn();
    public int getAntallStemmeberettigede();
    public int getSumRepresentanter();

    /**
     * Hvor stor del i prosent er det som har stemt ved valget
     */
    public double getValgdeltagelse();

    /**
     * Antall stemmer et navngitt parti har fått
     * @param parti Navnet på partiet
     * @return Antall stemmer
     */
    public int getAntalStemmer(String parti);

    /**
     * antall representanter et navngitt parti har fått i kommunestyret
     * @param parti Navnet på partiet
     * @return Antall representanter
     */
    public int getAntallRepresentanter(String parti);

    /**
     * Navn på alle partier som har stilt til valg i kommunen
     * @return partinavnene
     */
    public String[] getAllePartiNavn();
}

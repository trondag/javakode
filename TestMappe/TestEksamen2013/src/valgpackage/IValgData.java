package valgpackage;
/**
 * Valgdata for alle kommuner i et kommunevalg
 * @author Administrator
 */
public interface IValgData {

    /**
     * Alle stemmer til et bestemt parti i en bestemt kommune
     * @param kommunenavn Navnet på kommunen
     * @param parti Partinavnet
     * @return antall stemmer
     */
    public long getAntallStemmer(String kommunenavn,String parti);

    /**
     * Alle stemmer til et bestemt parti i et fylke
     * (Dette har ikke noe med fylkestingvalg å gjøre, kun en
     * telling for statistiske formål)
     * @param fylkesnavn Navnet på fylket
     * @param parti Partinavnet
     * @return antall stemmer
     */
    public long getAntallStemmerIFylke(String fylkesnavn,String parti);

    /**
     * Partier som stilte til valg i en kommune
     * @param kommunenavn Navnet på kommunen
     * @return En array av alle partinavnene, sortert alfabetisk
     */
    public String[] getPartiNavn(String kommunenavn);

    /**
     * Alle partinavn i Norge
     * @return En unik liste med alle partinavn som er registrert
     * totalt, sortert alfabetisk
     */
    public String[] getAllePartiNavnINorge();

    /**
     * Kontroller alle kommuner og sjekk at antall representanter
     * i kommunestyret stemmer med summen av de representantene
     * hvert part har fått
     * @return En Liste av de kommunenavnene der det er avvik,
     * feil i dataene
     */
    public String[] sjekkRepresentanter();
}

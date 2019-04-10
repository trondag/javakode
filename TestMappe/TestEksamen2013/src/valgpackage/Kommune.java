package valgpackage;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Set;

import static java.lang.Integer.parseInt;

/**
 * Noen faste data for en kommune samt valgresultater
 * ved et kommunevalg
 * @author Administrator
 */
public class Kommune implements IKommune{
    // kommune navn
    private String Navn;
    // fylkes navn
    private String Fylkesnavn;
    // antall stemmeberettigede
    private int Stemmeberettigede;
    // antall representanter i kommunestyret
    private int SumRepresentanter;

    // alle resultater , for hvert parti
    HashMap<String,PartiResultat> resultater;

    /**
     * Constructor
     * @param filecontent Innholdet, teksten, på en kommunefil
     * @throws Exception hvis galt data format
     */
    public Kommune(String filecontent)
            throws Exception{
        String[] lines=filecontent.split("\n");

        // line 0, tabseparert:
        // navn fylkesnavn stemmerettigede
        // representanter_i_kommunestyret
        String deler[]=lines[0].trim().split("\t");
        Navn=deler[0];
        Fylkesnavn=deler[1];
        Stemmeberettigede= parseInt(deler[2]);
        SumRepresentanter= parseInt(deler[3]);

        // alle andre linjer, tabseparert:
        // partinavn stemmer representanter
        resultater=new HashMap();
        for(int ix=1;ix<lines.length;ix++){
            PartiResultat pr=new PartiResultat(lines[ix]);
            resultater.put(pr.PartiNavn, pr);
        }
    }

    @Override
    public String getNavn() {
        return Navn;
    }
    @Override
    public String getFylkesNavn() {
        return Fylkesnavn;
    }
    @Override
    public int getAntallStemmeberettigede() {
        return Stemmeberettigede;
    }
    @Override
    public int getSumRepresentanter() {
        return SumRepresentanter;
    }

    @Override
    public int getAntalStemmer(String parti) {
        return resultater.get(parti).Stemmer;
    }

    @Override
    public double getValgdeltagelse() {
        double stemmeBerettigede = this.Stemmeberettigede;
        double stemmer = 0;

        String partinavn[] = this.getAllePartiNavn();
        for (String navn : partinavn) {
            stemmer += getAntalStemmer(navn);
        }
        return stemmeBerettigede/100*stemmer;
    }


    @Override
    public int getAntallRepresentanter(String parti){
        return resultater.get(parti).getRepresentanter();
    }

    @Override
    public String[] getAllePartiNavn() {
        Set<String> S=resultater.keySet();
        String[] ret=S.toArray(new String[0]);
        Arrays.sort(ret);
        return ret;
    }

    //---------------------------------
    // inner class Resultat for et parti i en kommune
    private class PartiResultat {
        private String PartiNavn;
        private int Stemmer;
        private int Representanter;

        /**
         * constructor
         * @param TextLinje En linje med tabseparerte verdier:
         * partinavn, stemmer, representanter
         * @exception Hvis feil i dataformat
         */

        public PartiResultat(String TextLinje) {
            String[] linje = TextLinje.split("\t");

            this.PartiNavn = linje[0];
            this.Stemmer = parseInt(linje[1]);
            this.Representanter = parseInt(linje[2]);
        }


        public String getPartiNavn() {
            return this.PartiNavn;
        }
        public long getStemmer() {
            return Stemmer;
        }
        public int getRepresentanter() {
            return Representanter;
        }
    }
}

package valgpackage;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
/**
 * Implementasjon av IValgdata
 * Valgdata for alle kommuner i et kommunevalg slik de
 * er registrerte på tekstfiler
 * @author Administrator
 */
public class ValgData implements IValgData{
    // alle registrerte kommuner
    List<IKommune>Kommuner;
    // alle registrerte partinavn, totalt i alle registrerte kommuner
    HashSet<String>PartiNavn;


    /**
     * Constructor
     * @param Katalog Den katalogen der alle kommunefilene ligger
     */
    public ValgData(File Katalog)
            throws Exception{
        Kommuner=new ArrayList(450);
        PartiNavn=new HashSet();
        // finn alle filer i katalogen
        File[] all=Katalog.listFiles();
        // lag et kommuneobject av hver
        for(File f : all){
            String T=readFile(f);
            if(T!=null){
                try{
                    Kommune K=new Kommune(T);
                    Kommuner.add(K);
                    String[] pnavn=K.getAllePartiNavn();
                    PartiNavn.addAll(Arrays.asList(pnavn));
                }
                catch(Exception e){
                    System.out.println("Bad file content: "+
                            f.getName());
                }
            }
        }
    }
    @Override
    public long getAntallStemmer(String kommuneNavn, String parti){
        for (IKommune kommune : Kommuner) {
            if (kommune.getNavn() == kommuneNavn) {
                long antallStemmer = kommune.getAntalStemmer(parti);
                return antallStemmer;
            }
        }
    }


    @Override
    public long getAntallStemmerIFylke(String fylkesnavn, String parti) {
        long antallStemmer = 0;

        for (IKommune kommune : Kommuner) {
            if (kommune.getFylkesNavn() == fylkesnavn)
                antallStemmer += kommune.getAntalStemmer(parti);
        }
        return antallStemmer;
    }

    @Override
    public String[] getPartiNavn(String kommuneNavn) {
        for (IKommune kommune : Kommuner) {
            if (kommune.getNavn().equals(kommuneNavn)) {
                // Listen jeg henter er allerede sortert
                return kommune.getAllePartiNavn();
            }
        }
    }

    @Override
    public String[] getAllePartiNavnINorge() {
        String[]ret=PartiNavn.toArray(new String[0]);
        Arrays.sort(ret);
        return ret;
    }
    @Override
    public String[] sjekkRepresentanter(){
        String[] kommunerMedFeilAntall = new String[450];
        for (IKommune kommune : Kommuner) {
            int sumRepresentanter = kommune.getSumRepresentanter();
            int sumRepresentanterIHvertParti = 0;
            String[] kommuneNavn= kommune.getAllePartiNavn();
            for (var i = 0 ; i < kommuneNavn.length ; i++) {
                sumRepresentanterIHvertParti += kommune.getAntallRepresentanter(kommuneNavn[i]);
            }
            int index = 0;
            if (sumRepresentanter != sumRepresentanterIHvertParti) {
                kommunerMedFeilAntall[0] = kommune.getNavn();
                index++;
            }
        }
        return kommunerMedFeilAntall;
    }


    /**
     * Utility for å laste inn innholdet fra en text-fil
     */
    private static String readFile(File f)
    {
        String content;
        try {
            FileReader reader = new FileReader(f);
            char[] chars = new char[(int) f.length()];
            reader.read(chars);
            content = new String(chars);
        } catch (IOException e) {
            System.out.println(e.getMessage());
            return null;
        }
        return content;
    }

}

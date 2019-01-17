
//En person
public class Person{

    //Instansvariabler
    public String fornavn;
    public String etternavn;
    public int alder;

    //Konstruktør-metode. Lager en person-objekt utifra parameterne.
    public Person(String fornavn, String etternavn, int alder){
        this.fornavn = fornavn;
        this.etternavn = etternavn;
        this.alder = alder;
    }

    //Get metoder
    public String getFornavn(){
        return fornavn;
    }

    public String getEtternavn(){
        return etternavn;
    }

    public int getAlder(){
        return alder;
    }

    //Set metoder
    public void setFornavn(String fornavn){
        this.fornavn = fornavn;
    }

    public void setEtternavn(String etternavn){
        this.etternavn = etternavn;
    }

    public void setAlder(int alder){
        this.alder = alder;
    }

    //Metode for å printe til terminalen
    public void printPersonInfo(){
        System.out.println("*********\nNavn: " + fornavn + " " + etternavn + "\nAlder: " + alder + "\n************");
    }
}
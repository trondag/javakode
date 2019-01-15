
//En person
public class Person{

    //Instansvariabler
    public String fornavn;
    public String etternavn;
    public int alder;

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
    public void setFornavn(){
        this.fornavn = fornavn;
    }

    public void setEtternavn(){
        this.etternavn = etternavn;
    }

    public void setAlder(){
        this.alder = alder;
    }

    //Metode for å printe til terminalen
    public void printPersonInfo(){
        System.out.println("Navn: " + fornavn + " " + etternavn + "\nAlder: " + alder);
    }
}
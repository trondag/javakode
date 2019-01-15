public class Main {

    public static void main(String[] args){
        //Lager et par person-objekter
        Person nikolaTesla = new Person("Nikola", "Tesla", 86);
        Person trond = new Person("Trond", "Graabræk", 24);
        //Printer informasjon
        nikolaTesla.printPersonInfo();
        trond.printPersonInfo();

        String etternavn = trond.getEtternavn();
        System.out.println(etternavn);

        //etternavn = "Johnsen";
        trond.setEtternavn("Johnsen");
        trond.printPersonInfo();


    }
}
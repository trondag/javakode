public class Main {

    public static void main(String[] args){

        //Lager et par person-objekter
        Person nikolaTesla = new Person("Nikola", "Tesla", 86);
        Person trond = new Person("Trond", "Graabræk", 24);
        Person jan = new Person("Jan Thomas", "Trinborg", 22);

        //Printer informasjon
        nikolaTesla.printPersonInfo();
        trond.printPersonInfo();

        String etternavn = trond.getEtternavn();
        System.out.println(etternavn);

        trond.setEtternavn("Johnsen");
        trond.printPersonInfo();

        //hente ut alder
        int alder = jan.getAlder();
        System.out.println("Alder på Jan: " + alder);

        //Setter ny alder på Jan
        jan.setAlder(13);
        System.out.println("Ny alder på Jan:");
        jan.printPersonInfo();

        //Setter nytt fornavn på Jan
        jan.setFornavn("Hans");
        System.out.println("Nytt fornavn:");
        jan.printPersonInfo();

    }
}
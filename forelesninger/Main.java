

public class Main {

    public static void main(String[] arg){
        Student nikolaTesla = new Student();

        nikolaTesla.fornavn = "Nikola";
        nikolaTesla.etternavn = "Tesla";
        nikolaTesla.alder = 86;
        nikolaTesla.studentId = "83742345";

        System.out.println(nikolaTesla.fornavn + " " + nikolaTesla.etternavn);
    }
}
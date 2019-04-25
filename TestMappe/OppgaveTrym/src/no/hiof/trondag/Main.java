package no.hiof.trondag;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String linje = "123 456";
        String reversertLinje = "";
        for (int i = linje.length() - 1 ; i >= 0 ; i--){
            reversertLinje += linje.charAt(i);
        }
        int tall1 = Integer.parseInt(reversertLinje.substring(0,3));
        int tall2 = Integer.parseInt(reversertLinje.substring(4,7));

        if (tall1 > tall2){
            System.out.println(tall1);
        } else {
            System.out.println(tall2);
        }
    }
}
import java.util.Scanner;

public class Passord {

  public static void main(String[] args){

    Scanner scanner = new Scanner(System.in);

    System.out.println("Skriv inn selskap(små bokstaver)");

    String firma = scanner.nextLine();
    int lengde = firma.length();

    String tallkode = "";




    for (var i = 0 ; i < lengde ; i++){
      int unicode = firma.charAt(i);
      unicode += 4;
      tallkode += unicode;
    }

    System.out.println(tallkode);
  }
}
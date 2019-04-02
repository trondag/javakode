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
      
      if (i % 2 = 0){
        unicode -= 3;
      } else {
        unicode += 4;
      }
      tallkode += unicode;
    }

    System.out.println(tallkode);

    String passord = "";

    for (var j = 0 ; 0 <= 10 ; j++){
      for (var k = 0 ; 0 <= 2 ; k++){
        
      }
    }
  }
}
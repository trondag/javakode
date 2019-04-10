package hiof.trondag.testeks2013;

public class Programbiter {
    static void doIt(String T){
        int index=T.indexOf(" ");
        if(index >= 0){
            doIt(T.substring(index+1));
            System.out.println(T.substring(0, index));
        }        else {            System.out.println(T);
        }
    }
    public static void main(String[] args) {
        doIt("god jul og godt nytt år");
    }
}
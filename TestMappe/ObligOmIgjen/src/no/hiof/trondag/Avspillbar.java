package no.hiof.trondag;

public interface Avspillbar {
    public String MIN_I_EN = "heisann";
    
    public default void gjorNoe(){
        System.out.println("gjør et eller annet");
    }
}

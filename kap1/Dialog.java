import static javax.swing.JOptionPane.*;

public class Dialog {
    public static void main(String[] args) {
        String navn = showInputDialog("Navn: ");
        showMessageDialog(null, "Hei " + navn);
    }
}
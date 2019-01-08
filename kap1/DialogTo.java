import static javax.swing.JOptionPane.*;

public class DialogTo {
    public static void main(String[] args) {
        String fornavn = showInputDialog("Fornavn: ");
        String etternavn = showInputDialog("Etternavn: ");
        showMessageDialog(null, "Hei " + fornavn + " " + etternavn + "!");
    }
}
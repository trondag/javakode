public class Grafikk2 extends EasyGraphics {
    public static void main(String[] args){
        launch(args);
    }

    public void run() {
        makeWindow("Grafikk", 350, 250);
        drawCircle(150, 70, 40);
        drawCircle(150, 150, 40);
    }
}
public class Grafikk extends EasyGraphics {
    public static void main(String[] args){
        launch(args);
    }

    public void run() {
        makeWindow("Grafikk", 350, 150);
        drawCircle(150, 70, 60);
    }
}
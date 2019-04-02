import robocode.Robot;

public class Fred extends Robot {

    @Override
    public void run() {
        while (true) {
            ahead(100);
            turnGunLeft(90);
            turnRight(90);
            fire(1);
            fireBullet(1);
        }
    }
}

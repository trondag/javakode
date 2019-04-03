import robocode.Robot;
import robocode.RobotStatus;
import robocode.ScannedRobotEvent;
import robocode.HitRobotEvent;

public class Fred extends Robot {

    @Override
    public void run() {
        while (true) {
            ahead(100);
            turnGunRight(360);
            turnGunRight(360);

        }
    }
    public void onScannedRobot(ScannedRobotEvent e) {
        fire(1);
        if (e.getDistance() <= 150) {
            if (getX() < 100 || getX() > 700){
                turnRight(90);
                ahead(50);
                out.println("Svinger 90 grader til høyre og rygger 50");
            } else if (getY() < 100 || getY() > 500){
                turnRight(90);
                ahead(50);
                out.println("Svinger 90 grader til høyre og rygger 50");
            }
        }
    }

    @Override
    public void onHitRobot(HitRobotEvent e) {
        if (e.getBearingRadians() > -90 && e.getBearingRadians() <= 90) {
            back(100);
            out.println("Truffet foran, rygger..");
            out.println("Y: " + getY());
            out.println("X: " + getX());
        } else {
            ahead(100);
            out.println("Truffet bak, kjører..");
        }
    }
}

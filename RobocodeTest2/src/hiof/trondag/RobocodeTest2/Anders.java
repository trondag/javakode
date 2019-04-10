package hiof.trondag.RobocodeTest2;

import robocode.Robot;
import robocode.RobotStatus;
import robocode.ScannedRobotEvent;
import robocode.HitRobotEvent;

public class Anders extends Robot {

    boolean skalSkyte = true;
    int antallKjoringerForSkyting = 0;

    @Override
    public void run() {
        while (true) {
            if (getX() < 100 || getX() > 700){
                turnRight(Math.random()*90);
                ahead(50);
                out.println("Svinger 90 grader til høyre og rygger 50");
            } else if (getY() < 100 || getY() > 500){
                turnRight(Math.random()*90);
                ahead(50);
                out.println("Svinger 90 grader til høyre og rygger 50");
            } else {
                ahead(80);
                turnLeft(Math.random()*40-20);
                /*if (!skalSkyte){
                    antallKjoringerForSkyting++;
                    if (antallKjoringerForSkyting > 8){
                        skalSkyte = true;
                        antallKjoringerForSkyting = 0;
                        turnRadarRight(360);
                    }
                }
                out.println(antallKjoringerForSkyting);*/

            }

        }
    }
    public void onScannedRobot(ScannedRobotEvent e) {
        //if (skalSkyte) {
          //  turnGunRight(getHeading() - getGunHeading() + e.getBearing());
            fire(1);
            skalSkyte = false;
        //}
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

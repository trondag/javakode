package hiof.trondag.robocodeTest1;

import robocode.*;

public class Johan extends Robot{

    @Override
    public void run(){
        setAdjustRadarForRobotTurn(true);
        while(true){
            turnRadarRight(360);
            if (getX() < 100 || getX() > 700){
                turnRight(Math.random()*90);
                ahead(50);
                out.println("Svinger 90 grader til høyre og rygger 50");
            } else if (getY() < 100 || getY() > 500){
                turnRight(Math.random()*90);
                ahead(50);
                out.println("Svinger 90 grader til høyre og rygger 50");
            } else {
                ahead(100);
            }
        }
    }

    @Override
    public void onScannedRobot(ScannedRobotEvent event){
        turnRight(event.getBearing());
        ahead(200);
    }

    @Override
    public void onHitRobot(HitRobotEvent e) {
        if (e.getBearingRadians() > -60 && e.getBearingRadians() <= 60) {
            fire(20);
            ahead(1);
        } else {
            ahead(100);
            out.println("Truffet bak, kjører..");
        }
    }

}

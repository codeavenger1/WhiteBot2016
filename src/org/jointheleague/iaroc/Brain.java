package org.jointheleague.iaroc;

import android.os.SystemClock;

import ioio.lib.api.IOIO;
import ioio.lib.api.exception.ConnectionLostException;
import org.wintrisstech.irobot.ioio.IRobotCreateAdapter;
import org.wintrisstech.irobot.ioio.IRobotCreateInterface;
import org.jointheleague.iaroc.sensors.UltraSonicSensors;

public class Brain extends IRobotCreateAdapter {
    private final Dashboard dashboard;
    public UltraSonicSensors sonar;
    int distance=0;

    public Brain(IOIO ioio, IRobotCreateInterface create, Dashboard dashboard)
            throws ConnectionLostException {
        super(create);
        sonar = new UltraSonicSensors(ioio);
        this.dashboard = dashboard;
    }

    /* This method is executed when the robot first starts up. */
    public void initialize() throws ConnectionLostException {
        dashboard.log("Hello! I'm a Clever Robot!");
        //what would you like me to do, Clever Human?
//        for (int i = 0; i<5; i++) {
//            driveDirect(300, 300);
//            SystemClock.sleep(2000);
//            driveDirect(1, 90);
//           SystemClock.sleep(4500);
//
//        }

        readSensors(0);

    }
    /* This method is called repeatedly. */
    public void loop() throws ConnectionLostException {

        if (distance >= 1000)
        {
            driveDirect(0,0);
        }

        else{
            driveDirect(50,50);
        }
        readSensors(0);
        distance+=getDistance();
        dashboard.log("" + distance);

    }

}
package org.firstinspires.ftc.teamcode;


import com.arcrobotics.ftclib.hardware.SimpleServo;
import com.arcrobotics.ftclib.hardware.motors.CRServo;
import com.arcrobotics.ftclib.hardware.motors.Motor;
import com.arcrobotics.ftclib.hardware.motors.MotorEx;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.HardwareMap;

/**
 * -- TEAM 3916 --
 * Robot functions using FTCLib library. Used to program season-specific robot functionality.
 * NOTICE: all dimensions are measured in meters (in case not specified). all measurements should be taken in meters or else calculations will absolutely mess up
 *
 * NOTICE: all angles are measured in radians (in case not specified). please don't ever use degrees for angles
 *
 * @author Aman Anas
 * @author Gabrian Chua
 *
 * @since November 2020
 * @version January 2021
 *
 */

public class FTCLibRobotFunctions extends FTCLibMecanumBot {
    /*
       Put extra game-specific robot functionality here,
       such as additional motors, servos, and sensors for arms, claws, and lifts.
     */
    private final static int CPR = 28;
    private final static int RPM = 6000;
    public final static double MAX_TICKS_PER_SECOND = (double)CPR * (double)RPM / 60;

    // declare motors and servos here


    // declare methods for extra components here


    //reset bot
    public void initBot(HardwareMap hw) {
        super.init(hw);
        // initialize motors, servos, etc. using hardware map here

    }
}

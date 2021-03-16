/*
Apex Robotics FTC Team 3916: Main TeleOp for SkyStone season (2019-2020)

Uses a Mecanum-style drivetrain for movement.
 */

package org.firstinspires.ftc.teamcode;

import com.acmerobotics.dashboard.FtcDashboard;
import com.acmerobotics.dashboard.telemetry.MultipleTelemetry;
import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.arcrobotics.ftclib.gamepad.GamepadKeys;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.robotcore.external.Telemetry;

import static org.firstinspires.ftc.teamcode.drive.DriveConstants.NEW_MIN;
import static org.firstinspires.ftc.teamcode.drive.DriveConstants.NEW_RANGE;
import static org.firstinspires.ftc.teamcode.drive.DriveConstants.OLD_MIN;
import static org.firstinspires.ftc.teamcode.drive.DriveConstants.OLD_RANGE;


@TeleOp(name="MAIN Robotcentric TeleOp", group="Apex Robotics 3916")
//@Disabled
public class TeleOp_Robotcentric extends LinearOpMode {

    private FTCLibRobotFunctions bot = new FTCLibRobotFunctions();

    @Override
    public void runOpMode() throws InterruptedException {
        //Initialize code and variables
        telemetry = new MultipleTelemetry(telemetry, FtcDashboard.getInstance().getTelemetry());

        bot.initBot(hardwareMap);

        GamepadEx Gamepad1 = new GamepadEx(gamepad1);
        GamepadEx Gamepad2 = new GamepadEx(gamepad2);

        //double STICK_DEAD_ZONE = TeleOpConfig.STICK_DEAD_ZONE;
        double x = 0;
        double y = 0;
        double z = 0;

        FtcDashboard dashboard = FtcDashboard.getInstance();
        Telemetry dashboardTelemetry = dashboard.getTelemetry();

        //Wait for the driver to hit Start
        waitForStart();

        while (opModeIsActive()) {
            /*
                GAMEPAD 1 CONTROLS
             */
            double leftY = Gamepad1.getLeftY();
            double leftX = Gamepad1.getLeftX();
            double rightX = Gamepad1.getRightX();

            if (rightX > TeleOpConfig.STICK_DEAD_ZONE) {
                //update x with current x position
                z = ((rightX - OLD_MIN) * NEW_RANGE / OLD_RANGE) + NEW_MIN;
            } else if (rightX < -TeleOpConfig.STICK_DEAD_ZONE) {
                z = -((Math.abs(rightX) - OLD_MIN) * NEW_RANGE / OLD_RANGE) + NEW_MIN;
            } else {
                z= 0;
            }

            if (leftY > TeleOpConfig.STICK_DEAD_ZONE) {
                //update y with current y position
                y = ((leftY - OLD_MIN) * NEW_RANGE / OLD_RANGE) + NEW_MIN;
            } else if (leftY < -TeleOpConfig.STICK_DEAD_ZONE) {
                y = -((Math.abs(leftY) - OLD_MIN) * NEW_RANGE / OLD_RANGE) + NEW_MIN;
            } else {
                y = 0;
            }

            if (leftX > TeleOpConfig.STICK_DEAD_ZONE) {
                //update x with current x position
                x = ((leftX - OLD_MIN) * NEW_RANGE / OLD_RANGE) + NEW_MIN;
            } else if (leftX < -TeleOpConfig.STICK_DEAD_ZONE) {
                x = -((Math.abs(leftX) - OLD_MIN) * NEW_RANGE / OLD_RANGE) + NEW_MIN;
            } else {
                x = 0;
            }

            /*
               GAMEPAD 2 CONTROLS
             */




            // Send the X, Y, and rotation (Z) to the mecanum method
            bot.mecanumDrivetrain.driveRobotCentric(x, y, z);


            // Add a little telemetry
            telemetry.addData("Status", "power: x:" + x + " y:" + y + " z:" + z);
            telemetry.update();
            //dashboardTelemetry.addData("Status", "power: x:" + x + " y:" + y + " z:" + z);
            //dashboardTelemetry.update();
        }
    }
}
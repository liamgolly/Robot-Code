/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;


public final class Constants {

    public static final class robotMovementConstants {
        //1: Forza, 2: CrabwalkBananna
        public final static int driveMode = 1;

        public final static int xboxAccelerateAxis = 5;
        public final static int xboxBrakeAxis = 6;
        public final static int xboxRotateAxis = 0;
    }

    public static final class ControlPorts {
        public final static int controllerPort = 0;
        public final static int moveJoystickPort = 1;
        public final static int rotateJoystickPort = 2;
    }

    public static final class MotorID {
        //Drivetrain
        public final static int leftMotor1ID = 0;
        public final static int leftMotor2ID = 1;
        public final static int rightMotor1ID = 2;
        public final static int rightMotor2ID = 3;

        //Climb
        public final static int pvcExtenderID = 4;
        public final static int leftWinchID = 5;
        public final static int rightWinchID = 6;

        //Turret Assembly
        public final static int turretRotatorID = 7;
        public final static int shooterID = 8;

        //Ball transportation
        public final static int intakeID = 9;
        public final static int intakeRotatorID = 10;
        public final static int hopperID = 11;
        public final static int turretIntakeID = 12;

        //Color wheel
        public final static int colorWheelID = 13;
    }

    public static final class SensorID {
        public final static int hallSensorRotator = 0;

    }

}

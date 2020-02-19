/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

public final class Constants {

    public static final class ControlPorts {
        public static final int controllerPort = 0;
        public static final int moveJoystickPort = 1;
        public static final int rotateJoystickPort = 2;
    }

    public static final class CurrentLimitingConstants {
        public static final double currentLimit = 100;
    }

    public static final class HopperConstants {
        public static final double hopperPower = 0.3;
    }

    public static final class intakeConstants {
        public static final double intakePower = 0.45;
        public static final int activateIntakeButtonID = 3;
    }

    public static final class MotorID {
        // Drivetrain
        public static final int leftMotor1ID = 0;
        public static final int leftMotor2ID = 1;
        public static final int rightMotor1ID = 2;
        public static final int rightMotor2ID = 3;

        // Climb
        public static final int pvcExtenderID = 4;
        public static final int leftWinchID = 5;
        public static final int rightWinchID = 6;

        // Turret Assembly
        public static final int turretRotatorID = 7;
        public static final int shooterID = 8;

        // Ball transportation
        public static final int intakeID = 9;
        public static final int intakeRotatorID = 10;
        public static final int hopperID = 11;
        public static final int turretIntakeID = 12;

        // Color wheel
        public static final int colorWheelID = 13;
    }

    public static final class ProtectionConstants {
        // Intake
        public static final int intakeCurrentLimit = 43;
        public static final double intakeStallTime = 1;
        public static final double intakeUnstallTime = 1;

        public static final double intakeRotatorPower = 0.3;
    }

    public static final class robotMovementConstants {
        public static final int changeDriveModeButtonID = 1;

        public static final int xboxAccelerateAxis = 3;
        public static final int xboxBrakeAxis = 2;
        public static final int xboxRotateAxis = 0;

        public static final int flightStickMoveAxis = 1;
        public static final int flightStickRotateAxis = 0;
    }

    public static final class SensorID {
        public static final int hallSensorRotator = 0;
    }

    public static final class TurretIntakeConstants {
        public static final double turretIntakePower = 0.3;
    }

}

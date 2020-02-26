/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

public final class Constants {

    public static final class AutonomousConstants {
        // haha diameter of the wheels don't know it whatever close enough
        public static final double DrivetrainEncoderInch = (Math.PI * 7.7 / 4096);
        // distance between the hooks lol mounted yet? no.
        public static final double HookDistance = 14;

        public static final double PVCEncoderInch = 2 * Math.PI / 4096;
        // missing the diameter of the winch spool here \/
        public static final double WinchEncoderInch = 2.5 * Math.PI / 4096;
    }

    public static final class ClimbConstants {
        public static int OverrideClimbModeID = 2; // alt stick
    }

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
        public static final int activateIntakeButtonID = 9; // main stick
        public static final int raiseIntakeButtonID = 10; // main stick
    }

    public static final class MotorID {
        // Drivetrain
        public static final int leftMotor1ID = 0;
        public static final int leftMotor2ID = 1;
        public static final int rightMotor1ID = 2;
        public static final int rightMotor2ID = 5;

        // Climb
        public static final int pvcExtenderID = 4;
        public static final int leftWinchID = 3;
        public static final int rightWinchID = 6;

        // Turret Assembly
        public static final int turretRotatorID = 7;
        public static final int shooterID = 0;

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
        public static final double intakeStallTime = 1.5;
        public static final double intakeUnstallTime = .75;

        public static final double intakeRotatorPower = 0.3;
    }

    public static final class robotMovementConstants {
        public static final int quickTurnButtonID = 99; // not a thing

        public static final int xboxAccelerateAxis = 3;
        public static final int xboxBrakeAxis = 2;
        public static final int xboxRotateAxis = 0;

        public static final int pedalAccelerateAxis = 1;
        public static final int pedalBrakeAxis = 0;

        public static final int yokeTurnAxis = 0;
        public static final int yokePushPull = 1;
        public static final int yokeBlackLever = 2;

        public static final int flightStickMoveAxis = 1;
        public static final int flightStickRotateAxis = 0;
        public static final int yokeAxis = 3;
        public static final int pedalAxis = 4;

        public static final int driveStraightTolerance = 1;
    }

    public static final class SensorID {
        public static final int hallSensorTurretRotator = 0;
        public static final int hallSensorUpperIntakeRotator = 1;
        public static final int hallSensorLowerIntakeRotator = 2;
    }

    public static final class ShooterConstants {
        public static final int aimButtonID = 9;
        public static final double shooterPower = 1;
        public static final int shootButtonID = 6;
    }

    public static final class TurretIntakeConstants {
        public static final double turretIntakePower = 0.5;
    }
}

/*

Extend/Lower PVC
Balance
Override Autobalance - hold


Color Wheel

Lower + Enable Intake / Raise Intake

Aim Turret
Override Aim - default joystick
Shoot Turret
Stop Lift and Triangle Override
Enable Lift
Enable Triangle









Button IDS:

            XBox Controller
    Buttons:
left bumper     -   shift left
Right bumper    -   shift right
A
X
Y
B
Start
Select

    Axis:
Right trigger   -   accelerate
Left trigger    -   brake
left X          -   movement
Left Y          -
Right X         -
Right Y         -

           Main Flightstick
    Buttons:
1               -   Shoot turret            -   Hold
2               -   Override Autobalance    -   Hold
3               -   Auto aim                -   Hold / Make it obvious it is done
4
5               -   Enable Triangle         -   Hold
6               -   Enable Lift             -   Hold
7               -   Lower PVC               -   Press
8               -   Extend PVC              -   Press
9               -   Lower Intake            -   Press
10              -   Raise Intake            -   Press
11              -   Override Lift/Triangle  -   Press
12

    Axis:
0
1
2               -   Manual Aim              -   Default
3

            Alt Flightstick
    Buttons:
1
2               -   Start Autobalance       -   Press
3
4
5
6
7
8               -   Rotate Color Wheel 5    -   Press
9               -   Go to color             -   Press
10
11
12

    Axis:
0
1
2
3
*/

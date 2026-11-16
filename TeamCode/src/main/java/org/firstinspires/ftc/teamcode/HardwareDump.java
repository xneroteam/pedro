package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotorEx;

@TeleOp(name = "Hardware Dump", group = "Test")
public class HardwareDump extends LinearOpMode {

    @Override
    public void runOpMode() {
        telemetry.addLine("All motors/encoders in the active configuration:");
        for (DcMotorEx motor : hardwareMap.getAll(DcMotorEx.class)) {
            telemetry.addData(motor.getDeviceName(),
                    "port " + motor.getPortNumber() + " | pos " + motor.getCurrentPosition());
        }
        telemetry.addLine("Push the robot forward, then sideways, to see which names change.");
        telemetry.update();

        waitForStart();

        while (opModeIsActive()) {
            for (DcMotorEx motor : hardwareMap.getAll(DcMotorEx.class)) {
                telemetry.addData(motor.getDeviceName(),
                        "port " + motor.getPortNumber() + " | pos " + motor.getCurrentPosition());
            }
            telemetry.update();
        }
    }
}

package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotorEx;

@TeleOp(name = "Odometry Pod Ticks Test", group = "TeleOp")
public class OdometryPodTest extends LinearOpMode {

    private DcMotorEx leftEncoder;
    private DcMotorEx rightEncoder;
    private DcMotorEx strafeEncoder;

    @Override
    public void runOpMode() {
        // Initialize the encoder motor ports from HardwareMap
        // Left pod: "lf", Right pod: "rr", Strafe pod: "lr"
        leftEncoder = hardwareMap.get(DcMotorEx.class, "lf");
        rightEncoder = hardwareMap.get(DcMotorEx.class, "rr");
        strafeEncoder = hardwareMap.get(DcMotorEx.class, "lr");

        telemetry.addData("Status", "Initialized. Press Play to view encoder ticks.");
        telemetry.update();

        waitForStart();

        while (opModeIsActive()) {
            // Get current tick positions for each odometry pod
            int leftTicks = getLeftPodTicks();
            int rightTicks = getRightPodTicks();
            int strafeTicks = getStrafePodTicks();

            // Display ticks on Driver Station telemetry
            telemetry.addData("Left Pod (lf) Ticks", leftTicks);
            telemetry.addData("Right Pod (rr) Ticks", rightTicks);
            telemetry.addData("Strafe Pod (lr) Ticks", strafeTicks);
            telemetry.update();
        }
    }

    /**
     * Returns the raw tick position of the Left Odometry Pod ("lf").
     */
    public int getLeftPodTicks() {
        return leftEncoder.getCurrentPosition();
    }

    /**
     * Returns the raw tick position of the Right Odometry Pod ("rr").
     */
    public int getRightPodTicks() {
        return rightEncoder.getCurrentPosition();
    }

    /**
     * Returns the raw tick position of the Strafe Odometry Pod ("lr").
     */
    public int getStrafePodTicks() {
        return strafeEncoder.getCurrentPosition();
    }
}

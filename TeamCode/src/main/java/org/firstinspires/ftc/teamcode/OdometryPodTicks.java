package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;

import java.util.Locale;

/**
 * Helper class to read tick positions from three odometry pods:
 * - Left Pod: "lf"
 * - Right Pod: "rr"
 * - Strafe Pod: "lr"
 */
public class OdometryPodTicks {

    private final DcMotorEx leftEncoder;
    private final DcMotorEx rightEncoder;
    private final DcMotorEx strafeEncoder;

    public OdometryPodTicks(HardwareMap hardwareMap) {
        this.leftEncoder = hardwareMap.get(DcMotorEx.class, "lf");
        this.rightEncoder = hardwareMap.get(DcMotorEx.class, "rr");
        this.strafeEncoder = hardwareMap.get(DcMotorEx.class, "lr");
    }

    public int getLeftTicks() {
        return leftEncoder.getCurrentPosition();
    }

    public int getRightTicks() {
        return rightEncoder.getCurrentPosition();
    }

    public int getStrafeTicks() {
        return strafeEncoder.getCurrentPosition();
    }

    /**
     * Data object representing all three pod tick values.
     */
    public static class PodTicks {
        public final int left;
        public final int right;
        public final int strafe;

        public PodTicks(int left, int right, int strafe) {
            this.left = left;
            this.right = right;
            this.strafe = strafe;
        }

        @Override
        public String toString() {
            return String.format(Locale.US, "Left (lf): %d, Right (rr): %d, Strafe (lr): %d", left, right, strafe);
        }
    }

    public PodTicks getAllTicks() {
        return new PodTicks(getLeftTicks(), getRightTicks(), getStrafeTicks());
    }
}

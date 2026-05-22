package frc.robot.subsystems.pivot;

import org.littletonrobotics.junction.AutoLog;

public interface PivotIO {

    @AutoLog
    class PivotIOInputs {
        public double positionRadians = 0.0;
        public double velocityRadiansPerSecond = 0.0;
        public double currentAmps = 0.0;
    }

    default void updateInputs(PivotIOInputs inputs) {}

    default void setPosition(double radians) {}

    default void stop() {}
}
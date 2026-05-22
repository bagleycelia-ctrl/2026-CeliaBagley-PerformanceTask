package frc.robot.subsystems.grabber;

import org.littletonrobotics.junction.AutoLog;

public interface GrabberIO {

    @AutoLog
    class GrabberIOInputs {
        public double leftCurrentAmps = 0.0;
        public double rightCurrentAmps = 0.0;

        public double leftVelocity = 0.0;
        public double rightVelocity = 0.0;
    }

    default void updateInputs(GrabberIOInputs inputs) {}

    default void setPercent(double left, double right) {}

    default void stop() {}
}
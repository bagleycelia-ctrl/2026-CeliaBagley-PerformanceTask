package frc.robot.subsystems.elevator;

import org.littletonrobotics.junction.AutoLog;

public interface ElevatorIO {

    @AutoLog
    class ElevatorIOInputs {
        public double positionMeters = 0.0;
        public double velocityMetersPerSecond = 0.0;
        public double appliedVolts = 0.0;
        public double currentAmps = 0.0;
    }

    default void updateInputs(ElevatorIOInputs inputs) {}

    default void setPosition(double meters) {}

    default void setVoltage(double volts) {}

    default void stop() {}
}
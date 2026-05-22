package frc.robot.subsystems.elevator;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import org.littletonrobotics.junction.Logger;

public class ElevatorSubsystem extends SubsystemBase {

    private final ElevatorIO io;
    private final ElevatorIOInputsAutoLogged inputs =
            new ElevatorIOInputsAutoLogged();

    public ElevatorSubsystem(ElevatorIO io) {
        this.io = io;
    }

    @Override
    public void periodic() {
        io.updateInputs(inputs);
        Logger.processInputs("Elevator", inputs);
    }

    public void setHeight(double meters) {
        io.setPosition(meters);
    }

    public double getHeight() {
        return inputs.positionMeters;
    }

    public double getVelocity() {
        return inputs.velocityMetersPerSecond;
    }

    public void stop() {
        io.stop();
    }
}
package frc.robot.subsystems.pivot;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import org.littletonrobotics.junction.Logger;

public class PivotSubsystem extends SubsystemBase {

    private final PivotIO io;
    private final PivotIOInputsAutoLogged inputs =
            new PivotIOInputsAutoLogged();

    public PivotSubsystem(PivotIO io) {
        this.io = io;
    }

    @Override
    public void periodic() {
        io.updateInputs(inputs);
        Logger.processInputs("Pivot", inputs);
    }

    public void setAngle(double radians) {
        io.setPosition(radians);
    }

    public double getAngle() {
        return inputs.positionRadians;
    }

    public void stop() {
        io.stop();
    }

    public Command moveToAngle(double radians) {
        return run(() -> setAngle(radians))
                .until(() -> Math.abs(getAngle() - radians) < 0.05);
    }
}
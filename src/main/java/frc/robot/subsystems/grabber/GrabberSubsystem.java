package frc.robot.subsystems.grabber;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import org.littletonrobotics.junction.Logger;

public class GrabberSubsystem extends SubsystemBase {

    private final GrabberIO io;
    private final GrabberIOInputsAutoLogged inputs =
            new GrabberIOInputsAutoLogged();

    public GrabberSubsystem(GrabberIO io) {
        this.io = io;
    }

    @Override
    public void periodic() {
        io.updateInputs(inputs);
        Logger.processInputs("Grabber", inputs);
    }

    public void run(double leftPercent, double rightPercent) {
        io.setPercent(leftPercent, rightPercent);
    }

    public boolean hasGamePiece() {
        return inputs.leftCurrentAmps >
                GrabberConstants.INTAKE_CURRENT_THRESHOLD
            && inputs.rightCurrentAmps >
                GrabberConstants.INTAKE_CURRENT_THRESHOLD;
    }

    public void stop() {
        io.stop();
    }

    public Command runPercent(double left, double right) {
    return startEnd(
            () -> run(left, right),
            this::stop);
    }
}
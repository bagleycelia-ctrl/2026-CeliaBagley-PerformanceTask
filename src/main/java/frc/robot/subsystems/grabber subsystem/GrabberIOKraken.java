package frc.robot.subsystems.grabber;

import com.ctre.phoenix6.hardware.TalonFX;

public class GrabberIOKraken implements GrabberIO {

    private final TalonFX leftMotor =
            new TalonFX(GrabberConstants.LEFT_ID);

    private final TalonFX rightMotor =
            new TalonFX(GrabberConstants.RIGHT_ID);

    @Override
    public void updateInputs(GrabberIOInputs inputs) {

        inputs.leftCurrentAmps =
                leftMotor.getSupplyCurrent().getValueAsDouble();

        inputs.rightCurrentAmps =
                rightMotor.getSupplyCurrent().getValueAsDouble();

        inputs.leftVelocity =
                leftMotor.getVelocity().getValueAsDouble();

        inputs.rightVelocity =
                rightMotor.getVelocity().getValueAsDouble();
    }

    @Override
    public void setPercent(double left, double right) {
        leftMotor.set(left);
        rightMotor.set(right);
    }

    @Override
    public void stop() {
        leftMotor.stopMotor();
        rightMotor.stopMotor();
    }
}
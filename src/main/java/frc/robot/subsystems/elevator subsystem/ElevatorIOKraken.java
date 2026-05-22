package frc.robot.subsystems.elevator;

import com.ctre.phoenix6.hardware.TalonFX;

public class ElevatorIOKraken implements ElevatorIO {

    private final TalonFX leftMotor =
            new TalonFX(ElevatorConstants.LEFT_MOTOR_ID);

    private final TalonFX rightMotor =
            new TalonFX(ElevatorConstants.RIGHT_MOTOR_ID);

    @Override
    public void updateInputs(ElevatorIOInputs inputs) {
        inputs.positionMeters =
                leftMotor.getPosition().getValueAsDouble();

        inputs.velocityMetersPerSecond =
                leftMotor.getVelocity().getValueAsDouble();

        inputs.currentAmps =
                leftMotor.getSupplyCurrent().getValueAsDouble();
    }

    @Override
    public void setPosition(double meters) {
        // Motion Magic request would go here
    }

    @Override
    public void setVoltage(double volts) {
        leftMotor.setVoltage(volts);
        rightMotor.setVoltage(volts);
    }

    @Override
    public void stop() {
        leftMotor.stopMotor();
        rightMotor.stopMotor();
    }
}
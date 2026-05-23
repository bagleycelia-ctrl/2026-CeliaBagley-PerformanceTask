package frc.robot.subsystems.elevator;

import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.controls.Follower;
import com.ctre.phoenix6.controls.MotionMagicVoltage;
import com.ctre.phoenix6.hardware.TalonFX;

public class ElevatorIOKraken implements ElevatorIO {

    private final TalonFX leftMotor =
            new TalonFX(ElevatorConstants.LEFT_MOTOR_ID);

    private final TalonFX rightMotor =
            new TalonFX(ElevatorConstants.RIGHT_MOTOR_ID);

    private final MotionMagicVoltage motionMagicRequest =
            new MotionMagicVoltage(0);

    public ElevatorIOKraken() {

        TalonFXConfiguration config =
                new TalonFXConfiguration();

        config.Slot0.kP = ElevatorConstants.kP;
        config.Slot0.kI = ElevatorConstants.kI;
        config.Slot0.kD = ElevatorConstants.kD;

        config.MotionMagic.MotionMagicCruiseVelocity = 3.0;
        config.MotionMagic.MotionMagicAcceleration = 6.0;
    }

    @Override
    public void updateInputs(ElevatorIOInputs inputs) {

        inputs.positionMeters =
                leftMotor.getPosition().getValueAsDouble();

        inputs.velocityMetersPerSecond =
                leftMotor.getVelocity().getValueAsDouble();

        inputs.appliedVolts =
                leftMotor.getMotorVoltage().getValueAsDouble();

        inputs.currentAmps =
                leftMotor.getSupplyCurrent().getValueAsDouble();
    }

    @Override
    public void setPosition(double meters) {

        leftMotor.setControl(
                motionMagicRequest.withPosition(meters));
    }

    @Override
    public void setVoltage(double volts) {
        leftMotor.setVoltage(volts);
    }

    public void stop() {
        leftMotor.stopMotor();
    }
}
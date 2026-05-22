package frc.robot.subsystems.pivot;

import com.ctre.phoenix6.hardware.TalonFX;

public class PivotIOKraken implements PivotIO {

    private final TalonFX motor =
            new TalonFX(PivotConstants.MOTOR_ID);

    @Override
    public void updateInputs(PivotIOInputs inputs) {
        inputs.positionRadians =
                motor.getPosition().getValueAsDouble();

        inputs.velocityRadiansPerSecond =
                motor.getVelocity().getValueAsDouble();

        inputs.currentAmps =
                motor.getSupplyCurrent().getValueAsDouble();
    }

    @Override
    public void setPosition(double radians) {
        // Motion Magic request here
    }

    @Override
    public void stop() {
        motor.stopMotor();
    }
}
package frc.robot;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.Superstructure.Goal;
import frc.robot.Superstructure.Superstructure;
import frc.robot.subsystems.elevator.*;
import frc.robot.subsystems.pivot.*;
import frc.robot.subsystems.grabber.*;

public class RobotContainer {

    private final XboxController driver =
            new XboxController(0);

    private final ElevatorSubsystem elevator =
            new ElevatorSubsystem(new ElevatorIOKraken());

    private final PivotSubsystem pivot =
            new PivotSubsystem(new PivotIOKraken());

    private final GrabberSubsystem grabber =
            new GrabberSubsystem(new GrabberIOKraken());

    private final Superstructure superstructure =
            new Superstructure(
                    elevator,
                    pivot,
                    grabber);

    public RobotContainer() {
        configureBindings();
    }

    private void configureBindings() {

        new JoystickButton(driver, XboxController.Button.kA.value)
                .onTrue(
                        superstructure.goToGoal(Goal.L1));

        new JoystickButton(driver, XboxController.Button.kB.value)
                .onTrue(
                        superstructure.goToGoal(Goal.L2));

        new JoystickButton(driver, XboxController.Button.kX.value)
                .onTrue(
                        superstructure.goToGoal(Goal.L3));

        new JoystickButton(driver, XboxController.Button.kY.value)
                .onTrue(
                        superstructure.goToGoal(Goal.L4));

        new JoystickButton(driver, XboxController.Button.kLeftBumper.value)
                .onTrue(
                        superstructure.intakeHumanPlayer());

        new JoystickButton(driver, XboxController.Button.kRightBumper.value)
                .onTrue(
                        superstructure.throwPiece());

        new JoystickButton(driver, XboxController.Button.kStart.value)
                .onTrue(
                        superstructure.scoreForward());
    }

    public Command getAutonomousCommand() {
        return null;
    }
}
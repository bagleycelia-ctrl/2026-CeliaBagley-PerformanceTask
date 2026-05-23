package frc.robot.Superstructure;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;

import frc.robot.subsystems.elevator.ElevatorSubsystem;
import frc.robot.subsystems.pivot.PivotSubsystem;
import frc.robot.subsystems.grabber.GrabberSubsystem;

public class Superstructure {

    private final ElevatorSubsystem elevator;
    private final PivotSubsystem pivot;
    private final GrabberSubsystem grabber;

    public Superstructure(
            ElevatorSubsystem elevator,
            PivotSubsystem pivot,
            GrabberSubsystem grabber) {

        this.elevator = elevator;
        this.pivot = pivot;
        this.grabber = grabber;
    }

    public Command goToGoal(Goal goal) {

        return switch (goal) {

            case L1 -> Commands.parallel(
                    elevator.moveToHeight(1.0),
                    pivot.moveToAngle(Math.PI / 6.0));

            case L2 -> Commands.parallel(
                    elevator.moveToHeight(2.0),
                    pivot.moveToAngle(-Math.PI / 6.0));

            case L3 -> Commands.parallel(
                    elevator.moveToHeight(3.0),
                    pivot.moveToAngle(-Math.PI / 6.0));

            case L4 -> Commands.parallel(
                    elevator.moveToHeight(4.0),
                    pivot.moveToAngle(-Math.PI / 3.0));

            case HUMAN_PLAYER -> Commands.parallel(
                    elevator.moveToHeight(1.5),
                    pivot.moveToAngle(Math.PI / 3.0));

            case THROW -> Commands.parallel(
                    elevator.moveToHeight(4.5),
                    pivot.moveToAngle(2.0 * Math.PI / 3.0));
        };
    }

    public Command scoreL1() {

        return grabber.runPercent(0.33, -0.33)
                .withTimeout(0.5);
    }

    public Command scoreForward() {

        return grabber.runPercent(0.33, 0.33)
                .withTimeout(0.5);
    }

    public Command intakeHumanPlayer() {

        return goToGoal(Goal.HUMAN_PLAYER)
                .andThen(
                        grabber.runPercent(-0.5, -0.5)
                                .until(grabber::hasGamePiece));
    }

    public Command throwPiece() {

        return goToGoal(Goal.THROW)
                .alongWith(
                        Commands.waitUntil(
                                () ->
                                        elevator.getHeight() >= 3.5
                                                && elevator.getVelocity() >= 2.0)
                                .andThen(
                                        grabber.runPercent(1.0, 1.0)
                                                .withTimeout(0.25)));
    }
}
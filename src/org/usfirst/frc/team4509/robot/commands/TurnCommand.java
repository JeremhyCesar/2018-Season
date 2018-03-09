package org.usfirst.frc.team4509.robot.commands;


import org.usfirst.frc.team4509.robot.Robot;
import org.usfirst.frc.team4509.robot.RobotMap;

import edu.wpi.first.wpilibj.Preferences;
import edu.wpi.first.wpilibj.command.Command;


/**
 * Turn the robot a given amount in degrees 
 * 
 * @author FRC Team 4509
 */
public class TurnCommand extends Command {

	double turnDegrees, targetDegrees;

	public TurnCommand(double turnDegrees) {
		requires(Robot.drivingSubsystem);
		this.turnDegrees = turnDegrees > 180 ? turnDegrees - 360 : turnDegrees;
		this.targetDegrees = this.turnDegrees + RobotMap.gyro.getAngle();
	}

	protected void initialize() {
		Robot.drivingSubsystem.stop();
	}

	protected void execute() {
		double multiplier = this.targetDegrees - RobotMap.gyro.getAngle() < 45 ? 0.6 : 1;
		if(this.targetDegrees - RobotMap.gyro.getAngle() > 0)
			Robot.drivingSubsystem.turn(1 * multiplier);
		else
			Robot.drivingSubsystem.turn(-1 * multiplier);
	}

	protected boolean isFinished() {
		return Math.abs(this.targetDegrees - RobotMap.gyro.getAngle()) < Preferences.getInstance().getDouble("GYRO_PRECISION", RobotMap.GYRO_PRECISION);
	}

	protected void end() {
		Robot.drivingSubsystem.stop();
	}

}

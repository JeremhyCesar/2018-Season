package org.usfirst.frc.team4509.robot.commands;

import org.usfirst.frc.team4509.robot.Robot;

import edu.wpi.first.wpilibj.command.TimedCommand;


/**
 * Run the grabber at the given speed for a given number of seconds.
 * 
 * @author FRC Team 4509
 */
public class GrabberForSecondsCommand extends TimedCommand {

	double speed;
	
	public GrabberForSecondsCommand(double speed, double timeout) {
		super(timeout);
		requires(Robot.grabberSubsystem);
		this.speed = speed;
	}
	
	public void execute() {
		Robot.grabberSubsystem.set(this.speed);
	}
	
	public void end() {
		Robot.grabberSubsystem.stop();
	}

}

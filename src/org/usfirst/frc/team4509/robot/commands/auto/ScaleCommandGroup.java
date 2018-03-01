package org.usfirst.frc.team4509.robot.commands.auto;

import org.usfirst.frc.team4509.robot.Robot;
import org.usfirst.frc.team4509.robot.commands.DriveForFeetCommand;
import org.usfirst.frc.team4509.robot.commands.GrabCommand;
import org.usfirst.frc.team4509.robot.commands.SlideForSecondsCommand;
import org.usfirst.frc.team4509.robot.commands.TurnCommand;
import org.usfirst.frc.team4509.robot.commands.WinchForSecondsCommand;

import edu.wpi.first.wpilibj.command.CommandGroup;


/**
 * Command Group to put a cube on the scale.
 */
public class ScaleCommandGroup extends CommandGroup {

	public ScaleCommandGroup() {
		if(Robot.getStartingPosition() == Robot.gameData[0]) {
			addSequential(new DriveForFeetCommand(19.061));
			addSequential(new TurnCommand(180 * Robot.startPosition));
			addSequential(new SlideForSecondsCommand(-1, 2));
			addSequential(new GrabCommand());
			addSequential(new SlideForSecondsCommand(1, 2));
			addSequential(new TurnCommand(180 * Robot.startPosition));
			addSequential(new WinchForSecondsCommand(1, 4));
			addSequential(new DriveForFeetCommand(5.910));
			addSequential(new WinchForSecondsCommand(-1, 4));
			addSequential(new DriveForFeetCommand(-5.910));
			
		}
	}
	
}

package org.usfirst.frc.team4509.robot.commands.auto;

import org.usfirst.frc.team4509.robot.Robot;
import org.usfirst.frc.team4509.robot.commands.DriveForFeetCommand;
import org.usfirst.frc.team4509.robot.commands.SlideForSecondsCommand;
import org.usfirst.frc.team4509.robot.commands.TurnCommand;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * Command Group to put a cube on the switch.
 */
public class SwitchCommandGroup extends CommandGroup {

	public SwitchCommandGroup() {
		addSequential(new DriveForFeetCommand(19.061));
		addSequential(new TurnCommand(180 * Robot.startPosition));
		addSequential(new SlideForSecondsCommand(-1, 2));
		
		
		addSequential(new DriveForFeetCommand(1));
		
		addSequential(new DriveForFeetCommand(1));
		
	}
}
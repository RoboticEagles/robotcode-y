package org.usfirst.frc.team7299.robot.commands;

import org.usfirst.frc.team7299.robot.Robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Command;

public class TeleopCommand extends Command {
	public boolean slowmode = true;
	public boolean isols = false;
	public boolean rsols = false;
	public boolean inflating = false;
	public boolean inverted = false;
	
	public final int buttonA = 1;
	public final int buttonB = 2;
	public final int buttonX = 3;
	public final int buttonY = 4;
	public final int buttonLB = 5;
	public final int buttonRB = 6;
	public final int buttonBack = 7;
	public final int buttonStart = 8;
	public final int buttonLS = 9;
	public final int buttonRS = 10;

    public TeleopCommand() {
        //requires(Robot.conveyor);
        requires(Robot.drivetrain);
        //requires(Robot.intake);
    }

    protected void initialize() {}

    protected void execute() {
    		Joystick j = Robot.oi.getJoystick(0);
    		if(j.getRawButtonReleased(buttonBack)) {
    			inverted = !inverted;
    		}
    		if(j.getRawButtonReleased(buttonStart)) slowmode = !slowmode;
    		double x = j.getRawAxis(0) * (slowmode? 0.35 : 0.75);
    		double y = -j.getRawAxis(1) * 0.8 * (inverted? -1 : 1);
    		double pL = ((y + x) / Math.sqrt(2));
    		double pR = ((y - x) / Math.sqrt(2));
    		//double iL = ((k.getRawAxis(1) + k.getRawAxis(0)) / Math.sqrt(2));
    		//double iR = ((k.getRawAxis(1) - k.getRawAxis(0)) / Math.sqrt(2));
    		//Robot.intake.setLeftSpeed(iL);
    		//Robot.intake.setRightSpeed(iR);
    		//Robot.intake.setSpeed((k.getRawButton(buttonLB) ? -0.6 : 0.6 * k.getRawAxis(2)));
    		//Robot.conveyor.setSpeed((k.getRawButton(buttonRB) ? -0.35 : 0.75 * k.getRawAxis(3)));
        	Robot.drivetrain.setLeftSpeed(pL);
        	Robot.drivetrain.setRightSpeed(pR);
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {}
    
    protected void interrupted() {}
}

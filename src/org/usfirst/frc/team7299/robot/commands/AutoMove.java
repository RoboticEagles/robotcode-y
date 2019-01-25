package org.usfirst.frc.team7299.robot.commands;

import org.usfirst.frc.team7299.robot.Robot;

import edu.wpi.first.wpilibj.DriverStation;

//import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.command.Command;
//import edu.wpi.first.wpilibj.I2C;

public class AutoMove extends Command {
    	private double time = 0;
    	private String pos = "";
    	private String swp = "";
    	private boolean done = false;
	//private AHRS ahrs;

    public AutoMove() {
        requires(Robot.drivetrain);
    }

	protected void initialize() {
		//ahrs = new AHRS(I2C.Port.kMXP);
	    Robot.drivetrain.setSpeed(0.4);
	    pos = Robot.autoPosition.getSelected();
	    	String msg = DriverStation.getInstance().getGameSpecificMessage();
	    	System.out.println("MESSAGE IS: " + msg);
	    	
	    	if(msg.length() < 1) {
	    		if(pos.equals("R")) {
	    			swp = "L";
	    		} else if (pos.equals("L")) {
	    			swp = "R";
	    		}
	    } else {
	    		swp = msg.substring(0,1);
	    }
	    	
	    	if(pos.equals("L") || pos.equals("R")) {
	    		Robot.drivetrain.setRightSpeed(0.38);
	    		Robot.drivetrain.setLeftSpeed(0.4);
	    	}
    	}

    protected void execute() {
    		time += 0.02;
    		if(time >= 6) {
    			
    		} else if(time >= 5.2) {
    			if (pos.equals(swp)) {
    				//Robot.conveyor.setSpeed(0);
    			} else if(!pos.equals("C")) {
    				Robot.drivetrain.setSpeed(0);
    			}
    		} else if(time >= 4.6 && pos.equals(swp)) {
        		//Robot.conveyor.setSpeed(0.3);
        		Robot.drivetrain.setSpeed(0.2);
        	} else if(time >= 4 && pos.equals(swp)) {
 			if(pos.equals("L")) {
    				Robot.drivetrain.setRightSpeed(0.3);
    				Robot.drivetrain.setLeftSpeed(-0.3);
    			} else {
    				Robot.drivetrain.setRightSpeed(0.3);
    				Robot.drivetrain.setRightSpeed(-0.3);
    			}
     	}
    }

    protected boolean isFinished() {
        return (done && Robot.drivetrain.getLeftSpeed() == 0 && Robot.drivetrain.getRightSpeed() == 0);
    }

    protected void end() {}

    protected void interrupted() {}
}

package org.usfirst.frc.team7299.robot.subsystems;

import edu.wpi.first.wpilibj.PWMVictorSPX;
import edu.wpi.first.wpilibj.command.Subsystem;

public class DrivetrainSubsystem extends Subsystem {
	PWMVictorSPX drivetrainFL = new PWMVictorSPX(0);
	PWMVictorSPX drivetrainFR = new PWMVictorSPX(2);
	PWMVictorSPX drivetrainBL = new PWMVictorSPX(1);
	PWMVictorSPX drivetrainBR = new PWMVictorSPX(3);
	public double targetSpeedL = 0;
	public double targetSpeedR = 0;
	private double currentSpeedL = 0;
	private double currentSpeedR = 0;

    public void initDefaultCommand() {}

    public void forceSetLeftSpeed(double s) {
    		drivetrainFL.set(s);
    		drivetrainBL.set(s);
    		currentSpeedL = s;
    }
    
    public void forceSetRightSpeed(double s) {
		drivetrainFR.set(-s);
		drivetrainBR.set(-s);
		currentSpeedR = s;
    }

    public double getLeftSpeed() {
    		return currentSpeedL;
    }
    
    public double getRightSpeed() {
		return currentSpeedR;
    }

    public void setSpeed(double s) {
    		setLeftSpeed(s);
    		setRightSpeed(s);
    }

    public void setLeftSpeed(double s) {
		if(Math.abs(s) > 1) s = Math.signum(s);
    		targetSpeedL = s;
    }
    
    public void setRightSpeed(double s) {
		if(Math.abs(s) > 1) s = Math.signum(s);
		targetSpeedR = s;
    }
    
    public void fixSpeed() {
    		targetSpeedL = currentSpeedL;
    		targetSpeedR = currentSpeedR;
}
}

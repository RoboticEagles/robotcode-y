package org.usfirst.frc.team7299.robot.subsystems;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;

public class ConveyorSubsystem extends Subsystem {
	Spark conveyorL = new Spark(8);
	Spark conveyorR = new Spark(9);
	
	@Override
	protected void initDefaultCommand() {}

    public void setSpeed(double s) {
    		conveyorL.set(-s);
    		conveyorR.set(s);
    }
    
    public void stop() {
		setSpeed(0);
    }
    
}

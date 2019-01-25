package org.usfirst.frc.team7299.robot.subsystems;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Subsystem;

public class PneumaticSubsystem extends Subsystem {
	Compressor compressor = new Compressor();
	DoubleSolenoid intakeSolenoid = new DoubleSolenoid(1, 0);
	DoubleSolenoid rampSolenoid = new DoubleSolenoid(3, 2);
	
	@Override
	protected void initDefaultCommand() {
		compressor.setClosedLoopControl(true);
		compressor.start();
		intakeSolenoid.set(Value.kReverse);
		rampSolenoid.set(Value.kReverse);
	}
	
	public void setIntake(boolean y) {
		intakeSolenoid.set(y ? Value.kForward : Value.kReverse);
	}

	public void start() {
		compressor.setClosedLoopControl(true);
	}
	
	public void setRamp(boolean y) {
		rampSolenoid.set(y ? Value.kForward : Value.kReverse);
	}
	
}


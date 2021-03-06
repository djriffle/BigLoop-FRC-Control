/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.Subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * Add your docs here.
 */
public class Feeder{

  WPI_VictorSPX feeder = new WPI_VictorSPX(5);

  public Feeder(){

  }
  
  public void on(){
    feeder.set(ControlMode.PercentOutput, 50);

  }

  public void off(){
    feeder.set(ControlMode.PercentOutput, 0);

  }
  // Put methods for controlling this subsystem
  // here. Call these from Commands.


}

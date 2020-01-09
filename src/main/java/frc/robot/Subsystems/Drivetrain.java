/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.Subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.OI;
/**
 * Add your docs here.
 */
public class Drivetrain{
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  DifferentialDrive drive;

  WPI_TalonSRX rightMaster = new WPI_TalonSRX(3);
  WPI_TalonSRX rightSlave = new WPI_TalonSRX(4);
  WPI_TalonSRX leftMaster = new WPI_TalonSRX(2);
  WPI_TalonSRX leftSlave = new WPI_TalonSRX(1);

  public Drivetrain (){
    rightSlave.follow(rightMaster);
    leftSlave.follow(leftMaster);
    drive = new DifferentialDrive(leftMaster, rightMaster);
  }

  public void arcade(double move, double turn){
    System.out.println(move);
    System.out.println(turn);
    drive.arcadeDrive(move,turn);
  }

  public double getRightPosition() {
    return leftSlave.getSelectedSensorPosition();
  }

  public double getLeftPosition(){
    return rightSlave.getSelectedSensorPosition();
  }


}
/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import frc.robot.Subsystems.*;
//import frc.robot.pathfinding;
import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.SPI;
/**
 * Hardware abstraction layer
 */
public class HAL {
    public static Drivetrain drivetrain = new Drivetrain();
    public static AHRS navX = new AHRS(SPI.Port.kMXP);
   // public static Pathifinnding finder = new Pathifinnding(); 

}

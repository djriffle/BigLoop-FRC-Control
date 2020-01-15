/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;
import frc.robot.Robot;
import frc.robot.Loop;
import frc.robot.Grain;
import frc.robot.Procedure;
import frc.robot.TC;
import frc.robot.Subsystems.Drivetrain;
import frc.robot.ninjalib.Gamepad;
import java.util.function.DoubleSupplier;

import edu.wpi.first.vision.VisionRunner.Listener;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;


/**
 * Add your docs here.
 */
public class OI {

    Gamepad driver = new Gamepad(0);
    public OI(){
        //these are active listeners
        //make procedures and conditions
        TC noTC = ()->{return false;};
        Procedure drive = () ->{HAL.drivetrain.arcade(driver.getRightX()/1.75,-driver.getLeftY()/1.4);};
        //make and add grain
        Grain e = new Grain(drive,noTC,drive);
        Robot.mill.addGrain(e);
    }
    public void listener(){
        TC encoder = () -> {return HAL.drivetrain.getRightPosition() >= 10;};
        Procedure stop = () ->{HAL.drivetrain.arcade(0,0);};
        Procedure move = () ->{HAL.drivetrain.arcade(0.3,0);System.out.println(HAL.drivetrain.getRightPosition());};
        Grain forward = new Grain(move,encoder,stop);
        if(driver.getButtonStateA()){
            Robot.mill.addGrain(forward);
            
        }
    }
   

}

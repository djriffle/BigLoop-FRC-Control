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


/**
 * Add your docs here.
 */
public class OI {
    public OI(){
        //temporary make subsystem
        Drivetrain drivetrain = new Drivetrain();
        //make gamepad
        Gamepad driver = new Gamepad(0);
        //make procedures and conditions
        TC noTC = ()->{return false;};
        Procedure drive = () ->{drivetrain.arcade(driver.getRightX()/1.75,-driver.getLeftY()/1.4);};
        //make and add grain
        Grain e = new Grain(drive,noTC,drive);
        Robot.mill.addGrain(e);
    }

}

/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;
import frc.robot.Loop;
import frc.robot.Grain;
import frc.robot.Procedure;
import frc.robot.TC;
/**
 * Add your docs here.
 */
public class OI {
    public OI(){

        Loop Mill = new Loop();
        Procedure movefoward = ()->{System.out.println("moving motor forward");};
        TC hitwall = ()->{return true;};
        Procedure backupalittle = () ->{System.out.println("backing up a little");};
        
        Grain e = new Grain(movefoward,hitwall,backupalittle);
        Mill.addGrain(e);
    }

}

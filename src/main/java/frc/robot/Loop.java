/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import java.util.ArrayList;
import frc.robot.Grain;

/**
 * Is the home of autonomous
 * Crushes Feed to make the robot drive
 */


public class Loop {
    
    ArrayList<Grain> chain = new ArrayList<Grain>();



public void addGrain(Grain e){
    e.run();
    chain.add(e);
}

//looks for dead grians
public void Maintence(){
		for (int i = 0; i < chain.size(); i++) {
            System.out.println(chain.get(i));
            if(chain.get(i).dead){
                chain.remove(i);
            }
	}
    
}

}
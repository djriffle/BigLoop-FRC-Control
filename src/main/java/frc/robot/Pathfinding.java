/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/
//great reference ->
//https://github.com/team2383/2018Kappa/blob/5ff1b0afae8c319719aa4fdfe2d89dc8e98971cd/src/
//com/team2383/robot/commands/FollowTrajectory.java

//To Do: reintegrate navx

package frc.robot;

import jaci.pathfinder.*;
import jaci.pathfinder.modifiers.TankModifier;
import frc.robot.ninjalib.PathFollower;
import frc.robot.HAL;


/**
 * Add your docs here.
 */

public class Pathfinding {
    Waypoint[] points = new Waypoint[] {
        new Waypoint(-4, -1, Pathfinder.d2r(-45)),      // Waypoint @ x=-4, y=-1, exit angle=-45 degrees
        new Waypoint(-2, -2, 0),                        // Waypoint @ x=-2, y=-2, exit angle=0 radians
        new Waypoint(0, 0, 0)                           // Waypoint @ x=0, y=0,   exit angle=0 radians
    };
    Trajectory.Config config = new Trajectory.Config(Trajectory.FitMethod.HERMITE_CUBIC, Trajectory.Config.SAMPLES_HIGH, 0.05, 1.7, 2.0, 60.0);
// Fit Method:          HERMITE_CUBIC or HERMITE_QUINTIC
// Sample Count:        SAMPLES_HIGH (100 000)
//                      SAMPLES_LOW  (10 000)
//                      SAMPLES_FAST (1 000)
// Time Step:           0.05 Seconds
// Max Velocity:        1.7 m/s
// Max Acceleration:    2.0 m/s/s
// Max Jerk:            60.0 m/s/s/s
    Trajectory trajectory = Pathfinder.generate(points, config);
    double wheelbase_width = 0.6;
    TankModifier modifier = new TankModifier(trajectory);
    Trajectory left  = modifier.getLeftTrajectory();       // Get the Left Side
    Trajectory right = modifier.getRightTrajectory();      // Get the Right Side



    Pathfinding(){
        modifier.modify(wheelbase_width);
		
		PathFollower leftFollower = new PathFollower(modifier.getLeftTrajectory());
		PathFollower rightFollower = new PathFollower(modifier.getRightTrajectory());
		
		leftFollower.configurePIDVA(
            1, // proportional
			0.0,//integral
			0.0,//derivative
			0.5,//Max velocity percentage of totakl
			0.5);//acceleration

		rightFollower.configurePIDVA(
            1, // proportional
            0.0,//integral
            0.0,//derivative
            0.5,//Max velocity percentage of totakl
            0.5);//acceleration

		leftFollower.reset();
		rightFollower.reset();
        

    }

    
}


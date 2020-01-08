/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;
/**
 * Add your docs here.
 */
public class Grain {
    public Procedure procedure; //will be a void method
    public TC tCondition; //will be a method that returns a boolean
    public Procedure tProcedure; //will be a void method
    public boolean dead;
     
    public Grain(Procedure procedure, TC tCondition, Procedure tProcedure){
        this.procedure = procedure;
        this.tCondition = tCondition;
        this.tProcedure = tProcedure;
    }

    public void run(){
            if(!tCondition.ask()) {
                procedure.run();
            }
            else{
                tProcedure.run();
                dead = true;
            }
        }  
    }
        

 


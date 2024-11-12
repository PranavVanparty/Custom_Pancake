// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.revrobotics.CANSparkMax;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;



public class DriveTrain extends SubsystemBase {
  /** Creates a new DriveTrain. */
  private CANSparkMax m_leftFront = new CANSparkMax(0, CANSparkMax.MotorType.kBrushless);
  private CANSparkMax m_leftBack = new CANSparkMax(1, CANSparkMax.MotorType.kBrushless);
  private CANSparkMax m_rightFront = new CANSparkMax(2, CANSparkMax.MotorType.kBrushless);
  private CANSparkMax m_rightBack = new CANSparkMax(3, CANSparkMax.MotorType.kBrushless);


  private DifferentialDrive m_drive;
  
  

  public DriveTrain() {

    m_rightFront.setInverted(true);
    m_rightBack.setInverted(true); 

    //m_rightBack.follow(m_rightFront);
    //m_leftBack.follow(m_leftFront);

    MotorControllerGroup m_left = new MotorControllerGroup(m_leftFront, m_leftBack);
    MotorControllerGroup m_right = new MotorControllerGroup(m_rightFront, m_rightBack);


    m_drive = new DifferentialDrive(m_left, m_right);
   }

  public void arcadeDrive(double speed, double rotation) {
    // To only have the robot going at half its max speed, you need to scale it by 0.5
    speed *= 2;
    rotation *= 2;

    m_drive.arcadeDrive(speed,rotation);
  }


  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}

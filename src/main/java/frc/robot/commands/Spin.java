// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.DriveTrain;

public class Spin extends Command {
  /** Creates a new Spin. */
  private DriveTrain m_driveTrain;
  public long m_duration;
  public double m_speed;
  public long m_startTime;
  public double m_rotation;

  // Todo: add a way to make it spin for a set amount of time (ie 5 seconds because we dont know the angle of the robot hence we have to rely on time)


  public Spin(DriveTrain thDriveTrain, double theSpeed, double theRotation, long theDuration) {
    // Use addRequirements() here to declare subsystem dependencies.
    m_driveTrain = thDriveTrain;
    addRequirements(m_driveTrain);

    m_speed = theSpeed;
    m_rotation = theRotation;
    m_duration = theDuration;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    m_startTime = System.currentTimeMillis();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_driveTrain.arcadeDrive(m_speed, m_rotation);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return (System.currentTimeMillis() - m_startTime) >= m_duration;
  }
}

package com.team303.robot.commands.drive;

import static com.team303.robot.Robot.ALLIANCE_SUBSTATION_ID;
import static com.team303.robot.Robot.arm;
import static com.team303.robot.Robot.photonvision;
import static com.team303.robot.Robot.poseTracker;
import com.team303.robot.Robot;
import static com.team303.robot.RobotMap.IOConstants.DEADBAND_FILTER;

import com.team303.robot.Robot;
import com.team303.robot.RobotMap.Swerve;
import com.team303.robot.modules.Photonvision.PhotonPipeline;

import edu.wpi.first.math.geometry.Translation2d;
import edu.wpi.first.math.geometry.Translation3d;
import edu.wpi.first.wpilibj2.command.CommandBase;
import com.team303.robot.modules.Photonvision.CameraName;

public class DefaultDrive extends CommandBase {

    boolean fieldOriented;

    public DefaultDrive(boolean fieldOriented) {
        addRequirements(Robot.swerve);
        this.fieldOriented = fieldOriented;
    }

    @Override
    public void execute() {
        Robot.swerve.drive(
                new Translation2d(
                        DEADBAND_FILTER.applyDeadband(Robot.getRightJoyStick().getX(), DEADBAND_FILTER.getLowerBound())
                                * Swerve.MAX_VELOCITY,
                        DEADBAND_FILTER.applyDeadband(Robot.getRightJoyStick().getY(), DEADBAND_FILTER.getLowerBound())
                                * Swerve.MAX_VELOCITY),
                DEADBAND_FILTER.applyDeadband(Robot.getLeftJoyStick().getY(), DEADBAND_FILTER.getLowerBound()),
                fieldOriented);
    } 
    /* 
    if (photonvision.getPipeline(CameraName.CAM1) != PhotonPipeline.APRILTAG) {
        photonvision.setPipeline(CameraName.CAM1, PhotonPipeline.APRILTAG);
    }*/
    /* 
    //TODO: Find good area threshold
    if (photonvision.getBestTarget(CameraName.CAM1).getFiducialId() == ALLIANCE_SUBSTATION_ID && photonvision.getBestTarget(CameraName.CAM1).getArea() >= 1) {
        photonvision.setPipeline(CameraName.CAM1, PhotonPipeline.CUBE);
        if (!photonvision.hasTargets(CameraName.CAM1)) {
            photonvision.setPipeline(CameraName.CAM1, PhotonPipeline.CONE);
        }
        Translation3d armToPiece = poseTracker.getArmtoTargetTranslation();
        //TODO: Find optimal part of cone to grab
        arm.reach(armToPiece.plus(new Translation3d()));
    //FIXME: Change when we introduce more cameras
    //FIXME: Change when we create autonomous driving during teleop and move it to the autonomous part
    }*/
        
    
}

package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;

public class Robot {
    //public BNO055IMU imu_hub1;
    MecanumDriveTrain  mecanumDriveTrain;
    Vision      vision;
    IMUControl          imuControl;
    Arm_centerSTAGE      arm_centerstage;

    ElapsedTime autonomusTime;
    final LinearOpMode opMode;

    public Robot (LinearOpMode opMode){
        this.opMode         = opMode;
        this.autonomusTime  = new ElapsedTime();
        this.mecanumDriveTrain     = new MecanumDriveTrain(this);
        this.arm_centerstage =  new Arm_centerSTAGE(this );
        this.imuControl     = new IMUControl(this);
        this.vision     = new Vision(this);
    }

    public MecanumDriveTrain getMecanumDriveTrain()     {return this.mecanumDriveTrain;}
    public Vision getVision() {return this.vision;}
    public IMUControl        getImuControl()     {return this.imuControl;}
    public Arm_centerSTAGE  getArm_centerSTAGE()  {return this.arm_centerstage;}
}

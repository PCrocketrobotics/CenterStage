package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.Servo;

public class Arm_centerSTAGE {
    public DcMotor Arm_liftMotor;
    public DcMotor Pixle_SuckUP;
    public Servo Pixle_drop;
    public Servo Ariplane_shooter;
    public DcMotor Hanging_arm;
    public DcMotor Hanging_wrench;



    Robot robot;

    public Arm_centerSTAGE(Robot robot) {
        this.robot = robot;
    }


    public void init() {
        Arm_liftMotor = robot.opMode.hardwareMap.get(DcMotor.class, "armlift");
        Pixle_SuckUP = robot.opMode.hardwareMap.get(DcMotor.class, "Pixle_SuckUP");
        Pixle_drop = robot.opMode.hardwareMap.get(Servo.class, "Pixle_drop");
        Ariplane_shooter = robot.opMode.hardwareMap.get(Servo.class,"airplane");
        Hanging_arm = robot.opMode.hardwareMap.get(DcMotor.class,"Hangingtree");
        Hanging_wrench = robot.opMode.hardwareMap.get(DcMotor.class,"Hanging_wrench");

        Hanging_wrench.setDirection(DcMotorSimple.Direction.FORWARD);
        Hanging_arm.setDirection(DcMotorSimple.Direction.FORWARD);
        Arm_liftMotor.setDirection(DcMotorSimple.Direction.FORWARD);
        Pixle_SuckUP.setDirection(DcMotorSimple.Direction.REVERSE);

        Arm_liftMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        Arm_liftMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        Hanging_arm.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        Arm_liftMotor.setPower(0);
    }
    public void setPixle_drop() {
        if(robot.opMode.gamepad2.triangle) {
            Pixle_drop.setPosition(.15);
        }
            else{
            Pixle_drop.setPosition(0);
        }
    }
    public void setAriplane_shooter(){
        if (robot.opMode.gamepad2.circle){
            Ariplane_shooter.setPosition(.3);
        }
        else {
            Ariplane_shooter.setPosition(.0);
        }
    }
    public void setHANGING() {
        if (robot.opMode.gamepad1.dpad_down) {
            Hanging_wrench.setPower(.5);
        } else {
            Hanging_wrench.setPower(0);
        }
        if (robot.opMode.gamepad1.circle) {
            Hanging_arm.setPower(.85);
        } else {
            Hanging_arm.setPower(0);

        }
    }
    public void setArm_liftMotor() {
        if (robot.opMode.gamepad2.square){
            Pixle_SuckUP.setDirection(DcMotorSimple.Direction.REVERSE);
            Pixle_SuckUP.setPower(1);
        }else {
            Pixle_SuckUP.setPower(0);
        }
        if (robot.opMode.gamepad2.cross) {
            Pixle_SuckUP.setDirection(DcMotorSimple.Direction.FORWARD);
            Pixle_SuckUP.setPower(1);
        }else {
            Pixle_SuckUP.setPower(0);
        }

        if (robot.opMode.gamepad2.dpad_up) {
            Arm_liftMotor.setTargetPosition(6000);


        }
        if (robot.opMode.gamepad2.dpad_left) {
            Arm_liftMotor.setTargetPosition(4500);
            Arm_liftMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            Arm_liftMotor.setPower(1);

        }
        if (robot.opMode.gamepad2.dpad_right) {
            Arm_liftMotor.setTargetPosition(1800);
            Arm_liftMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            Arm_liftMotor.setPower(1);

        }
        if (robot.opMode.gamepad2.dpad_down) {
            Arm_liftMotor.setTargetPosition(-10);
            Arm_liftMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            Arm_liftMotor.setPower(1);

        }




    }



}




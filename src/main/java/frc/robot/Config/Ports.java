package frc.robot.Config;

public class Ports {

    public class pAimer {
        public static int[] // UNCHECKED
            PCM_Lft = { 0, 1 },
            PCM_Rgt = { 2, 3 };
    }

    public class pClimber {
        public static int
            CAN_Climber = 19, // PROBABLE
            HUB_Climber = 0;
    }

    public class pFlipper {
        public static int 
            PWM_Servo = 0,
            HUB_Servo = 0;
    }

    public class pIntake {
        public static int
            CAN_Lft = 5,
            CAN_Rgt = 6,

            HUB_Lft = 0,
            HUB_Rgt = 0;
    }

    public class pMover {
        public static int
            CAN_Mover = 0, // UNCHECKED, SPARKMAX ?
            HUB_Mover = 0;
    }

    public class pRoller {
        public static int
            CAN_Roller = 3,
            HUB_Roller = 0;
    }

    public class pShooter {
        public static int
            CAN_Hi = 9,
            CAN_Lo = 10,

            HUB_HI = 0,
            HUB_Lo = 0;
    }

    public class pSonar {
        public static int[]
            DIO_Frt = { 0, 0 },
            DIO_Bck = { 0, 0 };
    }

    public class pStick {
        public static int
            USB_DS = 0,
            USB_MS = 1;
    }

    public class pSwerve {
        public static int[]
            CAN_FL = { 12, 11, 5 },
            CAN_FR = { 14, 13, 6 },
            CAN_BL = { 18, 17, 8 },
            CAN_BR = { 16, 15, 7 },

            HUB_FL = { 0, 0 },
            HUB_FR = { 0, 0 },
            HUB_BL = { 0, 0 },
            HUB_BR = { 0, 0 };
    }

}

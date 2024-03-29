package frc.robot.Config;

public class Ports {

    public class pAimer {
        public static int[]
            PCM_Lft = { 0, 0 },
            PCM_Rgt = { 0, 0 };
    }

    public class pClimber {
        public static int
            CAN_Climber = 0,
            HUB_Climber = 0;
    }

    public class pFlipper {
        public static int 
            CAN_Servo = 0,
            HUB_Servo = 0;
    }

    public class pIntake {
        public static int
            CAN_Lft = 0,
            CAN_Rgt = 0,

            HUB_Lft = 0,
            HUB_Rgt = 0;
    }

    public class pMover {
        public static int
            CAN_Mover = 0,
            HUB_Mover = 0;
    }

    public class pRoller {
        public static int
            CAN_Roller = 0,
            HUB_Roller = 0;
    }

    public class pShooter {
        public static int
            CAN_Hi = 0,
            CAN_Lo = 0,

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
            CAN_FL = { 0, 0, 0 },
            CAN_FR = { 0, 0, 0 },
            CAN_BL = { 0, 0, 0 },
            CAN_BR = { 0, 0, 0 },

            HUB_FL = { 0, 0 },
            HUB_FR = { 0, 0 },
            HUB_BL = { 0, 0 },
            HUB_BR = { 0, 0 };
    }

}

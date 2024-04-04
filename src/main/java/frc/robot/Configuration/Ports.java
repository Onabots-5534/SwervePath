package frc.robot.Configuration;

public class Ports {

    public class pAimer {
        public static int[] // UNCHECKED
            PCM_Lft = { 0, 1 },
            PCM_Rgt = { 2, 3 };
    }

    public class pClimber { // Talon FX
        public static int
            CAN_Climber = 19,
            HUB_Climber = 0;
    }

    public class pFlipper { // Servo
        public static int 
            PWM_Servo = 0,
            HUB_Servo = 0;
    }

    public class pIntake { // Spark Max
        public static int
            CAN_Lft = 1,
            CAN_Rgt = 2,

            HUB_Lft = 0,
            HUB_Rgt = 0;
    }

    public class pLED { // Programmable LEDs
        public static int
            PWM_LED = 2;
    }

    public class pMover { // Spark Max
        public static int
            CAN_Mover = 3,
            HUB_Mover = 0;
    }

    public class pRoller { // Talon SRX
        public static int
            CAN_Roller = 4, 
            HUB_Roller = 0;
    }

    public class pShooter { // Talon FX
        public static int
            CAN_Hi = 9,
            CAN_Lo = 10,

            HUB_HI = 0,
            HUB_Lo = 0;
    }

    public class pSonar { // Untested
        public static int[]
            DIO_Frt = { 0, 0 },
            DIO_Bck = { 0, 0 };
    }

    public class pStick {
        public static int
            USB_DS = 0,
            USB_MS = 1;
    }

    public class pSwerve { // Talon FX
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

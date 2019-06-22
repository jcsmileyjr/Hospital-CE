package Hospital;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public  static void main(String[] args){

        System.out.println("Several Doctors have came to work at Saint John Pet Hospital. We treat your pet like FAMILY");
        Hospital.checkInDoctor("Bob");
        Hospital.checkInDoctor("Greg");

        System.out.println("\n Several pets are checking into Saint John Pet Hospital");
        Hospital.checkInPatient("Shelly the Turtle", "Hiding in Shell", 5.5, "Bob");
        Hospital.checkInPatient("FishSticks the GoldFish", "Flying", 3.00, "Bob");
        Hospital.checkInPatient("Crazy the Cat", "Doing yoga", 10.00, "Greg");

        System.out.println("\n Let's view all working doctors");
        Hospital.viewAllDoctor();

        System.out.println("\n Let's view all patients");
        Hospital.viewAllPatients();

        System.out.println("\n Check out Shelly the Turtle");
        Hospital.checkOutPatient("Bob", "Shelly the Turtle");

    }
}

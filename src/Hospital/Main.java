package Hospital;

import javax.net.ssl.HostnameVerifier;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public  static void main(String[] args){
        String openForBusiness = "open";

        //while open, interface will ask the questions
        while(openForBusiness.equals("open")){
            Scanner menuChoice = new Scanner(System.in);
            System.out.println("\n Please type in a number to make your choice \n 1) Check-in Doctor \n 2) Check-in Patient \n 3) Check-out Patient \n )4 View all Current Patients \n 5) Exit");
            int choice = menuChoice.nextInt();
            System.out.println("Your choice was " + choice);

            //INTERFACE TO CLOCK IN A DOCTOR
            if(choice == 1){
                Scanner doctorBadge = new Scanner(System.in);//create a Scanner object to get user input
                System.out.println("Which doctor has come to volunteer today?");//ask a question
                String doctorName = doctorBadge.next();//get the user string input
                Hospital.checkInDoctor(doctorName);//create a doctor object to work in the Hospital
            }

            //INTERFACE TO CHECK-IN A PATIENT
            if(choice == 2){
                Scanner newPet = new Scanner(System.in);    //create a Scanner object to accept user inputs

                System.out.println("What is your fantastic pet name");
                String petName = newPet.nextLine();//get the user pet game

                System.out.println("What is wrong with your pet");
                String petAilment = newPet.nextLine();//get the user pet treatement

                System.out.println("How much would you like to donate to Saint John Pet Hospital");
                double money = Double.parseDouble(newPet.nextLine());//get the user donation amount by converting the string

                System.out.println("Choose a doctor");
                Hospital.viewAllDoctor();//view all doctors
                String petDoctor = newPet.next();//get user choice of doctor

                Boolean doctorExist = Hospital.ifDoctorExist(petDoctor);//check if doctor exist
                if(doctorExist){//if exist, add patient to doctor care
                    Hospital.checkInPatient(petName, petAilment, money, petDoctor);
                }else{
                    System.out.println("There is no doctor by that name working today.");
                }

            }//end of choice 2

            if(choice == 3){
                Scanner findPet = new Scanner(System.in);
                System.out.println("What is your pet name?");
                String curedPetName = findPet.next();

                Doctor myPetDoctor = Hospital.findMyPetDoctor(curedPetName);//find the pet's doctor
                Hospital.checkOutPatient(myPetDoctor.getDoctorName(), curedPetName);//checkout the pet

            }//end of choice 3

            if(choice == 4){
                Hospital.viewAllPatients();
            }//end of choice 4

            if(choice == 5){
                openForBusiness = "close";
            }//end of choice 5
        }


    }


}

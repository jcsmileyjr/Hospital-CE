package Hospital;

import javax.print.Doc;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Hospital {
    private static List<Doctor> doctors = new ArrayList<>();

    public Hospital(){}

    public static void checkInDoctor(String name){
        Doctor doc  = new Doctor(name);
        doctors.add(doc);
        System.out.println("Doctor " + doc.getDoctorName() + " is ready to treat patients");
    }

    public static void checkInPatient(String name, String treatment, double donation, String doctorName){
        //create patient
        Patient pet = new Patient(name, treatment, donation, doctorName);

        //find the doctor, add the patient to the doctor care, and show that the doctor acknowledge them
        Doctor doc =  Hospital.findDoctor(doctorName);
        doc.newPatient(pet);
        doc.viewPatient(pet);
    }

    //find a specific doctor based on name
    public static Doctor findDoctor(String doctorName){
        Doctor foundDoctor = null;
        for(Doctor doc: doctors){
            if(doc.getDoctorName().equals(doctorName)){
                int isHere = doctors.indexOf(doc);
                foundDoctor = doctors.get(isHere);
            }
        }
        return foundDoctor;
    }

    //NOT USED ANYWHERE YET
    public static Boolean ifDoctorExist(String doctorName){
        Boolean foundDoctor = false;
        for(Doctor doc: doctors){
            if(doc.getDoctorName().equals(doctorName)){
                foundDoctor = true;
            }
        }
        return foundDoctor;
    }

    public static Doctor findMyPetDoctor(String petName){
        Doctor foundDoc = null;//used to hold found doctor
        for(Doctor doc: doctors){//Loop through a array of doctors
            List<Patient> pets = doc.getDoctorListOfPatient();//get each doctor list of patients
            for(Patient pet: pets){//Loop through a array of pets that belong to each doctor
                if(pet.getFullname()==petName){
                    foundDoc = doc;
                }
            }
        }
        return foundDoc;
    }

    public static void checkOutPatient( String doctorName,String petName){
        Doctor doc = Hospital.findDoctor(doctorName);

        List<Patient> listOfPets = doc.getDoctorListOfPatient();

        for(int j = 0; j<listOfPets.size();j++){
            Patient pet = listOfPets.get(j);
            if(pet.getFullname().equals(petName)){
                Patient foundPet = listOfPets.get(j);
                doc.checkoutPatient(foundPet);
                break;
            }
        }
    }

    //print all patients in Hospital
    public static void viewAllPatients(){
        //loop through all doctors
        for(Doctor doc : doctors){
            doc.viewAllDoctorPatients(); //print their patient names
        }
    }

    //print all Doctors checked in
    public static void viewAllDoctor(){
        for(Doctor doc : doctors){
            System.out.println("Doctor " + doc.getDoctorName() + " is working today.");
        }
    }

    //Return a array of doctor objects
    public static List <Doctor> getDoctors(){
        return doctors;
    }

    //View a chosen doctor's schedule
    public static void viewDoctorSchedule(String doctorName){
        Doctor doc = Hospital.findDoctor(doctorName);
        doc.printSchedule();
    }


}


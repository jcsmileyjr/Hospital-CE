package Hospital;

import javax.print.Doc;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Hospital {
    private static List<Doctor> doctors = new ArrayList<>();

    public Hospital(){}

    //Get a name from the user to create a Doctor and add that doctor to the array of doctors
    public static void checkInDoctor(String name){
        Doctor doc  = new Doctor(name);//create new Doctor instance
        doctors.add(doc);//add new Doctor instance to array
        System.out.println("Doctor " + doc.getDoctorName() + " is ready to treat patients");
    }

    //Create a new Patient, find the doctor ask for, add the pet that doctor's list, and view the Patient
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

    //check if a doctor exist by getting the doctor name, comparing it to each known doc, and return a boolean
    public static Boolean ifDoctorExist(String doctorName){
        Boolean foundDoctor = false;
        for(Doctor doc: doctors){//loop through the array of doctors
            if(doc.getDoctorName().equals(doctorName)){//if the doctor name match the name enter by the user
                foundDoctor = true;
            }
        }
        return foundDoctor;
    }

    //Find a pet's doctor instance by using the pet name
    public static Doctor findMyPetDoctor(String petName){
        Doctor foundDoc = null;//used to hold found doctor
        for(Doctor doc: doctors){//Loop through a array of doctors
            List<Patient> pets = doc.getDoctorListOfPatient();//get each doctor list of patients
            for(Patient pet: pets){//Loop through a array of pets that belong to each doctor
                if(pet.getFullname().equals(petName)){//check if the current pet name match the user given name
                    foundDoc = doc;//if there is a match, return that doctor instance
                    break;
                }
            }
        }
        return foundDoc;
    }

    //Check out/remove a pet from a doctor list
    public static void checkOutPatient( String doctorName,String petName){
        Doctor doc = Hospital.findDoctor(doctorName);//find the instance by using his name

        List<Patient> listOfPets = doc.getDoctorListOfPatient();//get the list of pets for that doctor

        for(int j = 0; j<listOfPets.size();j++){//loop through the list of pets
            Patient pet = listOfPets.get(j);//get the pet of the current loop
            if(pet.getFullname().equals(petName)){//check if that pet name match the user enter pet name
                Patient foundPet = listOfPets.get(j);//if it match, get that pet
                doc.checkoutPatient(foundPet);//remove pet from the doctor list of pets
                break;
            }
        }
    }

    //print all patients in Hospital
    public static void viewAllPatients(){
        //loop through all doctors
        for(Doctor doc : doctors){//loop through list of doctors
            doc.viewAllDoctorPatients(); //print their patient names
        }
    }

    //print all Doctors checked in
    public static void viewAllDoctor(){
        for(Doctor doc : doctors){//loop through list of doctors
            System.out.println("Doctor " + doc.getDoctorName() + " is working today.");
        }
    }

    //Return a array of doctor objects
    public static List <Doctor> getDoctors(){
        return doctors;
    }

    //View a chosen doctor's schedule
    public static void viewDoctorSchedule(String doctorName){
        Doctor doc = Hospital.findDoctor(doctorName);//find the doctor instance by the name enter by the user
        doc.printSchedule();//print the schedule for all pets on the doctor's list
    }


}


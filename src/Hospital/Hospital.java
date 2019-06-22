package Hospital;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Hospital {
    private static List<Doctor> doctors = new ArrayList<>();
    private static Doctor foundDoctor;

    public Hospital(){}

    public static void checkInDoctor(String name){
        Doctor doc  = new Doctor(name);
        doctors.add(doc);
        System.out.println("Doctor " + doc.getDoctorName() + " is ready to treat patients");
    }

    public static void checkInPatient(String name, String treatment, double donation, String doctorName){
        //create patient
        Patient pet = new Patient(name, treatment, donation, doctorName);

        //find doctor and add patient
        for(Doctor doc : doctors){
            if(doc.getDoctorName().equals(doctorName)){
                int isHere = doctors.indexOf(doc);//find the index of the pet in the array
                Doctor foundDoctor = doctors.get(isHere);//get the pet from the array
                foundDoctor.newPatient(pet);//add patient to doctor care
                foundDoctor.viewPatient(pet);//show that the pet is being treated by a doctor
                break;
            }
        }
        //Doctor foundDoctor = Hospital.findDoctor(doctorName);
        //foundDoctor.newPatient(pet);//add patient to doctor care
        //foundDoctor.viewPatient(pet);//show that the pet is being treated by a doctor
    }

    /*    //Could not get to work
        public static Doctor findDoctor(String doctorName){
            Doctor foundDoctor;
            for(Doctor doc: doctors){
                if(doc.getDoctorName().equals(doctorName)){
                    int isHere = doctors.indexOf(doc);
                    return foundDoctor = doctors.get(isHere);

                }
            }
        }
        */
    public static void checkOutPatient( String doctorName,String petName){

        for(int i = 0;i<doctors.size();i++){
            Doctor doc = doctors.get(i);
            if (doc.getDoctorName().equals(doctorName)) {
                foundDoctor = doc;
                break;
            }
        }

        List<Patient> listOfPets = foundDoctor.getDoctorListOfPatient();

        for(int j = 0; j<listOfPets.size();j++){
            Patient pet = listOfPets.get(j);
            if(pet.getFullname().equals(petName)){
                Patient foundPet = listOfPets.get(j);
                foundDoctor.checkoutPatient(foundPet);
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

    public static void viewAllDoctor(){
        for(Doctor doc : doctors){
            System.out.println("Doctor " + doc.getDoctorName() + " is working today.");
        }
    }


}


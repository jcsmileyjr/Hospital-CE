package Hospital;

import java.util.ArrayList;
import java.util.List;

public class Doctor {
    private String fullName;
    private List<Patient> patient = new ArrayList<>();

    public Doctor(String aFullName){
        fullName = aFullName;
    }

    //create a new patient and add to the patient array
    public void newPatient(Patient pet){
        patient.add(pet);
    }

    //get the name of the current doctor instance
    public String getDoctorName(){
        return this.fullName;
    }

    //Remove a pet from a doctor.
    public void checkoutPatient(Patient pet){
        System.out.println(pet.getFullname() + " have been cured of " + pet.getTreament() +" &  has checkout.");
        patient.remove(pet);
    }

    //print the doctor's schedule of pet treatments
    public void printSchedule(){
        for(Patient pet : patient){//loop through the array of pets
            System.out.println(pet.getFullname() + " is in the Hospital for " + pet.getTreament());
        }
    }

    //view a chosen pet
    public void viewPatient(Patient pet){
        int isHere = patient.indexOf(pet);//find the index of the pet in the array
        Patient foundPet = patient.get(isHere);//get the pet from the array
        System.out.println(foundPet.getFullname() + " is being treated for " + foundPet.getTreament() + " and is a patient of " + this.fullName);//print the name of the pet
    }

    //view all pets under the care of this doctor
    public  void viewAllDoctorPatients(){
        for(Patient pet : patient){//loop through a array of pets
            System.out.println(pet.getFullname()+ " is being treated for " + pet.getTreament() +  " and is a patient of " + this.fullName);
        }
    }

    //used in Hospital check out patient method
    public List<Patient> getDoctorListOfPatient(){
        return patient;

    }

}


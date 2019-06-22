package Hospital;

import java.util.List;

public class Patient {
    private String fullname;
    private String treament;
    private double donation;
    private String doctorName;

    public Patient(String fullname, String treament, double donation, String doctorName) {
        this.fullname = fullname;
        this.treament = treament;
        this.donation = donation;
        this.doctorName = doctorName;//??????? Is this needed
    }

    public String getFullname() {
        return fullname;
    }

    public String getTreament() {
        return treament;
    }

    public double getDonation() {
        return donation;
    }

    public String getDoctorName() {
        return doctorName;
    }
}

package entity;

public class Patient {

    private int id_patient;
    private String name;
    private String lastname;
    private String date_birth;
    private double identification_document;

    public Patient() {
    }

    public Patient(int id_patient, String name, String lastname, String date_birth, double identification_document) {
        this.id_patient = id_patient;
        this.name = name;
        this.lastname = lastname;
        this.date_birth = date_birth;
        this.identification_document = identification_document;
    }

    public int getId_patient() {
        return id_patient;
    }

    public void setId_patient(int id_patient) {
        this.id_patient = id_patient;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getDate_birth() {
        return date_birth;
    }

    public void setDate_birth(String date_birth) {
        this.date_birth = date_birth;
    }

    public double getIdentification_document() {
        return identification_document;
    }

    public void setIdentification_document(double identification_document) {
        this.identification_document = identification_document;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "id_patient=" + id_patient +
                ", name='" + name + '\'' +
                ", lastname='" + lastname + '\'' +
                ", date_birth='" + date_birth + '\'' +
                ", identification_document=" + identification_document +
                '}';
    }
}

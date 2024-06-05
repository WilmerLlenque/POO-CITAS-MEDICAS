package Model;

import java.util.ArrayList;
import java.util.List;

public class Patient extends User{

    //ATRIBUTOS && PROPIEDADES
    private String birthday;
    private double weight;
    private double height;
    private String blood;
    private List<AppointmentDoctor> citasDisponiblesDoctor=new ArrayList<>();
    private List<AppointmentNurse> citasDisponiblesNurse=new ArrayList<>();

    //METODO CONSTRUCTOR
    public Patient(String name, String email,String birthday) {
        super(name, email);
        this.birthday=birthday;
    }

    //GETTERS && SETTERS
    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public String getBlood() {
        return blood;
    }

    public void setBlood(String blood) {
        this.blood = blood;
    }

    public List<AppointmentDoctor> getCitasDisponiblesDoctor() {
        return citasDisponiblesDoctor;
    }

    public void setCitasDisponiblesDoctor(List<AppointmentDoctor> citasDisponiblesDoctor) {
        this.citasDisponiblesDoctor = citasDisponiblesDoctor;
    }

    public List<AppointmentNurse> getCitasDisponiblesNurse() {
        return citasDisponiblesNurse;
    }

    public void setCitasDisponiblesNurse(List<AppointmentNurse> citasDisponiblesNurse) {
        this.citasDisponiblesNurse = citasDisponiblesNurse;
    }

    //OTROS METODOS
    public void addCitasDisponiblesDoctor(Doctor doctor, String date, String time){
        this.citasDisponiblesDoctor.add(new AppointmentDoctor(doctor,date,time));
    }

    @Override
    public String toString() {
        return super.getName();
    }
}

package Model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AppointmentDoctor implements ISchedulable{

    //ATRIBUTOS && PROPIEDADES
    private int id;
    private Patient patient;
    private Doctor doctor;
    private Date date;
    private String time;
    SimpleDateFormat formater=new SimpleDateFormat("dd/MM/yyyy");

    //METODOS CONSTRUCTORES
    public AppointmentDoctor() {
    }
    public AppointmentDoctor(Doctor doctor, String date, String time) {
        try {
            this.date=formater.parse(date);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        this.doctor = doctor;
        this.time = time;
    }

    //GETTERS && SETTERS
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    //OTROS METODOS
    @Override
    public void schedulable(Date date, String time) {
    }
    @Override
    public String toString() {
        return "Doctor: " + doctor +", Date:" + date +", Time:" + time;
    }
}

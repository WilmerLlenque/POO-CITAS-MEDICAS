package Model;

import java.util.ArrayList;
import java.util.List;

public class Doctor extends User{

    //ATRIBUTOS && PROPIEDADES
    private String speciality;
    public List<CitasDisponibles> citasDisponibles=new ArrayList<>();

    //METODO CONSTRUCTOR
    public Doctor(String name,String email,String speciality){
        super(name,email);
        this.speciality=speciality;
    }

    //GETTERS && SETTERS
    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    public List<CitasDisponibles> getCitasDisponibles() {
        return citasDisponibles;
    }

    public void setCitasDisponibles(List<CitasDisponibles> citasDisponibles) {
        this.citasDisponibles = citasDisponibles;
    }

    //OTROS METODOS
    public void addCitasDisponibles(String date, String time){
        this.citasDisponibles.add(new CitasDisponibles(date,time));
    }

    @Override
    public String toString() {
        return super.getName();
    }


}

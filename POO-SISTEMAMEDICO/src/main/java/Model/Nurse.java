package Model;

public class Nurse extends User{

    //ATRIBUTOS && PROPIEDADES
    private String speciality;

    //METODO CONSTRUCTOR
    public Nurse(String name, String email) {
        super(name, email);
    }

    //GETTERS && SETTERS
    protected String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

}

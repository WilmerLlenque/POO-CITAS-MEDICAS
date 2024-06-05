package Model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CitasDisponibles {

    //ATRIBUTOS && PROPIEDADES
    private int id;
    private Date date;
    private String time;
    SimpleDateFormat formater=new SimpleDateFormat("dd/MM/yyyy");

    //METODO CONSTRUCTOR
    public CitasDisponibles(String date, String time) {
        try {
            this.date=formater.parse(date);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        this.time = time;
    }

    //GETTERS && SETTERS
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate(Date date) {
        return date;
    }
    public String getDate(){
        return formater.format(date);
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
    public String toString() {
        return "Date: " + date + ", Time: " + time;
    }
}

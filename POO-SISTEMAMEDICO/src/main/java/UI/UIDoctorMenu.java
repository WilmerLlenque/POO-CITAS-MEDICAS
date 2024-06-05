package UI;


import Model.AppointmentDoctor;
import Model.CitasDisponibles;
import Model.Doctor;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UIDoctorMenu {
    private static Scanner entrada=new Scanner(System.in);
    public static List<Doctor> doctoresConCitasDisponibles=new ArrayList<>();
    private static final String[] meses={"Enero","Febrero","Marzo"};
    public static void MenuDoctor(){
        int opcion=0;
        do {
            System.out.println("\n\n");
            System.out.println("Menu Doctor");
            System.out.println("Bienvenido Doctor - "+UIMenu.doctorLogged);
            System.out.println("1.- Agregar citas disponibles\n2.- Mis citas programadas\n" +
                    "0.- Logout\nDigite una opcion: ");
            opcion=entrada.nextInt();
            switch (opcion){
                case 1:
                    agregarCitasDisponibles();
                    break;
                case 2:
                    misCitasProgramadas();
                    break;
                case 0:
                    System.out.println("\n\n");
                    break;
                default:
                    System.out.println("Digite otra opcion valida");
                    break;
            }

        }while (opcion!=0);
    }

    public static void agregarCitasDisponibles(){
        int mesSelected=-1;
        do {

            System.out.println("Agregar Citas Disponibles");
            System.out.println(":: Selecciona un Mes");
            for (int i = 0; i < meses.length; i++) {
                System.out.println((i+1)+". "+meses[i]);

            }
            System.out.println("0.- return");
            mesSelected=entrada.nextInt();
            if(mesSelected>=1 && mesSelected<4){
                System.out.println("Mes -> "+meses[mesSelected-1]);
                int fechaCorrect=0;
                do {
                    System.out.println("Inserte la fecha disponible: [dd/mm/yyyy]");
                    String fechaSelected=entrada.next();

                    System.out.println("La fecha es "+fechaSelected);
                    System.out.println("1. Correcto.\n2. Cambiar de Fecha.");
                    fechaCorrect=entrada.nextInt();
                    if (fechaCorrect==2) {
                        continue;
                    }

                    if (fechaCorrect==1){
                        int hourCorrect=0;
                        String hourSelected="";
                        do {
                            System.out.println("Inserte la hora de la cita para esta fecha: "+fechaSelected+" [16:00]");
                            hourSelected=entrada.next();
                            System.out.println("La hora es "+hourSelected);

                            System.out.println("1. Correcto.\n2. Cambiar de hora.");
                            hourCorrect=entrada.nextInt();
                        }while (hourCorrect!=1);

                        UIMenu.doctorLogged.addCitasDisponibles(fechaSelected,hourSelected);
                        checkearDoctoresConCitasDisponibles(UIMenu.doctorLogged);
                        for (CitasDisponibles citas:UIMenu.doctorLogged.getCitasDisponibles()){
                            System.out.println(citas);
                        }
                    }

                }while (fechaCorrect!=1);
            }
        }while (mesSelected!=0);
    }
    public static void misCitasProgramadas(){
        /*int option=0;
        List<CitasDisponibles> misCitasProgramadas;
        do {
            misCitasProgramadas=UIMenu.doctorLogged.citasDisponibles;
            System.out.println("::My Apointments");
            if (misCitasProgramadas.size()==0){
                System.out.println("Don´t have appointments");
                break;
            }
            for (int i = 0; i < misCitasProgramadas.size(); i++) {
                System.out.println((i+1)+". Date: "+misCitasProgramadas.get(i).getDate()+" ; " +
                        "Time: "+misCitasProgramadas.get(i).getTime());
            }
        }while(option!=0);*/

        boolean disponible=false;
        for (int i = 0; i < UIPatientMenu.pacientesConCitasDisponibles.size(); i++) {
            List<AppointmentDoctor> citasDisponibles=UIPatientMenu.pacientesConCitasDisponibles.get(i).getCitasDisponiblesDoctor();
            for (int j = 0; j < citasDisponibles.size(); j++) {
                if(UIMenu.doctorLogged.equals(citasDisponibles.get(j).getDoctor())){
                    /*System.out.println(UIPatientMenu.pacientesConCitasDisponibles.get(i)+" - "+citasDisponibles.get(j).getDate()+
                            " - "+citasDisponibles.get(j).getTime());*/
                    System.out.println(String.format("%-24s %-30s %-8s",UIPatientMenu.pacientesConCitasDisponibles.get(i),
                            citasDisponibles.get(j).getDate(),citasDisponibles.get(j).getTime()));
                    disponible=true;
                }
            }
        }
        if (disponible==false) System.out.println("Don´t have appointments");
    }

    public static void checkearDoctoresConCitasDisponibles(Doctor doctor){
        if (!doctoresConCitasDisponibles.contains(doctor)){
            doctoresConCitasDisponibles.add(doctor);
        }
    }

}

package UI;

import Model.Doctor;
import Model.Patient;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UIMenu {
    private static Scanner entrada=new Scanner(System.in);
    public static Doctor doctorLogged;
    public static Patient patientLogged;
    static List<Doctor> doctors=new ArrayList<>();
    static List<Patient> patients=new ArrayList<>();


    public static void cargarData(){
        doctors.add(new Doctor("Juan Fiestas","juan@gmail.com","pediatria"));
        doctors.add(new Doctor("Jose Ticlahuanca","jose@gmail.com","pediatria"));
        doctors.add(new Doctor("Andre Llenque","andres@gmail.com","pediatria"));

        patients.add(new Patient("wilmer llenque","wilmer@email.com","agosto"));
        patients.add(new Patient("sofia vasquez","sofia@email.com","diciembre"));
        patients.add(new Patient("eleana villalobos","elena@email.com","enero"));
    }
    public static void Menu(){
        int opcion=0;
        do {
            System.out.println("Sistemas de Citas Medicas");
            System.out.println("1.- Doctor\n2.- Paciente\n0.- Salir\nDigite una opcion: ");
            opcion=entrada.nextInt();
            switch (opcion){
                case 1:
                    Authenticacion(1);
                    break;
                case 2:
                    Authenticacion(2);
                    break;
                case 0:
                    System.out.println("¡¡ Gracias por su visita !!");
                    break;
                default:
                    System.out.println("Digite otra opcion valida");
                    break;
            }

        }while (opcion!=0);
    }

    public static void Authenticacion(int value){
        boolean emailCorrect=false;

        do {
            System.out.println("Ingrese su email : ");
            String email=entrada.next();
            if(value==1){
                for (int i = 0; i < doctors.size(); i++) {
                    if (email.equals(doctors.get(i).getEmail())) {
                        doctorLogged=doctors.get(i);
                        UIDoctorMenu.MenuDoctor();
                        emailCorrect=true;
                    }
                }
            }
            if(value==2){
                for (int i = 0; i < patients.size(); i++) {
                    if (email.equals(patients.get(i).getEmail())) {
                        patientLogged=patients.get(i);
                        UIPatientMenu.MenuPatient();
                        emailCorrect=true;
                    }
                }
            }
        }while (!emailCorrect);
    }
}

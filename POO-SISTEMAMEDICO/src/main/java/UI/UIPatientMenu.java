package UI;

import Model.AppointmentDoctor;
import Model.CitasDisponibles;
import Model.Doctor;
import Model.Patient;

import java.util.*;

public class UIPatientMenu {

    private static Scanner entrada=new Scanner(System.in);
    public static List<Patient> pacientesConCitasDisponibles=new ArrayList<>();
    public static void MenuPatient(){

        Scanner entrada=new Scanner(System.in);
        int opcion=-1;
        do {
            System.out.println("\n\n");
            System.out.println("Menu Patient");
            System.out.println("Bienvenido - "+UIMenu.patientLogged);
            System.out.println(" 1.- Reservar una cita. \n 2.- Mis citas\n " +
                    "0.- Logout\n Digite una opcion: ");
            opcion=entrada.nextInt();
            switch (opcion){
                case 1:
                    reservarCitaV2();
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


    public static void reservarCitaV2(){
        int elemento=-1;

        do {
            System.out.println("::Book an appointment");
            System.out.println("::Select date");

            Map<Integer, Map<Integer,Doctor>> doctors=new HashMap<>();
            int k=0;

            List<CitasDisponibles> citasDisponibles;
            for (int i = 0; i < UIDoctorMenu.doctoresConCitasDisponibles.size(); i++) {
                citasDisponibles=UIDoctorMenu.doctoresConCitasDisponibles.get(i).getCitasDisponibles();
                for (int j = 0; j < citasDisponibles.size(); j++) {
                    k++;
                    /*System.out.println(k+"."+UIDoctorMenu.doctoresConCitasDisponibles.get(i)+" [ "
                            +citasDisponibles.get(j).getDate()+" - "
                            +citasDisponibles.get(j).getTime()+" ] ");*/
                    System.out.println(k+". "+String.format("%-24s %-12s %-8s",UIDoctorMenu.doctoresConCitasDisponibles.get(i),
                            citasDisponibles.get(j).getDate(),citasDisponibles.get(j).getTime()));
                    Map<Integer,Doctor> doctorsAppoinments=new HashMap<>();
                    doctorsAppoinments.put(Integer.valueOf(j),UIDoctorMenu.doctoresConCitasDisponibles.get(i));
                    doctors.put(Integer.valueOf(k),doctorsAppoinments);
                }
            }
            System.out.println("0. return");
            elemento=entrada.nextInt();
            if(elemento>0 && elemento<=doctors.size()){
                Map<Integer,Doctor>doctorSelected= doctors.get(elemento);

                Integer indexDoc=-1;
                Doctor doctor=new Doctor("","","");

                for (Map.Entry<Integer,Doctor> doc:doctorSelected.entrySet()){
                    indexDoc=doc.getKey();
                    doctor=doc.getValue();
                }

                System.out.println(doctor.getName());
                System.out.println("Date: "+doctor.getCitasDisponibles().get(indexDoc).getDate()+" - "+
                        "Time: "+doctor.getCitasDisponibles().get(indexDoc).getTime());
                System.out.println("Confirm your appointment:\n1.Yes\n2. Change Data");
                int option=entrada.nextInt();
                if (option==1){
                    UIMenu.patientLogged.addCitasDisponiblesDoctor(doctor,doctor.getCitasDisponibles().get(indexDoc).getDate(),
                            doctor.getCitasDisponibles().get(indexDoc).getTime()
                    );
                    checkearPacientesConCitasDisponibles(UIMenu.patientLogged);
                }
            }
        }while (elemento!=0);
    }

    public static void misCitasProgramadas(){
        int option=0;
        List<AppointmentDoctor> misCitas;
        do {
            misCitas=UIMenu.patientLogged.getCitasDisponiblesDoctor();
            System.out.println("::My Apointments");
            if (misCitas.size()==0){
                System.out.println("Don´t have appointments");
                break;
            }
            for (int i = 0; i < misCitas.size(); i++) {
                /*System.out.println((i+1)+". Date: "+misCitas.get(i).getDate()+" ; Time: "+misCitas.get(i).getTime()
                        +" ; "+misCitas.get(i).getDoctor());*/
                System.out.println((i+1)+". "+String.format("%-20s %-30s %-8s",misCitas.get(i).getDoctor(),misCitas.get(i).getDate(),
                        misCitas.get(i).getTime()));
            }
        }while(option!=0);
    }

    public static void checkearPacientesConCitasDisponibles(Patient patient){
        if (!pacientesConCitasDisponibles.contains(patient)){
            pacientesConCitasDisponibles.add(patient);
        }
    }
}

import controller.DoctorController;
import controller.SpecialityController;
import database.ConfigDB;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        int option = 0, option2 = 0;

        do {
            option = Integer.parseInt(JOptionPane.showInputDialog("""
                    1. Administrar Especialidades
                    2. Administrar Médicos
                    3. Administrar Pacientes
                    4. Administrar Citas
                    5. Salir
                                        
                    Ingrese una opción:
                    """));

            switch (option) {
                case 1:
                    do {
                        option2 = Integer.parseInt(JOptionPane.showInputDialog("""
                                1. Listar Especialidad
                                2. Crear Especialidad
                                3. Eliminar Especialidad
                                4. Actualizar Especialidad
                                5. Salir
                                  
                                Ingrese una opción:
                                """));

                        switch (option2) {
                            case 1: SpecialityController.getAll();
                                break;
                            case 2:
                                SpecialityController.insert();
                                break;
                            case 3:
                                SpecialityController.delete();
                                break;
                            case 4:
                                SpecialityController.update();
                                break;
                        }
                    } while (option2 != 5);
                    break;
                case 2:
                    do {
                        option2 = Integer.parseInt(JOptionPane.showInputDialog("""
                                1. Listar Medicos
                                2. Crear Medico
                                3. Eliminar Medico
                                4. Actualizar Medico
                                5. Salir
                                  
                                Ingrese una opción:
                                """));
                        switch (option2){
                            case 1: DoctorController.getAll();
                            break;
                            case 2:
                                DoctorController.insert();
                                break;
                            case 3:
                                DoctorController.delete();
                                break;

                            case 4:
                             DoctorController.update();
                             break;
                        }

                    }while (option2 !=5);
                    break;
            }
        } while (option != 5);
    }
}
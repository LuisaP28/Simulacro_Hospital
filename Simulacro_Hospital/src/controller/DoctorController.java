package controller;

import entity.Doctor;
import entity.Speciality;
import utils.Utils;

import javax.swing.*;
import java.util.List;

public class DoctorController {

    public static void getAll(){
        String list = getAll(instanceModel().findAll());
        JOptionPane.showInputDialog(null, list);
    }
    public static String getAll(List<Object> list){
        String listString = "Lista de registros \n:";

        for (Object temp : list){
            Doctor objMedic = (Doctor) temp;
            listString+= objMedic.toString() + "\n";
        }
        return listString;

    }

    public static void delete (){
        Object[] options = Utils.listToArray(instaceModel().findAll());
        Doctor objMedic = (Doctor) JOptionPane.showInputDialog(
                null,
                "Seleccione el médico a eliminar",
                "",
                JOptionPane.QUESTION_MESSAGE,
                null,
                optionsSpecialities,
                optionsSpecialities[0]
        );

        instanceModel().delete(objMedic);
    }
public static void update(){
    Object[] options = Utils.listToArray(instaceModel().findAll());
    Doctor objMedic = (Doctor) JOptionPane.showInputDialog(
            null,
            "Seleccione el médico a eliminar",
            "",
            JOptionPane.QUESTION_MESSAGE,
            null,
            optionsSpecialities,
            optionsSpecialities[0]
    );

    String name = JOptionPane.showInputDialog(null, "Ingrese el nombre del médico", objMedic.getName_doctor());
    Stringlastname = JOptionPane.showInputDialog("Ingrese los apellidos del médico", objMedic.getLastname());

    Speciality objSpeciality = (Speciality) JOptionPane.showInputDialog(
            null,
            "Seleccione una especialidad",
            "",
            JOptionPane.QUESTION_MESSAGE,
            null,
            optionsSpecialities,
            optionsSpecialities[0]
    );

    instanceModel().update(new Doctor(name_doctor, lastname, objSpeciality.getId(), objSpeciality);
}

    public static void insert() {
        String name_doctor = JOptionPane.showInputDialog("INgrese el nombre del médico:");
        String lastname = JOptionPane.showInputDialog("Ingrese los apellidos del médico:");

        Speciality objSpeciality = (Speciality) JOptionPane.showInputDialog(
                null,
                "Seleccione una especialidad",
                "",
                JOptionPane.QUESTION_MESSAGE,
                null,
                optionsSpecialities,
                optionsSpecialities[0]
        );

        instanceModel().insert(new Doctor(name_doctor, lastname, objSpeciality.getId(), objSpeciality ));
    }
}

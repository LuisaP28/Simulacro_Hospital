package controller;

import entity.Speciality;
import model.SpecialityModel;
import utils.Utils;

import javax.swing.*;
import java.util.List;

public class SpecialityController {
    public static void insert() {
        String name_speciality = JOptionPane.showInputDialog("Ingresa el nombre de la especialidad");
        String description = JOptionPane.showInputDialog("Ingresa la descripción de la especialidad");

        instanceModel().insert(new Speciality(name_speciality, description));
    }

    public static void getAll(){
        String list = getAll(instanceModel().findAll());

        JOptionPane.showMessageDialog(null, list);
    }
    public static String getAll(List<Object> list){
        String listString = "Lista de registros: \n";

        for (Object temp: list){
            Speciality objSpeciality = (Speciality) temp;
            listString+= objSpeciality.toString() + "\n";
        }
        return listString;
    }
    public static SpecialityModel instanceModel() {
        return  new SpecialityModel();
    }

    public static void delete() {
        Object[] options = Utils.listToArray(instanceModel().findAll());

        Speciality objSelected =(Speciality) JOptionPane.showMessageDialog(null,"Seleccione una especialidad","",JOptionPane.QUESTION_MESSAGE, null, options,options[0]);

        instanceModel().delete(objSelected);
    }

    public static void update(){
        Object[] options = Utils.listToArray(instanceModel().findAll());
        Speciality objSelected =(Speciality) JOptionPane.showMessageDialog(null, "Seleccione una especialidad para actualizar","",JOptionPane.QUESTION_MESSAGE, null, options,options[0]);

        objSelected.setName_speciality(JOptionPane.showInputDialog(null, "Ingresa el nuevo nombre de la especialidad:", objSelected.getName_speciality()));
        objSelected.setName_speciality(JOptionPane.showInputDialog(null, "Ingresa la nueva descripción", objSelected.getDescription());

        instanceModel().update(objSelected);
    }
}

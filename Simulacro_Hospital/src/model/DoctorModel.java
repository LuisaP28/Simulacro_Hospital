package model;

import database.CRUD;
import database.ConfigDB;
import entity.Doctor;
import entity.Speciality;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DoctorModel implements CRUD {

    @Override
    public Object insert(Object obj) {

        Connection objConnection = ConfigDB.openConnection();

        Doctor objMedic = (Doctor) obj;

        try {
            String sql = "INSERT INTO medico (nombre, apellidos, id_especialidad) VALUES (?,?,?;";
            PreparedStatement objPrepare = objConnection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);

            objPrepare.setString(1, objMedic.getName_doctor());
            objPrepare.setString(2, objMedic.getLastname());
            objPrepare.setInt(3, objMedic.getId());

            objPrepare.execute();

            ResultSet objResult = objPrepare.getGeneratedKeys();

            while (objResult.next()){
                objMedic.setId(objResult.getInt(1));
            }

            JOptionPane.showMessageDialog(null, "Registro insertado correctamente");
        }catch (SQLException e){
            System.out.println("ERROR >" + e.getMessage());
        }
        return objMedic;
    }

    @Override
    public List<Object> findAll() {
        List<Object> listMedics = new ArrayList<>();
        Connection objConnection = ConfigDB.openConnection();

        try {
            String sql = "SELECT * FROM doctor\n" +
                    "INNER JOIN speciality ON speciality.id = doctor.id_speciality:";

            PreparedStatement objPrepare = objConnection.prepareStatement(sql);

            ResultSet objResult = objPrepare.executeQuery();

            while (objResult.next()){
                Doctor objMedic = new Doctor();

                objMedic.setId(objResult.getInt("doctor.name_doctor"));
                objMedic.setName_doctor(objResult.getString("doctor.name_doctor"));
                objMedic.setLastname(objResult.getString("doctor.lastname"));
                objMedic.setId_speciality(objResult.getInt("doctor.id_speciality"));

                objSpeciality.setId(objResult.getInt("speciality.id"));
                objSpeciality.setName_doctor(objResult.getString("speciality.name_doctor"));
                onjSpeciality setDescription(objResult.getString("speciality.description"));

            objMedic.setObjSpeciality(objSpeciality);
            listMedics.add();
            }

        }catch(SQLException e){
            System.out.println("ERROR >" + e.getMessage());
        }
        return null;
    }

    @Override
    public boolean update(Object obj) {
        Connection objConnection = ConfigDB.openConnection();
        Doctor objMedic = (Doctor) obj;
        boolean isUpdated = false;

        try {
            String sql = "UPDATE doctor SET nombre=?, apellidos=?, id_especialidad=?";
            PreparedStatement objPrepare = objConnection.prepareStatement(sql);

            objPrepare.setString(1, objMedic.getName_doctor());
            objPrepare.setString(2, objMedic.getLastname());
            objPrepare.setInt(3, objMedic.getId_speciality());

            int totalRomAffected = objPrepare.executeUpdate();

            if (totalRomAffected >0){
                isUpdated = true;
                JOptionPane.showInputDialog(null, "Registro actualizado con éxito");
            }

        }catch(SQLException e){
            System.out.println("ERROR >" + e.getMessage());
        }

        ConfigDB.closeConnection();
        return isUpdated;
    }

    @Override
    public boolean delete(Object obj) {
        Connection objConnection = ConfigDB.openConnection();

        Doctor objMedic =(Doctor) obj;

        try {
            String sql = "DELETE FROM doctor WHERE id = ?;";
            PreparedStatement.objPrepare = objConnection.prepareStatement(sql);

            objPrepare.setInt(1, objMedic.getId());

            int totalRomAffected = objPrepare.executeUpdate();

            if (totalRomAffected >0){
                isDeleted = true;
                JOptionPane.showInputDialog(null, "Registro actualizado con éxito");
            }

        }catch(SQLException e){
            System.out.println("ERROR >" + e.getMessage());
        }
        return isDeleted;
    }
}

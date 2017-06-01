/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.co.sergio.mundo.dao;

import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Fabian Giraldo
 */
public class CreateDataBase {
     public static void run(){
          String sql = "create table visitaTecnica( \n" +
"cantidad_colmena varchar(20),\n" +
"calidad_Colmena varchar(20),\n" +
"reinaColmena varchar(10),\n" +
"Produccion_Miel varchar(10),\n" +
"Panales_Cera Integer(10),\n" +
"panales_Alimento integer(10),\n" +
"panalesCria integer(20),\n" +
"panalesVacios integer (15),\n" +
"lugarColmena integer(10),\n" +
"id_visita integer(10) primary key\n" +
")";
          Connection connection = null;
            try {
                connection = Conexion.getConnection();
                Statement stmt = connection.createStatement();
                stmt.executeUpdate(sql);
                
            } catch (URISyntaxException ex) {
                Logger.getLogger(DepartamentoDAO.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
             Logger.getLogger(CreateDataBase.class.getName()).log(Level.SEVERE, null, ex);
         }
          
     }
}

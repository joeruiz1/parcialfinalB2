package edu.co.sergio.mundo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import edu.co.sergio.mundo.vo.Proyecto;
import edu.co.sergio.mundo.vo.*;
import java.net.URISyntaxException;
import java.util.logging.Level;
import java.util.logging.Logger;



    /**
     * @author Isabel-Fabian
     * @since 12/08/2015
     * @version 2 Clase que permite la gestion de la tabla Depto en la base de
     * datos.
     *
     * CREATE TABLE Depto( id_depto integer, nom_depto varchar(40), PRIMARY
     * KEY(id_depto) );
     */
public class colmenaDao  implements IBaseDatos<Colmena> {    

        /**
         * Funcion que permite obtener una lista de los departamentos existentes
         * en la base de datos
         *
         * @return List<Departamento> Retorna la lista de Departamentos
         * existentes en la base de datos
         */
        public List<Colmena> findAll() {
            List<Colmena> colmenas = null;
            String query = "SELECT * FROM Colmena";
            Connection connection = null;
            try {
                connection = Conexion.getConnection();
            } catch (URISyntaxException ex) {
                Logger.getLogger(DepartamentoDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                Statement st = connection.createStatement();
                ResultSet rs = st.executeQuery(query);
                int id = 0;
                int ala = 0;

                while (rs.next()) {
                    if (colmenas == null) {
                        colmenas = new ArrayList<Colmena>();
                    }

                    Colmena registro = new Colmena();
                    id = rs.getInt("id_Colmena");
                    registro.setIdColmena(id);

                    ala = rs.getInt("idAlarios");
                    registro.setIdalarios(ala);

                    colmenas.add(registro);
                }
                st.close();

            } catch (SQLException e) {
                System.out.println("Problemas al obtener la lista de Colmenas");
                e.printStackTrace();
            }

            return colmenas;
        }

        /**
         * Funcion que permite realizar la insercion de un nuevo registro en la
         * tabla Departamento
         *
         * @param Departamento recibe un objeto de tipo Departamento
         * @return boolean retorna true si la operacion de insercion es exitosa.
         */
        public boolean insert(Colmena t) {
            boolean result = false;
            Connection connection = null;
            try {
                connection = Conexion.getConnection();
            } catch (URISyntaxException ex) {
                Logger.getLogger(DepartamentoDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            String query = " insert into Depto (id_depto,nom_depto)" + " values (?,?)";
            PreparedStatement preparedStmt = null;
            try {
                preparedStmt = connection.prepareStatement(query);
                preparedStmt.setInt(1, t.getIdColmena());
                preparedStmt.setInt(2, t.getIdalarios());
                result = preparedStmt.execute();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return result;
        }

        /**
         * Funcion que permite realizar la actualizacion de un nuevo registro en
         * la tabla Departamento
         *
         * @param Departamento recibe un objeto de tipo Departamento
         * @return boolean retorna true si la operacion de actualizacion es
         * exitosa.
         */
        public boolean update(Colmena t) {
            boolean result = false;
            Connection connection = null;
            try {
                connection = Conexion.getConnection();
            } catch (URISyntaxException ex) {
                Logger.getLogger(DepartamentoDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            String query = "update Colmena set idColmena = ? where idAlarios = ?";
            PreparedStatement preparedStmt = null;
            try {
                preparedStmt = connection.prepareStatement(query);
                preparedStmt.setInt(1, t.getIdColmena());
                preparedStmt.setInt(2, t.getIdalarios());
                if (preparedStmt.executeUpdate() > 0) {
                    result = true;
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }

            return result;
        }

        /**
         * Funcion que permite realizar la eliminario de registro en la tabla
         * Departamento
         *
         * @param Departamento recibe un objeto de tipo Departamento
         * @return boolean retorna true si la operacion de borrado es exitosa.
         */
        public boolean delete(Departamento t) {
            boolean result = false;
            Connection connection = null;
            try {
                connection = Conexion.getConnection();
            } catch (URISyntaxException ex) {
                Logger.getLogger(DepartamentoDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            String query = "delete from Colmena where idColmena = ?";
            PreparedStatement preparedStmt = null;
            try {
                preparedStmt = connection.prepareStatement(query);
                preparedStmt.setInt(1, t.getId_departamento());
                result = preparedStmt.execute();
            } catch (SQLException e) {
                e.printStackTrace();
            }

            return result;
        }

        public List<Colmena> recursos() {
            List<Colmena> colmena = null;

            Colmena d=null;
            String query = "select panales_Alimento from visitaTecnica where id_Colmena = 1;";
            Connection connection = null;
           
            try {
                connection = Conexion.getConnection();
            } catch (URISyntaxException ex) {
                Logger.getLogger(DepartamentoDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                Statement st = connection.createStatement();
                ResultSet rs = st.executeQuery(query);

                d=new Colmena();
                int total = 0;
                 int alimento = 0;
                while (rs.next()) {
                    if (colmena == null) {
                        colmena = new ArrayList<Colmena>();
                    }

                    alimento = rs.getInt("panales_Alimento");
                    d.setIdColmena(alimento);
                    
                    colmena.add(d);
                }
                st.close();

            } catch (SQLException e) {
                System.out.println("Problemas al obtener la lista de colmenas");
                e.printStackTrace();
            }
            return colmena;
        }

    @Override
    public boolean delete(Colmena t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}


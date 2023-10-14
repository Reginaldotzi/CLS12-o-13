package edu.umg.test;

import edu.umg.datos.Conexion;
import edu.umg.datos.PersonaJDBC;
import edu.umg.domain.Persona;

import java.sql.Connection;
import java.sql.SQLException;

public class ManejoPersonas {

    public static void main(String[] args) {
        //hacer pruebas de los metodos de persona
        Connection conexion = null;
        PersonaJDBC personaJdbc = new PersonaJDBC();
        try {
            conexion = Conexion.getConnection();
            //el autocommit por default es true, lo pasamos a false
            if (conexion.getAutoCommit()) {
                conexion.setAutoCommit(false);
            }

            Persona nuevaPersona = new Persona();
            nuevaPersona.setNombre("melvin");
            nuevaPersona.setApellido("tzun");
            nuevaPersona.setEmail("mtzune@gmail.com");
            personaJdbc.insert(nuevaPersona);

            if (nuevaPersona.getNombre().equals("melvin")){
                conexion.rollback();
                throw new SQLException("No se puede insertar la persona, se hizo rollback");

            } else {
                System.out.println("se ha insertado con exito y se hará commit");
                conexion.commit();

            }






        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
            System.out.println("Entramos al rollback");
            try {
                conexion.rollback();
            } catch (SQLException ex1) {
                ex1.printStackTrace(System.out);
            }
        }

    }


} //end class

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MOdelo;

import Controlador.ConexionMySQL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class ControladorPersona {
    private ConexionMySQL c;

    public ControladorPersona(ConexionMySQL c) {
        this.c = c;
    }
    
    public ArrayList<Persona> obtenerPersonas() throws SQLException{
        ArrayList<Persona> lista= new ArrayList<>();
        String consulta=" SELECT nombre,DNI, eDAD FROM Persona";
        ResultSet res=c.ejecutarSelect(consulta);
        
        while (res.next()){
            String n=res.getString("Nombre"); //el parámetro debe ser el mismo que el de la base de datos
            String dni= res.getString("DNI");
            int edad= res.getInt("Edad");
            Persona p1= new Persona (n,edad,dni);    //creamos el objeto persona para almacenar los datos de la consulta uqe recibimos de la base de datos
            lista.add(p1);                  // lo añadimos al array, ya que vamos a devolver el array, con todas las personas añadidas
        }
        return lista;           // devolvemos el array
    }
    
}

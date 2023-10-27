
package desafio2media.conexion;

import desafio2media.Clases.Libro;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author GUASI
 */
public class DaoLibros {
     ConexionBD conectar;//Abre la conexion de la base de datos
    Connection con; //Conexion con la base de datos
    PreparedStatement ps; //Nos sirve para trabajar  o ejecutar las consultas 
    ResultSet rs;  //Con este se obtiene todos los resultados , un resultado de la consulta que yo ejecute
    
    
    public ArrayList<Libro> SelectAll(){
        String sql = "SELECT Id, Titulo, IdDirector, Duracion, IdGenero, Stock FROM materiales WHERE Id LIKE 'LIB%' AND Stock>0";
        return select(sql);
    }

    private ArrayList<Libro> select(String sql) {
        ArrayList<Libro> Libros = new ArrayList<>();
        
        try {
            this.con=this.conectar.getConnection();
            this.ps=con.prepareStatement(sql);
            this.rs=ps.executeQuery();
            
            Libro libros = new Libro();
            libros.setId(rs.getString("Id"));
            libros.setTitulo(rs.getString("Titulo"));
            libros.setIdAutor(rs.getInt("IdAutor"));
        } catch (Exception e) {
        }
         return null;
    }
}

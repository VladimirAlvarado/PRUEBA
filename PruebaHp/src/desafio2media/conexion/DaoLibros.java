
package desafio2media.conexion;

import desafio2media.Clases.Libro;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

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
         return Libros;
    }
    
    public ArrayList<Libro> INSERTAll(){
        String sql = "INSERT INTO materiales(IdTipo, Titulo, IdAutor, IdArtista,NumPag, IdEditorial, ISBN,AnioPublic,Stock) VALUES (?,?,?,?,?,?,?,?,?) SCOPE_IDENTITY() ";
        return insert(sql);
    }

    private ArrayList<Libro> insert(String sql) {
        ArrayList<Libro> Libros = new ArrayList<>();
  private boolean insert( sql) {
    try {
        this.con=this.conectar.getConnection();
        this.ps=con.prepareStatement(sql);
        this.ps.executeUpdate();
        con.commit();
        return true;
    } catch (SQLException ex) {
        ex.printStackTrace();
        Logger.getLogger(DaoLibros.class.getName()).log(Level.SEVERE, null, ex);
        return false;
    }finally{
        try {
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(DaoLibros.class.getName()).log(Level.SEVERE, null, ex);
        }
        conectar.close(con);
    }
}
}


package desafio2media.conexion;

import desafio2media.Clases.CD;
import desafio2media.Clases.DVD;
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
public class DaoDvd {
    ConexionBD conectar;//Abre la conexion de la base de datos
    Connection con; //Conexion con la base de datos
    PreparedStatement ps; //Nos sirve para trabajar  o ejecutar las consultas 
    ResultSet rs;  //Con este se obtiene todos los resultados , un resultado de la consulta que yo ejecute

    
    public ArrayList<DVD> selectAll(){
        String sql = "SELECT Id, Titulo, IdDirector, Duracion, IdGenero, Stock FROM materiales WHERE Id LIKE 'DVD%' AND Stock>0";
        return select(sql);
    }
    
    private ArrayList<DVD> select(String sql){
        ArrayList<DVD> listaDVD = new ArrayList<>();
        try {
            this.con=this.conectar.getConnection();
            this.ps=con.prepareStatement(sql);
            this.rs = ps.executeQuery();
            
            while(rs.next()){
                DVD dvd = new DVD();
                dvd.setId(rs.getString("Id"));
                dvd.setTitulo(rs.getString("Titulo"));
                dvd.setIdDirector(rs.getInt("IdDirector"));
                dvd.setDuracion(rs.getTime("Duracion"));
                dvd.setIdGenero(rs.getInt("IdGenero"));
                dvd.setStock(rs.getInt("Stock"));
                listaDVD.add(dvd);
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
            Logger.getLogger(DaoCd.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try {
                ps.close();
            } catch (SQLException ex) {
                Logger.getLogger(DaoCd.class.getName()).log(Level.SEVERE, null, ex);
            }
            conectar.close(con);
        }
        return listaDVD;
    }
}

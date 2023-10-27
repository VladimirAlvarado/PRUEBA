/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package desafio2media.conexion;

import desafio2media.Clases.CD;
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
public class DaoCd {
    ConexionBD conectar;//Abre la conexion de la base de datos
    Connection con; //Conexion con la base de datos
    PreparedStatement ps; //Nos sirve para trabajar  o ejecutar las consultas 
    ResultSet rs;  //Con este se obtiene todos los resultados , un resultado de la consulta que yo ejecute

    
    public ArrayList<CD> selectAll(){
        String sql = "SELECT Id, Titulo, IdGenero, Duracion, NumCanciones, Stock FROM materiales WHERE Id LIKE 'CD%' AND Stock>0";
        return select(sql);
    }
    
    private ArrayList<CD> select(String sql){
        ArrayList<CD> listaCD = new ArrayList<>();
        try {
            this.con=this.conectar.getConnection();
            this.ps=con.prepareStatement(sql);
            this.rs = ps.executeQuery();
            
            while(rs.next()){
                CD cd = new CD();
                cd.setId(rs.getString("Id"));
                cd.setTitulo(rs.getString("Titulo"));
                cd.setIdGenero(rs.getInt("IdGenero"));
                cd.setDuracion(rs.getTime("Duracion"));
                cd.setNumCanciones(rs.getInt("NumCanciones"));
                cd.setStock(rs.getInt("Stock"));
                listaCD.add(cd);
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
        return listaCD;
    }
}

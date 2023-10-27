/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package desafio2media;

import desafio2media.Clases.CD;
import desafio2media.Clases.DVD;
import desafio2media.Clases.Libro;
import desafio2media.conexion.ConexionBD;
import desafio2media.conexion.DaoCd;
import desafio2media.conexion.DaoDvd;
import desafio2media.conexion.DaoLibros;
import java.awt.BorderLayout;
import java.awt.Dialog;
import java.awt.Dimension;
import java.sql.Connection;
import java.util.ArrayList;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javax.swing.JApplet;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Josue
 */
public class PRUEBA extends JApplet {
    
       public static DaoCd CdDao = new DaoCd();
       private static ArrayList<CD> cds = new ArrayList<>();
       public static DaoDvd DvdDao = new DaoDvd();
       private static ArrayList<DVD> dvds = new ArrayList<>();
       public static DaoLibros LibDao = new DaoLibros();
       private static ArrayList<Libro> Libs = new ArrayList<>();
       
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        agregarLibro();
        
    }
    public static void verEquipos() {
       
        String[] opciones = {"CD", "DVD", "LIBROS","REVISTAS"};
        int tipoEquipo = JOptionPane.showOptionDialog(null, "Seleccione el tipo de material que desea ver", "Vista de Materiales", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opciones, opciones[0]);

        DefaultTableModel modeloTabla = new DefaultTableModel();

        switch (tipoEquipo) {
            case 0: // CD
                cds = CdDao.selectAll();
                modeloTabla.addColumn("ID");
                modeloTabla.addColumn("TITULO");
                modeloTabla.addColumn("DURACION");
                modeloTabla.addColumn("ID GENERO");
                modeloTabla.addColumn("NUM CANCIONES");
                modeloTabla.addColumn("DISPONIBLES");

                for (CD cd : cds) {
                    modeloTabla.addRow(new Object[]{
                        cd.getId(),
                        cd.getTitulo(),
                        cd.getDuracion(),
                        cd.getIdGenero(),
                        cd.getNumCanciones(),
                        cd.getStock(),            
                    });
                }
                break;
            case 1: // DVD
                dvds = DvdDao.selectAll();
                modeloTabla.addColumn("ID");
                modeloTabla.addColumn("TITULO");
                modeloTabla.addColumn("ID DIRECTOR");
                modeloTabla.addColumn("DURACION");
                modeloTabla.addColumn("ID GENERO");
                modeloTabla.addColumn("DISPONIBLES");

                for (DVD dvd : dvds) {
                    modeloTabla.addRow(new Object[]{
                        dvd.getId(),
                        dvd.getTitulo(),
                        dvd.getIdDirector(),
                        dvd.getDuracion(),
                        dvd.getIdGenero(),
                        dvd.getStock(),            
                    });
                }
                break;
                
            default:
                JOptionPane.showMessageDialog(null, "Opción no válida");
        }

        // Crear una JTable con el modelo de tabla
        // Crear una JTable con el modelo de tabla
        JTable table = new JTable(modeloTabla);

        // Crear un JScrollPane para la tabla
        JScrollPane scrollPane = new JScrollPane(table);

        // Crear un JDialog para mostrar la tabla
        JDialog dialog = new JDialog();
        dialog.setTitle("Lista de Equipos");
        dialog.setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
        dialog.add(scrollPane);
        dialog.pack();
        dialog.setVisible(true);
        dialog.setLocationRelativeTo(null);
    }
  
    private static void agregarLibro() {
          Libs = LibDao.INSERTAll();
        String id = JOptionPane.showInputDialog("Ingrese código de identificación interna:");
        String titulo = JOptionPane.showInputDialog("Ingrese El titulo:");
        int idGenero = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el IdGenero"));
        int stock = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el número de unidades disponibles del libro:"));
        int idAutor = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el IdAutor:"));
        int IdEditorial = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el IdEditorial"));
        int numPaginas = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el IdEditorial"));
        String isbn =(JOptionPane.showInputDialog("Ingrese el ISBN del libro:"));
        int AnioPublic = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el IdEditorial"));

        Libro nuevoLibro = new Libro(id, titulo, idGenero, stock, idAutor, IdEditorial, numPaginas, isbn,AnioPublic);
        Libs.add(nuevoLibro); 

        // Aquí se tiene que agregar el código para conectarte a la base de datos y guardar el objeto 'libro'

        JOptionPane.showMessageDialog(null, "Libro agregado correctamente.");
    }
}


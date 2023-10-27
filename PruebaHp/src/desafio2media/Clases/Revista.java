/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package desafio2media.Clases;

/**
 *
 * @author Josue
 */
public class Revista extends MaterialEscrito {

    private String periodicidad;
    private int fechPublicacion;

    public Revista(String id, String titulo, int idGenero, int stock, int idAutor, int idEditorial, int numPaginas, int fechPublicacion, String periodicidad) {
        super(id, titulo, idGenero, stock, idAutor, numPaginas, idEditorial);
        this.periodicidad = periodicidad;
        this.fechPublicacion = fechPublicacion;
    }

    public String getPeriodicidad() {
        return periodicidad;
    }

    public void setPeriodicidad(String periodicidad) {
        this.periodicidad = periodicidad;
    }
    
    public int getfechPublicacion(){
        return fechPublicacion;
    }
    
    public void setfechPublicacion(int fechPublicacion){
        this.fechPublicacion = fechPublicacion;
    }
    @Override
    public String toString() {
        return "Revista{" + "periodicidad=" + periodicidad + '}';
    }

    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package desafio2media.Clases;

import java.sql.Time;

/**
 *
 * @author Josue
 */
public class CD extends MaterialAudiovisual {

    private int numCanciones;

    public CD(String id, String titulo, int idGenero, int stock, Time duracion, int numCanciones) {
        super(id, titulo, idGenero, stock, duracion);
        this.numCanciones = numCanciones;
    }
    public CD() {
        super();
    }

    public int getNumCanciones() {
        return numCanciones;
    }

    public void setNumCanciones(int numCanciones) {
        this.numCanciones = numCanciones;
    }

    @Override
    public String toString() {
        return "CD{" + "numCanciones=" + numCanciones + '}';
    }
    
    

}

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
public abstract class MaterialAudiovisual extends Material {

    protected Time duracion; // en minutos
    
    public MaterialAudiovisual(){
        super();
    }

    public MaterialAudiovisual(String id, String titulo, int idGenero, int stock, Time duracion) {
        super(id, titulo, idGenero, stock);
        this.duracion = duracion;
    }

    public Time  getDuracion() {
        return duracion;
    }

    public void setDuracion(Time duracion) {
        this.duracion = duracion;
    }

    @Override
    public String toString() {
        return "MaterialAudiovisual{" + "duracion=" + duracion + '}';
    }
    
    
    

}

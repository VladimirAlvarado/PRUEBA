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
public abstract class MaterialEscrito extends Material {

    protected int idAutor;
    protected int idEditorial;
    protected int numPaginas;
    
    
    public MaterialEscrito(String id, String titulo, int idGenero, int stock, int idAutor, int idEditorial, int numPaginas) {
        super(id, titulo, idGenero, stock);
        this.idAutor = idAutor;
        this.idEditorial = idEditorial;
        this.numPaginas = numPaginas;
    }
    public MaterialEscrito(){
        super();
    }

    public int getIdAutor() {
        return idAutor;
    }

    public void setIdAutor(int idAutor) {
        this.idAutor = idAutor;
    }

    public int getIdEditorial() {
        return idEditorial;
    }

    public void setIdEditorial(int idEditorial) {
        this.idEditorial = idEditorial;
    }
    
    public int getnumPaginas(){
        return numPaginas;
    }
    
    public void setnumPaginas(int numPaginas){
        this.numPaginas = numPaginas;
    }

    @Override
    public String toString() {
        return "MaterialEscrito{" + "idAutor=" + idAutor + ", idEditorial=" + idEditorial + '}';
    }
    
    

}

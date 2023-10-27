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
public class Libro extends MaterialEscrito {

    private String isbn;
    private int AnioPublic;

    public Libro(String id, String titulo, int idGenero, int stock, int idAutor, int idEditorial, int numPaginas, String isbn, int AnioPublic) {
        super(id, titulo, idGenero, stock, idAutor, idEditorial, numPaginas);
        this.isbn = isbn;
        this.AnioPublic = AnioPublic;
    }
    public Libro(){
        super();
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
    public int getAnioPublic(){
        return AnioPublic;
    }
    public void setAnioPublic(int AnioPublic){
        this.AnioPublic = AnioPublic;
    }
    @Override
    public String toString() {
        return "Libro{" + "isbn=" + isbn + '}';
    }

    public void add(Libro libros) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}

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

    public Libro(String id, String titulo, int idGenero, int stock, int idAutor, int idEditorial, int numPaginas, String isbn) {
        super(id, titulo, idGenero, stock, idAutor, idEditorial, numPaginas);
        this.isbn = isbn;
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

    @Override
    public String toString() {
        return "Libro{" + "isbn=" + isbn + '}';
    }

    
}

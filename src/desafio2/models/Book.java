package desafio2.models;

public class Book extends Material {
    
    private int creadorId;
    private int editorialId;
    private String isbn;
    private int numPaginas; 
    private int anioPublicacion;
    private int unidades;

    public int getCreadorId() {
        return creadorId;
    }

    public void setCreadorId(int creadorId) {
        this.creadorId = creadorId;
    }

    public int getEditorialId() {
        return editorialId;
    }

    public void setEditorialId(int editorialId) {
        this.editorialId = editorialId;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public int getNumPaginas() {
        return numPaginas;
    }

    public void setNumPaginas(int numPaginas) {
        this.numPaginas = numPaginas;
    }

    public int getAnioPublicacion() {
        return anioPublicacion;
    }

    public void setAnioPublicacion(int anioPublicacion) {
        this.anioPublicacion = anioPublicacion;
    }

    public int getUnidades() {
        return unidades;
    }

    public void setUnidades(int unidades) {
        this.unidades = unidades;
    }
    
}

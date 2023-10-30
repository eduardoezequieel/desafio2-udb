package desafio2.models;

public class Gender {

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getTipoGeneroId() {
        return tipoGeneroId;
    }

    public void setTipoGeneroId(int tipoGeneroId) {
        this.tipoGeneroId = tipoGeneroId;
    }
    private int id;
    private String genero;
    private int tipoGeneroId;
}

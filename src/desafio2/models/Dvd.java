package desafio2.models;

public class Dvd extends Material {

    public int getGeneroId() {
        return generoId;
    }

    public void setGeneroId(int generoId) {
        this.generoId = generoId;
    }

    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    public int getCreadorId() {
        return creadorId;
    }

    public void setCreadorId(int creadorId) {
        this.creadorId = creadorId;
    }
    private int generoId;
    private String duracion;
    private int creadorId;
}

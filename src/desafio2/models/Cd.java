package desafio2.models;

public class Cd extends Material {

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

    public int getNumero_canciones() {
        return numero_canciones;
    }

    public void setNumero_canciones(int numero_canciones) {
        this.numero_canciones = numero_canciones;
    }

    public int getUnidades() {
        return unidades;
    }

    public void setUnidades(int unidades) {
        this.unidades = unidades;
    }

    public int getTipoMaterialId() {
        return tipoMaterialId;
    }

    public void setTipoMaterialId(int tipo_material_id) {
        this.tipoMaterialId = tipo_material_id;
    }
    private int generoId;
    private String duracion;
    private int numero_canciones;
    private int unidades;
    private int tipoMaterialId;

    public int getArtistId() {
        return artistId;
    }

    public void setArtistId(int artistId) {
        this.artistId = artistId;
    }
    private int artistId;
}

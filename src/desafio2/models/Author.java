
package desafio2.models;

public class Author {
    private int id;
    private String nombre;
    private String tipoCreador;
    private int tipoCreadorId;
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipoCreador() {
        return tipoCreador;
    }

    public void setTipoCreador(String tipoCreador) {
        this.tipoCreador = tipoCreador;
    }
    
    public int getTipoCreadorId() {
        return tipoCreadorId;
    }

    public void setTipoCreadorId(int tipoCreadorId) {
        this.tipoCreadorId = tipoCreadorId;
    }
}

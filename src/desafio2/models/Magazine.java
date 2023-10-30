package desafio2.models;

public class Magazine extends Material {

    public int getPeriodicidadId() {
        return periodicidadId;
    }

    public void setPeriodicidadId(int periodicidadId) {
        this.periodicidadId = periodicidadId;
    }

    public String getFechaPublicacion() {
        return fechaPublicacion;
    }

    public void setFechaPublicacion(String fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
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

    public void setTipoMaterialId(int tipoMaterialId) {
        this.tipoMaterialId = tipoMaterialId;
    }
    
    public int getEditorialId() {
        return editorialId;
    }

    public void setEditorialId(int editorialId) {
        this.editorialId = editorialId;
    }
    
    private int periodicidadId;
    private String fechaPublicacion;
    private int unidades;
    private int tipoMaterialId;
    private int editorialId;
}

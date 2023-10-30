package desafio2.models;

public class Material {
    private String codigo;
    private String titulo;
    private String tipoMaterial;
    private int tipoMaterialId;
    private int categoriaMaterialId;
    private String categoriaMaterial;

    public int getTipoMaterialId() {
        return tipoMaterialId;
    }

    public void setTipoMaterialId(int tipoMaterialId) {
        this.tipoMaterialId = tipoMaterialId;
    }

    public int getCategoriaMaterialId() {
        return categoriaMaterialId;
    }

    public void setCategoriaMaterialId(int categoriaMaterialId) {
        this.categoriaMaterialId = categoriaMaterialId;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getTipoMaterial() {
        return tipoMaterial;
    }

    public void setTipoMaterial(String tipoMaterial) {
        this.tipoMaterial = tipoMaterial;
    }

    public String getCategoriaMaterial() {
        return categoriaMaterial;
    }

    public void setCategoriaMaterial(String categoriaMaterial) {
        this.categoriaMaterial = categoriaMaterial;
    }
}

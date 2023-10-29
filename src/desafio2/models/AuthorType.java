/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package desafio2.models;

/**
 *
 * @author Eduardo
 */
public class AuthorType {

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipoCreador() {
        return tipoCreador;
    }

    public void setTipoCreador(String tipoCreador) {
        this.tipoCreador = tipoCreador;
    }
    private int id;
    private String tipoCreador;
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VO;

import java.util.List;

/**
 *
 * @author Luis
 */
public class Proveedor {

    private int id;
    private List<Producto> productos;
    private String correo;

    public Proveedor() {
    }

    public Proveedor(int id, String correo) {
        this.id = id;
        this.correo = correo;
    }

   

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

}

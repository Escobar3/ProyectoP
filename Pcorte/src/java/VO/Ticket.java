/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VO;

/**
 *
 * @author Luis
 */
public class Ticket {

    private int id;
    private String zona;
    private Vendedor cvendedor;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getZona() {
        return zona;
    }

    public void setZona(String zona) {
        this.zona = zona;
    }

    public Vendedor getCvendedor() {
        return cvendedor;
    }

    public void setCvendedor(Vendedor cvendedor) {
        this.cvendedor = cvendedor;
    }

    public Caja getCaja() {
        return caja;
    }

    public void setCaja(Caja caja) {
        this.caja = caja;
    }
    private Caja caja;

}

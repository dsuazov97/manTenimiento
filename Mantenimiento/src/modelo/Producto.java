/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author ziNk
 */
public abstract class Producto {
    
    private String codigo;
    private String marca;
    private String modelo;
    private int cantDias;
    private int precioBase;

    public Producto(String codigo, String marca, String modelo, int cantDias, int precioBase) {
        this.codigo = codigo;
        this.marca = marca;
        this.modelo = modelo;
        this.cantDias = cantDias;
        this.precioBase = precioBase;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getCantDias() {
        return cantDias;
    }

    public void setCantDias(int cantDias) {
        this.cantDias = cantDias;
    }

    public int getPrecioBase() {
        return precioBase;
    }

    public void setPrecioBase(int precioBase) {
        this.precioBase = precioBase;
    }
    
    // METODOS
    
    public int valor(){
        return cantDias * precioBase;
    }
    
    public abstract int costoServicios();
    
    public abstract int valorFinal();
    
    
}




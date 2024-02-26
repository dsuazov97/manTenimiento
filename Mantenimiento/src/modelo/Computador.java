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
public class Computador extends Producto{
    
    private boolean limpieza;
    private boolean formateo;

    public Computador(String codigo, String marca, String modelo, int cantDias, int precioBase,boolean limpieza, boolean formateo) {
        super(codigo, marca, modelo, cantDias, precioBase);
        this.limpieza = limpieza;
        this.formateo = formateo;
    }

    public boolean isLimpieza() {
        return limpieza;
    }

    public void setLimpieza(boolean limpieza) {
        this.limpieza = limpieza;
    }

    public boolean isFormateo() {
        return formateo;
    }

    public void setFormateo(boolean formateo) {
        this.formateo = formateo;
    }

    // METODOS
    
    public int valorFinal(){
        return costoServicios() + valor() - descAmbos();
    }
    
    public int descAmbos(){
        if(isFormateo() && isLimpieza())
            return (int) (costoServicios() * 0.1);
        return 0;
    }
    
    public int costoServicios(){
        int x = 0;
        if(isFormateo())
            x = x + 12000;
        if(isLimpieza())
            x = x + 30000;
        return x;
    }
}

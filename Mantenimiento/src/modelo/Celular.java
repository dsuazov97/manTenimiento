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
public class Celular extends Producto{
    
    private boolean cPantalla;
    private boolean cBateria;
    private boolean cPlaca;
    private boolean cCamara;
    private boolean desbloqueoImei;

    public Celular(String codigo, String marca, String modelo, int cantDias, int precioBase,boolean cPantalla, boolean cBateria, boolean cPlaca, boolean cCamara, boolean desbloqueoImei) {
        super(codigo, marca, modelo, cantDias, precioBase);
        this.cPantalla = cPantalla;
        this.cBateria = cBateria;
        this.cPlaca = cPlaca;
        this.cCamara = cCamara;
        this.desbloqueoImei = desbloqueoImei;
    }

    public boolean iscPantalla() {
        return cPantalla;
    }

    public void setcPantalla(boolean cPantalla) {
        this.cPantalla = cPantalla;
    }

    public boolean iscBateria() {
        return cBateria;
    }

    public void setcBateria(boolean cBateria) {
        this.cBateria = cBateria;
    }

    public boolean iscPlaca() {
        return cPlaca;
    }

    public void setcPlaca(boolean cPlaca) {
        this.cPlaca = cPlaca;
    }

    public boolean iscCamara() {
        return cCamara;
    }

    public void setcCamara(boolean cCamara) {
        this.cCamara = cCamara;
    }

    public boolean isDesbloqueoImei() {
        return desbloqueoImei;
    }

    public void setDesbloqueoImei(boolean desbloqueoImei) {
        this.desbloqueoImei = desbloqueoImei;
    }

    // METODOS
    
    public int valorFinal(){
        return costoServicios() - descPantalla() + valor();
    }
    
    public int descPantalla(){
        if(iscPantalla())
            return (int) (costoServicios() * 0.2);
        return 0;
    }
    
    public int costoServicios(){
        int x = 0;
        if(isDesbloqueoImei())
            x = x + 25000;
        if(iscPantalla())
            x = x + 150000;
        if(iscBateria())
            x = x + 10000;
        if(iscPlaca())
            x = x + 80000;
        if(iscCamara())
            x = x + 50000;
        return x;
    }
}

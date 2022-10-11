package alex.example.ejercicioimobiliaria.Models;

import java.io.Serializable;

public class Piso implements Serializable {
    private String direccion,ciudad,provincia,cp;
    private int numero;
    private float valoracion;

    public Piso(String direccion, String ciudad, String provincia, String cp, int numero, float valoracion) {

        this.direccion = direccion;
        this.ciudad = ciudad;
        this.provincia = provincia;
        this.cp = cp;
        this.numero = numero;
        this.valoracion = valoracion;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getCp() {
        return cp;
    }

    public void setCp(String cp) {
        this.cp = cp;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public float getValoracion() {
        return valoracion;
    }

    public void setValoracion(float valoracion) {
        this.valoracion = valoracion;
    }

    @Override
    public String toString() {
        return "Piso{" +
                "direccion='" + direccion + '\'' +
                ", ciudad='" + ciudad + '\'' +
                ", provincia='" + provincia + '\'' +
                ", cp='" + cp + '\'' +
                ", numero=" + numero +
                ", valoracion=" + valoracion +
                '}';
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prototype;

/**
 *
 * @author wevergara
 */
public abstract class Documento implements Cloneable {

    protected String contenido = new String();
    protected String nombre = new String();
    
    public Documento duplica() {
        Documento resultado;
        try {
            resultado = (Documento) this.clone();
        } catch (CloneNotSupportedException exception) {
            return null;
        }
        return resultado;
    }

    public void setNombre(String nom_doc){
        nombre = nom_doc;
    }
    
    public String getNombre(){
       return nombre;
    }
    
    public void rellena(String informacion) {
        contenido = informacion;
    }
    
    public String getContenido() {
        return contenido;
    }

    public abstract void imprime();

    public abstract void visualiza();
}

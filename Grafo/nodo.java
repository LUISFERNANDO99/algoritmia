/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aristas;

/**
 *
 * @author LUIS FERNANDO
 */
public class nodo {

    //atributos
    String nombre;

    //constructor
    public nodo(String nombre) {
        this.nombre = nombre;
    }

    public nodo() {
    }
    
    

    //set y get
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "nodo : " + this.nombre;
    }
    
    

}

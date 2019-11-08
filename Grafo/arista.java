/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aristas;

import java.util.Vector;

/**
 *
 * @author LUIS FERNANDO
 */
public class arista {

    //atributos
    int costo;
    nodo nodo1;
    nodo nodo2;

    //constructor
    public arista() {
    }

    public arista(int costo) {
        this.costo = costo;
    }

    public arista(int costo, nodo nodo1, nodo nodo2) {
        this.costo = costo;
        this.nodo1 = nodo1;
        this.nodo2 = nodo2;
    }
    

    //set y get
    public int getCosto() {
        return costo;
    }

    public void setCosto(int costo) {
        this.costo = costo;
    }

    public nodo getNodo1() {
        return nodo1;
    }

    public void setNodo1(nodo nodo1) {
        this.nodo1 = nodo1;
    }

    public nodo getNodo2() {
        return nodo2;
    }

    public void setNodo2(nodo nodo2) {
        this.nodo2 = nodo2;
    }
//to string
    @Override
    public String toString() {
        return "arista{" + "costo=" + costo + ", nodo1=" + nodo1 + ", nodo2=" + nodo2 + '}';
    }

}

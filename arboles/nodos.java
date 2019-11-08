/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nodoss;

/**
 *
 * @author LUIS FERNANDO
 */
public class nodos {

    String dato;
    nodos siguente;

    public nodos(String d, nodos sig) {
        dato = d;
        siguente = sig;
    }
    public nodos(String d){
        dato=d;
        siguente=null;
    }   
}

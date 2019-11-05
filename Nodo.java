/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoritmia;

/**
 *
 * @author LUIS FERNANDO
 */
public class Nodo {

        int dato;
        Nodo izquierdo;
        Nodo derecho;
        int altura;

        Nodo(int dato) {
            this.dato = dato;
            this.altura = 1;
        }

        public int getDato() {
            return dato;
        }

        public void setDato(int dato) {
            this.dato = dato;
        }

        public Nodo getIzquierdo() {
            return izquierdo;
        }

        public void setIzquierdo(Nodo izquierdo) {
            this.izquierdo = izquierdo;
        }

        public Nodo getDerecho() {
            return derecho;
        }

        public void setDerecho(Nodo derecho) {
            this.derecho = derecho;
        }
    
}

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
public class Nodoss {
    //inicio=izquierda

    nodos inicio, fin;//punteros para acceder inicio y fin
    int cont = 0;//para saber cuantos datos ingresamos

    public Nodoss() {
        inicio = null;
        fin = null;
    }

    public boolean Vacia() {
        return inicio == null;
    }

    public void agrega_inicio(String d) {
        cont++;
        if (Vacia()) {
            inicio = new nodos(d, inicio);//apunta a un nuevo nodo
            fin = inicio;
        } else {
            inicio = new nodos(d, inicio);//agrega al inicio cuando ya existe uno creado
        }
    }

    public void agreg_final(String d) {
        cont++;
        if (Vacia()) {
            inicio = new nodos(d);
            fin = inicio;
        } else {
            fin.siguente = new nodos(d);//agrega del nodo despues final
            fin = fin.siguente;//para estar pasando al ultimo nodo agregado
        }
    }

    public int cantidadNodos() {
        return cont;
    }

    public void mostrarlista() {
        nodos aux = inicio;
        while (aux != null) {
            System.out.println("");
            System.out.print("[" + aux.dato + "]");
            aux = aux.siguente;//accede al siguiente dato
        }

    }

    public String primerElemento() {
        return inicio.dato;
    }

    public String ultimoElemento() {
        return fin.dato;
    }
    
    public void arbol(String d){
        try {
           nodos aux = inicio;
        cont++;
        if (Vacia()) {
            inicio = new nodos(d);
            fin = inicio;
        }else if(d.compareTo(aux.dato)>0){
            fin.siguente = new nodos(d);//agrega del nodo despues final
            fin = fin.siguente;
        } else {
            inicio = new nodos(d, inicio);
        } 
        } catch (Exception e) {
        } 
    }

    public boolean buscaDato(String d) {
        boolean encontrado = false;
        nodos aux = inicio;
        while (encontrado != true && aux != null) {
            if (d.equals(aux.dato)) {
                encontrado = true;
            } else {
                aux = aux.siguente;//busca entre cada nodo asta encontrar el dato buscado
            }
            if (encontrado == true) {
                break;//termina busqueda des ciclo
            }
        }
        return encontrado;
    }

    public String eliminar_dato_inicio() {
        String eliminado = inicio.dato;
        if (cont == 1) {
            inicio = null;
            fin = inicio;
        } else {
            inicio = inicio.siguente;//inicio.siguiente accedesmos al siguiente del nodo del cual apunta inicio
        }
        cont--;
        return eliminado;
    }

    public String elimina_dato_final() {
        String eliminado = fin.dato;
        nodos aux = inicio;
        while (aux.siguente != fin) {
            aux = aux.siguente;
        }
        cont--;
        fin = aux;
        fin.siguente = null;
        return eliminado;
    }

}

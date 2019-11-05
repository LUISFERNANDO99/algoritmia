/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoritmia;

import java.util.Scanner;

/**
 *
 * @author LUIS FERNANDO
 */
public class ArbolJava {

    Scanner myObj = new Scanner(System.in);
    public static ArbolJava a = new ArbolJava();

    public static void main(String[] args) {
        a.menu();

    }

    public void menu() {
        System.out.println("INGRESA UNA OPCION" + "\n 1.-Agrega datos" + "\n 2.-Mostrar Datos" + "\n 3.-Eliminar" + "\n 4.-Altura"+"\n 5.-valor minim"+"\n 6.-salir");
        int opcion = myObj.nextInt();
        if (opcion == 1) {
            System.out.println("ingresa valor");
            int op = myObj.nextInt();
            a.agregar(op);
            a.menu();
        } else if (opcion == 2) {
            a.mostrar();
            a.menu();
        } else if (opcion == 3) {
            System.out.println("ingresa valor a eliminar");
            int opn = myObj.nextInt();
            a.eliminar(opn);
            a.menu();
        } else if (opcion == 4) {
            System.out.println("La altura es : " + a.altura(raiz));
            a.menu();
        } else if (opcion == 5) {
            System.out.println(" ;" + a.valorMinimo(raiz));
            a.menu();
        }else if(opcion==6){
            System.exit(0);
        }else{
            System.out.println("lo siento la opcion :"+opcion+" no existe");
            a.menu();
        }
    }

    private Nodo raiz;

    public void agregar(int dato) {
        this.raiz = agregar(raiz, dato);
    }

    private Nodo agregar(Nodo nodo, int dato) {
        if (nodo == null) {
            Nodo nn = new Nodo(dato);
            return nn;
        }

        if (dato > nodo.dato) {
            nodo.derecho = agregar(nodo.derecho, dato);
        } else if (dato < nodo.dato) {
            nodo.izquierdo = agregar(nodo.izquierdo, dato);
        }

        nodo.altura = Math.max(altura(nodo.derecho), altura(nodo.izquierdo)) + 1;

        //factor de equilibrio
        int bf = bf(nodo);
        //caso I
        if (bf > 1 && dato < nodo.izquierdo.dato) {
            return rotacionAlaDerecha(nodo);
        }
        //caso D
        if (bf < -1 && dato > nodo.derecho.dato) {
            return rotacionAlaIzquierdo(nodo);
        }
        //caso ID
        if (bf > 1 && dato > nodo.izquierdo.dato) {
            nodo.izquierdo = rotacionAlaIzquierdo(nodo.izquierdo);
            return rotacionAlaDerecha(nodo);
        }
        //caso DI
        if (bf < -1 && dato < nodo.derecho.dato) {
            nodo.derecho = rotacionAlaIzquierdo(nodo.derecho);
            return rotacionAlaIzquierdo(nodo);
        }

        return nodo;
    }

    private int altura(Nodo nodo) {
        if (nodo == null) {
            return 0;
        }
        return nodo.altura;
    }

    private int bf(Nodo nodo) {
        if (nodo == null) {
            return 0;
        }
        return altura(nodo.izquierdo) - altura(nodo.derecho);
    }

    private Nodo rotacionAlaDerecha(Nodo c) {
        Nodo b = c.izquierdo;
        Nodo T3 = b.derecho;

        //rotacion
        b.derecho = c;
        c.izquierdo = T3;
        //actualizacion de altura
        c.altura = Math.max(altura(c.izquierdo), altura(c.derecho)) + 1;
        b.altura = Math.max(altura(b.izquierdo), altura(b.derecho)) + 1;

        return b;
    }

    private Nodo rotacionAlaIzquierdo(Nodo c) {
        Nodo b = c.derecho;
        Nodo T2 = b.izquierdo;

        //rotacion
        b.izquierdo = c;
        c.derecho = T2;
        //actualizacion de altura
        c.altura = Math.max(altura(c.izquierdo), altura(c.derecho)) + 1;
        b.altura = Math.max(altura(b.izquierdo), altura(b.derecho)) + 1;

        return b;
    }

    public void mostrar() {
        mostrar(this.raiz);
    }

    public void eliminar(int dato) {

        eliminarNodo(this.raiz, dato);
    }

    private Nodo eliminarNodo(Nodo nodo, int dato) {

        if (nodo == null) {
            return nodo;
        }

        if (dato < nodo.getDato()) {
            nodo.setIzquierdo(eliminarNodo(nodo.getIzquierdo(), dato));
        } else if (dato > nodo.getDato()) {
            nodo.setDerecho(eliminarNodo(nodo.getDerecho(), dato));
        } else {
            if (nodo.getIzquierdo() == null && nodo.getDerecho() == null) {
                System.out.println("borrando " + dato);
                return null;
            } else if (nodo.getIzquierdo() == null) {
                System.out.println("borrando " + dato);
                return nodo.getDerecho();
            } else if (nodo.getDerecho() == null) {
                System.out.println("borrando " + dato);
                return nodo.getIzquierdo();
            } else {
                int minValue = valorMinimo(nodo.getDerecho());
                nodo.setDato(minValue);
                nodo.setDerecho(eliminarNodo(nodo.getDerecho(), minValue));
                System.out.println("borrando " + dato);
            }
        }

        return nodo;
    }

    private Integer valorMinimo(Nodo nodo) {

        if (nodo.getIzquierdo() != null) {
            return valorMinimo(nodo.getIzquierdo());
        }
        return nodo.getDato();
    }

    private void mostrar(Nodo nodo) {
        if (nodo == null) {
            return;
        }

        String str = "";
        if (nodo.izquierdo == null) {
            str += ".";
        } else {
            str += nodo.izquierdo.dato;
        }
        str += " => " + nodo.dato + " <= ";
        if (nodo.derecho == null) {
            str += ".";
        } else {
            str += nodo.derecho.dato;
        }

        System.out.println(str);
        mostrar(nodo.derecho);
        mostrar(nodo.izquierdo);
    }

}

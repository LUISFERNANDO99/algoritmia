/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nodoss;

import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author LUIS FERNANDO
 */
public class principal {

    public static String dato, datos, busca, elimina, elige;
    public static Nodoss nodos = new Nodoss();

    public static void main(String[] args) {
        menu();

    }

    public static void menu() {
        elige = JOptionPane.showInputDialog("ELIGE UNA OPCION" + "\n 1.-agrega al inicio" + "\n 2.-agrega al final" + "\n 3.-buscar" + "\n 4.-eliminar al inicio" + "\n 5.-elimina al final" + "\n 6.-crea arbol" + "\n 7.-salir");
        if (elige.equals("1")) {
            agregainicio();
        } else if (elige.equals("2")) {
            agregafinal();
        } else if (elige.equals("3")) {
            busca();
        } else if (elige.equals("4")) {
            eliminainicio();
        } else if (elige.equals("5")) {
            eliminafinal();
        } else if (elige.equals("6")) {
            crea_arbol();
        } else if (elige.equals("7")) {
            System.exit(0);
        } else {
            System.out.println("no existe esa opcion");
        }
    }

    public static void eliminafinal() {
        System.out.println("eliminado : " + nodos.elimina_dato_final());
        System.out.println("datos restantes");
        nodos.mostrarlista();
        menu();
    }

    public static void eliminainicio() {
        System.out.println("eliminado : " + nodos.eliminar_dato_inicio());
        System.out.println("datos restantes");
        nodos.mostrarlista();
        menu();
    }

    public static void busca() {
        busca = JOptionPane.showInputDialog("ingresa un dato a buscar");
        if (nodos.buscaDato(busca)) {
            System.out.println("si existe");
            menu();
        } else {
            System.out.println("no existe ");
            menu();
        }
    }

    public static void agregainicio() {
        boolean o = false;
        while (o != true) {
            String opcion = JOptionPane.showInputDialog("ELIGE UNA OPCION" + "\n 1.-ingresa nodo" + "\n 2.-salir al menu");
            if (opcion.equals("1")) {
                dato = JOptionPane.showInputDialog("ingresa un numero");
                nodos.agrega_inicio(dato);
                nodos.mostrarlista();
                System.out.println("elemento agregado : " + nodos.primerElemento());
            } else if (opcion.equals("2")) {
                o = true;
                menu();
            }
        }
        nodos.mostrarlista();
        System.out.println("Elementos agregados : " + nodos.cantidadNodos());//para ver cuantos nodos agregamos
    }

    public static void agregafinal() {
        boolean o = false;
        while (o != true) {
            String opcion = JOptionPane.showInputDialog("ELIGE UNA OPCION" + "\n 1.-ingresa nodo" + "\n 2.-salir al menu");
            if (opcion.equals("1")) {
                datos = JOptionPane.showInputDialog("ingresa un numero");
                nodos.agreg_final(datos);
                nodos.mostrarlista();
                System.out.println("ultimo elemento agrrgado : " + nodos.ultimoElemento());
            } else if (opcion.equals("2")) {
                o = true;
                menu();
            }
        }
        nodos.mostrarlista();
        System.out.println("Elementos agregados : " + nodos.cantidadNodos());//para ver cuantos nodos agregamos  
    }

    public static void crea_arbol() {
        boolean o = false;
        while (o != true) {
            String opcion = JOptionPane.showInputDialog("ELIGE UNA OPCION" + "\n 1.-ingresa dato" + "\n 2.-salir al menu");
            if (opcion.equals("1")) {
                dato = JOptionPane.showInputDialog("ingresa un numero");
                nodos.arbol(dato);
                nodos.mostrarlista();
            } else if (opcion.equals("2")) {
                o = true;
                menu();
            }
        }
        nodos.mostrarlista();
        System.out.println("Elementos agregados : " + nodos.cantidadNodos());//para ver cuantos nodos agregamos
    }
}

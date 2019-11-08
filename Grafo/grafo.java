/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aristas;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author LUIS FERNANDO
 */
public class grafo {

    //atributos

    public static final String SEPARATOR = ",";
    public static final String QUOTE = "\"";
    public static ArrayList<String> listas = new ArrayList<String>();
    public static List<nodo>nodos = new ArrayList<>();
    public static List<arista>aristas= new ArrayList<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = null;

        try {

            br = new BufferedReader(new FileReader("C:\\Users\\LUIS FERNANDO\\Documents\\NetBeansProjects\\nodoss\\src\\aristas\\archivo.csv"));
            String line = br.readLine();
            int cont=0;
            while (null != line) {
                String[] fields = line.split(SEPARATOR);
                //System.out.println(Arrays.toString(fields));
                fields = removeTrailingQuotes(fields);
                //System.out.println(""+fields[1]);
                if (nodos.isEmpty()) {
                    String[] aux=line.split(",");
                    for (int i = 0; i < aux.length; i++) {
                        nodos.add(new nodo(aux[i]));
                    }
                    for (int i = 0; i < nodos.size(); i++) {
                        System.out.println(nodos.get(i).toString());
                    }
                }else{
                    String[] aux = line.split(",");
                    for (int i = 0; i < aux.length; i++) {
                        arista Arista =new arista();
                        if (aux[i].equals("1")) {
                            Arista.nodo1 = nodos.get(cont);
                            Arista.nodo2 = nodos.get(i);
                            aristas.add(Arista);
                        }
                    }
                   cont++; 
                }
                
                
                System.out.println(Arrays.toString(fields));//imprime los datos del archivo

                line = br.readLine();

            }
            for (int i = 0; i < aristas.size(); i++) {
                System.out.println(aristas.get(i).toString());
            }
            

        } catch (Exception e) {
            System.out.println("error");
        } finally {
            if (null != br) {
                br.close();
            }
        }

    }

    private static String[] removeTrailingQuotes(String[] fields) {

        String result[] = new String[fields.length];

        for (int i = 0; i < result.length; i++) {
            result[i] = fields[i].replaceAll("^" + QUOTE, "").replaceAll(QUOTE + "$", "");
        }
        return result;
    }

}

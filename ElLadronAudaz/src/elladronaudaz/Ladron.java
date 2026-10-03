/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package elladronaudaz;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author pm.arroyo.2023
 */
public class Ladron {
    // ATRIBUTOS 
    String ruta_entrada;
    ArrayList<Objeto> objetos = new ArrayList<>(); 
    int num_objetos; 
    int capacidad_mochila;
    int beneficio_max;
    ArrayList<Integer> sol = new ArrayList<>();
    ArrayList<Integer> mejor_sol = new ArrayList<>();

    // CONSTRUCTOR 
    public Ladron(String ruta_entrada) { 
        this.ruta_entrada = ruta_entrada;
        this.beneficio_max=0;
    try (BufferedReader texto = new BufferedReader(new FileReader(this.ruta_entrada))) { 
        String linea;
        if ((linea = texto.readLine()) != null) { 
        String[] cabecera = linea.trim().split(" ");
        this.num_objetos = Integer.parseInt(cabecera[0]);
        this.capacidad_mochila = Integer.parseInt(cabecera[1]);
        }  
        while ((linea = texto.readLine()) != null) { 
            linea = linea.trim(); 
            if (linea.isEmpty()) { 
            continue; 
            } 
        String[] datos = linea.split(" "); 
        int valor = Integer.parseInt(datos[0]); 
        int peso = Integer.parseInt(datos[1]); 
        this.objetos.add(new Objeto(valor, peso));
    } 
    } 
    catch (IOException e) { 
        System.err.println("Error leyendo el archivo: " + e.getMessage());
    } 
    }
    
    //METODOS
    public void robarObjetos(int k, int capacidad_actual, int beneficio_actual){
        //caso base: mo hay mas objetos que mirar
        if(k==objetos.size()){
            //ahora miramos si el beneficio que llevamos acumulado es mejor que el anterior, en ese caso actualizo el nuevo valor 
            if(beneficio_actual>beneficio_max){
                this.beneficio_max = beneficio_actual;
                this.mejor_sol = new ArrayList<>(this.sol);
            }
            return;
        }
        //si no llegamos al caso base, debemos evaluar los objetos
        Objeto objeto_actual = objetos.get(k);
        //si el objeto entra en la mochila, lo tomamos
        if(capacidad_actual+objeto_actual.getPeso()<=capacidad_mochila){
            this.sol.add(1);
            robarObjetos(k+1,capacidad_actual+objeto_actual.getPeso(),beneficio_actual+objeto_actual.getValor());
            //vuelta atras
            this.sol.remove(sol.size()-1);   
        }
        //si el obejeto no entra en la mochila
        sol.add(0);
        robarObjetos(k+1,capacidad_actual,beneficio_actual);
        this.sol.remove(sol.size()-1);               
    }
    //esta funcion inicia todo
    public ArrayList<Integer> resolver(){
        this.beneficio_max=0;
        this.sol.clear();
        this.mejor_sol.clear();
        
        robarObjetos(0,0,0);
        return mejor_sol;
    }   
}

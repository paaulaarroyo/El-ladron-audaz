/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package elladronaudaz;

import java.util.ArrayList;
public class ElLadronAudaz {
    public static void main(String[] args) {
        String ruta="src/ks_19_0"; //aqui pones el nombre del fichero que quieras resolver con src/nombre
        Ladron ladron1 = new Ladron(ruta);
        ArrayList<Integer> solucion = ladron1.resolver();
        System.out.println("objetos robados");
        System.out.println(solucion);
    }
    
}

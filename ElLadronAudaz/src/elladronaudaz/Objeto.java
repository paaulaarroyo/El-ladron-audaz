/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package elladronaudaz;

public class Objeto {
    //ATRIBUTOS
    int valor;
    int peso;
    
    //CONSTRUCTOR
    public Objeto(int valor, int peso){
        this.valor=valor;
        this.peso=peso;
    }
    
    //METODO
    public int getPeso(){
        return this.peso;
    }
    public int getValor(){
        return this.valor;
    }
    
}

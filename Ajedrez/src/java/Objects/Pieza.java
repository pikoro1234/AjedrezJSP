/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objects;

public abstract class Pieza {

    private String equipo;
    private String nombre;
    
    public Pieza(String equipo){
       this.equipo = equipo;
       this.nombre = "A";
    }
    
    public String getNombre(){
        return this.nombre;
    }
    
    public abstract void isPossibleMoving();
    
}

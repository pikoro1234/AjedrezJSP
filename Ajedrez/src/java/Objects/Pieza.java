/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objects;


public abstract class Pieza {

    private String equipo;
    private String nombre;
    private String img;
    
    public Pieza(String equipo,String nombre,String img){
       this.equipo = equipo;
       this.nombre = nombre;
       this.img = img;
    }
    
    public String getNombre(){
        return this.nombre;
    }
    
    public abstract void isPossibleMoving();
   
    public String getImage(){
        if (equipo.equalsIgnoreCase("blancas")){
            setEquipo("pb");
        } else {
            setEquipo("pn");
        }
        
        String [] a =img.split("/");
        String s = a[1].substring(1, a[1].length());
        a[1] = s;
        return this.img;
    }
    
    public void setImage(String path){
        this.img = path;       
    }
    
    public void setEquipo(String equipo){
        this.equipo = equipo;
    }
      
}

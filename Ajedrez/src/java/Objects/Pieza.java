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
       setImage(img);
    }
    
    public String getNombre(){
        return this.nombre;
    }
    
    public abstract void isPossibleMoving(int x,int y);
   
    public String getImage(){
        return img;
    }
    
    public String getEquipo(){
        return equipo;
    }
    
    public Pieza getPieza(){
        return this;
    }
    
    public final void setImage(String path){
        if (equipo.equalsIgnoreCase("Blanco") && !(equipo.isEmpty())){
            String[] a = path.split("/");
            a[1] = "/blancas/"+nombre.toLowerCase()+"b.png";
            this.img = String.join("",a);
        } else if (equipo.equalsIgnoreCase("Negro") && !(equipo.isEmpty())){
            String a[] = path.split("/");
            a[1] = "/negras/"+nombre.toLowerCase()+"n.png";
            this.img = String.join("",a);
        }
    }
   
 
      
}

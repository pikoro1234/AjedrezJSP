package Objects;

import java.util.ArrayList;

public class Jugador {
    
    private String nombre;   
    private Equipo equipo;
    private Pieza cache;
    private ArrayList<Pieza> cementerio = new ArrayList<Pieza>();
       
    public Jugador(String nombre, Equipo equipo) {
        this.nombre = nombre;
        this.equipo = equipo;
    }
    
    public Jugador() {}

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Equipo getEquipo() {
        return equipo;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }

    public void setCache(Pieza p){
        this.cache = p;
    }
    
    public Pieza getCache(){
        return this.cache;
    }
    
    public void agregar(Pieza pieza){
        cementerio.add(pieza);
    }
    
    public ArrayList<Pieza> getCementerio() {
        return cementerio;
    }

}

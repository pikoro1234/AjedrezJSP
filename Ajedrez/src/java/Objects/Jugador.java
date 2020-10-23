package Objects;

public class Jugador {
    
    private String nombre;   
    
    private String equipo;
    private Pieza cache;
    
    public Jugador(String nombre, String equipo) {
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

    public String getEquipo() {
        return equipo;
    }

    public void setEquipo(String equipo) {
        this.equipo = equipo;
    }

    public void setCache(Pieza p){
        this.cache = p;
    }
    
    public Pieza getCache(){
        return this.cache;
    }

}

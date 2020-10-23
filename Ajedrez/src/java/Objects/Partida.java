/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objects;

public class Partida {
    
    private int turno;
    private Tablero t;  
    private Jugador jugador1;
    private Jugador jugador2;
    
    public Partida(Jugador j1,Jugador j2){
        this.t = Tablero.get();
        this.turno = 1;
        this.jugador1 = j1;
        this.jugador2 = j2;
    }
       
    public Tablero getTablero(){
        return t;
    }
    
    public void sumarRonda(){
        this.turno+=1;
    }
    
    public int getRonda(){
        return this.turno;
    }

    public Jugador getJugadorBlanco(){
        return this.jugador1;
    }
    
    public Jugador getJugadorNegro(){
        return this.jugador2;
    }
    
    public void mover(int x,int y){
        if (turno %2 == 0){ // turno blanco
            if (t.tablero[x][y] != null && t.tablero[x][y].getEquipo().equals("blanco")){
                jugador1.setCache(t.tablero[x][y]);
            }
            if ((t.tablero[x][y].getEquipo().equals("negro") || 
                    t.tablero[x][y] == null) && jugador1.getCache() != null){
                
                jugador1.getCache().isPossibleMoving(x, y);             
                jugador1.setCache(null);
                sumarRonda();
                
            }
        } else { // turno negro
            if (t.tablero[x][y] != null && t.tablero[x][y].getEquipo().equals("negro")){
                jugador2.setCache(t.tablero[x][y]);
            }
            if ((t.tablero[x][y].getEquipo().equals("blanco") || 
                    t.tablero[x][y] == null) && jugador2.getCache() != null){
                
                jugador2.getCache().isPossibleMoving(x, y);
                sumarRonda();
                jugador2.setCache(null);
                
            }
        }
    }    
    
}

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

    public void setRonda(int r){
        this.turno = 1;
    }
    
    public Jugador getJugadorBlanco(){
        return this.jugador1;
    }
    
    public Jugador getJugadorNegro(){
        return this.jugador2;
    }
    
    public void mover(int x,int y){
        
        if (turno % 2 == 0){
   
          if (getTablero().tablero[x][y] != null 
                    && getTablero().tablero[x][y].getEquipo().equals("blanco")){
                    
                jugador1.setCache(getTablero().tablero[x][y]);
                jugador1.getCache().setX(x);
                jugador1.getCache().setY(y);
                return;
            }            
          
          if (getTablero().tablero[x][y] == null || getTablero().tablero[x][y]
                  .getEquipo().equals("negro")){
              if (jugador1.getCache() != null){
                
                jugador1.getCache().isPossibleMoving(getTablero(),getJugadorBlanco(), x, y);
                jugador1.setCache(null);
                sumarRonda();
              
              }
          }
            
        } else {
            
            if (getTablero().tablero[x][y] != null 
                    && getTablero().tablero[x][y].getEquipo().equals("negro")){
                    
                jugador2.setCache(getTablero().tablero[x][y]);
                jugador2.getCache().setX(x);
                jugador2.getCache().setY(y);
                
                return;
            }
            
          if (getTablero().tablero[x][y] == null || 
                  getTablero().tablero[x][y].getEquipo().equals("blanco")){
                  
              if (jugador2.getCache() != null){
              
              jugador2.getCache().isPossibleMoving(getTablero(),getJugadorNegro(), x, y);
              jugador2.setCache(null);
              sumarRonda();              
            }

          }
            
        }
        
    }    
    
}

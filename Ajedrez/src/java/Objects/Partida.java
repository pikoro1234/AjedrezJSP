/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objects;

import java.util.ArrayList;

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
                this.getPossibleMoves(getJugadorBlanco(), getTablero());
                //TODO: Pintar posibles movimientos en el tablero
                return;
            }            
          
          if (getTablero().tablero[x][y] == null || getTablero().tablero[x][y]
                  .getEquipo().equals("negro")){
              if (jugador1.getCache() != null){
                
                if (jugador1.getCache().isPossibleMoving(getTablero(),getJugadorBlanco(), x, y)){
                    move(getJugadorBlanco(),x,y);                    
                    jugador1.setCache(null);
                    sumarRonda();
                }
              
              }
          }
            
        } else {
            
            if (getTablero().tablero[x][y] != null 
                    && getTablero().tablero[x][y].getEquipo().equals("negro")){
                    
                jugador2.setCache(getTablero().tablero[x][y]);
                jugador2.getCache().setX(x);
                jugador2.getCache().setY(y);
                this.getPossibleMoves(getJugadorNegro(), getTablero());
                return;
            }
            
          if (getTablero().tablero[x][y] == null || 
                  getTablero().tablero[x][y].getEquipo().equals("blanco")){
                  
              if (jugador2.getCache() != null){
                
                if (jugador2.getCache().isPossibleMoving(getTablero(),getJugadorNegro(), x, y)){
                    move(getJugadorNegro(),x,y);
                    jugador2.setCache(null);
                    sumarRonda();                     
                }
             
            }

          }
            
        }
        
    }

    public ArrayList<Integer> getPossibleMoves(Jugador j,Tablero t){
        ArrayList<Integer> valid = new ArrayList();
        Pieza p = j.getCache();

        for(int x = 0;x<t.tablero.length;x++){
            for (int y = 0;y<t.tablero[x].length;y++){
               if(p.isPossibleMoving(t, j, x, y)){
                   valid.add(Integer.parseInt(x+""+y));
               }
            }

        }

        return valid;
    }
    
    public void move(Jugador j,int x,int y){
        getTablero().tablero[j.getCache().getX()][j.getCache().getY()] = null;
        getTablero().tablero[x][y] = j.getCache();
    }

    
    
}

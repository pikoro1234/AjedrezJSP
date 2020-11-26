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
                    && getTablero().tablero[x][y].getEquipo() == Equipo.Blanco ) {
                
                if (getJugadorBlanco().getCache() != getTablero().tablero[x][y]){
                    cleanPossibleMoves();
                }
                jugador1.setCache(getTablero().tablero[x][y]);
                jugador1.getCache().setX(x);
                jugador1.getCache().setY(y);
                this.getPossibleMoves(getJugadorBlanco(), getTablero());
                
                return;
            }            
          
          
          if (getTablero().tablero[x][y] == null || getTablero().tablero[x][y]
                  .getEquipo() == Equipo.Negro  || getTablero().tablero[x][y] instanceof Fantasma){
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
                    && getTablero().tablero[x][y].getEquipo() == Equipo.Negro ){

                if (getJugadorNegro().getCache() != getTablero().tablero[x][y]){
                    cleanPossibleMoves();
                }
                
                jugador2.setCache(getTablero().tablero[x][y]);
                jugador2.getCache().setX(x);
                jugador2.getCache().setY(y);
                this.getPossibleMoves(getJugadorNegro(), getTablero());
                return;
            }
            
          if (getTablero().tablero[x][y] == null || 
                  getTablero().tablero[x][y].getEquipo() == Equipo.Blanco || getTablero().tablero[x][y] instanceof Fantasma){
                  
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
    
    public void cleanPossibleMoves(){
        
        
        for(int x = 0;x<getTablero().tablero.length;x++){
            for(int y = 0;y<getTablero().tablero[x].length;y++){
                if (getTablero().tablero[x][y] != null && !(getTablero().tablero[x][y] instanceof Fantasma) && getTablero().tablero[x][y].isEatable()){
                    getTablero().tablero[x][y].setEatable(false);
                } else if (getTablero().tablero[x][y] instanceof Fantasma ){
                    getTablero().tablero[x][y] = null;
                }

            }
        }
    }
    
    
    public ArrayList<Integer> getPossibleMoves(Jugador j,Tablero t){
        ArrayList<Integer> valid = new ArrayList();
        Pieza p = j.getCache();

        for(int x = 0;x<t.tablero.length;x++){
            for (int y = 0;y<t.tablero[x].length;y++){
               if(p.isPossibleMoving(t, j, x, y) && t.tablero[x][y] instanceof Pieza){
                   if (!(t.tablero[x][y].getEquipo().equals(j.getEquipo()))){
                       t.tablero[x][y].setEatable(true);
                   }
               }
               if(p.isPossibleMoving(t, j, x, y) && t.tablero[x][y] == null){
                    t.tablero[x][y] = new Fantasma();
               }
            }

        }

        return valid;
    }
    
    public void move(Jugador j,int x,int y){
        if(getTablero().tablero[j.getCache().getX()][j.getCache().getY()] instanceof Peon){
            Peon p = (Peon) getTablero().tablero[j.getCache().getX()][j.getCache().getY()];
            p.setMoved(true);
        }
        
        getTablero().tablero[j.getCache().getX()][j.getCache().getY()] = null;
  
        if(getTablero().tablero[x][y] != null){
            if (!(j.getEquipo() == t.tablero[x][y].getEquipo()) && t.tablero[x][y] != null && !(t.tablero[x][y] instanceof Fantasma )) {
                j.agregar(t.tablero[x][y]);
            }
        }
        
        getTablero().tablero[x][y] = j.getCache();
        cleanPossibleMoves();
    }
}

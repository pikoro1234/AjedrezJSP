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
                
                if (getJugadorBlanco().getSelected() != getTablero().tablero[x][y]){
                    cleanPossibleMoves();
                }
                jugador1.setCache(getTablero().tablero[x][y]);
                jugador1.getSelected().setX(x);
                jugador1.getSelected().setY(y);
                this.getPossibleMoves(getJugadorBlanco(), getTablero());
                
                return;
            }            
          
          
          if (getTablero().getPieceAt(x, y) == null || getTablero().getPieceAt(x, y)
                  .getEquipo() == Equipo.Negro  || getTablero().getPieceAt(x, y) instanceof Fantasma){
              if (jugador1.getSelected() != null){
                
                if (jugador1.getSelected().isPossibleMoving(getTablero(),getJugadorBlanco(), x, y)){
                    move(getJugadorBlanco(),x,y);                    
                    jugador1.setCache(null);
                    sumarRonda();
                }
              
              }
          }
            
        } else {
            
            if (getTablero().getPieceAt(x, y) != null 
                    && getTablero().getPieceAt(x,y).getEquipo() == Equipo.Negro ){

                if (getJugadorNegro().getSelected() != getTablero().getPieceAt(x, y)){
                    cleanPossibleMoves();
                }
                
                jugador2.setCache(getTablero().getPieceAt(x, y));
                jugador2.getSelected().setX(x);
                jugador2.getSelected().setY(y);
                this.getPossibleMoves(getJugadorNegro(), getTablero());
                return;
            }
            
          if (getTablero().tablero[x][y] == null || 
                  getTablero().getPieceAt(x, y).getEquipo() == Equipo.Blanco || getTablero().getPieceAt(x, y) instanceof Fantasma){
                  
              if (jugador2.getSelected() != null){
                
                if (jugador2.getSelected().isPossibleMoving(getTablero(),getJugadorNegro(), x, y)){
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
                if (getTablero().getPieceAt(x, y) != null && !(getTablero().getPieceAt(x, y) instanceof Fantasma) && getTablero().getPieceAt(x, y).isEatable()){
                    getTablero().getPieceAt(x, y).setEatable(false);
                } else if (getTablero().getPieceAt(x, y) instanceof Fantasma ){
                    getTablero().tablero[x][y] = null;
                }

            }
        }
    }
    
    
    public ArrayList<Integer> getPossibleMoves(Jugador j,Tablero t){
        ArrayList<Integer> valid = new ArrayList();
        Pieza p = j.getSelected();

        for(int x = 0;x<t.tablero.length;x++){
            for (int y = 0;y<t.tablero[x].length;y++){
               if(p.isPossibleMoving(t, j, x, y) && t.getPieceAt(x, y) instanceof Pieza){
                   if (!(t.getPieceAt(x, y).getEquipo().equals(j.getEquipo()))){
                       t.tablero[x][y].setEatable(true);
                   }
               }
               if(p.isPossibleMoving(t, j, x, y) && t.getPieceAt(x, y) == null){
                    t.tablero[x][y] = new Fantasma();
               }
            }

        }

        return valid;
    }
    
    public void move(Jugador j,int x,int y){
        if(getTablero().tablero[j.getSelected().getX()][j.getSelected().getY()] instanceof Peon){
            Peon p = (Peon) getTablero().getPieceAt(j.getSelected().getX(), j.getSelected().getY());
            p.setMoved(true);
        }
        
        getTablero().tablero[j.getSelected().getX()][j.getSelected().getY()] = null;
  
        if(getTablero().getPieceAt(x, y) != null){
            if (!(j.getEquipo() == t.getPieceAt(x, y).getEquipo()) && t.tablero[x][y] != null && !(t.getPieceAt(x, y) instanceof Fantasma )) {
                j.agregar(t.getPieceAt(x, y));
            }
        }
        
        getTablero().tablero[x][y] = j.getSelected();
        cleanPossibleMoves();
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objects;

public class Peon extends Pieza implements PiezaBloqueable {
    
    public boolean moved = false;
    
    public Peon(String equipo) {
        super(equipo, "P", "img/p.png");

    }
    
    public void setMoved(boolean b){
        this.moved = b;
    }
    
    @Override
    public boolean isPossibleMoving(Tablero t,Jugador j,int x,int y) {
            
        if(!isBlocked(t,j.getCache().getX(),j.getCache().getY(),x,y)){
            return true;
        }
                    
        return false;
    }

    @Override
    public boolean isBlocked(Tablero t, int pieceX, int pieceY, int toX, int toY) {
            Peon p = (Peon) t.tablero[pieceX][pieceY];
            if(pieceY == toY){
                if (!p.moved) {
                    int dif = p.getEquipo().equals("blanco") ? toX - pieceX : pieceX - toX;
                    if(dif == 2 || dif == 1){
                        while(!(dif == 0)){
                            if(p.getEquipo().equals("blanco")){
                                if(t.tablero[pieceX++][pieceY] != null){
                                    return false;
                                }
                            }else{
                                if(t.tablero[pieceX--][pieceY] != null){
                                    return false;
                                }
                            }
                            dif--;
                        }
                    }
                } else {
                    int nextPos = p.getEquipo().equals("blanco") ? pieceX + 1 : pieceX - 1;
                    if (nextPos <= 7 && nextPos >=0 && t.tablero[nextPos][pieceY] == null){
                        if (p.getEquipo().equals("blanco") && toX - pieceX == 1){
                            return false;
                        } else if (p.getEquipo().equals("negro") && pieceX - toX == 1){
                            return false;
                        }
                    }                    
                }

            }
            return true;
        }
    }

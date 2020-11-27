/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objects;

public class Peon extends Pieza implements PiezaBloqueable {
    
    public boolean moved = false;
    
    public Peon(Equipo equipo) {
        super(equipo, "P", "img/p.png");

    }
    
    public void setMoved(boolean b){
        this.moved = b;
    }
    
    @Override
    public boolean isPossibleMoving(Tablero t,Jugador j,int x,int y) {
            
        if(!isBlocked(t,j.getSelected().getX(),j.getSelected().getY(),x,y)){
            return true;
        }
                    
        return false;
    }

    @Override
    public boolean isBlocked(Tablero t, int pieceX, int pieceY, int toX, int toY) {
            Peon p = (Peon) t.getPieceAt(pieceX, pieceY);
            if(pieceY == toY){
                if (!p.moved) {
                    int dif = p.getEquipo() == Equipo.Blanco ? toX - pieceX : pieceX - toX;
                    if(dif == 2 || dif == 1){
                        while(!(dif == 0)){
                            if(p.getEquipo() == Equipo.Blanco){
                                if(t.getPieceAt(pieceX++,pieceY) != null){
                                    return false;
                                }
                            }else{
                                if(t.getPieceAt(pieceX--,pieceY) != null){
                                    return false;
                                }
                            }
                            dif--;
                        }
                    }
                } else {
                    int nextPos = p.getEquipo() == Equipo.Blanco ? pieceX + 1 : pieceX - 1;
                    if (nextPos <= 7 && nextPos >=0 && t.getPieceAt(nextPos, pieceY) == null){
                        if (p.getEquipo() == Equipo.Blanco && toX - pieceX == 1){
                            return false;
                        } 
                        
                        if (p.getEquipo() == Equipo.Negro && pieceX - toX == 1){
                            return false;
                        }
                    }                    
                }

            }
            return true;
        }
    }

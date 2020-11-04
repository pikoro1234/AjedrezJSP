/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objects;

public class Peon extends Pieza implements PiezaBloqueable {
    
    private boolean moved = false;
    
    public Peon(String equipo) {
        super(equipo, "P", "img/p.png");

    }

    @Override
    public boolean isPossibleMoving(Tablero t,Jugador j,int x,int y) {
            
            int modX = j.getEquipo().equals("blanco") ? 1 : -1;
            Peon p = (Peon) j.getCache().getPieza();
            int xaux,yaux;
            
            if (p.getY() + 1 > 7 || p.getY() - 1 < 0){return false;}
            
            if ((t.tablero[xaux = p.getX() + modX][yaux = p.getY() + 1] != null) && (xaux == x && yaux == y)){
                t.tablero[p.getX()][p.getY()] = null;
                t.tablero[xaux][yaux] = j.getCache();
                p.moved = true;
                return true;
            } else if ((t.tablero[xaux = p.getX() + modX][yaux = p.getY() - 1] != null) && (xaux == x && yaux == y)){
                t.tablero[p.getX()][p.getY()] = null;
                t.tablero[xaux][yaux] = j.getCache();
                p.moved = true;
                return true;
            }
                        
            if (!isBlocked(t,j.getCache().getX(),j.getCache().getY(),x,y)){
                t.tablero[p.getX()][p.getY()] = null;
                t.tablero[x][y] = j.getCache();
                return true;
            }
            
            return false;
        }

    @Override
    public boolean isBlocked(Tablero t, int pieceX, int pieceY, int toX, int toY) {
            
            if(this.moved && t.tablero[toX][toY] == null){
                return false;
            }
            
            return true;
        }
    }
//}

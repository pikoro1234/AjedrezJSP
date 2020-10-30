/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objects;

public class Torre extends Pieza implements PiezaBloqueable {
    
    private String nombre;
    
    public Torre(String equipo){
        super(equipo,"T","img/t.png");
    }
    
    @Override
    public boolean isPossibleMoving(Tablero t,Jugador j,int x,int y) {
        
        boolean valid = true;
        
        if (isValidMovement(j.getCache().getX(),j.getCache().getY(),x,y)){          
            
            valid = isBlocked(t,j.getCache().getX(),j.getCache().getY(),x,y);
            
            if (valid){
                t.tablero[j.getCache().getX()][j.getCache().getY()] = null;
                t.tablero[x][y] = j.getCache();
                return true;
            }
            
        }
                
        return false;
        
    }
  
    @Override
    public boolean isBlocked(Tablero t, int pieceX, int pieceY, int toX, int toY) {
        
        if (pieceY == toY){
            
            int dx = (pieceX < toX) ? 1 : -1;
            
            for (int i = pieceX + dx ; i != toX ; i+= dx){
                if (t.tablero[i][pieceY] != null){
                    return false;
                }
            }
            
        } else {
            
            int dy = (pieceY < toY) ? 1 : -1;
             for (int i = pieceY + dy ; i != toY ; i+= dy){
                if (t.tablero[pieceX][i] != null){
                    return false;
                }
            }           
        }
        
        return true;
    }

    public boolean isValidMovement(int pX,int pY,int x,int y){
        
        return pX == x || pY == y ? true : false;
        
    }    
    
}

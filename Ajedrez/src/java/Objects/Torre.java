/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objects;

public class Torre extends Pieza implements PiezaBloqueable {
    
    private String nombre;
    
    public Torre(Equipo equipo){
        super(equipo,"T","img/t.png");
    }
    
    @Override
    public boolean isPossibleMoving(Tablero t,Jugador j,int x,int y) {
        
        boolean valid = true;
        
        if (isValidMovement(j.getSelected().getX(),j.getSelected().getY(),x,y)){          
            
            valid = isBlocked(t,j.getSelected().getX(),j.getSelected().getY(),x,y);
            
            if (valid){
                return true;
            }
            
        }
                
        return false;
        
    }
  
    @Override
    public boolean isBlocked(Tablero t, int pieceX, int pieceY, int toX, int toY) {
        
        if (pieceY == toY){
            
            int dx = (pieceX < toX) ? 1 : -1;
            
            for (int i = pieceX + dx ; i != toX; i+= dx){
                if (t.getPieceAt(i, pieceY) != null){
                    return false;
                }
            }
            
        } else if (pieceX == toX){
            
            int dy = (pieceY < toY) ? 1 : -1;
             for (int i = pieceY + dy ; i != toY; i+= dy){
                if (t.getPieceAt(pieceX, i) != null){
                    return false;
                }
            }           
        }
        
        return true;
    }

    public boolean isValidMovement(int pX,int pY,int x,int y){
        
        return (pX == x || pY == y);
        
    }    
    
}

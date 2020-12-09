/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objects;

import Utils.Directions;

public class Torre extends Pieza implements PiezaBloqueable {
    
    private String nombre;
    
    public Torre(Equipo equipo){
        super(equipo,"T","img/t.png");
    }
    
    @Override
    public boolean isPossibleMoving(Tablero t,Jugador j,int x,int y) {
        
        
        if (isValidMovement(j.getSelected().getX(),j.getSelected().getY(),x,y)){          
            
            boolean valid = isBlocked(t,j.getSelected().getX(),j.getSelected().getY(),x,y);
            
            if (valid){
                return true;
            }
            
        }
                
        return false;
        
    }
  
    @Override
    public boolean isBlocked(Tablero t, int pieceX, int pieceY, int toX, int toY) {
        
        if (pieceY == toY){
            
            return Directions.moverX(t, pieceX, pieceY, toX, toY);
            
        } else if (pieceX == toX){
            
            return Directions.moverY(t, pieceX, pieceY, toX, toY);
            
        }
        
        return false;
    }

    public boolean isValidMovement(int pX,int pY,int x,int y){
        
        return (pX == x || pY == y);
        
    }    
    
}

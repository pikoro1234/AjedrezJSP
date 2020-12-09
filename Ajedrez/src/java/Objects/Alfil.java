/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objects;

import Utils.Directions;

public class Alfil extends Pieza implements PiezaBloqueable {

    public Alfil(Equipo equipo) {
        super(equipo,"A", "img/a.png");
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
    
    public boolean isValidMovement(int pX,int pY,int x,int y){
        return Math.abs(pX - x) == Math.abs(pY - y);
    }

    @Override
    public boolean isBlocked(Tablero t, int pieceX, int pieceY, int toX, int toY) {

        if (pieceX > toX && pieceY < toY){ // Diagonal arriba izq

            return Directions.diagonalTopIzq(t, pieceX, pieceY, toX, toY);
        }
        else if(pieceX < toX && pieceY > toY){
           
           return Directions.diagonalTopDer(t, pieceX, pieceY, toX, toY);   
        }
        else if (pieceX > toX && pieceY > toY){

            return Directions.diagonalBotIzq(t, pieceX, pieceY, toX, toY);
        } 
        
        else if (pieceX < toX && pieceY < toY){
           
           return Directions.diagonalBotDer(t, pieceX, pieceY, toX, toY);

        }

        return true;
    }
    
}

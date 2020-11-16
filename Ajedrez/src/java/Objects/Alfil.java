/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objects;

public class Alfil extends Pieza implements PiezaBloqueable {

    public Alfil(String equipo) {
        super(equipo,"A", "img/a.png");
    }
    
    
    @Override
    public boolean isPossibleMoving(Tablero t,Jugador j,int x,int y) {      
        
        if (isValidMovement(j.getCache().getX(),j.getCache().getY(),x,y)){
            
            boolean valid = isBlocked(t,j.getCache().getX(),j.getCache().getY(),x,y);
            
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
        int xaux = pieceX, yaux = pieceY;
        //if(pieceY == toY && pieceX == toX){return true;}
        if (pieceX > toX && pieceY < toY){ // Diagonal arriba izq
            xaux--;
            yaux++;
            while (!(xaux == toX && yaux == toY)){
                if(t.tablero[xaux][yaux] != null && !(t.tablero[xaux][yaux] instanceof Fantasma)){
                    return false;
                }
                xaux--;
                yaux++;


            }
        } 
        
        else if(pieceX < toX && pieceY > toY){
            xaux++;
            yaux--;
            while(!(xaux == toX && yaux == toY)){
                if(t.tablero[xaux][yaux] != null && !(t.tablero[xaux][yaux] instanceof Fantasma)){
                    return false;
                }
                xaux++;
                yaux--;

            }

            
        } 
        
        else if (pieceX > toX && pieceY > toY){
            xaux--;
            yaux--;
            while(!(xaux == toX && yaux == toY)){
                if(t.tablero[xaux][yaux] != null && !(t.tablero[xaux][yaux] instanceof Fantasma)){
                    return false;
                }  
                xaux--;
                yaux--;
             
            }
        } 
        
        else if (pieceX < toX && pieceY < toY){
            xaux++;
            yaux++;
            while(!(xaux == toX && yaux == toY)){
                if(t.tablero[xaux][yaux] != null && !(t.tablero[xaux][yaux] instanceof Fantasma)){
                    return false;
                }  
                xaux++;
                yaux++;  
                     
            }

        }

        return true;
    }
    
}

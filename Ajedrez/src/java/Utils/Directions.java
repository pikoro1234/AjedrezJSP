/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import Objects.Fantasma;
import Objects.Tablero;

public class Directions {
    
    public static boolean diagonalTopIzq(Tablero t,int pieceX,int pieceY,int toX,int toY){
        int xaux = pieceX, yaux = pieceY;

        xaux--;
        yaux++;
        while (!(xaux == toX && yaux == toY)){
            //if (xaux < 0 || xaux > 7 || yaux < 0 || yaux > 7){ break; }
            if(t.getPieceAt(xaux, yaux) != null && !(t.getPieceAt(xaux, yaux) instanceof Fantasma)){
                return false;
            }
            xaux--;
            yaux++;


        }

        return true;
    }
        
    public static boolean diagonalTopDer(Tablero t,int pieceX,int pieceY,int toX,int toY){
        int xaux = pieceX, yaux = pieceY;

        xaux++;
        yaux--;
        while(!(xaux == toX && yaux == toY)){
            if(t.getPieceAt(xaux, yaux) != null && !(t.getPieceAt(xaux, yaux) instanceof Fantasma)){
                return false;
            }
            xaux++;
            yaux--;

        }
        return true;   
    }
    
    public static boolean diagonalBotIzq(Tablero t,int pieceX,int pieceY,int toX,int toY){
        int xaux = pieceX, yaux = pieceY;
        
        xaux--;
        yaux--;
        while(!(xaux == toX && yaux == toY)){
            if(t.getPieceAt(xaux, yaux) != null && !(t.getPieceAt(xaux, yaux) instanceof Fantasma)){
                return false;
            }  
            xaux--;
            yaux--;

        }        
        
        return true;
    }
    
    public static boolean diagonalBotDer(Tablero t, int pieceX, int pieceY,int toX,int toY){
        int xaux = pieceX, yaux = pieceY;
        
        xaux++;
        yaux++;
        while(!(xaux == toX && yaux == toY)){
            if(t.getPieceAt(xaux, yaux) != null && !(t.getPieceAt(xaux, yaux) instanceof Fantasma)){
                return false;
            }  
            xaux++;
            yaux++;  

        }        
        
        return true;
    }
}  

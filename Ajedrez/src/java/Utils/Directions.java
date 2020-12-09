/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import Objects.Fantasma;
import Objects.Tablero;

public class Directions {
    
    public static boolean moverX(Tablero t,int pieceX,int pieceY,int toX,int toY){

        int dx = (pieceX < toX) ? 1 : -1;

        for (int i = pieceX + dx ; i != toX; i+= dx){
            if (i <=7 && i>=0){
                if (t.getPieceAt(i, pieceY) != null && !(t.getPieceAt(i, pieceY) instanceof Fantasma)){
                    return false;
                }
            }
        }
        
        return true;
    }
    
    public static boolean moverY(Tablero t,int pieceX,int pieceY, int toX,int toY){
        
        int dy = (pieceY < toY) ? 1 : -1;
         for (int i = pieceY + dy ; i != toY; i+= dy){
            if (i <=7 && i>=0){
                if (t.getPieceAt(pieceX, i) != null && !(t.getPieceAt(pieceX, i) instanceof Fantasma)){
                    return false;
                }
            }
        }
        
        return true;
    }
    
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

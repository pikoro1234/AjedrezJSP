/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objects;

/**
 *
 * @author sergi.poza
 */
public interface PiezaBloqueable {
    
    boolean isBlocked(Tablero t,int pieceX,int pieceY,int toX,int toY);
    
}

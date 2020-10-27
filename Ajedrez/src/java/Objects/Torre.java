/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objects;

public class Torre extends Pieza {
    
    private String nombre;
    
    public Torre(String equipo){
        super(equipo,"T","img/t.png");
    }
    
    @Override
    public boolean isPossibleMoving(Tablero t,Jugador j,int x,int y) {
        
        return false;
        
    }
    
    public boolean isValidMovement(int pX,int pY,int x,int y){
        
        return pX == x || pY == y ? true : false;
        
    }

    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objects;

public class Caballo extends Pieza {

    public Caballo(Equipo equipo) {
        super(equipo,"C","img/c.png");
    }

    @Override
    public boolean isPossibleMoving(Tablero t,Jugador j,int x,int y) {        

        if (isValidMovement(j.getSelected().getX(),j.getSelected().getY(),x,y)){                               
            /*if (t.getPieceAt(x, y) != null) {
                return true;
            }*/
            return true;
        }
        return false;
    }
    
    public boolean isValidMovement(int pX,int pY,int x,int y){
        return (pX - x)*(pX - x)+(pY - y)*(pY - y) == 5;
    }
    
}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objects;

public class Alfil extends Pieza {

    public Alfil(String equipo) {
        super(equipo,"A", "img/a.png");
    }

    
    
    @Override
    public boolean isPossibleMoving(Tablero t,Jugador j,int x,int y) {
        return false;
    }
    
}

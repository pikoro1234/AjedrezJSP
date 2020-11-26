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
public class Rey extends Pieza{

    public Rey(Equipo equipo) {
        super(equipo, "K", "img/k.png");
    }

    @Override
    public boolean isPossibleMoving(Tablero t,Jugador j,int x, int y) {
        return false;
    }
    
}

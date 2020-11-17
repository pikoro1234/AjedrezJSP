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
public class Reina extends Pieza {

    public Reina(String equipo) {
        super(equipo, "Q", "img/q.png");
    }

    @Override
    public boolean isPossibleMoving(Tablero t,Jugador j,int x, int y) {
        return false;
    }
    
}

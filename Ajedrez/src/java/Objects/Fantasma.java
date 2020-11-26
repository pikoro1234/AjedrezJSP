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
public class Fantasma extends Pieza{

    public Fantasma(){
        super(Equipo.Fantasma, "FA", "");        
    }
    
    @Override
    public boolean isPossibleMoving(Tablero t, Jugador p, int x, int y) {
        return false;
    }
    
}

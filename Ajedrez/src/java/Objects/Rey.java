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

    public Rey(String equipo) {
        super(equipo, "K", "img/k.png");
    }

    @Override
    public void isPossibleMoving(Partida p,int x, int y) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

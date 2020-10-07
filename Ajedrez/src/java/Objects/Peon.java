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
public class Peon extends Pieza {

    public Peon(String equipo) {
        super(equipo, "P", "img/p.png");

    }


    @Override
    public void isPossibleMoving() {
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objects;

public class Caballo extends Pieza {

    public Caballo(String equipo) {
        super(equipo,"C","img/c.png");
    }

    
    
    @Override
    public void isPossibleMoving(int x,int y) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

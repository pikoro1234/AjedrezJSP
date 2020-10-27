/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objects;

public class Peon extends Pieza {
    
    private boolean moved = false;
    
    public Peon(String equipo) {
        super(equipo, "P", "img/p.png");

    }


    @Override
    public void isPossibleMoving(Tablero t,Jugador j,int x,int y) {
        

        
       /* Tablero t = Tablero.get();
        if (t.tablero[x][y] != null){
            Peon p = (Peon)t.tablero[x][y];
            if (t.getPieza(x, y).getEquipo().equalsIgnoreCase("blanco")){
                if (!p.moved){
                    Tablero.get().tablero[x][y] = null;
                    Tablero.get().tablero[x+2][y] = p;
                    p.moved = true;
                } else {
                    Tablero.get().tablero[x][y] = null;
                    Tablero.get().tablero[x+1][y] = p;                   
                }                
            } else {
                if (!p.moved){
                    Tablero.get().tablero[x][y] = null;
                    Tablero.get().tablero[x-2][y] = p;
                    p.moved = true;
                } else {
                    Tablero.get().tablero[x][y] = null;
                    Tablero.get().tablero[x-1][y] = p;                      
                }
            }*/
        }
    }
//}

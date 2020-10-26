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
    public void isPossibleMoving(Partida pa,int x,int y) {
        
        if (pa.getRonda() % 2 == 0 || pa.getRonda() == 0){
            pa.getTablero().tablero[x][y] = pa.getJugadorBlanco().getCache();
            pa.getTablero().tablero[pa.getJugadorBlanco().getCache().getX()][pa.getJugadorBlanco().getCache().getY()] = null;            
        } else {
            pa.getTablero().tablero[x][y] = pa.getJugadorNegro().getCache();
            pa.getTablero().tablero[pa.getJugadorNegro().getCache().getX()][pa.getJugadorNegro().getCache().getY()] = null;            
        }

        
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

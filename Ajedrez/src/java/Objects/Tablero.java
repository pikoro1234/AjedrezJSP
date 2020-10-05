/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objects;

import static java.lang.System.out;

public class Tablero {
    
    private static Tablero instance;
    private Pieza[][] tablero;
    
    private Tablero(){
        tablero = new Pieza[8][8];    
        createBoard();
    
    }
    
    public static Tablero get(){
        if (instance == null){
            instance = new Tablero();
        }
        return instance;
    }
    
    public void createBoard(){
        
        tablero[0][0] = new Torre();
        tablero[0][7] = new Torre();
        tablero[7][0] = new Torre();
        tablero[7][7] = new Torre();
        
    }
    
    public void printBoard(){
        
        for (int lin = 1;lin<tablero.length;lin++){
            for (int col = 1;col<tablero[lin].length;col++){
                if(tablero[lin][col] != null){
                    out.print(tablero[lin][col].getNombre());
                }
            }
            out.println("");
        }
    
    }
}

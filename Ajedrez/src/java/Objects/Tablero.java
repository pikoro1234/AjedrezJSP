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
        tablero = new Pieza[9][9];    
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
        tablero[0][8] = new Torre();
        tablero[8][0] = new Torre();
        tablero[8][8] = new Torre();
        
    }
    
    public String printBoard(){
        
        String var = "<table>"
                        + "<thead>"
                            + "<tr><th>A</th>"
                            + "<th>B</th>"
                            + "<th>C</th>"
                            + "<th>D</th>"
                            + "<th>E</th>"
                            + "<th>F</th>"
                            + "<th>G</th>"
                            + "<th>H</th>"
                            + "</tr>"
                        + "</thead>"
                        + "<tbody>";
                        var +="<tr>";
       
        for (int x=0; x < tablero.length; x++){
            for (int y=0; y < tablero[x].length; y++){
                if (tablero[x][y] != null){
                var += "<td class='filaColumna' data="+x+y+">"+tablero[x][y].getNombre()+"</td>";                    
                } else {
                    var += "<td class='filaColumna' data="+x+y+">"+"<p></p></td>";
                }
            }
              var +="</tr>";
        }
       
        var +="</tbody></table>";
        
        return var;
    }
}

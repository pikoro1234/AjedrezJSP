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
        
        for (int i=0;i<tablero[1].length;i++){
            tablero[1][i] = new Peon("blanco");
        }

        for (int i=0;i<tablero[6].length;i++){
            tablero[6][i] = new Peon("negro");
        }
        
    }
    
    public String printBoard(){
        
        String var = "<table>"
                        + "<thead></thead>"
                        + "<tbody>";
                        var +="<tr>";
       
        for (int x=0; x < tablero.length; x++){
            for (int y=0; y < tablero[x].length; y++){
                if (tablero[x][y] != null){
                    if ((x%2==0 && y%2!=0 || x%2!=0 && y%2==0)){
                    var += "<td class='filaColumna pares' width='50' heigth='80' data="+x+y+">"+
                        "<img class='imagen-ficha' src='"+tablero[x][y].getImage()+"' width='50' heigth='50'"+"</td>";                         
                    } else {
                    var += "<td class='filaColumna nones' width='50' heigth='80' data="+x+y+">"+
                        "<img class='imagen-ficha' src='"+tablero[x][y].getImage()+"' width='50' heigth='50'"+"</td>";                         
                    }
                   
                } else {
                    if ((x%2==0 && y%2!=0 || x%2!=0 && y%2==0)){
                        var += "<td class='filaColumna pares' width='50' heigth='80' data="+x+y+"></td>";                    
                    } else {
                        var += "<td class='filaColumna nones' width='50' heigth='80' data="+x+y+"></td>";
   
                    }

                }
            }
              var +="</tr>";
        }
       
        var +="</tbody></table>";
        
        return var;
    }
    

}

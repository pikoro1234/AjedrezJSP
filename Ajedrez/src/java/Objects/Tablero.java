/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objects;

import static java.lang.System.out;

public class Tablero {
    
    private static Tablero instance;
    public Pieza[][] tablero;
    
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
    
    public static void resetTablero(){
        instance = null;
    }
    
    public Pieza getPieza(int x,int y){
        return tablero[x][y];
    }
    
    public Pieza[][] getTablero(){
        return this.tablero;
    }
    
    public void createBoard(){
        
        tablero[0][0] = new Torre("blanco");
        tablero[0][7] = new Torre("blanco");
        tablero[7][0] = new Torre("negro");
        tablero[7][7] = new Torre("negro");
        
        tablero[0][1] = new Caballo("blanco");
        tablero[0][6] = new Caballo("blanco");
        tablero[7][1] = new Caballo("negro");
        tablero[7][6] = new Caballo("negro");

        tablero[0][2] = new Alfil("blanco");
        tablero[0][5] = new Alfil("blanco");
        tablero[7][2] = new Alfil("negro");
        tablero[7][5] = new Alfil("negro");
        
        tablero[0][3] = new Rey("blanco");
        tablero[7][3] = new Rey("negro");
        tablero[0][4] = new Reina("blanco");
        tablero[7][4] = new Reina("negro");
        
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
                    String eatable = tablero[x][y].isEatable() ? "mover" : "";
                    
                    if (tablero[x][y] instanceof Fantasma){
                        var += "<td class='filaColumna mover' width='50' height='80' data="+x+y+">"
                                + "<form action='Tablero' class='formularioDatos'>"
                                + "<input type='hidden' name='envioCoordenada' class='envioCoordenada' value='"+x+y+"'>"
                                + "<input type='hidden' name='envioNombre' class='envioNombre' value='"+tablero[x][y].getNombre()+"'>"
                                + "<input type='button' class='btnEnviar' value='send'></form></td>";
                    }else if ((x%2==0 && y%2!=0 || x%2!=0 && y%2==0)){
                    var += "<td class='filaColumna pares "+eatable+"' width='50' heigth='80' data="+x+y+" nombre='"+tablero[x][y].getNombre()+"'>"+
                            "<form action='Tablero' class='formularioDatos'>"
                            +"<img class='imagen-ficha' src='"+tablero[x][y].getImage()+"' width='50' heigth='50'>"+
                            "<input type='hidden' name='envioCoordenada' class='envioCoordenada' value='"+x+y+"'>"
                            + "<input type='hidden' name='envioNombre' class='envioNombre' value='"+tablero[x][y].getNombre()+"'>"                           
                            + "<input type='button' class='btnEnviar' value='send'></form></td>";                         
                    } else {
                    var += "<td class='filaColumna nones "+eatable+"' width='50' heigth='80' data="+x+y+" nombre='"+tablero[x][y].getNombre()+"'>"+
                            "<form action='Tablero' class='formularioDatos'>"+
                        "<img class='imagen-ficha' src='"+tablero[x][y].getImage()+"' width='50' heigth='50'>"+
                             "<input type='hidden' name='envioCoordenada' class='envioCoordenada' value='"+x+y+"'>"
                            + "<input type='hidden' name='envioNombre' class='envioNombre' value='"+tablero[x][y].getNombre()+"'>"                           
                            + "<input type='button' class='btnEnviar' value='Send'></form></td>";                         
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
    
    public boolean isOccupied(int x,int y){
        return tablero[x][y] != null && !(tablero[x][y] instanceof Fantasma);
    }
}

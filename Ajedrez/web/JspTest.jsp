<%-- 
    Document   : JspTest
    Created on : 09-oct-2020, 19:41:56
    Author     : jorge
--%>

<%@page import="Objects.Equipo"%>
<%@page import="Objects.Tablero"%>
<%@page import="Objects.Peon"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Objects.Pieza"%>
<%@page import="Objects.Jugador"%>
<%@page import="Objects.Partida"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel='stylesheet' href='css/tableStyle.css'>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>          
        <script src='http://code.jquery.com/jquery-1.9.1.js'></script>
        <script src="js/customTablero.js"></script>                             
        <title>Jsp Tablero Dinamico</title>       
    </head>
    <body>  
        
        <% 
        
        String nombreA = request.getParameter("nombre1html"); 
        
        String nombreB = request.getParameter("nombre2html");                 

        Partida p = (Partida) session.getAttribute("partida");
        Pieza[][] tablero = null;

        if (p == null){
           p = new Partida(new Jugador(nombreA,Equipo.Blanco),new Jugador(nombreB,Equipo.Negro));
           session.setAttribute("partida", p);
           tablero = p.getTablero().tablero;
       }        
        
    %>
    
    <%="longitud de array es: "+Tablero.get().tablero.length%>
           
        <h1 id='titulo' name='titulo'>Tablero</h1>       
        <div class='contenedor-principal d-flex'>
            <div class="contenido-left">
                <div class='user-left card-java'>
                    <div class="card usuario-box">
                        <div class="card-header text-center"><strong>Usuario A</strong></div>
                            <div class="card-body">
                                <h5 class="card-title titleJugador-uno"><%= nombreA %></h5>
                                <div class="bg-white equipos"></div>
                                <p class="card-text"><strong>Equipo:</strong><%= Equipo.Negro %></p>  
                            </div>
                    </div>
                    <br>
                    <br>
                    <div class="card">
                        <div class="card-header text-center">Cementerio</div>
                            <div class="card-body">
                                <div class="nuevoCementerio-dos"></div>                                  
                            </div>
                    </div>
                </div><!--fin user-left-->
                <div class='user-rigth card-java'>
                    <div class="card usuario-box">
                        <div class="card-header text-center"><strong>Usuario B</strong></div>
                            <div class="card-body">
                                <h5 class="card-title titleJugador-dos"><%= nombreB %></h5>
                                <div class="bg-dark equipos"></div>
                                <p class="card-text"><strong>Equipo:</strong><%= Equipo.Blanco %></p>                                   
                            </div>
                    </div>
                    <br>
                    <br>
                    <div class="card">
                        <div class="card-header text-center">Cementerio</div>
                            <div class="card-body">
                                <div class="nuevoCementerio"></div>
                            </div>
                    </div>
                </div><!--fin user-rigth-->
                <div class="user-center-button text-center mb-4"> 
                    <form class='formularioDatos'>                                                   
                        <input type='button' id='btnGame' value='Nueva Partida'>
                    </form> 
                    
                    
                </div><!--fin user center button-->
            </div>
            <div class="contenido-rigth">
                <div class='tablero card-java-tablero'>
                    <table>
                        <thead></thead>
                        <tbody>                                                                                         
                                <% out.println(Tablero.get().printBoard());%>
                        </tbody>
                    </table>
                </div><!--fin contenedor tablero-->                
            </div>                                                                 
        </div><!--fin contenedor-principal-->                                                
        
    </body>
</html>

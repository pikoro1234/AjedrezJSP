<%-- 
    Document   : JspTest
    Created on : 09-oct-2020, 19:41:56
    Author     : jorge
--%>

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
        String t1 = request.getParameter("dato1");
                        
        String t2 = request.getParameter("dato2");
        
        String nombreA = request.getParameter("nombre1html"); 
        
        String nombreB = request.getParameter("nombre2html"); %>                  
        
        <h1 id='titulo' name='titulo'>Tablero</h1>       
        <div class='contenedor-principal d-flex'>
            <div class="contenido-left">
                <div class='user-left card-java'>
                    <div class="card">
                        <div class="card-header text-center">Usuario A</div>
                            <div class="card-body">
                                <h5 class="card-title titleJugador-uno"><%= nombreA %></h5>
                                    <p class="card-text"><strong>Equipo:</strong><%= t1 %></p>                                    
                            </div>
                    </div>
                    <br>
                    <br>
                    <div class="card">
                        <div class="card-header text-center">Cementerio</div>
                            <div class="card-body">
                                <table class="table table-striped">
                                    <thead>
                                    </thead>
                                    <tbody>
                                        <tr>
                                          <td>00</td>
                                          <td>00</td>
                                          <td>00</td>
                                          <td>00</td>
                                        </tr>
                                     </tbody>
                                </table>                                       
                            </div>
                    </div>
                </div><!--fin user-left-->
                <div class='user-rigth card-java'>
                    <div class="card">
                        <div class="card-header text-center">Usuario B</div>
                            <div class="card-body">
                                <h5 class="card-title titleJugador-dos"><%= nombreB %></h5>
                                    <p class="card-text"><strong>Equipo:</strong><%= t2 %></p>                                   
                            </div>
                    </div>
                    <br>
                    <br>
                    <div class="card">
                        <div class="card-header text-center">Cementerio</div>
                            <div class="card-body">
                                <table class="table table-striped">
                                    <thead>   
                                    </thead>
                                    <tbody>
                                      <tr>
                                        <td>00</td>
                                        <td>00</td>
                                        <td>00</td>
                                        <td>00</td>
                                      </tr>
                                    </tbody>
                                </table> 
                            </div>
                    </div>
                </div><!--fin user-rigth-->
                <div class="user-center-button"> 
                    <form class='formularioDatos' >                                                
                        <input type="text" name="nombrePruebaTestUno" id="nombrePruebaTestUno" value="<%= nombreA %>">
                        <input type="text" name="nombrePruebaTestDos" id="nombrePruebaTestDos" value="<%= nombreB %>">
                        <input type='button' id='btnGame' value='Nueva Partida'>
                    </form>                                                    
                </div><!--fin user center button-->
            </div>
            <div class="contenido-rigth">
                <div class='tablero card-java-tablero'>                
                    <jsp:include page="/Test" />                   
                </div><!--fin contenedor tablero-->                
            </div>                                                                 
        </div><!--fin contenedor-principal-->                                                
        
    </body>
</html>

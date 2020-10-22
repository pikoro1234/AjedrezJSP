<%-- 
    Document   : portada
    Created on : 01-oct-2020, 19:03:54
    Author     : jorge
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/style.css">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV" crossorigin="anonymous"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="js/custom.js"></script>
        <title>Ajedrez</title>
    </head>
    
    
    
    <script type="text/javascript">
	$(document).ready(function(){
            $("#span-home").addClass("left-span");
            $("#span-home").click(function(){
		$(this).css({"display":"none"});
		$(".span-background").css({"display":"none"});
            });
	});
    </script>
    <body>
        
        <!--content de background negro-->   
        <div class="span-background"></div>
        
	<div id= "span-home" class="open-span" style="text-align: center;">
            <h3>Bienvenido</h3>
            <!--<span class="alertacion" style="padding-bottom: 10px;">Click Boton...</span>-->
            <span class="bg-dark information">Información<i data-feather="alert-octagon"></i></span>
		<div class="autor bg-dark">
			<span class="autoria autoria-uno">integrante integrante</span>
			<span class="autoria autoria-dos">integrante integrante</span>
                        <hr style="margin-top: 0px!important;">
			<span class="autoria autoria-tres">copyright© 2019 FLYPHI-BIT.S.R.L</span>
		</div>
	</div>
        
        <!--popup informacion-->
        <div class="jumbotron">
            <div class="content-jumbotron">
                <a class="bg-dark botonesJuego" data-toggle="modal" data-target="#exampleModalJuego">Jugar</a>
                <a class="bg-dark botonesJuego enlaceAyuda" href="Ayuda.html">Ayuda</a>
                <a class="bg-dark botonesJuego" data-toggle="modal" data-target="#exampleModal">Nosotros</a>
            </div>
        </div>        
        
        <!-- Modal  Inicio Juego -->
        <div class="modal fade" id="exampleModalJuego" tabindex="-1" aria-labelledby="exampleModalJuego" aria-hidden="true">
          <div class="modal-dialog">
            <div class="modal-content">
              <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Juego</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                  <span aria-hidden="true">&times;</span>
                </button>
              </div>
                <div class="modal-body" style="display: flex; justify-content: space-between;">           
                    <div class="body-left text-center">
                        <input type="text" class="form-control" id="jugadorA" placeholder="jugador A">
                        <br>
                        <input class="form-check-input" type="checkbox" checked="true" value="<%= "blanco" %>" id="Check1">
                        <label class="form-check-label" for="defaultCheck1">Equipo A</label>                        
                    </div>                  
                    <div class="body-right text-center">  
                      <input type="text" class="form-control" id="jugadorB" placeholder="jugador B">
                        <br>
                        <input class="form-check-input" type="checkbox" checked="true" value="<%= "negro" %>" id="Check2">
                        <label class="form-check-label" for="defaultCheck1">Equipo B</label>                        
                    </div>                                               
                </div>
              <div class="modal-footer justify-content-center">
                <button type="button" class="bg-dark botonesJuegoInicio m-0" data-dismiss="modal">Cerrar</button>
                <form action="JspTest.jsp" method="post">                    
                    <input type="hidden" name="dato1" id="dato1">
                    <input type="hidden" name="nombre1html" id="nombre1html">
                    <input type="hidden" name="dato2" id="dato2">
                    <input type="hidden" name="nombre2html" id="nombre2html">                    
                    <button type="submit" id="game" class="bg-dark botonesJuegoInicio">Iniciar Juego</button>
                </form>
              </div>
            </div>
          </div>
        </div>
                        
        <script>            
            /*obtencion de valores de los checkbox*/
            var dato1 = document.getElementById("Check1").value;                                
            document.getElementById("dato1").value = dato1;           
            
            var dato2 = document.getElementById("Check2").value;            
            document.getElementById("dato2").value = dato2;            
        </script>
        
        <!-- Modal -->
        <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
          <div class="modal-dialog">
            <div class="modal-content">
              <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Nosotros</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                  <span aria-hidden="true">&times;</span>
                </button>
              </div>
              <div class="modal-body">
                ...
              </div>
              <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                <button type="button" class="btn btn-primary">Save changes</button>
              </div>
            </div>
          </div>
        </div>
       
        <% String t1 = request.getParameter("dato1");%>
                        
        <% String t2 = request.getParameter("dato2"); %>
        
        <% String nombreA = request.getParameter("nombre1html"); %>
        
        <% String nombreB = request.getParameter("nombre2html"); %>
                
    </body>
</html>
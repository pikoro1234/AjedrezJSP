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
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
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
            <h3>Bienvenido Ajedrez</h3>
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
                <form action="ServletUno" method="post">
                <input class="bg-dark botonesJuego" type="submit" value="Iniciar Juego">
                </form>
                <a class="bg-dark botonesJuego" href="Ayuda.html">Ayuda</a>
                <a class="bg-dark botonesJuego" href="Nosotros.html">Nosotros</a>
            </div>
        </div>
        
        
    </body>
</html>
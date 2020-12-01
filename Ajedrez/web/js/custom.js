$(document).ready(function(){ 
    
    //ocultar spam y background
    $("#span-home").click(function(){

        $(this).css({"display":"none"});

        $(".span-background").css({"display":"none"});
    });
    
    //clase que muestra modal de bienvenida
    $("#span-home").addClass("left-span");
    
    //obtención y asignado de valores a textbox hidden
    var dato1 = document.getElementById("Check1").value;  
        
    document.getElementById("dato1").value = dato1;           

    var dato2 = document.getElementById("Check2").value; 

    document.getElementById("dato2").value = dato2;  
    
    //capturar datos usuario y equipo para JspTest.jsp
    $("#game").click(function(){
        
        if($("#jugadorA").val().length < 1 || $("#jugadorB").val().length < 1){  
            
            alert("nombres son obligatorios");  
            
            return false;
        } 
        
        //seteo valor a elementos html del DOM
        var acumulador = $("#jugadorA").val(); 
     
        var contador = $("#jugadorB").val();

        $("#nombre1html").attr("value",acumulador);

        $("#nombre2html").attr("value",contador); 
    }); 
      
    
    //captura enter para inicio juego
    $(".elementoPrueba").keypress(function(e) {
        
        //seteo valor a elementos html del DOM al presionar enter
        var acumulador = $("#jugadorA").val(); 
     
        var contador = $("#jugadorB").val();
     
        $("#nombre1html").attr("value",acumulador);
     
        $("#nombre2html").attr("value",contador);
        
        var code = (e.keyCode ? e.keyCode : e.which);
        
        if(code === 13){
            
           $("#formularioJuego").submit();
        }
    });
});
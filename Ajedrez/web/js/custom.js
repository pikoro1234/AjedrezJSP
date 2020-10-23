$(document).ready(function(){
    
    $("#game").click(function(){
        
        if($("#jugadorA").val().length < 1 || $("#jugadorB").val().length < 1){  
            
            alert("nombres son obligatorios");  
            
            return false;
        }
     
        var acumulador = $("#jugadorA").val(); 
     
        var contador = $("#jugadorB").val();
     
        $("#nombre1html").attr("value",acumulador);
     
        $("#nombre2html").attr("value",contador);    
    }); 
    
     //inicio enter para iniciar juego
    $(".elementoPrueba").keypress(function(e) {
        
        var code = (e.keyCode ? e.keyCode : e.which);
        if(code === 13){
           $("#formularioJuego").submit();
        }
    });
    
    
    
    
      
});

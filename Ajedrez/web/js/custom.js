$(document).ready(function(){
    
    $("#game").click(function(){
     
        var acumulador = $("#jugadorA").val(); 
     
        var contador = $("#jugadorB").val();
     
        $("#nombre1html").attr("value",acumulador);
     
        $("#nombre2html").attr("value",contador);    
    });
      
});
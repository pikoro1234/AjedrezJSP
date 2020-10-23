$(document).ready(function(){ 
    
    //e.preventDefault(); return false; quitar evento de recarga formulario 
    
    var coordenadasJs ="";
     
    var objetoNombreJs = "";
    
    $(".filaColumna").click(function(e){
        
        coordenadasJs = $(this).attr("data");
        
        objetoNombreJs = $(this).attr("nombre");               
        
        $.ajax({
            type:'POST',
            url:'Tablero',
            data:{
                coordenadaServ : coordenadasJs,
                objetoNombreServ : objetoNombreJs
            },
            success: function(data){   
                //$("body").empty();
                $(".contenido-rigth").html(data);
                console.log("exito...");
                console.log(data);
            },
            error: function(){
                console.log("error al ejecutar ajax");
            }                                    
        });//fin ajax
        
        e.preventDefault();
        
    });
              
    $(".filaColumna").hover(
        function() {
            $( this ).toggleClass("cambioColor");
    });
    
    //inicio nuevo juego
    $("#btnGame").click(function(e){   
        console.log($(".titleJugador-uno").text());
        console.log($(".titleJugador-dos").text());
           $.ajax({
            type:'POST',
            url:'Tablero',
            data: {
              valorPrueba : "true"  
            },
            success: function(response){   
                $(".contenido-rigth").html(response);
                console.log("enviamos todo el ajax...");
                console.log(response);
            },
            error: function(){
                console.log("error al ejecutar ajax");
            }                                    
        });//fin ajax   
       e.preventDefault();        
    });//fin nueva partida
    
   
   
});//fin document


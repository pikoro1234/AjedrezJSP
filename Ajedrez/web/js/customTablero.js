$(document).ready(function(){        
    
    $(".filaColumna").click(function(){         
        
        //pintado de la ficha aun falta mejorar 
        //$(this).css('background-color','#E0FAEF');  
                                   
        var valorFilaColumna = $(this).attr("data"); 
        
        $("#valorFilaColumna").attr("value",valorFilaColumna);   
        
        var valor = $("#valorFilaColumna").val();       
        $.ajax({
            type : 'POST',
            url: 'Tablero',            
            data : {valor : valor},
            success: function(data) {		
                $('#titulo').html(valor);
            },
            error: function() {
                console.log("No se ha podido obtener la información");
            }
        });//fin ajax
        
       // $(this).appendTo('.imagenFichas').fadeIn(500);
         //$(this).appendTo('#another-container').fadeIn(500); 
          
    });//fin click ficha
    
     $(".filaColumna").hover(
            function() {
                $( this ).toggleClass("cambioColor");
            });
    
});//fin document
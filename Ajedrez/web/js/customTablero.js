$(document).ready(function(){ 
    
    //cementerio de ambos equipo
    var arrayBlancas = new Array();
    
    var arrayNegras = new Array();
 
    var cardNegras = document.querySelector(".nuevoCementerio-dos");
    
    cardNegras.innerHTML = "";
    
    var cardBlancas = document.querySelector(".nuevoCementerio");
    
    cardBlancas.innerHTML = "";
        
    //cementerio fichas negras
    var imagenMuertosNegras = document.getElementsByClassName("valorMuertoB"),
    namesValues = [].map.call(imagenMuertosNegras,function(dataInput){
        
        arrayBlancas.push(dataInput.value);
    });
    
    //creacion de card por cada ficha muerta
    arrayBlancas.forEach(function(inputAll){
        
        cardNegras.innerHTML += "<div class='card'><img src='"+inputAll+"' width='50' height='50' class='card-img-top'></div>";
    });
    
    
    //cementerio fichas blancas
    var imagenMuertosBlancas = document.getElementsByClassName("valorMuertoA"),
    namesValues = [].map.call(imagenMuertosBlancas,function(data){
        
       arrayNegras.push(data.value); 
    });
    
    //creacion de card por cada ficha muerta
    arrayNegras.forEach(function(inputOll){
        
        cardBlancas.innerHTML += "<div class='card'><img src='"+inputOll+"' width='50' height='50' class='card-img-top'></div>";
    });  
     
    //coordenadas cada click del usuario
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
                
                $(".contenido-rigth").html(data);
                
                console.log("exito...");
            },
            error: function(){
                
                console.log("error al ejecutar ajax");
            }                                    
        });//fin ajax
        
        e.preventDefault();
        
    });
    
   //hover para detectar celdas del tablero           
    $(".filaColumna").hover(function() {
            
        $( this ).toggleClass("cambioColor");
            
    });
     
});//fin document
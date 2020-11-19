$(document).ready(function(){ 
    
    var arrayBlancas = new Array();
    
    var arrayNegras = new Array();
    
    var tablaTdBlancas = document.querySelector(".reemplazo-js-blancas");
    
    tablaTdBlancas.innerHTML = "";
    
    var tablaTdNegras = document.querySelector(".reemplazo-js-negras");
    
    tablaTdNegras.innerHTML = "";
        
    var imagenMuertosNegras = document.getElementsByClassName("valorMuertoB"),
    namesValues = [].map.call(imagenMuertosNegras,function(dataInput){
        arrayBlancas.push(dataInput.value);
    });
    
    arrayBlancas.forEach(function(inputAll){
        
        tablaTdBlancas.innerHTML += "<td><img src='"+inputAll+"' class='card-img-blancas imagen-ficha' width='50' height='50' alt='...'></td>";
    });
    
    var imagenMuertosBlancas = document.getElementsByClassName("valorMuertoA"),
    namesValues = [].map.call(imagenMuertosBlancas,function(data){
       arrayNegras.push(data.value); 
    });
    
    arrayNegras.forEach(function(inputOll){
        tablaTdNegras.innerHTML += "<td><img src='"+inputOll+"' class='card-img-blancas imagen-ficha' width='50' height='50' alt='...'></td>";     
    });
        
    
    //e.preventDefault(); return false; quitar evento de recarga formulario 
    
    var coordenadasJs ="";
     
    var objetoNombreJs = "";
    
    $(".filaColumna").click(function(e){
        
        //alert("hola mundo");
        
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
                console.log("Nueva partida pulsado");
                console.log(response);
            },
            error: function(){
                console.log("error al ejecutar ajax");
            }                                    
        });//fin ajax   
       e.preventDefault();        
    });//fin nueva partida
    
   
   
});//fin document


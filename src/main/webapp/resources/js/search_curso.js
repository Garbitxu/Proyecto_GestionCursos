"use-strict"
$(function() {

	console.debug('search_curso.js ready');
	$( "#buscador_cursos" ).autocomplete({		
		source: function( request, response ) {
	        $.ajax( {
	          url: "api/curso/?filtro=" + $("#buscador_cursos").val(),
	          dataType: "json",	          
	          success: function( data ) {
	        	var aString = [];
	        	$.each(data, function(i,v){	        		
	        		aString.push( {'label': v.nombre, 'value' : v.id} );	
	        	}); 	        	  
	            response( aString );
	          }
	        });
	      },		
	     minLength: 1,
	     select: function( event, ui ) {
	       console.debug( "Selected: " + ui.item.value + " label= " + ui.item.label );
	       var url = "curso/edit/" + ui.item.value;
	       window.location.href = url;
	     }
	});
})
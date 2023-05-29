$(document).on("click", "#btnagregar", function(){
	$("#txtcantidad").val("0");
	$("#txtdescripcion").val("");
	$("#txtnombre").val("");
	$("#txtprecios").val("0");
	$("#modalProducto").modal("show");
});

$(document).on("click", ".btnactualizar", function(){
	$("#txtcantidad").val($(this).attr("data-cantidad"));
	$("#txtdescripcion").val($(this).attr("data-descproducto"));
	$("#txtnombre").val($(this).attr("data-nombreproducto"));
	$("#txtprecios").val($(this).attr("data-precioproducto"));
	$("#modalProducto").modal("show");
});

$(document).on("click", "#btnguardar", function(){
	$.ajax({
		type: "POST",
		url: "/producto/registrarProducto",
		contentType: "application/json",
		data: JSON.stringify({
			idproducto: $("#hddidregistroproducto").val(),
			cantidad: $("#txtcantidad").val(),
			descproducto: $("#txtdescripcion").val(),
			nombreproducto: $("#txtnombre").val(),
			precioproducto: $("#txtprecios").val(),						
		}),
		success: function(resultado){
			alert(resultado.mensaje);
			ListarProducto();
		}
	});
	$("#modalProducto").modal("hide");
})

$(document).on("click", ".btneliminarproducto", function(){
	$("#hddideliminarproducto").val("");
	$("#hddideliminarproducto").val($(this).attr("data-idproducto"));
	$("#mensajeeliminar").text("¿Está seguro de eliminar el "+ 
			$(this).attr("data-descproducto")+"?");
	$("#modalEliminarProducto").modal("show");
})
$(document).on("click", "#btneliminar", function(){
	$.ajax({
		type: "DELETE",
		contentType: 'application/json',
		url: "/producto/eliminarProducto",
		data: JSON.stringify({
			idproducto: $("#hddideliminarproducto").val()
		}),
		success: function(resultado){
			alert(resultado.mensaje);
			ListarProducto();
		}
	})
	$("#modalEliminarProducto").modal("hide");
})

function ListarProducto(){
	$.ajax({
		type: "GET",
		url: "/producto/listarProductos",
		dataType: "json",
		success: function(resultado){
			//console.log(resultado);
			$("#productos > tbody").html("");
			$.each(resultado, function(index, value){
				$("#productos > tbody").append("<tr>"+
						"<td>"+value.idproducto+"</td>"+
						"<td>"+value.cantidad+"</td>"+
						"<td>"+value.descproducto+"</td>"+
						"<td>"+value.nombreproducto+"</td>"+
						"<td>"+value.precioproducto+"</td>"+
						"<td>"+
							"<button type='button' class='btn btn-success btnactualizar'"+
							" data-idproducto='"+value.idproducto+"'"+
							" data-cantidad='"+value.cantidad+"'"+
							" data-descproducto='"+value.descproducto+"'"+
							" data-nombreproducto='"+value.nombreproducto+"'"+
							" data-precioproducto='"+value.precioproducto+"'"+
							"><i class='fas fa-pen'></i></button></td>"+
						"<td>"+
							"<button type='button' class='btn btn-danger btneliminarproducto'"+	
							" data-idproducto='"+value.idproducto+"'"+
							" data-descproducto='"+value.descproducto+"'"+
							"><i class='fas fa-trash'></i></button></td>"+							
						"</tr>")
			})
			
			
		}
	})
}






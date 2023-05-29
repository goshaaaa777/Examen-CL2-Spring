package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.model.bd.Producto;
import com.example.demo.model.request.ProductoRequest;
import com.example.demo.model.response.ResultadoResponse;
import com.example.demo.service.ProductoService;




@Controller
@RequestMapping("/producto")
public class ProductoController {
	
	
	@Autowired
	private ProductoService productoService;
	
	@GetMapping("/frmproducto")
	public String frmMantProducto(Model model) {
		model.addAttribute("listaproductos", 
				productoService.listarProducto());
		return "producto/frmproducto";
	}
	
	@PostMapping("/registrarProducto")
	@ResponseBody
	public ResultadoResponse registrarProducto(
			@RequestBody ProductoRequest productoRequest
			) {
		String mensaje ="Producto registrado correctamente";
		Boolean respuesta = true;
		try {			
			//Se puede aplicar el patrón Builder en estos objetos
			Producto objProducto = new Producto();
			if(productoRequest.getIdproducto() > 0) {
				objProducto.setIdproducto(productoRequest.getIdproducto());
			}
			objProducto.setCantidad(productoRequest.getCantidad());
			objProducto.setDescproducto(productoRequest.getDescproducto());
			objProducto.setNombreproducto(productoRequest.getNombreproducto());
			objProducto.setPrecioproducto(productoRequest.getPrecioproducto());


			productoService.registrarProducto(objProducto);
		}catch(Exception ex){
			mensaje = "Producto no registrado";
			respuesta = false;
		}
		return ResultadoResponse.builder()
				.mensaje(mensaje)
				.respuesta(respuesta)
				.build();
	}
	
	@DeleteMapping("/eliminarProducto")
	@ResponseBody
	public ResultadoResponse eliminarProducto(@RequestBody
			ProductoRequest productoRequest) {
		String mensaje = "Producto eliminado correctamente";
		Boolean respuesta = true;
		try {
			productoService.eliminarProducto(productoRequest.getIdproducto());
		}catch (Exception e) {
			mensaje = "Producto no eliminado";
			respuesta = false;
		}
		return ResultadoResponse.builder()
				.mensaje(mensaje)
				.respuesta(respuesta)
				.build();
	}
	@GetMapping("/listarProductos")
	@ResponseBody
	public List<Producto> listarProductos(){
		return productoService.listarProducto();
	}
	
	
	
	


}

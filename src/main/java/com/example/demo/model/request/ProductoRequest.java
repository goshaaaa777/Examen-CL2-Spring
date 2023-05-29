package com.example.demo.model.request;



import lombok.Data;


@Data

public class ProductoRequest {
	

	private Integer idproducto;	
	private Integer cantidad;		
	private String descproducto;	
	private String nombreproducto;	
	private Double precioproducto;

}

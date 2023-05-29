package com.example.demo.model.bd;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "productos")
public class Producto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idproducto;
	
	@Column(name = "cantidad")
	private Integer cantidad;	
	
	@Column(name = "descripcion")
	private String descproducto;
	
	@Column(name = "nombre")
	private String nombreproducto;
	
	@Column(name = "precio")
	private Double precioproducto;
	
	
	/*@OneToMany(mappedBy = "estado", 
			cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Sala> salaList;*/
	
}

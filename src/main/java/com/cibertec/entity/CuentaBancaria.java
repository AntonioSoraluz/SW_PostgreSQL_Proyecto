package com.cibertec.entity;

import java.util.Date;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "CuentaBancaria")
public class CuentaBancaria {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_cuentaBancaria;
	
	@Column(name = "numeroCuenta")
	private String numeroCuenta;
	
	@Column(name = "monto")
	private Double monto;
	
	@Column(name = "nombre_banco")
	private String nombre_banco;
	
	@Column(name = "userid")
	private Integer userid;
	
	@Column(name = "fechaRegistro")
	private Date fechaRegistro;

}

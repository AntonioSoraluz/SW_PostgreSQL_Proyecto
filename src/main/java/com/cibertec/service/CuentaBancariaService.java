package com.cibertec.service;

import java.util.List;
import java.util.Optional;

import com.cibertec.entity.CuentaBancaria;

public interface CuentaBancariaService {

	public List<CuentaBancaria> listaCuentaBancarias();

	public CuentaBancaria insertaCuentaBancaria(CuentaBancaria obj);

	public List<CuentaBancaria> buscaCuentasBancariasXUser(Integer userid);
	
	public Optional<CuentaBancaria> buscaCuentaBancariaXId(Integer id_cuentaBancaria);
	
	public Optional<CuentaBancaria> buscaCuentaBancariaXNumero(String numeroCuenta);

}

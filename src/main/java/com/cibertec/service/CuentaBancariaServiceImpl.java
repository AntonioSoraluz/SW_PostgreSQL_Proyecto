package com.cibertec.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cibertec.entity.CuentaBancaria;
import com.cibertec.repository.CuentaBancariaRepository;

@Service
public class CuentaBancariaServiceImpl implements CuentaBancariaService {

	@Autowired
	private CuentaBancariaRepository repository;

	@Override
	public List<CuentaBancaria> listaCuentaBancarias() {
		return repository.findAll();
	}

	@Override
	public CuentaBancaria insertaCuentaBancaria(CuentaBancaria obj) {
		return repository.save(obj);
	}

	@Override
	public List<CuentaBancaria> buscaCuentasBancariasXUser(Integer userId) {
	    return repository.findByUserid(userId);
	}
	
	@Override
	public Optional<CuentaBancaria> buscaCuentaBancariaXId(Integer id_cuentaBancaria) {
	    return repository.findById(id_cuentaBancaria);
	}

	@Override
	public Optional<CuentaBancaria> buscaCuentaBancariaXNumero(String numeroCuenta) {
	    return repository.findByNumeroCuenta(numeroCuenta);
	}
}

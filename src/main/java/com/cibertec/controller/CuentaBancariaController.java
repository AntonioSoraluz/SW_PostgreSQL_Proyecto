package com.cibertec.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cibertec.entity.CuentaBancaria;
import com.cibertec.entity.ErrorMessage;
import com.cibertec.service.CuentaBancariaService;

@RestController
@RequestMapping("/rest/cuentaBancaria")
public class CuentaBancariaController {

	@Autowired
	private CuentaBancariaService service;

	@GetMapping()
	public ResponseEntity<?> lista() {
		List<CuentaBancaria> lstSalida = service.listaCuentaBancarias();
		return ResponseEntity.ok(lstSalida);
	}

	@PostMapping
	public ResponseEntity<?> inserta(@RequestBody CuentaBancaria obj) {
		CuentaBancaria objSalida = service.insertaCuentaBancaria(obj);
		return ResponseEntity.ok(objSalida);
	}
	
	@GetMapping("/porUser/{id}")
	public ResponseEntity<?> listaPorUserEnPath(@PathVariable Integer id) {
	    List<CuentaBancaria> cuentasBancarias = service.buscaCuentasBancariasXUser(id);
	    if (!cuentasBancarias.isEmpty()) {
	        return ResponseEntity.ok(cuentasBancarias);
	    } else {
	        String errorMessage = "No se registró ninguna cuenta bancaria.";
	        return ResponseEntity.status(HttpStatus.NOT_FOUND)
	                .body(new ErrorMessage(errorMessage));
	    }
	}
	
	@GetMapping("/porId/{id}")
	public ResponseEntity<?> listaPorIdEnPath(@PathVariable Integer id) {
	    Optional<CuentaBancaria> optSalida = service.buscaCuentaBancariaXId(id);
	    if (optSalida.isPresent()) {
	        return ResponseEntity.ok(optSalida.get());
	    } else {
	        String errorMessage = "No se registró ninguna cuenta bancaria.";
	        return ResponseEntity.status(HttpStatus.NOT_FOUND)
	                .body(new ErrorMessage(errorMessage));
	    }
	}
	
	@GetMapping("/porNumero/{id}")
	public ResponseEntity<?> listaPorNumeroEnPath(@PathVariable String id) {
	    Optional<CuentaBancaria> optSalida = service.buscaCuentaBancariaXNumero(id);
	    if (optSalida.isPresent()) {
	        return ResponseEntity.ok(optSalida.get());
	    } else {
	        String errorMessage = "No se registró ninguna cuenta bancaria.";
	        return ResponseEntity.status(HttpStatus.NOT_FOUND)
	                .body(new ErrorMessage(errorMessage));
	    }
	}


	/*@GetMapping("/porId")
	public ResponseEntity<?> listaPorIdEnParamaterer(
			@RequestParam(name = "id", defaultValue = "0", required = true) Integer id) {
		Optional<CuentaBancaria> optSalida = service.buscaCuentaBancaria(id);
		return ResponseEntity.ok(optSalida.get());
	}*/


	@PutMapping
	public ResponseEntity<?> actualiza(@RequestBody CuentaBancaria obj) {
		Optional<CuentaBancaria> optCuentaBancaria = service.buscaCuentaBancariaXId(obj.getId_cuentaBancaria());
		if (optCuentaBancaria.isPresent()) {
			CuentaBancaria objSalida = service.insertaCuentaBancaria(obj);
			return ResponseEntity.ok(objSalida);
		} else {
			return ResponseEntity.ok("La Cuenta Bancaria no existe");
		}
	}
}

package com.cibertec.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cibertec.entity.CuentaBancaria;

public interface CuentaBancariaRepository extends JpaRepository<CuentaBancaria, Integer> {
	List<CuentaBancaria> findByUserid(Integer userid);
	Optional<CuentaBancaria> findByNumeroCuenta(String numeroCuenta);
}

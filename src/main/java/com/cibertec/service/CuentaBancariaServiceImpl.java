package com.cibertec.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cibertec.entity.Categoria;
import com.cibertec.repository.CategoriaRepository;

@Service
public class CategoriaServiceImpl implements CategoriaService {

	@Autowired
	private CategoriaRepository repository;

	@Override
	public List<Categoria> listaCategoria() {
		return repository.findAll();
	}

	@Override
	public Categoria insertaCategoria(Categoria obj) {
		return repository.save(obj);
	}

	@Override
	public Optional<Categoria> buscaCategoria(int idCategoria) {
		return repository.findById(idCategoria);
	}

	@Override
	public void eliminaCategoria(int idCategoria) {
		repository.deleteById(idCategoria);
	}

}

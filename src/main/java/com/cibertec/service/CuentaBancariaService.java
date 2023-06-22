package com.cibertec.service;

import java.util.List;
import java.util.Optional;

import com.cibertec.entity.Categoria;

public interface CategoriaService {

	public List<Categoria> listaCategoria();

	public Categoria insertaCategoria(Categoria obj);

	public Optional<Categoria> buscaCategoria(int idCategoria);

	public void eliminaCategoria(int idCategoria);

}

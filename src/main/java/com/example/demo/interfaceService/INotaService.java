package com.example.demo.interfaceService;

import java.util.List;
import java.util.Optional;

import com.example.demo.modelo.Nota;

public interface INotaService {
	public List<Nota> listar();
	public Optional<Nota>listarId(int id);
	public int save(Nota n);
	public void delete(int id);
}

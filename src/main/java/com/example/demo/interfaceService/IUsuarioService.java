package com.example.demo.interfaceService;

import java.util.List;
import java.util.Optional;

import com.example.demo.modelo.TipoUsuario;
import com.example.demo.modelo.User;

public interface IUsuarioService {
	public List<User> listar();
	public Optional<User>listarId(int id);
	public int save(User p);
	public void delete(int id);
	public List<User> listarIdTipoUsuario(TipoUsuario tipo);
	
}

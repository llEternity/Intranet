package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.interfaceService.IUsuarioService;
import com.example.demo.interfaces.IUsuario;
import com.example.demo.modelo.TipoUsuario;
import com.example.demo.modelo.User;

@Service
public class PersonaService implements IUsuarioService{

	@Autowired
	private IUsuario data;
	
	@Override
	public List<User> listar() {
		return (List<User>)data.findAll();
	}

	@Override
	public Optional<User> listarId(int id) {
		return data.findById(id);
	}

	@Override
	public int save(User u) {
		int res=0;
		User user= data.save(u);
		if (!user.equals(null)) {
			res=1;
		}
		return res;
	}

	@Override
	public void delete(int id) {
		data.deleteById(id);
	}

	@Override
	public List<User> listarIdTipoUsuario(TipoUsuario tipo) {
		return (List<User>)data.findByTipoUsuario(tipo);
	}
	
}

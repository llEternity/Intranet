package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.interfaceService.ITipoUsuarioServices;
import com.example.demo.interfaces.ITipoUsuario;
import com.example.demo.modelo.TipoUsuario;

@Service
public class TipoUsuarioService implements ITipoUsuarioServices {

	@Autowired
	ITipoUsuario data;
	
	@Override
	public List<TipoUsuario> listarTipos() {
		return(List<TipoUsuario>) data.findAll();
	}

	@Override
	public Optional<TipoUsuario> listarId(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int save(TipoUsuario a) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

}

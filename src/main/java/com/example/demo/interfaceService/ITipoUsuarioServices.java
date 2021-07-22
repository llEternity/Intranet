package com.example.demo.interfaceService;

import java.util.List;
import java.util.Optional;

import com.example.demo.modelo.TipoUsuario;

public interface ITipoUsuarioServices {
	  public List<TipoUsuario>listarTipos();
	  public Optional<TipoUsuario>listarId(int id);	
	  public int save(TipoUsuario a);
	  public void delete(int id);
}

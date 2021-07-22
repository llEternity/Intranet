package com.example.demo.interfaces;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.modelo.TipoUsuario;
import com.example.demo.modelo.User;

@Repository
public interface IUsuario extends CrudRepository<User, Integer> {

	public List<User> findByTipoUsuario(TipoUsuario tipo);
}

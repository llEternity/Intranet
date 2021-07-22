package com.example.demo.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "profesor")
public class Profesor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String Rut;
    private String Nombre;
    private String ApellidoPaterno;
    private String ApellidoMaterno;
    private String CorreoElectronico;
    private String Direccion;
    private String Telefono;
	
	public Profesor() {
		// TODO Auto-generated constructor stub
	}

	public Profesor(int id, String rut, String nombre, String apellidoPaterno, String apellidoMaterno,
			String correoElectronico, String direccion, String telefono) {
		super();
		this.id = id;
		Rut = rut;
		Nombre = nombre;
		ApellidoPaterno = apellidoPaterno;
		ApellidoMaterno = apellidoMaterno;
		CorreoElectronico = correoElectronico;
		Direccion = direccion;
		Telefono = telefono;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRut() {
		return Rut;
	}

	public void setRut(String rut) {
		Rut = rut;
	}

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	public String getApellidoPaterno() {
		return ApellidoPaterno;
	}

	public void setApellidoPaterno(String apellidoPaterno) {
		ApellidoPaterno = apellidoPaterno;
	}

	public String getApellidoMaterno() {
		return ApellidoMaterno;
	}

	public void setApellidoMaterno(String apellidoMaterno) {
		ApellidoMaterno = apellidoMaterno;
	}

	public String getCorreoElectronico() {
		return CorreoElectronico;
	}

	public void setCorreoElectronico(String correoElectronico) {
		CorreoElectronico = correoElectronico;
	}

	public String getDireccion() {
		return Direccion;
	}

	public void setDireccion(String direccion) {
		Direccion = direccion;
	}

	public String getTelefono() {
		return Telefono;
	}

	public void setTelefono(String telefono) {
		Telefono = telefono;
	}
	
	
	
	
}

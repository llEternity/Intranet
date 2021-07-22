package com.example.demo.modelo;

import java.io.Serializable;

import javax.persistence.Column;

public class CursoAsignaturaId implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Column
	private int idCurso;
	
	@Column
	private int idAsignatura;
	
	public CursoAsignaturaId() {
		// TODO Auto-generated constructor stub
	}

	public CursoAsignaturaId(int idCurso, int idAsignatura) {
		super();
		this.idCurso = idCurso;
		this.idAsignatura = idAsignatura;
	}

	public int getIdCurso() {
		return idCurso;
	}

	public void setIdCurso(int idCurso) {
		this.idCurso = idCurso;
	}

	public int getIdAsignatura() {
		return idAsignatura;
	}

	public void setIdAsignatura(int idAsignatura) {
		this.idAsignatura = idAsignatura;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idAsignatura;
		result = prime * result + idCurso;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CursoAsignaturaId other = (CursoAsignaturaId) obj;
		if (idAsignatura != other.idAsignatura)
			return false;
		if (idCurso != other.idCurso)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "CursoAsignaturaId [idCurso=" + idCurso + ", idAsignatura=" + idAsignatura + "]";
	}
	
	
	
	

}

package com.example.demo.modelo;

import java.io.Serializable;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.MapKeyJoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.interfaceService.IUsuarioService;


@Entity
@Table(name = "curso")
public class Curso implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
	
	@Column
    private String seccion;
  
	/** @ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "curso_asignatura", 
				joinColumns = @JoinColumn(name = "id_curso"), inverseJoinColumns = @JoinColumn(name = "id_asignatura"))
	private Set<Asignatura> asignaturas; **/
	
	@OneToMany(mappedBy = "curso", cascade = CascadeType.ALL)
	private Set<User> usuarios;
	
	@OneToMany(mappedBy = "curso", cascade = CascadeType.ALL)
	private Set<Archivo> archivos;
	
	@OneToMany(mappedBy = "curso", cascade = CascadeType.ALL)
	private Set<CursoAsignatura> cursoAsignaturas;
	
    @JoinTable(name = "cursoAsignaturaU",
            joinColumns = @JoinColumn(name = "id_curso"),
            inverseJoinColumns = @JoinColumn(name = "id_user"))
        @MapKeyJoinColumn(name = "id_asignatura")
        @ElementCollection
        private Map<Asignatura, User> cursoAsignaturaU = new HashMap<>();
	
	

	public Curso(int id, String seccion) {
		super();
		this.id = id;
		this.seccion = seccion;
	}

	public Curso() {
		
	}
	
	public void addUser(User u) {
		if(usuarios==null) {
			usuarios= new HashSet<User>();
		}
		usuarios.add(u);
		u.setCurso(this);
	}
	
	public void removeUser(User u) {
		usuarios.remove(u);
		u.setCurso(null);
	}
	
	public void addCursoAsignatura(CursoAsignatura ca) {
		if(cursoAsignaturas==null) {
			usuarios= new HashSet<User>();
		}
		cursoAsignaturas.add(ca);
		ca.setCurso(this);
	}
	
	public void removeCursoAsignatura(CursoAsignatura ca) {
		cursoAsignaturas.remove(ca);
		ca.setCurso(null);
	}
	

	public void removeAll(Curso c, List<User> users) {


	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSeccion() {
		return seccion;
	}

	public void setSeccion(String seccion) {
		this.seccion = seccion;
	}

	public Set<User> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(Set<User> usuarios) {
		this.usuarios = usuarios;
	}

	public Set<Archivo> getArchivos() {
		return archivos;
	}

	public void setArchivos(Set<Archivo> archivos) {
		this.archivos = archivos;
	}

	public Set<CursoAsignatura> getCursoAsignaturas() {
		return cursoAsignaturas;
	}

	public void setCursoAsignaturas(Set<CursoAsignatura> cursoAsignaturas) {
		this.cursoAsignaturas = cursoAsignaturas;
	}

	public Map<Asignatura, User> getCursoAsignaturaU() {
		return cursoAsignaturaU;
	}

	public void setCursoAsignaturaU(Map<Asignatura, User> cursoAsignaturaU) {
		this.cursoAsignaturaU = cursoAsignaturaU;
	}
	
	

    
}

package com.example.demo.modelo;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.mapping.Table.ForeignKeyKey;
@Entity
public class Nota {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator="native")
	@GenericGenerator(name="native", strategy="native")
	private int id;
	@Column
	private String nombreCurso;
	@Column
	private String nombreAlumno;
	@Column
	private String nombreAsignatura;
	@Column
	private int nota1;
	@Column
	private int nota2;
	@Column
	private int nota3;
	@Column
	private int nota4;
	
	
	public Nota(int id, String nombreCurso, String nombreAlumno, String nombreAsignatura, int nota1, int nota2,
			int nota3, int nota4, int promedio, Asignatura asignatura) {
		super();
		this.id = id;
		this.nombreCurso = nombreCurso;
		this.nombreAlumno = nombreAlumno;
		this.nombreAsignatura = nombreAsignatura;
		this.nota1 = nota1;
		this.nota2 = nota2;
		this.nota3 = nota3;
		this.nota4 = nota4;
		this.promedio = promedio;
		this.asignatura = asignatura;
	}




	@Column
	private int promedio;
	
	
	@ManyToOne(fetch = FetchType.LAZY , cascade = CascadeType.ALL)
	@JoinColumn(name = "id_asignatura", referencedColumnName = "idAsignatura")
	private Asignatura asignatura;
	
	
		
	public Nota() {
		super();
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getNombreCurso() {
		return nombreCurso;
	}



	public void setNombreCurso(String nombreCurso) {
		this.nombreCurso = nombreCurso;
	}



	public String getNombreAlumno() {
		return nombreAlumno;
	}



	public void setNombreAlumno(String nombreAlumno) {
		this.nombreAlumno = nombreAlumno;
	}



	public String getNombreAsignatura() {
		return nombreAsignatura;
	}



	public void setNombreAsignatura(String nombreAsignatura) {
		this.nombreAsignatura = nombreAsignatura;
	}



	public int getNota1() {
		return nota1;
	}



	public void setNota1(int nota1) {
		this.nota1 = nota1;
	}



	public int getNota2() {
		return nota2;
	}



	public void setNota2(int nota2) {
		this.nota2 = nota2;
	}



	public int getNota3() {
		return nota3;
	}



	public void setNota3(int nota3) {
		this.nota3 = nota3;
	}



	public int getNota4() {
		return nota4;
	}



	public void setNota4(int nota4) {
		this.nota4 = nota4;
	}



	public int getPromedio() {
		return promedio;
	}



	public void setPromedio(int promedio) {
			
    this.promedio = promedio;
	}



	public Asignatura getAsignatura() {
		return asignatura;
	}



	public void setAsignatura(Asignatura asignatura) {
		this.asignatura = asignatura;
	}



	
	
	
	
	
}

package pe.edu.upc.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;

@Entity
@Table(name = "courses")
public class Course implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idCourse;
	
	@NotEmpty(message = "El nombre del curso es obligatorio")
	//@Pattern(regexp = "[a-zA-ZÀ-ÿ\\u00f1\\u00d1]+(\\s[a-zA-ZÀ-ÿ\\u00f1\\u00d1])*[a-zA-ZÀ-ÿ\\u00f1\\u00d1]+$", message = "El nombre solo puede tener letras")
	@Column(name = "nameCourse", nullable = false, length = 20)
	private String nameCourse;
	
	@ManyToOne
	@JoinColumn(name = "idTeacher", nullable = false)
	private Teacher teacher;
	
	
	@Column(name = "initalHour", nullable = false, length = 20)
	private String initalHour;
	
	@Column(name = "finalHour", nullable = false, length = 20)
	private String finalHour;
	
	public Course() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public Course(int idCourse, @NotEmpty(message = "El nombre del curso es obligatorio") String nameCourse,
			Teacher teacher, String initalHour, String finalHour) {
		super();
		this.idCourse = idCourse;
		this.nameCourse = nameCourse;
		this.teacher = teacher;
		this.initalHour = initalHour;
		this.finalHour = finalHour;
	}



	public void setIdCourse(int idCourse) {
		this.idCourse = idCourse;
	}
	


	public String getNameCourse() {
		return nameCourse;
	}



	public void setNameCourse(String nameCourse) {
		this.nameCourse = nameCourse;
	}



	public Teacher getTeacher() {
		return teacher;
	}



	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}



	public String getInitalHour() {
		return initalHour;
	}



	public void setInitalHour(String initalHour) {
		this.initalHour = initalHour;
	}



	public String getFinalHour() {
		return finalHour;
	}



	public void setFinalHour(String finalHour) {
		this.finalHour = finalHour;
	}





	public int getIdCourse() {
		return idCourse;
	}

	
	
}

package pe.edu.upc.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "courses")
public class Course implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idCourse;
	@Pattern(regexp = "[a-zA-ZÀ-ÿ\\u00f1\\u00d1]+(\\s[a-zA-ZÀ-ÿ\\u00f1\\u00d1])*[a-zA-ZÀ-ÿ\\u00f1\\u00d1]+(\\s[a-zA-ZÀ-ÿ\\u00f1\\u00d1])*[a-zA-ZÀ-ÿ\\u00f1\\u00d1]+$", message = "El nombre solo puede tener letras")
	@Column(name = "nameCourse", nullable = false, length = 45)
	private String nameCourse;
	@Column(name = "initalHourCourse", nullable = false, length = 20)
	private String initalHourCourse;
	@Column(name = "finalHourCourse", nullable = false, length = 20)
	private String finalHourCourse;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dateOfOpeningCourse;

	public Course() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Course(int idCourse, String nameCourse, String initalHourCourse, String finalHourCourse,
			Date dateOfOpeningCourse) {
		super();
		this.idCourse = idCourse;
		this.nameCourse = nameCourse;
		this.initalHourCourse = initalHourCourse;
		this.finalHourCourse = finalHourCourse;
		this.dateOfOpeningCourse = dateOfOpeningCourse;
	}

	public int getIdCourse() {
		return idCourse;
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

	public String getInitalHourCourse() {
		return initalHourCourse;
	}

	public void setInitalHourCourse(String initalHourCourse) {
		this.initalHourCourse = initalHourCourse;
	}

	public String getFinalHourCourse() {
		return finalHourCourse;
	}

	public void setFinalHourCourse(String finalHourCourse) {
		this.finalHourCourse = finalHourCourse;
	}

	public Date getDateOfOpeningCourse() {
		return dateOfOpeningCourse;
	}

	public void setDateOfOpeningCourse(Date dateOfOpeningCourse) {
		this.dateOfOpeningCourse = dateOfOpeningCourse;
	}

}

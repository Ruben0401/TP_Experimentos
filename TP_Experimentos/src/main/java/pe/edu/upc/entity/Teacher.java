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
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "teachers")
public class Teacher implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idTeacher;
	@Pattern(regexp = "[a-zA-ZÀ-ÿ\\u00f1\\u00d1]+(\\s[a-zA-ZÀ-ÿ\\u00f1\\u00d1])*[a-zA-ZÀ-ÿ\\u00f1\\u00d1]+(\\s[a-zA-ZÀ-ÿ\\u00f1\\u00d1])*[a-zA-ZÀ-ÿ\\u00f1\\u00d1]+$", message = "El nombre solo puede tener letras")
	@Column(name = "nameTeacher", nullable = false, length = 45)
	private String nameTeacher;
	@Pattern(regexp = "[a-zA-ZÀ-ÿ\\u00f1\\u00d1]+(\\s[a-zA-ZÀ-ÿ\\u00f1\\u00d1])*[a-zA-ZÀ-ÿ\\u00f1\\u00d1]+(\\s[a-zA-ZÀ-ÿ\\u00f1\\u00d1])*[a-zA-ZÀ-ÿ\\u00f1\\u00d1]+$", message = "El apellido solo puede tener letras")
	@Column(name = "lastnameTeacher", nullable = false, length = 45)
	private String lastnameTeacher;
	@Pattern(regexp = "[0-9]+", message = "El DNI solo puede tener números")
	@Size(min = 8, max = 8, message = "El DNI solo puede tener 8 números")
	@Column(name = "dniTeacher", nullable = false, length = 45)
	private String dniTeacher;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dateOfBirthTeacher;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dateOfAdmissionTeacher;

	public Teacher() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Teacher(int idTeacher, String nameTeacher, String lastnameTeacher, String dniTeacher,
			Date dateOfBirthTeacher, Date dateOfAdmissionTeacher) {
		super();
		this.idTeacher = idTeacher;
		this.nameTeacher = nameTeacher;
		this.lastnameTeacher = lastnameTeacher;
		this.dniTeacher = dniTeacher;
		this.dateOfBirthTeacher = dateOfBirthTeacher;
		this.dateOfAdmissionTeacher = dateOfAdmissionTeacher;
	}

	public int getIdTeacher() {
		return idTeacher;
	}

	public void setIdTeacher(int idTeacher) {
		this.idTeacher = idTeacher;
	}

	public String getNameTeacher() {
		return nameTeacher;
	}

	public void setNameTeacher(String nameTeacher) {
		this.nameTeacher = nameTeacher;
	}

	public String getLastnameTeacher() {
		return lastnameTeacher;
	}

	public void setLastnameTeacher(String lastnameTeacher) {
		this.lastnameTeacher = lastnameTeacher;
	}

	public String getDniTeacher() {
		return dniTeacher;
	}

	public void setDniTeacher(String dniTeacher) {
		this.dniTeacher = dniTeacher;
	}

	public Date getDateOfBirthTeacher() {
		return dateOfBirthTeacher;
	}

	public void setDateOfBirthTeacher(Date dateOfBirthTeacher) {
		this.dateOfBirthTeacher = dateOfBirthTeacher;
	}

	public Date getDateOfAdmissionTeacher() {
		return dateOfAdmissionTeacher;
	}

	public void setDateOfAdmissionTeacher(Date dateOfAdmissionTeacher) {
		this.dateOfAdmissionTeacher = dateOfAdmissionTeacher;
	}

}

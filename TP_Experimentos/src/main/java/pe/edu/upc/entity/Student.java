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
@Table(name = "students")
public class Student implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idStudent;
	@Pattern(regexp = "[0-9]+", message = "El código solo puede tener números")
	@Size(min = 9, max = 9, message = "El código solo puede tener 9 números")
	@Column(name = "codeStudent", nullable = false, length = 45)
	private String codeStudent;
	@Pattern(regexp = "[a-zA-ZÀ-ÿ\\u00f1\\u00d1]+(\\s[a-zA-ZÀ-ÿ\\u00f1\\u00d1])*[a-zA-ZÀ-ÿ\\u00f1\\u00d1]+(\\s[a-zA-ZÀ-ÿ\\u00f1\\u00d1])*[a-zA-ZÀ-ÿ\\u00f1\\u00d1]+$", message = "El nombre solo puede tener letras")
	@Column(name = "nameStudent", nullable = false, length = 45)
	private String nameStudent;
	@Pattern(regexp = "[a-zA-ZÀ-ÿ\\u00f1\\u00d1]+(\\s[a-zA-ZÀ-ÿ\\u00f1\\u00d1])*[a-zA-ZÀ-ÿ\\u00f1\\u00d1]+(\\s[a-zA-ZÀ-ÿ\\u00f1\\u00d1])*[a-zA-ZÀ-ÿ\\u00f1\\u00d1]+$", message = "El apellido solo puede tener letras")
	@Column(name = "lastnameStudent", nullable = false, length = 45)
	private String lastnameStudent;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dateOfBirthStudent;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dateOfAdmissionStudent;

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Student(int idStudent, String codeStudent, String nameStudent, String lastnameStudent,
			Date dateOfBirthStudent, Date dateOfAdmissionStudent) {
		super();
		this.idStudent = idStudent;
		this.codeStudent = codeStudent;
		this.nameStudent = nameStudent;
		this.lastnameStudent = lastnameStudent;
		this.dateOfBirthStudent = dateOfBirthStudent;
		this.dateOfAdmissionStudent = dateOfAdmissionStudent;
	}

	public int getIdStudent() {
		return idStudent;
	}

	public void setIdStudent(int idStudent) {
		this.idStudent = idStudent;
	}

	public String getCodeStudent() {
		return codeStudent;
	}

	public void setCodeStudent(String codeStudent) {
		this.codeStudent = codeStudent;
	}

	public String getNameStudent() {
		return nameStudent;
	}

	public void setNameStudent(String nameStudent) {
		this.nameStudent = nameStudent;
	}

	public String getLastnameStudent() {
		return lastnameStudent;
	}

	public void setLastnameStudent(String lastnameStudent) {
		this.lastnameStudent = lastnameStudent;
	}

	public Date getDateOfBirthStudent() {
		return dateOfBirthStudent;
	}

	public void setDateOfBirthStudent(Date dateOfBirthStudent) {
		this.dateOfBirthStudent = dateOfBirthStudent;
	}

	public Date getDateOfAdmissionStudent() {
		return dateOfAdmissionStudent;
	}

	public void setDateOfAdmissionStudent(Date dateOfAdmissionStudent) {
		this.dateOfAdmissionStudent = dateOfAdmissionStudent;
	}

}

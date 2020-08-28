package pe.edu.upc.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "students")
public class Student implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private int idStudent;
	@Column(name = "nameStudent", nullable = false, length = 45)
	private String nameStudent;
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

	public Student(int idStudent, String nameStudent, String lastnameStudent, Date dateOfBirthStudent,
			Date dateOfAdmissionStudent) {
		super();
		this.idStudent = idStudent;
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

package pe.edu.upc.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;

@Entity
@Table(name = "coursesxteachers")
public class CoursesxTeacher implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idCoursesxTeacher;
	
	@ManyToOne
	@JoinColumn(name = "idCourse")
	private Course course;
	
	@ManyToOne
	@JoinColumn(name = "idTeacher")
	private Teacher teacher;

	@Column(name = "semester", nullable = false, length = 10)
	private String semester;
	
	
	public CoursesxTeacher() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	public CoursesxTeacher(int idCoursesxTeacher, Course course, Teacher teacher, String semester) {
		super();
		this.idCoursesxTeacher = idCoursesxTeacher;
		this.course = course;
		this.teacher = teacher;
		this.semester = semester;
	}



	public String getSemester() {
		return semester;
	}



	public void setSemester(String semester) {
		this.semester = semester;
	}



	public int getIdCoursesxTeacher() {
		return idCoursesxTeacher;
	}

	public void setIdCoursesxTeacher(int idCoursesxTeacher) {
		this.idCoursesxTeacher = idCoursesxTeacher;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

}

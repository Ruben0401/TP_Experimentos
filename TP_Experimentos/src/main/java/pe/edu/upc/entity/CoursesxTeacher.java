package pe.edu.upc.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

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

	public CoursesxTeacher() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CoursesxTeacher(int idCoursesxTeacher, Course course, Teacher teacher) {
		super();
		this.idCoursesxTeacher = idCoursesxTeacher;
		this.course = course;
		this.teacher = teacher;
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

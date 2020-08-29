package pe.edu.upc.serviceinterface;

import java.util.List;

import pe.edu.upc.entity.CoursesxTeacher;

public interface ICoursesxTeacherService {
	
	public void insert(CoursesxTeacher coursesxteacher);

	List<CoursesxTeacher> list();

	public void delete(int idCoursesxTeacher);
}

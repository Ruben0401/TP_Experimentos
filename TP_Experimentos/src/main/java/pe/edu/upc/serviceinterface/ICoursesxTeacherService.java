package pe.edu.upc.serviceinterface;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.entity.CoursesxTeacher;

public interface ICoursesxTeacherService {

	public void insert(CoursesxTeacher coursesxteacher);

	List<CoursesxTeacher> list();

	public void delete(int idCoursesxTeacher);

	Optional<CoursesxTeacher> searchId(int idCoursesxTeacher);
	
	
	public List<String[]> report1();
	
	
	public List<String[]> report2(String param);
}

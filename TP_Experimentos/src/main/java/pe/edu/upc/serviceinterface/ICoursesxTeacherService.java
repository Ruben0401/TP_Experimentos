package pe.edu.upc.serviceinterface;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.entity.CoursesxTeacher;

public interface ICoursesxTeacherService {

	public void insert(CoursesxTeacher coursesxteacher);

	List<CoursesxTeacher> list();

	public void delete(int idCoursesxTeacher);

	Optional<CoursesxTeacher> searchId(int idCoursesxTeacher);
}

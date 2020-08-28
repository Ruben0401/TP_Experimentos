package pe.edu.upc.serviceinterface;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.entity.Course;

public interface ICourseService {
 

	public int insert(Course course);

	List<Course> list();
	
	Course listarId(int idCourse);

	public void delete(int idCourse);
	
}

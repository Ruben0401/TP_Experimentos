package pe.edu.upc.serviceinterface;

import java.util.List;

import pe.edu.upc.entity.Course;

public interface ICourseService {

	public int insert(Course course);

	List<Course> list();

	public void delete(int idCourse);
}

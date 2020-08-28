package pe.edu.upc.serviceimpl;


import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upc.entity.Course;
import pe.edu.upc.repository.ICourseRepository;
import pe.edu.upc.serviceinterface.ICourseService;


@Service
public class CourseServiceImpl implements Serializable, ICourseService  {
	
	private static final long serialVersionUID = 1L;

	@Autowired
	private ICourseRepository cR;
	
	@Override
	public int insert(Course course) {
		int rpta = cR.searchCourse(course.getNameCourse());
		if (rpta == 0) {
			cR.save(course);
		}
		return rpta;
	}

	@Override
	public List<Course> list() {
		// TODO Auto-generated method stub
		return cR.findAll();
	}

	@Override
	public void delete(int idCourse) {
		cR.deleteById(idCourse);
	}

	

	@Override
	public Course listarId(int idCourse) {
		Optional<Course> op = cR.findById(idCourse);
		return op.isPresent() ? op.get() : new Course();
	}
	
	
}

package pe.edu.upc.serviceimpl;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upc.entity.CoursesxTeacher;
import pe.edu.upc.repository.ICoursesxTeacherRepository;
import pe.edu.upc.serviceinterface.ICoursesxTeacherService;

@Service
public class CoursesxTeacherServiceImpl implements ICoursesxTeacherService, Serializable {

	private static final long serialVersionUID = 1L;
	
	@Autowired
	private ICoursesxTeacherRepository cxtR;

	@Override
	public void insert(CoursesxTeacher coursesxteacher) {
		cxtR.save(coursesxteacher);
	}

	@Override
	public List<CoursesxTeacher> list() {
		return cxtR.findAll();
	}

	@Override
	public void delete(int idCoursesxTeacher) {
		cxtR.deleteById(idCoursesxTeacher);
	}

}

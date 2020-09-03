package pe.edu.upc.serviceimpl;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upc.entity.Enrollment;
import pe.edu.upc.repository.IEnrollmentRepository;
import pe.edu.upc.serviceinterface.IEnrollmentService;

@Service
public class EnrollmentServiceImpl implements IEnrollmentService, Serializable {

	private static final long serialVersionUID = 1L;

	@Autowired
	private IEnrollmentRepository eR;

	@Override
	public void insert(Enrollment enrollment) {
		eR.save(enrollment);
	}

	@Override
	public List<Enrollment> list() {
		return eR.findAll();
	}

	@Override
	public void delete(int idEnrollment) {
		eR.deleteById(idEnrollment);
	}

	@Override
	public Optional<Enrollment> searchId(int idEnrollment) {
		return eR.findById(idEnrollment);
	}

	@Override
	public List<Enrollment> findSemesterCoursesxTeacherFull(String semesterCoursesxTeacher) {
		return eR.findBysemesterCoursesxTeacher(semesterCoursesxTeacher);
	}

	

}

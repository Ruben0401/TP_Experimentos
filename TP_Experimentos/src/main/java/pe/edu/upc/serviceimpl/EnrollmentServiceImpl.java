package pe.edu.upc.serviceimpl;

import java.io.Serializable;
import java.util.List;

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
	public void insert(Enrollment enroll) {
		eR.save(enroll);
	}

	@Override
	public List<Enrollment> list() {
		return eR.findAll();
	}

	@Override
	public void delete(int idEnrollment) {
		eR.deleteById(idEnrollment);
	}

}

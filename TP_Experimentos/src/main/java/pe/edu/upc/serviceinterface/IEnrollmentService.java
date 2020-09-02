package pe.edu.upc.serviceinterface;

import java.util.List;

import pe.edu.upc.entity.Enrollment;

public interface IEnrollmentService {
	
	public void insert(Enrollment enroll);

	List<Enrollment> list();

	public void delete(int idEnrollment);
}

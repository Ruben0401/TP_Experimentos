package pe.edu.upc.serviceimpl;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upc.entity.Student;
import pe.edu.upc.repository.IStudentRepository;
import pe.edu.upc.serviceinterface.IStudentService;

@Service
public class StudentServiceImpl implements Serializable, IStudentService {

	private static final long serialVersionUID = 1L;

	@Autowired
	private IStudentRepository sR;

	@Override
	public int insert(Student student) {
		int rpta = sR.searchStudent(student.getCodeStudent());
		if (rpta == 0) {
			sR.save(student);
		}
		return rpta;
	}

	@Override
	public List<Student> list() {
		return sR.findAll();
	}

	@Override
	public void delete(int idStudent) {
		sR.deleteById(idStudent);
	}

}

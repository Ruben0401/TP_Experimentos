package pe.edu.upc.serviceimpl;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upc.entity.Teacher;
import pe.edu.upc.repository.ITeacherRepository;
import pe.edu.upc.serviceinterface.ITeacherService;

@Service
public class TeacherServiceImpl implements Serializable, ITeacherService {

	private static final long serialVersionUID = 1L;

	@Autowired
	private ITeacherRepository tR;

	@Override
	public int insert(Teacher teacher) {
		int rpta = tR.searchTeacher(teacher.getDniTeacher());
		if (rpta == 0) {
			tR.save(teacher);
		}
		return rpta;
	}

	@Override
	public List<Teacher> list() {
		return tR.findAll();
	}

	@Override
	public void delete(int idTeacher) {
		tR.deleteById(idTeacher);
	}

}

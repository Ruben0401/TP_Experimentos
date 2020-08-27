package pe.edu.upc.serviceinterface;

import java.util.List;

import pe.edu.upc.entity.Teacher;

public interface ITeacherService {

	public int insert(Teacher teacher);

	List<Teacher> list();

	public void delete(int idTeacher);
}

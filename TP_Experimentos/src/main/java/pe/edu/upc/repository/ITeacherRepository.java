package pe.edu.upc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pe.edu.upc.entity.Teacher;

@Repository
public interface ITeacherRepository extends JpaRepository<Teacher, Integer> {
	@Query("SELECT COUNT(t.dniTeacher) FROM Teacher t WHERE t.dniTeacher=:dniTeacher")
	public int searchTeacher(@Param("dniTeacher") String dni);
}

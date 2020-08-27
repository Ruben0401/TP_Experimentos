package pe.edu.upc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pe.edu.upc.entity.Student;

@Repository
public interface IStudentRepository extends JpaRepository<Student, Integer> {
	@Query("SELECT COUNT(s.idStudent) FROM Student s WHERE s.idStudent=:idStudent")
	public int searchStudent(@Param("idStudent") int id);
}

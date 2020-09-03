package pe.edu.upc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upc.entity.Student;

@Repository
public interface IStudentRepository extends JpaRepository<Student, Integer> {
	
}

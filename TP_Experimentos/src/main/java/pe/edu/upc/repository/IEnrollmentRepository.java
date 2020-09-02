package pe.edu.upc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upc.entity.Enrollment;

@Repository
public interface IEnrollmentRepository extends JpaRepository<Enrollment, Integer> {
	
}

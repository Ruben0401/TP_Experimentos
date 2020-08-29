package pe.edu.upc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pe.edu.upc.entity.Course;

@Repository
public interface ICourseRepository extends JpaRepository<Course, Integer> {
	@Query("SELECT COUNT(c.nameCourse) FROM Course c WHERE c.nameCourse=:nameCourse")
	public int searchCourse(@Param("nameCourse") String nombre);
}

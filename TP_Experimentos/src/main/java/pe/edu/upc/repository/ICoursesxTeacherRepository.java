package pe.edu.upc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pe.edu.upc.entity.CoursesxTeacher;

@Repository
public interface ICoursesxTeacherRepository extends JpaRepository<CoursesxTeacher, Integer> {

	@Query(value = "SELECT id_coursesx_teacher, semester, id_course, id_teacher FROM public.coursesxteachers where semester like ('%', :semester,'%')", nativeQuery = true)
	public List<String[]> CoursesxSemesters(@Param("semester") String semester);
	
}

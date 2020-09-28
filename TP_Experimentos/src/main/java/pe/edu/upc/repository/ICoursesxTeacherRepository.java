package pe.edu.upc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pe.edu.upc.entity.CoursesxTeacher;

@Repository
public interface ICoursesxTeacherRepository extends JpaRepository<CoursesxTeacher, Integer> {
	
	@Query(value = "SELECT c.name_course,t.name_teacher, z.semester_coursesx_teacher FROM coursesxteachers z join courses c on c.id_course = z.id_course join teachers t on t.id_teacher = z.id_teacher where z.semester_coursesx_teacher =:parametro ", nativeQuery = true)
	public List<String[]> findBysemesterxCourses(@Param("parametro") String parametro);
	
	@Query(value = "SELECT c.name_course,t.name_teacher, z.semester_coursesx_teacher FROM coursesxteachers z join courses c on c.id_course = z.id_course join teachers t on t.id_teacher = z.id_teacher", nativeQuery = true)
	public List<String[]> findBysemesterxCourses2();
	
}

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

	@Query(value = "SELECT cxt.id_coursesx_teacher, cxt.final_hour_coursesx_teacher, cxt.inital_hour_coursesx_teacher, cxt.semester_coursesx_teacher, cxt.id_course, cxt.id_teacher FROM Coursesxteachers cxt INNER JOIN Courses co ON cxt.id_course=co.id_course INNER JOIN Teachers te ON cxt.id_teacher=te.id_teacher WHERE LOWER(co.name_course) LIKE LOWER(concat('%',:parametro,'%')) OR LOWER(te.name_teacher) LIKE LOWER(concat('%',:parametro,'%')) OR LOWER(te.lastname_teacher) LIKE LOWER(concat('%',:parametro,'%'))", nativeQuery = true)
	List<CoursesxTeacher> findBynameCoursexteacher(@Param("parametro") String parametro);

}

package pe.edu.upc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upc.entity.CoursesxTeacher;

@Repository
public interface ICoursesxTeacherRepository extends JpaRepository<CoursesxTeacher, Integer> {

}

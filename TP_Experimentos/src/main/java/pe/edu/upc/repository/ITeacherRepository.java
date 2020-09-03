package pe.edu.upc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upc.entity.Teacher;

@Repository
public interface ITeacherRepository extends JpaRepository<Teacher, Integer> {

}

package pe.edu.upc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import pe.edu.upc.entity.Student;
import pe.edu.upc.serviceinterface.IStudentService;

@Controller
@RequestMapping("/students")
public class StudentController {
	@Autowired
	private IStudentService sS;

	@GetMapping("/new")
	public String newStudent(Model model) {
		model.addAttribute("student", new Student());
		return "student/student";
	}

	@PostMapping("/save")
	public String saveStudent(@Validated Student student, BindingResult result, Model model) throws Exception {
		if (result.hasErrors()) {
			return "student/student";
		} else {
			int rpta = sS.insert(student);
			if (rpta > 0) {
				model.addAttribute("mensaje", "Ya existe un alumno con ese código");
				return "student/student";
			} else {
				sS.insert(student);
				model.addAttribute("listStudents", sS.list());
				return "student/listStudents";
			}
		}

	}

	@GetMapping("/list")
	public String listStudents(Model model) {
		try {
			model.addAttribute("listStudents", sS.list());
		} catch (Exception e) {
			model.addAttribute("error", e.getMessage());
		}
		return "student/listStudents";
	}

	@RequestMapping("/delete/{id}")
	public String deleteStudent(Model model, @PathVariable(value = "id") int id) {
		try {
			if (id > 0) {
				sS.delete(id);
			}
			model.addAttribute("mensaje", "Se eliminó correctamente");
		} catch (Exception e) {
			model.addAttribute("mensaje", "Ocurrió un error, no se pudo eliminar");
		}
		model.addAttribute("listStudents", sS.list());
		return "student/listStudents";

	}

}

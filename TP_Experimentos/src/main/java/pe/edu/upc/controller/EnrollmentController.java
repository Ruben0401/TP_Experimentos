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

import pe.edu.upc.entity.Enrollment;
import pe.edu.upc.serviceinterface.IEnrollmentService;
import pe.edu.upc.serviceinterface.ICoursesxTeacherService;
import pe.edu.upc.serviceinterface.IStudentService;

@Controller
@RequestMapping("/enrollments")
public class EnrollmentController {

	@Autowired
	private ICoursesxTeacherService cxtS;

	@Autowired
	private  IEnrollmentService eS;

	@Autowired
	private IStudentService sS;
	
	
	
	@GetMapping("/new")
	public String newEnrollment(Model model) {
		model.addAttribute("enrollment", new Enrollment());
		model.addAttribute("listCoursesxTeacher", cxtS.list());
		model.addAttribute("listStudents", sS.list());
		return "enrollment/enrollment";
	}

	@PostMapping("/save")
	public String saveCoursesxTeacher(@Validated Enrollment enroll, BindingResult result, Model model)
			throws Exception {
		if (result.hasErrors()) {
		model.addAttribute("listCoursesxTeacher", cxtS.list());
		model.addAttribute("listStudents", sS.list());
			return "enrollment/enrollment";
		} else {
			eS.insert(enroll);	
			model.addAttribute("listCoursesxTeacher", cxtS.list());
			model.addAttribute("listStudents", sS.list());
			model.addAttribute("listEnrollments", eS.list());
			return "redirect:/enrollments/list";
		}
	}

	@GetMapping("/list")
	public String listCoursesxTeacher(Model model) {
		try {
			//model.addAttribute("coursesxteacher", new CoursesxTeacher());// necesario para el buscar
			model.addAttribute("listEnrollments", eS.list());
		} catch (Exception e) {
			model.addAttribute("error", e.getMessage());
		}
		return "enrollment/listEnrollments";
	}

	@RequestMapping("/delete/{id}")
	public String deleteCoursesxTeacher(Model model, @PathVariable(value = "id") int id) {
		try {
			if (id > 0) {
				eS.delete(id);
			}
			model.addAttribute("mensaje", "Se eliminó correctamente");
		} catch (Exception e) {
			model.addAttribute("mensaje", "Ocurrió un error, no se pudo eliminar");
		}
		model.addAttribute("listEnrollments", eS.list());
		return "enrollment/listEnrollments";
	}
}

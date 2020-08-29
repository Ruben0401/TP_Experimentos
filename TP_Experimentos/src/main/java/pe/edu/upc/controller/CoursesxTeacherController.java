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

import pe.edu.upc.entity.CoursesxTeacher;
import pe.edu.upc.serviceinterface.ICourseService;
import pe.edu.upc.serviceinterface.ICoursesxTeacherService;
import pe.edu.upc.serviceinterface.ITeacherService;

@Controller
@RequestMapping("/coursesxteachers")
public class CoursesxTeacherController {

	@Autowired
	private ICoursesxTeacherService cxtS;

	@Autowired
	private ICourseService cS;

	@Autowired
	private ITeacherService tS;
	
	@GetMapping("/new")
	public String newCoursesxTeacher(Model model) {
		model.addAttribute("coursesxteacher", new CoursesxTeacher());
		model.addAttribute("listCourses", cS.list());
		model.addAttribute("listTeachers", tS.list());
		return "coursesxteacher/coursesxteacher";
	}

	@PostMapping("/save")
	public String saveCoursesxTeacher(@Validated CoursesxTeacher coursesxteacher, BindingResult result, Model model)
			throws Exception {
		if (result.hasErrors()) {
			model.addAttribute("listCourses", cS.list());
			model.addAttribute("listTeachers", tS.list());
			return "coursesxteacher/coursesxteacher";
		} else {
			cxtS.insert(coursesxteacher);
			model.addAttribute("listCourses", cS.list());
			model.addAttribute("listTeachers", tS.list());
			model.addAttribute("listCoursesxTeachers", cxtS.list());
			return "redirect:/coursesxteachers/list";
		}
	}

	@GetMapping("/list")
	public String listCoursesxTeacher(Model model) {
		try {
			model.addAttribute("coursesxteacher", new CoursesxTeacher());// necesario para el buscar
			model.addAttribute("listCoursesxTeachers", cxtS.list());
		} catch (Exception e) {
			model.addAttribute("error", e.getMessage());
		}
		return "coursesxteacher/listCoursesxTeacher";
	}

	@RequestMapping("/delete/{id}")
	public String deleteCoursesxTeacher(Model model, @PathVariable(value = "id") int id) {
		try {
			if (id > 0) {
				cxtS.delete(id);
			}
			model.addAttribute("mensaje", "Se eliminó correctamente");
		} catch (Exception e) {
			model.addAttribute("mensaje", "Ocurrió un error, no se pudo eliminar");
		}
		model.addAttribute("listCoursesxTeachers", cxtS.list());
		return "coursesxteacher/listCoursesxTeacher";
	}
}

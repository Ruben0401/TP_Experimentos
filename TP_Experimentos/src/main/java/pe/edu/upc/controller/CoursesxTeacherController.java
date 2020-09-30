package pe.edu.upc.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import pe.edu.upc.entity.CoursesxTeacher;
import pe.edu.upc.entity.Enrollment;
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
		return "coursesxteacher/listCoursesxTeachers";
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
		return "coursesxteacher/listCoursesxTeachers";
	}
	
	@RequestMapping("/irupdate/{id}")
	public String irupdate(@PathVariable int id, Model model, RedirectAttributes objRedir) {
		Optional<CoursesxTeacher> objPro = cxtS.searchId(id);
		if (objPro == null) {
			objRedir.addFlashAttribute("mensaje", "Ocurrió un error");
			return "redirect:/coursesxteacher/list";
		} else {
			model.addAttribute("listCourses", cS.list());
			model.addAttribute("listTeachers", tS.list());
			model.addAttribute("listCoursesxTeachers", cS.list());
			model.addAttribute("coursesxteacher", objPro.get());
			return "coursesxteacher/coursesxteacher";
		}
	}
	
	@RequestMapping("/reports")
	public String reportsvist(Model model) {
		model.addAttribute("enrollment", new Enrollment());
		model.addAttribute("listEnrollments", cxtS.report1());
		return "enrollment/reportEnrollments";
	}
	
	//@RequestMapping("/reports1/{param}")
	//public String reportsvist(Map<String, Object> model, @PathVariable String param) {
	//	model.put("listEnrollments", cxtS.report2(param));
	//	return "enrollment/reportEnrollments";
	//}
	
	@RequestMapping("/reports1")
	public String reportfiltr(Model model, @Validated Enrollment enrollment) throws Exception {
		List<String[]> listEnrollments;
		listEnrollments = cxtS.report2(enrollment.getCoursesxteacher().getSemesterCoursesxTeacher());
		if (listEnrollments.isEmpty()) {
			model.addAttribute("mensaje", "No hay registros que coincidan con la búsqueda");
		}
		model.addAttribute("listEnrollments", listEnrollments);
		return "enrollment/reportEnrollments";
	}
}

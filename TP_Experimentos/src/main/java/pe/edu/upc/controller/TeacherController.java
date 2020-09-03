package pe.edu.upc.controller;

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

import pe.edu.upc.entity.Teacher;
import pe.edu.upc.serviceinterface.ITeacherService;

@Controller
@RequestMapping("/teachers")
public class TeacherController {
	@Autowired
	private ITeacherService tS;

	@GetMapping("/new")
	public String newTeacher(Model model) {
		model.addAttribute("teacher", new Teacher());
		return "teacher/teacher";
	}

	@PostMapping("/save")
	public String saveTeacher(@Validated Teacher teacher, BindingResult result, Model model) throws Exception {
		if (result.hasErrors()) {
			return "teacher/teacher";
		} else {
			tS.insert(teacher);
			model.addAttribute("listTeachers", tS.list());
			return "teacher/listTeachers";
		}
	}

	@GetMapping("/list")
	public String listTeachers(Model model) {
		try {
			model.addAttribute("listTeachers", tS.list());
		} catch (Exception e) {
			model.addAttribute("error", e.getMessage());
		}
		return "teacher/listTeachers";
	}

	@RequestMapping("/delete/{id}")
	public String deleteTeacher(Model model, @PathVariable(value = "id") int id) {
		try {
			if (id > 0) {
				tS.delete(id);
			}
			model.addAttribute("mensaje", "Se eliminó correctamente");
		} catch (Exception e) {
			model.addAttribute("mensaje", "Ocurrió un error, no se pudo eliminar");
		}
		model.addAttribute("listTeachers", tS.list());
		return "teacher/listTeachers";
	}

	@RequestMapping("/irupdate/{id}")
	public String irupdate(@PathVariable int id, Model model, RedirectAttributes objRedir) {
		Optional<Teacher> objPro = tS.searchId(id);
		if (objPro == null) {
			objRedir.addFlashAttribute("mensaje", "Ocurrió un error");
			return "redirect:/teacher/list";
		} else {
			model.addAttribute("listTeachers", tS.list());
			model.addAttribute("teacher", objPro.get());
			return "teacher/modTeacher";
		}
	}
}

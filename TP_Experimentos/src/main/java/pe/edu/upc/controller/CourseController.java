package pe.edu.upc.controller;

import java.util.Date;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import pe.edu.upc.entity.Course;
import pe.edu.upc.serviceinterface.ICourseService;

@Controller
@RequestMapping("/courses")
public class CourseController {
	@Autowired
	private ICourseService cS;
	
	@GetMapping("/new")
	public String newCourse(Model model) {
		model.addAttribute("course",new Course());
		return "course/course";
	}
	
	
	@GetMapping("/list")
	public String listCourses(Model model) {
		try {
			model.addAttribute("listCourses", cS.list());
		} catch (Exception e) {
			model.addAttribute("error", e.getMessage());
		}
		return "course/listCourses";
	}
	
	@PostMapping("/save")
	public String saveLoan(@Validated Course course, BindingResult result,SessionStatus status, Model model) throws Exception{
		
		if (result.hasErrors()) {

			model.addAttribute("mensaje","Prestamo no se registró correctamente");
			return "course/course";
		}else {
			
			cS.insert(course);
			model.addAttribute("mensaje","Prestamo se registró correctamente");
			return "redirect:/courses/list";
			
		}	
	}

	
	
	
	
}

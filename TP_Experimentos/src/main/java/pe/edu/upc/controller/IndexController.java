package pe.edu.upc.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import pe.edu.upc.entity.Account;
import pe.edu.upc.entity.Role;
import pe.edu.upc.serviceinterface.IAccountService;
import pe.edu.upc.serviceinterface.IRoleService;
@Controller
public class IndexController {
	@Autowired
	private IAccountService cS;
	@Autowired
	private IRoleService rS;
	
	private Role rol;
	
	
	
	//@GetMapping
	@GetMapping("/")	
	public String home() {
		return "index";
	}
	
	
	@GetMapping("/registry")	
	public String newAccount (Model model) {
		model.addAttribute("account", new Account());
		return "registro";
	}
	
	@PostMapping("/registry/save")
	public String saveAccount (@Validated Account account, BindingResult result, Model model) throws Exception {
		if (result.hasErrors()) {
			
			return "registro";
		} else {
			String password = new BCryptPasswordEncoder().encode(account.getPasswordAccount());
			account.setPasswordAccount(password);
			rol = new Role();
			rol =rS.getrole(1);
			account.setRoleAccount(rol);
			int rpta = cS.insert(account);
			if (rpta > 0) {
				
				
				model.addAttribute("mensaje2", "El UserName ya está en uso");
				return "registro";
			} else {
				
				cS.insert(account);
				model.addAttribute("listAccounts", cS.list());
				model.addAttribute("mensaje", "El usuario se registró correctamente");
				return "redirect:/login";
			}
		}
		
	}
	/*
	@GetMapping("/login")
	public String login (Model model) {
	
		return "login";
	}*/
	
	
	
	
	
}

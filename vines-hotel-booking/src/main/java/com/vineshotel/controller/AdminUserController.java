package com.vineshotel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.vineshotel.entity.User;
import com.vineshotel.repository.UserRepository;

@Controller
@RequestMapping("/admin/users")
public class AdminUserController {
	@Autowired
	private UserRepository userRepo;
	
	@Autowired 
	private PasswordEncoder passwordEncoder;
	
	// Show Add User Form
	@GetMapping("/add")
	public String showAddForm(Model model) {
	    model.addAttribute("user", new User());
	    return "admin/add-user";
	}
	
	// View users
	@GetMapping
	public String viewUsers(Model model) {
		model.addAttribute("users", userRepo.findAll());
		return "admin/manage-users";
	}
	
	//Save user
	@PostMapping("/save")
	public String saveUser( @ModelAttribute User user ) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		user.setRole("ROLE_USER");
		
		userRepo.save(user);
		
		return "redirect:/admin/users";
	}
	
	//Delete user
	@GetMapping("/delete/{id}")
	public String deleteUser(@PathVariable Long id) {
		userRepo.deleteById(id);
		return "redirect:/admin/users";
	}
}

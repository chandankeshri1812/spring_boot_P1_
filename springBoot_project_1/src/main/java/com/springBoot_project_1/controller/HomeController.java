package com.springBoot_project_1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.springBoot_project_1.dao.UserRepository;
import com.springBoot_project_1.helper.Message;
import com.springBoot_project_1.models.User;

import jakarta.servlet.http.HttpSession;

@Controller
public class HomeController {

	@Autowired
	private UserRepository userRepository;

	@RequestMapping("/")
	public String home(Model model) {

		model.addAttribute("title", "Home : perosnal portfolio");
		return "home";
	}

	@RequestMapping("/about")
	public String about(Model model) {

		model.addAttribute("title", "About : perosnal portfolio");
		return "about";
	}

	@RequestMapping("/signup")
	public String signup(Model model) {

		model.addAttribute("title", "signup : perosnal portfolio");
		model.addAttribute("user", new User());
		return "signup";
	}

//	 this handle for  registration user 
	@RequestMapping(value = "/do_register", method = RequestMethod.POST)
	public String registerUser(@ModelAttribute("user") User user,
			@RequestParam(value = "argrement", defaultValue = "false") boolean argrement, Model model
			,HttpSession session
			) {

		System.out.println("Agreement " + argrement);

		try {
			if (!argrement) {
				System.out.println("you have not agreed the terms and conditions");
				throw new Exception("you have not agreed the terms and conditions");
			}
			user.setRole("ROLE_USER");
			user.setEnabled(true);
			user.setImageUrl("deffault.png");

			System.out.println("User " + user);
			User result = this.userRepository.save(user);

			model.addAttribute("user", new User());
			session.setAttribute("message",new Message("Successfully Registered ", "alert-success"));
			return "signup";


		} catch (Exception e) {

			e.printStackTrace();
			model.addAttribute("user",user);
			session.setAttribute("message", new Message("Something went wrong : " + e.getMessage(),"alert-danger"));
			return "signup";
		}
		

	}

}

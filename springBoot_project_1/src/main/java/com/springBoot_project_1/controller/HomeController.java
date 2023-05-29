package com.springBoot_project_1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.springBoot_project_1.dao.UserRepository;
import com.springBoot_project_1.helper.Message;
import com.springBoot_project_1.models.User;
import com.springBoot_project_1.services.JwtGeneratorInterface;
//import com.springBoot_project_1.services.UserService;

import jakarta.servlet.http.HttpSession;

@Controller
public class HomeController {

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	@Autowired
	private UserRepository userRepository;

//	@Autowired
//	private JwtGeneratorInterface jwtGenerator;

//	@Autowired
//	private UserService userService;

	@RequestMapping("/")
	public String home(Model model) {

		model.addAttribute("title", "Home : home portfolio");
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
			@RequestParam(value = "argrement", defaultValue = "false") boolean argrement, Model model,
			HttpSession session) {

		System.out.println("Agreement " + argrement);

		try {
			if (!argrement) {
				System.out.println("you have not agreed the terms and conditions");
				throw new Exception("you have not agreed the terms and conditions");

			}
			user.setRole("ROLE_USER");
//			user.setEnabled(true);
			user.setImageUrl("deffault.png");

			user.setPassword(passwordEncoder.encode(user.getPassword()));
			System.out.println("User " + user);
			User result = this.userRepository.save(user);

			model.addAttribute("user", new User());
			session.setAttribute("message", new Message("Successfully Registered ", "alert-success"));
			return "signup";
		} catch (Exception e) {

			e.printStackTrace();
			model.addAttribute("user", user);
			session.setAttribute("message", new Message("Something went wrong : " + e.getMessage(), "alert-danger"));
			return "signup";
		}

	}

	@GetMapping("/signin")
	public String customLogin() {

//		model.addAttribute(model)
//		System.out.println("signin" + user.getEmail() +" get password : " + user.getPassword());
		return "login";

	}

//	  @PostMapping("/login")
//	  public ResponseEntity<?> login(@RequestBody User user) {
//		return null;
//	    try {
//	      if(user.getEmail() == null || user.getPassword() == null) {
////	      throw new UserNotFoundException("UserName or Password is Empty");
//	    	  System.out.println("UserName or Password is Empty");
//	    }
//	    User userData = userService.getUserByNameAndPassword(user.getEmail(), user.getPassword());
//	    if(userData == null){
////	       throw new UserNotFoundException("UserName or Password is Invalid");
//	    	  System.out.println("UserName or Password is Empty");
//	    }
//	       return new ResponseEntity<>(jwtGenerator.generateToken(user), HttpStatus.OK);
//	    } catch (Exception e) {
//	       return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
//	    }

//		  user.getEmail()
//	  }

}

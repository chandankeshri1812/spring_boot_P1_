package com.springBoot_project_1.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.springBoot_project_1.dao.UserRepository;
import com.springBoot_project_1.helper.Message;
import com.springBoot_project_1.models.Articles;
import com.springBoot_project_1.models.User;
import com.springBoot_project_1.services.ArticlesService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Autowired
	private ArticlesService articlesService;

	@RequestMapping("/index")
	public String dasboard(Model model, Principal principal) {

		String userName = principal.getName();
		User user = userRepository.getUserByUserName(userName);
		// get the user using username (email)
//		System.out.println("username : " + user);
		model.addAttribute("user", user);
		return "normal/userDashboard";
	}

	// user profile
	@RequestMapping("/profile")
	public String userProfile(Model model, Principal principal) {

		String userName = principal.getName();
		User user = userRepository.getUserByUserName(userName);
//		 get the user using username (email)
//		System.out.println("username : " + user);
		model.addAttribute("user", user);
		return "normal/userProfile";
	}

	// open update profile
	@RequestMapping("/userprofileupdate")
	public String updateUserProfile(Model model, Principal principal) {
		String userName = principal.getName();
		User user = userRepository.getUserByUserName(userName);
		model.addAttribute("user", user);
		return "normal/profileupdate";
	}

	
//	 this handle for  update profile of  user 
	@RequestMapping(value = "/do_update_profile", method = RequestMethod.POST)
	public String doUpdateProfile(@RequestParam("oldPassword") String oldPassword,
			@RequestParam("newPassword") String newPassword,
			@RequestParam("newConfirmPassword") String newConfirmPassword,

			@ModelAttribute("user") User user, Model model, HttpSession session, Principal principal) {

//		System.out.println("hello sir , i ma user update");
//
//		System.out.println("user Model at :  " + user.getName());

		// from dao user1
		User currentUser = this.userRepository.getUserByUserName(principal.getName());
//		user1.setName(user.getName());
//		System.out.println("user1 Model at :  " + currentUser.getName());
		currentUser.setName(user.getName());
		currentUser.setAbout(user.getAbout());
		currentUser.setPhoneNumber(user.getPhoneNumber());
//		System.out.println("dao user 1 password : " + currentUser.getPassword());
//		System.out.println();
//		System.out.println("oldPassword : " + oldPassword);
//		System.out.println("newPassword : " + newPassword);
//		System.out.println("newConfirmPassword : " + newConfirmPassword);
//		
//		if(newPassword==newConfirmPassword) {
		// error
//			System.out.println(newConfirmPassword==newPassword);
//						session.setAttribute("message", new Message("Please enter your correct confirmation password 2","danger"));
//
//						return "redirect:/user/userprofileupdate";
//		}else {

		if (this.bCryptPasswordEncoder.matches(oldPassword, currentUser.getPassword())) {

			// change the password

			currentUser.setPassword(this.bCryptPasswordEncoder.encode(newPassword));
			this.userRepository.save(currentUser);
			session.setAttribute("message", new Message("You successfully updated your profile", "success"));

		} else {

			// error
			session.setAttribute("message", new Message("Please enter your correct old password", "danger"));

			return "redirect:/user/userprofileupdate";
		}

		return "redirect:/user/allArticle";
//		}
	}

	// find all articles
	@RequestMapping("/allArticle")
	public String findAllArticles(Model model) {
		List<Articles> articles = articlesService.findAllArticles();
//		System.out.println("all Articles  are : " + articles);
		model.addAttribute("articles", articles);
		return "normal/userarticleALl";
	}

	
}

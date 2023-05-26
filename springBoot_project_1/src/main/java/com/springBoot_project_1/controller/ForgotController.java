package com.springBoot_project_1.controller;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.springBoot_project_1.dao.UserRepository;
import com.springBoot_project_1.models.User;
import com.springBoot_project_1.services.EmailServices;

import jakarta.servlet.http.HttpSession;

@Controller
public class ForgotController {
	Random random = new Random(10000);

	@Autowired
	private EmailServices emailServices;
	
	
	@Autowired
	private UserRepository userRepository;

	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	// email id form open handler
	@RequestMapping("/forgot")
	public String openEmailform() {

		return "forgot_email_form";
	}

	@PostMapping("/send_otp")
	public String sendOTP(@RequestParam("email") String email, HttpSession session) {

		System.out.println("Email : " + email);

		// generating otp of 4 digit

		int otp = random.nextInt(999999);
		System.out.println("Otp : " + otp);

		// write code for send opt to email

		String to = email;
		String from = "testingspringbootapi@gmail.com";
		String subject = "OPT From SCM";

		String text = " OTP = " +otp+  "";

//		String text = "" + "<div style ='border:1px solid #e2e2e2; padding:20px>" + "<h1>" + "OTP is " + "<b>" + otp
//				+ "</n>" + "</h1>" + "</div>";

		boolean b = this.emailServices.sendEmail(to, from, subject, text);

		if (b) {
			session.setAttribute("sessionOtp", otp);
			session.setAttribute("email", email);
			System.out.println("Email is sent successfully");

			return "verify_otp";
		} else {
			System.out.println("There is problem in sending email");
			session.setAttribute("message", "Check Your email id !!");
			return "forgot_email_form";
		}

	}

	// verify otp
	@PostMapping("/verify_otp")
	public String verifyOtp(@RequestParam("otp") int otp, HttpSession session) {
		
		int sessionOtp=(int) session.getAttribute("sessionOtp");
		String email = (String) session.getAttribute("email");
		
		if(sessionOtp==otp) {
			// password change form
			
			User user = this.userRepository.getUserByUserName(email);			
			
			if(user==null) {
				// send errror message
				session.setAttribute("email","User does not exits with this email");
				return "forgot_email_form";
				
			}else {
				// send change password-form
				
				
			}
			
			System.out.println("change your password : otp is correct ");
			return "change_password";
		}else {
			session.setAttribute("message","you have Entered wrong otp !! ");
			System.out.println("you have Entered wrong otp !! ");
			return "verify_otp";
		}
		
	}
	
	// change password
	@PostMapping("/change-password")
	public String changePassword(@RequestParam("newpassword") String newpassword
			, HttpSession session) {
		
		
		String email = (String) session.getAttribute("email");
		User user = this.userRepository.getUserByUserName(email);			

		user.setPassword(this.bCryptPasswordEncoder.encode(newpassword));
		this.userRepository.save(user);
		

		return "redirect:/signin?change=password changed sucessfully";
	}
	
	
}

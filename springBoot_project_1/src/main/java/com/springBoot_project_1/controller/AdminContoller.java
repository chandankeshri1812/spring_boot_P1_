package com.springBoot_project_1.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.springBoot_project_1.models.Articles;
import com.springBoot_project_1.services.ArticlesService;

@Controller
@RequestMapping("/admin")
public class AdminContoller {

	@Autowired
	private ArticlesService articlesService;

	@RequestMapping("/dash")
	public String admin() {

		System.out.println("admin dashbaord");
		return "admin/adminDashboard";
	}

	

	// find all articles 
	@RequestMapping("/allArticle")
	public String  findAllArticles(Model model) {
		List<Articles> articles = articlesService.findAllArticles();
		System.out.println("all Articles  are : " + articles);
		model.addAttribute(articles);
		return "admin/allArticle";
	}

	

	// create the articles form
	@RequestMapping("/add_article")
	public String createArticles() {
		
		
		return "admin/reasearch_form";

	}
//	method = RequestMethod.POST


	// submit of articles 
	@PostMapping("/do_add_article")
	public String doAddArticle(@ModelAttribute Articles articles) {
		Articles createArticles = articlesService.createArticles(articles);
		
		System.out.println("added one articles" + createArticles);
		return "admin/adminDashboard";
	}
	
	
	
	
	
	
	
//	// find by id
//	@GetMapping("/{id}")
//	public Optional<Articles> findByIdArticles(@PathVariable Integer id) {
//		System.out.println("findByIdArticles : " + articlesService.findByIdArticles(id));
//		return articlesService.findByIdArticles(id);
//	}

}

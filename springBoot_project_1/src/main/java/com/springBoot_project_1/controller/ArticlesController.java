package com.springBoot_project_1.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.springBoot_project_1.dao.ArticlesRepositroy;
import com.springBoot_project_1.models.Articles;
import com.springBoot_project_1.services.ArticlesService;

@RestController
@RequestMapping("/admin")
public class ArticlesController {

	@Autowired
	private ArticlesService articlesService;

	@GetMapping("/test")
	@ResponseBody
	public String test() {

		return "working";

	}

	// create the articles
	@PostMapping("/add_article")
	public ResponseEntity<Articles> createArticles(@RequestBody Articles articles) {
		System.out.println("created articels");
		return new ResponseEntity<>(articlesService.createArticles(articles), HttpStatus.CREATED);

	}

	// find all articles

	@GetMapping("/allArticle")
	public List<Articles> findAllArticles() {

		return articlesService.findAllArticles();
	}

	@GetMapping("/{id}")
	public Optional<Articles> findByIdArticles(@PathVariable Integer id) {
		System.out.println("findByIdArticles : " + articlesService.findByIdArticles(id));
		return articlesService.findByIdArticles(id);
	}

}

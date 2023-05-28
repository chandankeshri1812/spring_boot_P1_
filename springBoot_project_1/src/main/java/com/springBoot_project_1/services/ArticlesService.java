package com.springBoot_project_1.services;

import java.util.List;
import java.util.Optional;

import com.springBoot_project_1.models.Articles;

public interface ArticlesService {

	
	public Articles createArticles(Articles articles);
	
	public List<Articles>  findAllArticles();

	public Optional<Articles> findByIdArticles(Integer id);
	
}

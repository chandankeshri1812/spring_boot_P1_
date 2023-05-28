package com.springBoot_project_1.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.springBoot_project_1.dao.ArticlesRepositroy;
import com.springBoot_project_1.models.Articles;

@Service
public class ArticlesServiceImpl implements ArticlesService{

	@Autowired
	private ArticlesRepositroy articlesRepositroy;
	
	

	
	//created articles

	public Articles createArticles(Articles articles) {
		return articlesRepositroy.save(articles);
	}



// find all the articles 
	@Override
	public List<Articles>  findAllArticles() {
		return articlesRepositroy.findAll();
	}

	
	// find articles by id
	@Override
	public Optional<Articles> findByIdArticles(Integer id) {
		return articlesRepositroy.findById(id);
	}



	

	
	

}

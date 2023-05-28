package com.springBoot_project_1.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springBoot_project_1.models.Articles;

@Repository
public interface ArticlesRepositroy extends JpaRepository<Articles, Integer>{

}

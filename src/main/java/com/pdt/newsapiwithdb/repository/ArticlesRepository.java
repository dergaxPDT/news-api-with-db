package com.pdt.newsapiwithdb.repository;

import com.pdt.newsapiwithdb.model.entity.Articles;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ArticlesRepository extends JpaRepository<Articles, UUID>, CustomArticlesRepository {

}

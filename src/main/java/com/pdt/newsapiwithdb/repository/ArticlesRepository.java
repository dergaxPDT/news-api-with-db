package com.pdt.newsapiwithdb.repository;

import com.pdt.newsapiwithdb.model.entity.Articles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ArticlesRepository extends JpaRepository<Articles, UUID>, CustomArticlesRepository {

}

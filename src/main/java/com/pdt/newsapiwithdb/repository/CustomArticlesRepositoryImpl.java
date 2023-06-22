package com.pdt.newsapiwithdb.repository;

import com.pdt.newsapiwithdb.model.entity.Articles;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CustomArticlesRepositoryImpl implements CustomArticlesRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Articles> findAllWithLimitAndOffset(int offset, int limit) {
        return entityManager
                .createQuery("SELECT m FROM Articles m ORDER BY m.publishedAt DESC", Articles.class)
                .setMaxResults(limit)
                .setFirstResult(offset)
                .getResultList();
    }
}

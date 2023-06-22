package com.pdt.newsapiwithdb.repository;

import com.pdt.newsapiwithdb.model.entity.Articles;

import java.util.List;

public interface CustomArticlesRepository {
    List<Articles> findAllWithLimitAndOffset(int offset, int limit);

}

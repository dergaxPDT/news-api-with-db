package com.pdt.newsapiwithdb.service;

import com.pdt.newsapiwithdb.model.dto.ArticlesDTO;
import com.pdt.newsapiwithdb.model.entity.Articles;

import java.util.List;

public interface ArticlesService {
    List<ArticlesDTO> getNewsAndSave(String query, String sortBy);

    List<Articles> getArticles(int offset, int limit);
}

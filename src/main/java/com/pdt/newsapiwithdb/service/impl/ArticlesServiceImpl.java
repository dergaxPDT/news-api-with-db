package com.pdt.newsapiwithdb.service.impl;

import com.pdt.newsapiwithdb.mapper.ArticlesMapper;
import com.pdt.newsapiwithdb.model.dto.ArticlesDTO;
import com.pdt.newsapiwithdb.model.entity.Articles;
import com.pdt.newsapiwithdb.repository.ArticlesRepository;
import com.pdt.newsapiwithdb.service.ArticlesService;
import com.pdt.newsapiwithdb.service.NewsApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticlesServiceImpl implements ArticlesService {

    private final ArticlesRepository articlesRepository;

    private final NewsApiService newsApiService;

    @Autowired
    private ArticlesServiceImpl(ArticlesRepository articlesRepository, NewsApiService newsApiService) {
        this.articlesRepository = articlesRepository;
        this.newsApiService = newsApiService;
    }

    @Override
    public List<ArticlesDTO> getNewsAndSave(String query, String sortBy) {
        List<ArticlesDTO> listDTO = newsApiService.getNews(query, sortBy).getArticles();
        listDTO.forEach(dto -> articlesRepository.save(ArticlesMapper.MAPPER.toEntity(dto)));
        return listDTO;
    }

    @Override
    public List<Articles> getArticles(int offset, int limit) {
        return articlesRepository.findAllWithLimitAndOffset(offset, limit);
    }
}

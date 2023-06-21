package com.pdt.newsapiwithdb.service;

import com.pdt.newsapiwithdb.model.dto.NewsApiModelDTO;

public interface NewsApiService {
    NewsApiModelDTO getNews(String query, String sortBy);
}

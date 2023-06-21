package com.pdt.newsapiwithdb.service.impl;

import com.pdt.newsapiwithdb.model.dto.NewsApiModelDTO;
import com.pdt.newsapiwithdb.service.NewsApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Collections;

@Service
public class NewsApiServiceImpl implements NewsApiService {

    private final RestTemplate restTemplate;

    @Autowired
    private NewsApiServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Value("${newsapi.url}")
    private String url;

    @Value("${newsapi.api.key}")
    private String apiKey;

    @Override
    public NewsApiModelDTO getNews() {
        String resourceUrl = UriComponentsBuilder
                .fromHttpUrl(url)
                .queryParam("q", "apple")
                .queryParam("sortBy", "popularity")
                .queryParam("ApiKey", apiKey)
                .build()
                .encode()
                .toUriString();
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(new MediaType(MediaType.APPLICATION_JSON)));
        HttpEntity<Void> entity = new HttpEntity<>(headers);
        ResponseEntity<NewsApiModelDTO> responseEntity = restTemplate.exchange(resourceUrl, HttpMethod.GET, entity, NewsApiModelDTO.class);
        return responseEntity.getBody();
    }
}

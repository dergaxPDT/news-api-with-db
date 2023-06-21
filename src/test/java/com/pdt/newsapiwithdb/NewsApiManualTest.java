package com.pdt.newsapiwithdb;

import com.pdt.newsapiwithdb.model.dto.NewsApiModelDTO;
import com.pdt.newsapiwithdb.service.impl.NewsApiServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class NewsApiManualTest {

    @Autowired
    private NewsApiServiceImpl newsApiServiceImpl;

    @Test
    @Disabled("Direct api to API NEWS")
    void getMessagesDirectFromApi(){
        NewsApiModelDTO dto = newsApiServiceImpl.getNews("query", "sortBy");
        Assertions.assertEquals(59237, dto.getTotalResults());
    }
}

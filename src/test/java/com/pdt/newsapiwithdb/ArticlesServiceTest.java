package com.pdt.newsapiwithdb;

import com.pdt.newsapiwithdb.model.dto.ArticlesDTO;
import com.pdt.newsapiwithdb.model.entity.Articles;
import com.pdt.newsapiwithdb.repository.ArticlesRepository;
import com.pdt.newsapiwithdb.model.dto.NewsApiModelDTO;
import com.pdt.newsapiwithdb.model.dto.SourceDTO;
import com.pdt.newsapiwithdb.service.ArticlesService;
import com.pdt.newsapiwithdb.service.NewsApiService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;

@SpringBootTest
@DisplayName("MESSAGE SERVICE TEST")
class ArticlesServiceTest {

    @Autowired
    private ArticlesService articlesService;

    @Autowired
    private ArticlesRepository articlesRepository;

    @MockBean
    private NewsApiService newsApiService;

    @Test
    @DisplayName("should  get one message dto from mock and save it to db")
    void getNewsAndSave() {
        //given
        ArticlesDTO articlesDTO = getMessageDTO();
        Mockito.when(newsApiService.getNews(any(), any())).thenReturn(new NewsApiModelDTO("ok", 1, List.of(getMessageDTO())));
        //when
        articlesService.getNewsAndSave("query", "sortBy");
        //then
        Articles articles = articlesRepository.findAll().get(0);
        assertEquals(articlesDTO.getSource().getName(), articles.getSource().getName());
        assertEquals(articlesDTO.getAuthor(), articles.getAuthor());
        assertEquals(articlesDTO.getTitle(), articles.getTitle());
        assertEquals(articlesDTO.getDescription(), articles.getDescription());
        assertEquals(articlesDTO.getUrl(), articles.getUrl());
        assertEquals(articlesDTO.getUrlToImage(), articles.getUrlToImage());
        assertEquals(articlesDTO.getPublishedAt(), articles.getPublishedAt());
        assertEquals(articlesDTO.getContent(), articles.getContent());
    }

    private ArticlesDTO getMessageDTO() {
        return ArticlesDTO
                .builder()
                .source(
                        SourceDTO.builder()
                                .name("Lifehacker.com")
                                .build()
                )
                .author("Ross Johnson")
                .title("12 'Legacy Sequels' That Don’t (and 8 That Kinda Do)")
                .description("I’m not wild about our current pop culture obsession with nostalgia, in part because we seem be reaching a point where a dearth of original cinematic fare is going to leave the nostalgia miners of the future with nothing to work with.Read more...")
                .url("https://lifehacker.com/12-legacy-sequels-that-don-t-suck-and-8-that-kinda-do-1850459463")
                .urlToImage("https://i.kinja-img.com/gawker-media/image/upload/c_fill,f_auto,fl_progressive,g_center,h_675,pg_1,q_80,w_1200/d983fef5f9768d61b5dd7b57db65c818.jpg")
                .publishedAt(LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS))
                .content("Maple syrup is so good, its hard to believe it comes out of a tree. Or maybe its easy to believe. Trees also give us peaches, olives, and lemons, three things that markedly improve mundane life with … [+2578 chars]")
                .build();
    }
}
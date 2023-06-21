package com.pdt.newsapiwithdb.service;

import com.pdt.newsapiwithdb.repository.MessageRepository;
import com.pdt.newsapiwithdb.model.dto.MessageDTO;
import com.pdt.newsapiwithdb.model.dto.NewsApiModelDTO;
import com.pdt.newsapiwithdb.model.dto.SourceDTO;
import com.pdt.newsapiwithdb.model.entity.Message;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@DisplayName("MESSAGE SERVICE TEST")
class MessageServiceTest {

    @Autowired
    private MessageService messageService;

    @Autowired
    private MessageRepository messageRepository;

    @MockBean
    private NewsApiService newsApiService;

    @Test
    @DisplayName("should  get one message dto from mock and save it to db")
    void getNewsAndSave() {
        //given
        MessageDTO messageDTO = getMessageDTO();
        Mockito.when(newsApiService.getNews()).thenReturn(new NewsApiModelDTO("ok", 1, List.of(getMessageDTO())));
        //when
        messageService.getNewsAndSave();
        //then
        Message message = messageRepository.findAll().get(0);
        assertEquals(messageDTO.getSource().getName(), message.getSource().getName());
        assertEquals(messageDTO.getAuthor(), message.getAuthor());
        assertEquals(messageDTO.getTitle(), message.getTitle());
        assertEquals(messageDTO.getDescription(), message.getDescription());
        assertEquals(messageDTO.getUrl(), message.getUrl());
        assertEquals(messageDTO.getUrlToImage(), message.getUrlToImage());
        assertEquals(messageDTO.getPublishedAt(), message.getPublishedAt());
        assertEquals(messageDTO.getContent(), message.getContent());
    }

    private MessageDTO getMessageDTO() {
        return MessageDTO
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
                .publishedAt(LocalDateTime.now())
                .content("Maple syrup is so good, its hard to believe it comes out of a tree. Or maybe its easy to believe. Trees also give us peaches, olives, and lemons, three things that markedly improve mundane life with … [+2578 chars]")
                .build();
    }
}
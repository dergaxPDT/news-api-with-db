package com.pdt.newsapiwithdb.service.impl;

import com.pdt.newsapiwithdb.MessageRepository;
import com.pdt.newsapiwithdb.mapper.MessageMapper;
import com.pdt.newsapiwithdb.model.dto.MessageDTO;
import com.pdt.newsapiwithdb.model.dto.NewsApiModelDTO;
import com.pdt.newsapiwithdb.service.MessageService;
import com.pdt.newsapiwithdb.service.NewsApiService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class MessageServiceImpl implements MessageService {

    private final MessageRepository messageRepository;
    private final NewsApiService newsApiService;

    @Autowired
    private MessageServiceImpl(MessageRepository messageRepository, NewsApiService newsApiService) {
        this.messageRepository = messageRepository;
        this.newsApiService = newsApiService;
    }

    @Override
    public List<MessageDTO> getNewsAndSave() {
        List<MessageDTO> listDTO = newsApiService.getNews().getArticles();
        listDTO.forEach(dto -> messageRepository.save(MessageMapper.MAPPER.toEntity(dto)));
        return listDTO;
    }
}

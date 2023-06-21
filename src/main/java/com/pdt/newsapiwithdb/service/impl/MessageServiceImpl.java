package com.pdt.newsapiwithdb.service.impl;

import com.pdt.newsapiwithdb.model.entity.Message;
import com.pdt.newsapiwithdb.repository.MessageRepository;
import com.pdt.newsapiwithdb.mapper.MessageMapper;
import com.pdt.newsapiwithdb.model.dto.MessageDTO;
import com.pdt.newsapiwithdb.service.MessageService;
import com.pdt.newsapiwithdb.service.NewsApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public List<MessageDTO> getNewsAndSave(String query, String sortBy) {
        List<MessageDTO> listDTO = newsApiService.getNews(query, sortBy).getArticles();
        listDTO.forEach(dto -> messageRepository.save(MessageMapper.MAPPER.toEntity(dto)));
        return listDTO;
    }

    @Override
    public List<Message> getArticles(int offset, int limit) {
        return messageRepository.findAllWithLimitAndOffset(offset, limit);
    }
}

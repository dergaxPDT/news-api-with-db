package com.pdt.newsapiwithdb.service;

import com.pdt.newsapiwithdb.model.dto.MessageDTO;
import com.pdt.newsapiwithdb.model.entity.Message;

import java.util.List;

public interface MessageService {
    List<MessageDTO> getNewsAndSave();

    List<Message> getArticles(int offset, int limit);
}

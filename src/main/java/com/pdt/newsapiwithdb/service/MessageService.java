package com.pdt.newsapiwithdb.service;

import com.pdt.newsapiwithdb.model.dto.MessageDTO;

import java.util.List;

public interface MessageService {
    List<MessageDTO> getNewsAndSave();
}

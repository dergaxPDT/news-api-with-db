package com.pdt.newsapiwithdb.controller;

import com.pdt.newsapiwithdb.model.dto.MessageDTO;
import com.pdt.newsapiwithdb.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/messages")
//TODO message controller
public class MessageController {

    private final MessageService messageService;

    @Autowired
    private MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    @PostMapping
    List<MessageDTO> getArticlesAndSave() {
       return messageService.getNewsAndSave();
    }

}

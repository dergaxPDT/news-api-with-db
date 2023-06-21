package com.pdt.newsapiwithdb.controller;

import com.pdt.newsapiwithdb.model.dto.MessageDTO;
import com.pdt.newsapiwithdb.model.entity.Message;
import com.pdt.newsapiwithdb.service.MessageService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/messages")
@Tag(name = "MESSAGE REST API")
public class MessageController {

    private final MessageService messageService;

    @Autowired
    private MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    @PostMapping
    @Operation(description = "downloads articles from an external API and saves them to the database")
    List<MessageDTO> getArticlesAndSave() {
        return messageService.getNewsAndSave();
    }


    @GetMapping
    @Operation(description = "list of articles.")
    List<Message> getArticles(@RequestParam("OFFSET") int offset, @RequestParam("LIMIT") int limit) {
        return messageService.getArticles(offset, limit);
    }

}

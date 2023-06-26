package com.pdt.newsapiwithdb.controller;

import com.pdt.newsapiwithdb.mapper.ArticlesMapper;
import com.pdt.newsapiwithdb.model.dto.ArticlesDTO;
import com.pdt.newsapiwithdb.service.ArticlesService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/articles")
@Tag(name = "Articles REST API")
public class ArticlesController {

    private final ArticlesService articlesService;

    @Autowired
    private ArticlesController(ArticlesService articlesService) {
        this.articlesService = articlesService;
    }

    @PostMapping
    @Operation(description = "downloads articles from an external API and saves them to the database. Params: query (ex. apple), sortBy(ex. popularity)")
    public List<ArticlesDTO> getArticlesAndSave(@RequestParam String query, @RequestParam String sortBy) {
        return articlesService.getNewsAndSave(query, sortBy);
    }

    @GetMapping
    @Operation(description = "list of articles")
    public List<ArticlesDTO> getArticles(@RequestParam("OFFSET") int offset, @RequestParam("LIMIT") int limit) {
        return articlesService.getArticles(offset, limit)
                .stream()
                .map(ArticlesMapper.MAPPER::toDto)
                .toList();
    }
}

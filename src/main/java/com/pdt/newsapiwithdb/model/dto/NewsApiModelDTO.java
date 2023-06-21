package com.pdt.newsapiwithdb.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class NewsApiModelDTO {
    private String status;
    private int totalResults;
    private List<MessageDTO> articles;
}

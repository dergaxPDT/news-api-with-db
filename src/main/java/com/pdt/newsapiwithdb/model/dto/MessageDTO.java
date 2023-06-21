package com.pdt.newsapiwithdb.model.dto;

import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
public class MessageDTO {

    private SourceDTO source;
    private String author;
    private String title;
    private String description;
    private String url;
    private String urlToImage;
    private LocalDateTime publishedAt;
    private String content;

}

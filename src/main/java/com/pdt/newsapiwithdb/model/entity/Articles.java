package com.pdt.newsapiwithdb.model.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.*;
import org.hibernate.annotations.CascadeType;

import java.time.LocalDateTime;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Getter
@ToString
@Setter
public class Articles {

    @Id
    @GeneratedValue
    @UuidGenerator
    private UUID id;
    @OneToOne
    @Fetch(FetchMode.JOIN)
    @Cascade(CascadeType.ALL)
    private Source source;
    private String title;
    private String author;
    @Column(columnDefinition = "TEXT")
    private String description;
    private String url;
    private String urlToImage;
    private LocalDateTime publishedAt;
    @Column(columnDefinition = "TEXT")
    private String content;
}


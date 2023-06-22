package com.pdt.newsapiwithdb.model.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Getter
@ToString
@Setter
public class Articles {

    @Id
    private String title;

    @OneToOne
    @Fetch(FetchMode.JOIN)
    @Cascade(CascadeType.ALL)
    private Source source;

    private String author;

    @Column(columnDefinition = "TEXT")
    private String description;
    private String url;
    private String urlToImage;
    private LocalDateTime publishedAt;
    @Column(columnDefinition = "TEXT")
    private String content;
}


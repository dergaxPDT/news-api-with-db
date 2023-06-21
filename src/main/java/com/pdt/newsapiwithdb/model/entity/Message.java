package com.pdt.newsapiwithdb.model.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.UuidGenerator;

import java.time.LocalDate;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Getter
@ToString
public class Message {
    @Id
    @GeneratedValue
    @UuidGenerator
    private UUID id;

    @OneToOne
    @Fetch(FetchMode.JOIN)
    @Cascade(CascadeType.ALL)
    private Source source;
    private String author;
    private String title;
    private String description;
    private String url;
    private String urlToImage;
    private LocalDate publishedAt;
    private String content;

}


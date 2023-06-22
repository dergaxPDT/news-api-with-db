package com.pdt.newsapiwithdb.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Getter
public class Source {

    @Id
    @GeneratedValue
    @UuidGenerator
    private UUID id;
    private String name;
    @OneToOne
    @Fetch(FetchMode.JOIN)
    @Cascade(CascadeType.ALL)
    private Articles message;
}

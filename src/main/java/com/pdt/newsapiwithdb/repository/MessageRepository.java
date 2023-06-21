package com.pdt.newsapiwithdb.repository;

import com.pdt.newsapiwithdb.model.entity.Message;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface MessageRepository extends JpaRepository<Message, UUID>, CustomMessageRepository {

}

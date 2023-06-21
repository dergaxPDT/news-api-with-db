package com.pdt.newsapiwithdb.repository;

import com.pdt.newsapiwithdb.model.entity.Message;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CustomMessageRepository {
    List<Message> findAllWithLimitAndOffset(int offset, int limit);

}

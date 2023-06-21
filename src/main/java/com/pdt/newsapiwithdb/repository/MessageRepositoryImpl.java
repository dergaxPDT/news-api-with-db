package com.pdt.newsapiwithdb.repository;

import com.pdt.newsapiwithdb.model.entity.Message;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MessageRepositoryImpl implements CustomMessageRepository  {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Message> findAllWithLimitAndOffset(int offset, int limit) {
        return entityManager.createQuery("SELECT m FROM Message m ORDER BY m.publishedAt DESC",
                Message.class).setMaxResults(limit).setFirstResult(offset).getResultList();
    }
}

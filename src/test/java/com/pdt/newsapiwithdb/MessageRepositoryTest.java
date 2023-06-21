package com.pdt.newsapiwithdb;

import com.pdt.newsapiwithdb.model.entity.Message;
import com.pdt.newsapiwithdb.model.entity.Source;
import com.pdt.newsapiwithdb.repository.MessageRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class MessageRepositoryTest {

    @Autowired
    private MessageRepository messageRepository;

    @Test
    void shouldSaveInDbMessage() {
        messageRepository.save(getMessageEx());
        assertEquals(1, messageRepository.findAll().size());
    }

    @Test
    void shouldSaveMessagesAndReturn() {
        List<Message> listExpected = new ArrayList<>();
        for (int i = 20; i > 0; i--) {
            Message message = getMessageEx();
            message.setPublishedAt(LocalDateTime.now().plusMinutes(i).truncatedTo(ChronoUnit.MILLIS));
            messageRepository.save(message);
            listExpected.add(message);
        }
        int limit = 7;
        int offset = 7;
        List<Message> listActual = messageRepository.findAllWithLimitAndOffset(offset, limit);
        int size = 7;
        assertEquals(size, listActual.size());
        for (int i = 0; i < limit; i++) {
            assertEquals(listExpected.get(i+offset).getPublishedAt(), listActual.get(i).getPublishedAt());
        }
    }

    private Message getMessageEx() {
        return Message
                .builder()
                .source(
                        Source.builder()
                                .name("Lifehacker.com")
                                .build()
                )
                .author("Ross Johnson")
                .title("12 'Legacy Sequels' That Don’t (and 8 That Kinda Do)")
                .description("I’m not wild about our current pop culture obsession with nostalgia, in part because we seem be reaching a point where a dearth of original cinematic fare is going to leave the nostalgia miners of the future with nothing to work with.Read more...")
                .url("https://lifehacker.com/12-legacy-sequels-that-don-t-suck-and-8-that-kinda-do-1850459463")
                .urlToImage("https://i.kinja-img.com/gawker-media/image/upload/c_fill,f_auto,fl_progressive,g_center,h_675,pg_1,q_80,w_1200/d983fef5f9768d61b5dd7b57db65c818.jpg")
                .publishedAt(LocalDateTime.now())
                .content("Maple syrup is so good, its hard to believe it comes out of a tree. Or maybe its easy to believe. Trees also give us peaches, olives, and lemons, three things that markedly improve mundane life with … [+2578 chars]")
                .build();
    }
}

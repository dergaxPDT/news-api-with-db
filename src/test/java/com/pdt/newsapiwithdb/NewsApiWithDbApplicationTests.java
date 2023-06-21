package com.pdt.newsapiwithdb;

import com.pdt.newsapiwithdb.model.entity.Message;
import com.pdt.newsapiwithdb.model.entity.Source;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

@SpringBootTest
class NewsApiWithDbApplicationTests {

    @Autowired
    private MessageRepository messageRepository;

    @Test
    void shouldSaveInDbMessage() {
        messageRepository.save(getMessageEx());
        Assertions.assertEquals(1, messageRepository.findAll().size());
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
                .publishedAt(LocalDate.now())
                .content("Maple syrup is so good, its hard to believe it comes out of a tree. Or maybe its easy to believe. Trees also give us peaches, olives, and lemons, three things that markedly improve mundane life with … [+2578 chars]")
                .build();
    }
}

package com.lsh.project.domain.posts;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class PostRepositoryTest {

    @Autowired
    PostRepository postRepository;

    @AfterEach
    public void cleanup(){
        System.out.println("cleanup method start!");
        postRepository.deleteAll();
    }

    @Test
    public void getBoardData(){
        String title = "test title";
        String content = "test content~~~";

        postRepository.save(Posts.builder()
                            .title(title)
                            .content(content)
                            .author("lsh503984@gmail.com")
                            .build());

        //when

        List<Posts> list  = postRepository.findAll();

        //then
        Posts posts = list.get(0);
        assertThat(posts.getTitle()).isEqualTo(title);
        assertThat(posts.getContent()).isEqualTo(content);

    }

    @Test
    public void registBaseTimeEntity(){
        LocalDateTime now = LocalDateTime.of(2020,2,8,0,0,0);
        postRepository.save(Posts.builder()
                                .title("title")
                                .content("content")
                                .author("author")
                                .build());

        List<Posts> list = postRepository.findAll();

        Posts posts = list.get(0);
        System.out.println(">>>>>>>>>>> now : "+now);
        System.out.println(">>>>>>>>>>> createDate = "+posts.getModifiedDate());

        assertThat(posts.getCreateDate()).isAfter(now);
        assertThat(posts.getModifiedDate().isAfter(now));
    }
}

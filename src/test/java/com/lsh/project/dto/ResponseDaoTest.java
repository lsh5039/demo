package com.lsh.project.dto;

import org.junit.jupiter.api.Test;

public class ResponseDaoTest {

    @Test
    public void lombokTest(){


        PostsResponseDto dao = PostsResponseDto.builder().content("안녕하세요").title("인사글").build();
        System.out.println(dao.getTitle());
        System.out.println(dao.getContent());
        
    }
}

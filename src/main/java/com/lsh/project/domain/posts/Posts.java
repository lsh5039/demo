package com.lsh.project.domain.posts;


import com.lsh.project.domain.BaseTimeEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Posts extends BaseTimeEntity {

    @Id //pk지정
    @GeneratedValue(strategy = GenerationType.IDENTITY) //pk 값 지정방식
    private Long id;

    @Column(length = 500, nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;


    public void update(String title, String content){
        this.title = title;
        this.content = content;
    }


}

package com.lsh.project.controller;


import com.lsh.project.dto.PostsListResponseDto;
import com.lsh.project.dto.PostsResponseDto;
import com.lsh.project.service.posts.PostsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;


@RequiredArgsConstructor
@Controller
public class IndexController {
    private final PostsService postsService;


    @GetMapping("/")
    public String index(Model model) {
        System.out.println("들어옴");
        List<PostsListResponseDto> list = new ArrayList<>();
                list = postsService.findAllDesc();
        /*for(PostsListResponseDto item : list){
            System.out.println("크기 ::"+list.size());
            System.out.println("제목 ::"+item.getTitle());

        }*/


        model.addAttribute("posts", list);
        System.out.println("여기까진 OK...");
        return "index";

    }

    @GetMapping("/post/save")
    public String postSave(){
        return "post-save";
    }


    @GetMapping("/posts/update/{id}")
    public String postsUpdate(@PathVariable Long id, Model model){
        PostsResponseDto dto = postsService.find(id);
        model.addAttribute("post", dto);

        return "post-update";
    }

}


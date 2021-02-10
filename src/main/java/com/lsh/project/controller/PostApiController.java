package com.lsh.project.controller;


import com.lsh.project.dto.PostsResponseDto;
import com.lsh.project.dto.PostsSaveRequestDto;
import com.lsh.project.dto.PostsUpdateRequestDto;
import com.lsh.project.service.posts.PostsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class PostApiController {
    private final PostsService postsService;
    //@RequiredArgsConstructor 로 인해 final인 모든필드 생성자 bean 주입 따라서 @Autowired를 안해도 됨.

   @PostMapping("/api/v1/posts")
   public Long save(@RequestBody PostsSaveRequestDto requestDto){
       System.out.println("컨트롤러 도착");
       
       
       return postsService.save(requestDto);
   }

   @PutMapping("/api/v1/posts/{id}")
   public Long update(@PathVariable Long id, @RequestBody PostsUpdateRequestDto requestDto){
        return postsService.update(id, requestDto);
   }

   @GetMapping("/api/v1/posts/{id}")
    public PostsResponseDto find(@PathVariable Long id){
      // Long num = Long.valueOf(1);
       return postsService.find(id);
   }

   @DeleteMapping("/api/v1/posts/{id}")
    public Long delete(@PathVariable Long id){
        postsService.delete(id);
        return id;
   }
}

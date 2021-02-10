package com.lsh.project.service.posts;

import com.lsh.project.domain.posts.PostRepository;
import com.lsh.project.domain.posts.Posts;
import com.lsh.project.dto.PostsListResponseDto;
import com.lsh.project.dto.PostsResponseDto;
import com.lsh.project.dto.PostsSaveRequestDto;
import com.lsh.project.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class PostsService {
    private final PostRepository postRepository;

    @Transactional
    public Long save(PostsSaveRequestDto requestDto){
        return postRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, PostsUpdateRequestDto requestDto){
        Posts posts = postRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 게시물없음"));
        posts.update(requestDto.getTitle(),requestDto.getContent());

        return id;
    }

    @Transactional
    public PostsResponseDto find(Long id){

        Posts entity = postRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 게시물없음"));
        return new PostsResponseDto(entity);
    }

    @Transactional(readOnly = true)
    public List<PostsListResponseDto> findAllDesc() {
     /*return postRepository.findAllDesc()
                            .stream()
                            .map(PostsListResponseDto::new)
                            .collect(Collectors.toList());*/
        return postRepository.findAllDesc()
                             .stream()
                             .map(posts -> new PostsListResponseDto(posts))
                             .collect(Collectors.toList());


    }

    @Transactional
    public void delete(Long id){
        Posts posts = postRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 게시물없음"));

        postRepository.delete(posts);


    }
}

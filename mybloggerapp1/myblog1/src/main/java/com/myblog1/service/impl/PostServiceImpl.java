package com.myblog1.service.impl;

import com.myblog1.entity.Post;
import com.myblog1.payload.PostDto;
import com.myblog1.repository.PostRepository;
import com.myblog1.service.PostService;
import org.springframework.stereotype.Service;

@Service
public class PostServiceImpl implements PostService {
    private PostRepository postRepository;

    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public PostDto createPost(PostDto postDto) {
        Post post = new Post();
        post.setTitle(postDto.getTitle());
        post.setDescription(postDto.getDescription());
        post.setContent(postDto.getContent());

        Post newpost = postRepository.save(post);
        PostDto dto = new PostDto();
        dto.setId(newpost.getId());
        dto.setTitle(newpost.getTitle());
        dto.setDescription(newpost.getDescription());
        dto.setContent(newpost.getContent());
        return dto;
    }
}

package com.sagardev.gateway.controller;

import com.sagardev.gateway.model.PostDto;
import com.sagardev.gateway.service.PostDtoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;

@RestController
public class PostController {

    @Autowired
    private PostDtoService postDtoService;

    @GetMapping("/posts")
    public List<PostDto> getPosts(){
        return postDtoService.getPosts();
    }
}

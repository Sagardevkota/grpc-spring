package com.sagardev.gateway.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PostDto {

    private int postId;


    private String postTitle;


    private String postPhoto;

}

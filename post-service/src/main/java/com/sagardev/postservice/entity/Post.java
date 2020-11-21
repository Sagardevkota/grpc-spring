package com.sagardev.postservice.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.persistence.*;

@Entity
@Table(name = "post")
@AllArgsConstructor
@Getter
public class Post {

    @Id
    @Column(name = "postId",nullable = false,unique = true)
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int postId;

    @Column(name = "postTitle")
    private String postTitle;

    @Column(name = "postPhoto")
    private String postPhoto;


    public Post() {

    }
}

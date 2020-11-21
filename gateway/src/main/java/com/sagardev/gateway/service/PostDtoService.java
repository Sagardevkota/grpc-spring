package com.sagardev.gateway.service;

import com.sagardev.gateway.model.PostDto;
import com.sagardev.posts.PostRequest;
import com.sagardev.posts.PostResponse;
import com.sagardev.posts.PostServiceGrpc;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostDtoService {
    @GrpcClient("post-service")
    private PostServiceGrpc.PostServiceBlockingStub postServiceBlockingStub;


    public List<PostDto> getPosts(){
        PostRequest postRequest = PostRequest.newBuilder().setPage(1).build();
        PostResponse postResponse = postServiceBlockingStub.getPosts(postRequest);
        return postResponse.getPostsList().stream().map(post -> new PostDto(post.getPostId(),post.getPostName(),post.getPostPicture())).collect(Collectors.toList());
    }
}

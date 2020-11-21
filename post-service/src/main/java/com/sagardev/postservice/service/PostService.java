package com.sagardev.postservice.service;

import com.sagardev.posts.Post;
import com.sagardev.posts.PostRequest;
import com.sagardev.posts.PostResponse;
import com.sagardev.posts.PostServiceGrpc;
import com.sagardev.postservice.repository.PostRepository;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import org.springframework.beans.factory.annotation.Autowired;


@GrpcService
public class PostService extends PostServiceGrpc.PostServiceImplBase {

    @Autowired
    private PostRepository postRepository;

    @Override
    public void getPosts(PostRequest request, StreamObserver<PostResponse> responseObserver) {

        PostResponse.Builder builder = PostResponse.newBuilder();

        postRepository.findAll().forEach(post ->builder.addPosts(Post.newBuilder()
                .setPostId(post.getPostId())
                .setPostName(post.getPostTitle())
                .setPostPicture(post.getPostPhoto())
                .build()));

        responseObserver.onNext(builder.build());
        responseObserver.onCompleted();
    }
}

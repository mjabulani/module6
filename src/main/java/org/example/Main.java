package org.example;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {

        JSONPlaceholderFetcher jsonPlaceholderFetcher = new JSONPlaceholderFetcher();

        // print single post
        Post post = PostMapper.convertJSONtoPost(jsonPlaceholderFetcher.getSinglePost(1));

        System.out.println(post);
        // print all posts
        System.out.println(jsonPlaceholderFetcher.getAllPosts());


        List<Post> posts = PostMapper.convertJsonToPostList(jsonPlaceholderFetcher.getAllPosts());
        System.out.println(posts);

        Post post1 = new Post(1, 23, "dupa", "cycki");

        String postJson = PostMapper.mapPostToJson(post1);

        System.out.println(postJson);


    }
}